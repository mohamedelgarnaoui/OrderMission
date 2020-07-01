package com.order.mission.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.order.mission.entities.Departement;
import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.entities.ProfessorGrade;
import com.order.mission.entities.Ville;
import com.order.mission.model.MissionModel;
import com.order.mission.model.UserModel;
import com.order.mission.security.SecurityService;
import com.order.mission.services.IServiceMission;
import com.order.mission.services.IServiceProf;
import com.order.mission.validator.ProfValidator;

@Controller
public class ProfController {
	SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
	
	private static final Logger logger = LoggerFactory.getLogger(ProfController.class);
	
	@Value("#{myProps['uploadFolder']}")
	String UPLOAD_DIRECTORY;
	
	@Autowired
	IServiceProf sp;

	@Autowired
	ProfValidator pv;

	@Autowired
	SecurityService ss;
	

	@Autowired
	IServiceMission sm;
	
	


	@RequestMapping(value= {"/","/index"}, method=RequestMethod.GET)
	public String index(Model model) {
		boolean admin = false, chef = false;
		MissionModel m = new MissionModel();
		Professor p = sp.getConnectedProf();
		m.setProf(p);
		List<Privileges> priv = sp.getAllPreviligeByProf(p.getIdProfessor());
		for (Privileges privileges : priv) {
			if (privileges.getName().toLowerCase().contains("admin")) {
				admin = true;
				break;
			}else if (privileges.getName().toLowerCase().contains("chef")) {
				chef = true;
			}
		}
		logger.info("Admin connected " + admin);
		if (admin) {
			m.setMissions(sm.getAllMissionByState(4));
		}else if (chef) {
			m.setMissions(sm.getAllMissionByDepByState(p.getDepartement().getIdDep(),4));
		}else {
			m.setMissions(sm.getAllMissionByProfByState(p.getIdProfessor(),4));
		}
		m.setImage(sp.getConnectedProf().getPhoto());
		model.addAttribute("missionModel", m);

		return "index";
	}

	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String signUpPage(Model model) {
		model.addAttribute("userForm", new UserModel());
		return "register";
	}

	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String signUpPage(@ModelAttribute("userForm") UserModel userForm, BindingResult bindingResult, Model model) {
		pv.validate(userForm, bindingResult);

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = null;
		try {
			dd = date.parse(userForm.getBirthDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (bindingResult.hasErrors()) {
			return "register";
		}
		Professor p = new Professor(userForm.getEmail(), userForm.getUsername(), userForm.getPassword(), 
				userForm.getLastName(), userForm.getFirstName(), dd,userForm.getAdresses(),
				userForm.getCity(), userForm.getPhone(), userForm.getMobile(),userForm.getNumCIN(), 
				userForm.getResume(), userForm.getPhoto(), userForm.getCINPrinted(), "Created", userForm.getProfession() );
		sp.addProfessor(p);

		ss.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/index";
	}

	@RequestMapping(value="/addProfessor", method=RequestMethod.GET)
	public String addProfessor(Model model) {
		MissionModel m = new MissionModel();
		m.setVilles(sp.getAllVille());
		m.setDepartements(sp.getAllDepartement());
		m.setTransports(sm.getAllTransport());
		m.setProf(sp.getConnectedProf());

		model.addAttribute("missionModel", m);

		UserModel u = new UserModel();
		u.setProfessors(sp.getAllProfessor());
		u.setProf(sp.getConnectedProf());
		u.setGrades(sp.getAllProfessorGrade());
		u.setImage(sp.getConnectedProf().getPhoto());
		model.addAttribute("userForm",u);
		return "professor";
	}

	@RequestMapping(value="/addProfessor", method=RequestMethod.POST, consumes = {"multipart/form-data"})
	public String addProfessor(@ModelAttribute("userForm") UserModel userForm, BindingResult bindingResult, Model model,
			@RequestParam("file") MultipartFile multipart, RedirectAttributes attributes) throws IOException, ParseException {
		logger.info("here is the error " +bindingResult.getFieldError());
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.hasErrors());
			return "redirect:/addProfessor";
		}

		if (multipart.isEmpty()) {
			attributes.addFlashAttribute("message", "Veuillez sélectionner votre justification");
			return "redirect:addProfessor";
		}

		Date dd = null;
		dd = date.parse(userForm.getBirthDate());
		
		Ville v = sp.getVille(Integer.parseInt(userForm.getCity()));
		Professor p = new Professor(userForm.getEmail(), userForm.getUsername(), userForm.getPassword(), 
				userForm.getLastName(), userForm.getFirstName(), dd, userForm.getAdresses(),
				v.getName(), userForm.getPhone(), userForm.getMobile(),userForm.getNumCIN(), 
				userForm.getResume(), userForm.getUsername()+"_"+multipart.getOriginalFilename(), userForm.getCINPrinted(), "Created", userForm.getProfession() );
		
		p.setDepartement(sp.getDepartement(Integer.parseInt(userForm.getDepartement())));
		
		String listg[] = userForm.getGrade().split(",");

		List<ProfessorGrade> gList = new ArrayList<ProfessorGrade>();
		for (String g : listg) {
			ProfessorGrade pg = sp.getProfessorGrade(Integer.parseInt(g));
			gList.add(pg);
		}
		p.setProfessorGrade(gList);
		p = sp.addProfessor(p);
		
		// rename and add  document
		byte[] bytes = multipart.getBytes();
		Path path = Paths.get(UPLOAD_DIRECTORY + File.separator + userForm.getUsername()+"_"+multipart.getOriginalFilename());
		logger.info(path.toString());  
		Files.write(path, bytes);

		return "redirect:/professor";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Votre Matricule et mot de passe sont invalid.");

		if (logout != null)
			model.addAttribute("message", "vous étes déconnecté avec succés !");

		return "login";
	}

