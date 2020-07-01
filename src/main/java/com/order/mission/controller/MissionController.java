package com.order.mission.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.order.mission.entities.Departement;
import com.order.mission.entities.JustificationDocument;
import com.order.mission.entities.Mission;
import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.entities.State;
import com.order.mission.entities.Transport;
import com.order.mission.entities.Ville;
import com.order.mission.model.MissionModel;
import com.order.mission.services.IServiceMission;
import com.order.mission.services.IServiceProf;

@Controller
public class MissionController implements ServletContextAware{
	SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
	
	@Value("#{myProps['uploadFolder']}")
	String UPLOAD_DIRECTORY;

	@Autowired
	ServletContext context; 

	@Autowired
	IServiceMission sm;

	@Autowired
	IServiceProf sp;

	private static final Logger logger = LoggerFactory.getLogger(MissionController.class);

	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}

	@RequestMapping(value="/addMission", method=RequestMethod.GET)
	public String addMission(Model model) {
		MissionModel m = new MissionModel();
		m.setVilles(sp.getAllVille());
		m.setDepartements(sp.getAllDepartement());
		m.setTransports(sm.getAllTransport());
		m.setProf(sp.getConnectedProf());
		m.setImage(sp.getConnectedProf().getPhoto());
		model.addAttribute("missionModel", m);

		return "mission";
	}

	@RequestMapping(value="/addMission", method=RequestMethod.POST, consumes = {"multipart/form-data"})
	public String addMission(@ModelAttribute("missionModel") MissionModel m, BindingResult bindingResult, 
			@RequestParam("justif") MultipartFile multipart, Model model, RedirectAttributes attributes) throws IOException, ParseException {

		if (multipart.isEmpty()) {
			attributes.addFlashAttribute("message", "Veuillez sélectionner votre justification");
			return "redirect:addMission";
		}

		String [] dep = m.getDepartureTime().split("-");
		logger.info("Date depature--> " + m.getDepartureTime());

		logger.info("Date expiration --> " + m.getExpiryDate());

		logger.info("List Transport getted from the select multiple :-->" + m.getMoyenTrans());

		Date expiry = date.parse(m.getExpiryDate()),
				depart = date.parse(dep[0]),
				returnDate = date.parse(dep[1]);

		Mission mission = new Mission(m.getSubject(), sp.getVille(Integer.parseInt(m.getDestination())), 
				depart, returnDate, new Date(), expiry, "", m.getComment());
		mission.setProfessor(sp.getConnectedProf());
		mission.setState(sm.getState(4));
		mission.setDepartement(sp.getDepartement(Integer.parseInt(m.getDepartement())));
		
		String listTrans[] = m.getMoyenTrans().split(",");

		List<Transport> trsList = new ArrayList<Transport>();
		for (String trans : listTrans) {
			Transport t = sm.getTransport(Integer.parseInt(trans));
			trsList.add(t);
		}
		mission.setTransport(trsList);
		if (m.getIdMission() != null) {
			mission.setIdMission(Integer.parseInt(m.getIdMission()));
		}
		mission = sm.AddMission(mission);

		// rename and add justification document
		byte[] bytes = multipart.getBytes();
		Path path = Paths.get(UPLOAD_DIRECTORY + File.separator + mission.getIdMission()+"_"+multipart.getOriginalFilename());
		logger.info(path.toString());  
		Files.write(path, bytes);

		JustificationDocument jd = new JustificationDocument(mission.getIdMission()+"_"+multipart.getOriginalFilename(), "");
		jd.setMission(mission);
		sm.AddJustificationDocument(jd);

		return "redirect:/index";
	}

	@RequestMapping(value="/mission", method=RequestMethod.GET)
	public String  allMission(Model model) {
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

		if (admin) {
			m.setMissions(sm.getAllMission());
		}else if (chef) {
			m.setMissions(sm.getAllMissionByDep(p.getDepartement().getIdDep()));
		}else {
			m.setMissions(sm.getAllMissionByProf(p.getIdProfessor()));
		}
		m.setImage(sp.getConnectedProf().getPhoto());
		model.addAttribute("missionModel", m);

		return "listmission";
	}


	@RequestMapping(value="/updateMission", method=RequestMethod.GET)
	public String updateMission(@RequestParam(value = "idm") String idm, Model model) {
		MissionModel m = new MissionModel();
		Mission mis = sm.getMission(Integer.parseInt(idm));

		m.setIdMission(mis.getIdMission()+"");
		m.setComment(mis.getComment());
		m.setDepartement(mis.getDepartement().getName());
		m.setDepartureTime(mis.getDepartureTime().toString());
		m.setDestination(mis.getDestination().getName());
		m.setExpiryDate(mis.getExpiryDate().toString());

		Collection<Transport> mtrs = sm.getAllTransportByMission(mis.getIdMission());
		String trs = "";
		for (Transport transport : mtrs) {
			trs += transport.getTypeTransport() + ", ";
		}
		trs = trs.substring(0,trs.lastIndexOf(","));

		m.setMoyenTrans(trs);

		m.setReturnTime(mis.getReturnTime().toString());
		m.setSubject(mis.getSubject());
		m.setState(mis.getState());

		m.setVilles(sp.getAllVille());
		m.setDepartements(sp.getAllDepartement());
		m.setTransports(sm.getAllTransport());
		m.setProf(sp.getConnectedProf());
		m.setIsupdate(true);
		model.addAttribute("missionModel", m);

		return "mission";
	}




	@RequestMapping(value="/addVille", method=RequestMethod.POST)
	public String  addVille(@ModelAttribute("missionModel") MissionModel m, BindingResult bindingResul, Model model, RedirectAttributes attributes) {
		sp.addVille(new Ville(m.getNameVille(), sp.getPays(m.getPays())));
		m.setVilles(sp.getAllVille());
		m.setDepartements(sp.getAllDepartement());
		m.setTransports(sm.getAllTransport());
		model.addAttribute("missionModel", m);
		attributes.addFlashAttribute("messagev", "Ville "+m.getNameVille()+" a était ajouter avec succés.");

		return "redirect:/addMission";
	}

	@RequestMapping(value="/addDepartement", method=RequestMethod.POST)
	public String addDepartement(@ModelAttribute("missionModel") MissionModel m, BindingResult bindingResul, Model model, RedirectAttributes attributes) {
		sp.addDepartement(new Departement(m.getDepartementName()));
		m.setVilles(sp.getAllVille());
		m.setDepartements(sp.getAllDepartement());
		m.setTransports(sm.getAllTransport());
		model.addAttribute("missionModel", m);
		attributes.addFlashAttribute("messaged", "Departement " + m.getDepartementName()+" a était ajouter avec succés.");

		return "redirect:/addMission";

	}

	@RequestMapping(value="/advanceMission/{idm}", method=RequestMethod.GET)
	public String advanceMission(@PathVariable String idm, RedirectAttributes attributes) {
		if (idm == null)
			attributes.addFlashAttribute("erra", " id mission doit étre remplit");
		Mission m = sm.getMission(Integer.parseInt(idm));
		State s = m.getState();
		m.setState(s.getState());
		m = sm.updateMission(m);

		return "redirect:/mission";
	}


	@RequestMapping(value="/rejectMission", method=RequestMethod.POST)
	public String rejectMission(@RequestParam(value = "idMission") String idMission, 
			@RequestParam(value = "raison") String raison, RedirectAttributes attributes) {
		if (idMission == null)
			attributes.addFlashAttribute("errr", "id mission doit étre remplit");
		Mission m = sm.getMission(Integer.parseInt(idMission));
		m.setState(sm.getState(5));
		m = sm.updateMission(m);

		return "redirect:/mission";
	}


	@RequestMapping(value="/deleteMission/{idm}", method=RequestMethod.GET)
	public String deleteMission(@PathVariable String idm, RedirectAttributes attributes) {
		if (idm == null)
			attributes.addFlashAttribute("errd", "id mission doit étre remplit");
		sm.deleteMission(Integer.parseInt(idm));
		return "redirect:/mission";
	}



	@RequestMapping(value="/printMission/{idm}", method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> printMission(@PathVariable String idm, RedirectAttributes attributes) {
		if (idm == null)
			attributes.addFlashAttribute("errd", "id mission doit étre remplit");
		Mission m = sm.getMission(Integer.parseInt(idm));
		m.setState(sm.getState(5));
		
		try {
			sm.generatePDF(m);
			File file = new File("OrdreMission_Mr."+m.getProfessor().getLastName()+".pdf");
			HttpHeaders respHeaders = new HttpHeaders();
			MediaType mediaType = MediaType.parseMediaType("application/pdf");
			respHeaders.setContentType(mediaType);
			respHeaders.setContentLength(file.length());
			respHeaders.setContentDispositionFormData("attachment", file.getName());
			InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
			m = sm.updateMission(m);
			return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
		
		}catch (Exception e){
			String message = "Errore nel download del file  "+e.getMessage();
			logger.error(message, e);
			return new ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/downloadMission/{idm}", method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadMission(@PathVariable String idm, RedirectAttributes attributes) {
		if (idm == null)
			attributes.addFlashAttribute("errd", "id mission doit étre remplit");
		Mission m = sm.getMission(Integer.parseInt(idm));
		
		try {
			List<JustificationDocument> js = sm.getJustificationDocByMission(m.getIdMission());
			
			File file = new File(UPLOAD_DIRECTORY + "/" +js.get(0).getDocument());
			HttpHeaders respHeaders = new HttpHeaders();
			MediaType mediaType = MediaType.parseMediaType("application/pdf");
			respHeaders.setContentType(mediaType);
			respHeaders.setContentLength(file.length());
			respHeaders.setContentDispositionFormData("attachment", file.getName());
			InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
			return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
		
		}catch (Exception e){
			String message = "Errore nel download del file  "+e.getMessage();
			logger.error(message, e);
			return new ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