	@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public String allProfessor(@ModelAttribute("userForm") UserModel userForm, Model model) {
		UserModel u = new UserModel();
		u.setProfessors(sp.getAllProfessor());
		u.setProf(sp.getConnectedProf());
		u.setGrades(sp.getAllProfessorGrade());
		u.setImage(sp.getConnectedProf().getPhoto());
		model.addAttribute("userForm", u);
		return "listprof";
	}
	
	@RequestMapping(value="/addVill", method=RequestMethod.POST)
	public String  addVille(@ModelAttribute("missionModel") MissionModel m, BindingResult bindingResul, Model model, RedirectAttributes attributes) {
		sp.addVille(new Ville(m.getNameVille(), sp.getPays(m.getPays())));
		m.setVilles(sp.getAllVille());
		m.setDepartements(sp.getAllDepartement());
		m.setTransports(sm.getAllTransport());
		model.addAttribute("missionModel", m);
		attributes.addFlashAttribute("messagev", "Ville "+m.getNameVille()+" a était ajouter avec succés.");

		return "redirect:/addProfessor";
	}

	@RequestMapping(value="/addDepartemen", method=RequestMethod.POST)
	public String addDepartement(@ModelAttribute("missionModel") MissionModel m, BindingResult bindingResul, Model model, RedirectAttributes attributes) {
		sp.addDepartement(new Departement(m.getDepartementName()));
		m.setVilles(sp.getAllVille());
		m.setDepartements(sp.getAllDepartement());
		m.setTransports(sm.getAllTransport());
		m.setImage(sp.getConnectedProf().getPhoto());
		model.addAttribute("missionModel", m);
		attributes.addFlashAttribute("messaged", "Departement " + m.getDepartementName()+" a était ajouter avec succés.");

		return "redirect:/addProfessor";

	}
	
	@RequestMapping(value="/addGrade", method=RequestMethod.POST)
	public String addGrade(@RequestParam(value = "idProf") String idProf, 
			@RequestParam(value = "grade") String grade, RedirectAttributes attributes) {
		if (idProf == null)
			attributes.addFlashAttribute("errr", "id Prof doit étre remplit");
		Professor p = sp.getProfessor(Integer.parseInt(idProf));
		
		String listg[] = grade.split(",");
		List<ProfessorGrade> gList = new ArrayList<ProfessorGrade>();
		for (String g : listg) {
			ProfessorGrade pg = sp.getProfessorGrade(Integer.parseInt(g));
			gList.add(pg);
		}
		p.setProfessorGrade(gList);
		p = sp.updateProfessor(p);

		return "redirect:/professor";
	}


	@RequestMapping(value="/deleteProfessor/{idp}", method=RequestMethod.GET)
	public String deleteMission(@PathVariable String idp, RedirectAttributes attributes) {
		if (idp == null)
			attributes.addFlashAttribute("errd", "id prof doit étre remplit");
		sp.deleteProfessor(Integer.parseInt(idp));
		return "redirect:/professor";
	}


}
