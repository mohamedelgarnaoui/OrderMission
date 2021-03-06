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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

	@Value("#{myProps['uploadFolder']}")
	String UPLOAD_DIRECTORY;
	
	@Value("#{myProps['subject']}")
	String subject;
	
	@Value("#{myProps['message']}")
	String message;

	@Autowired
	ServletContext context; 

	@Autowired
	IServiceMission sm;

	@Autowired
	IServiceProf sp;
	
	@Autowired
    private JavaMailSender mailSender;

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
			@RequestParam("justif") MultipartFile multipart, Model model, RedirectAttributes attributes) {

		if (multipart.isEmpty()) {
			attributes.addFlashAttribute("message", "Veuillez s�lectionner votre justification");
			return "redirect:addMission";
		}

		String [] dep = m.getDepartureTime().split("-");
		logger.info("Date depature--> " + m.getDepartureTime()+" -- "+dep[0]+" -- "+dep[1]);

		logger.info("Date expiration --> " + m.getExpiryDate());

		logger.info("List Transport getted from the select multiple :-->" + m.getMoyenTrans());

		String depp = dep[0].substring(0,dep[0].lastIndexOf(" "));
		String ret = dep[1].substring(1);
		logger.info("dep time-->"+depp+"ret time-->"+ret);
		SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
		Date expiry = null;
		try {
			expiry = date1.parse(m.getExpiryDate());
		} catch (ParseException e) {
			logger.error("expiry date does not parsed = " + m.getExpiryDate(), e);
		}
		Date depart = null;
		try {
			depart = date.parse(depp);
			logger.info("depart date does not parsed =" + depart);
		} catch (ParseException e) {
			logger.error("depart date does not parsed = " + dep[0], e);
		}
		Date returnDate = null;
		try {
			returnDate = date.parse(ret);
			logger.error("return date does not parsed = " + returnDate);
		} catch (ParseException e) {
			logger.error("return date does not parsed = " + dep[1], e);
		}

		Mission mission = new Mission(m.getSubject(), sp.getVille(Integer.parseInt(m.getDestination())), 
				depart, returnDate, new Date(), expiry, "", m.getComment());
		mission.setProfessor(sp.getConnectedProf());
		mission.setState(sm.getState(5));
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
		byte[] bytes;
		try {
			bytes = multipart.getBytes();
			Path path = Paths.get(UPLOAD_DIRECTORY + File.separator + mission.getIdMission()+"_"+multipart.getOriginalFilename());
			logger.info(path.toString());  
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		List<Mission> alm = m.getMissions();
		List<Mission> mf = new ArrayList<Mission>();
		for (Mission mission : alm) {
			List<Transport> tr = sm.getAllTransportByMission(mission.getIdMission());
			for (Transport transport : tr) {
				logger.info("inside transport list = " + transport.getTypeTransport());
				if (transport.getTypeTransport().toLowerCase().contains("universit")) {
					logger.info("inside transport list = " + transport.getTypeTransport());
					mission.setHasUniversiteTrans(true);
				}
			}
			mf.add(mission);
		}
		
		m.setMissions(mf);
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
		attributes.addFlashAttribute("messagev", "Ville "+m.getNameVille()+" a �tait ajouter avec succ�s.");

		return "redirect:/addMission";
	}

	
	@RequestMapping(value="/addDepartement", method=RequestMethod.POST)
	public String addDepartement(@ModelAttribute("missionModel") MissionModel m, BindingResult bindingResul, Model model, RedirectAttributes attributes) {
		sp.addDepartement(new Departement(m.getDepartementName()));
		m.setVilles(sp.getAllVille());
		m.setDepartements(sp.getAllDepartement());
		m.setTransports(sm.getAllTransport());
		model.addAttribute("missionModel", m);
		attributes.addFlashAttribute("messaged", "Departement " + m.getDepartementName()+" a �tait ajouter avec succ�s.");

		return "redirect:/addMission";

	}

	
	@RequestMapping(value="/advanceMission/{idm}", method=RequestMethod.GET)
	public String advanceMission(@PathVariable String idm, RedirectAttributes attributes) {
		if (idm == null)
			attributes.addFlashAttribute("erra", " id mission doit �tre remplit");
		Mission m = sm.getMission(Integer.parseInt(idm));
		State s = m.getState();
		
		logger.info("the state id is =========> " + m.getState().getIdState()+" state name ==> " + m.getState().getName());
		if (m.getState().getIdState() == 3) {
			// creates a simple e-mail object
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(m.getProfessor().getEmail());
	        email.setSubject(subject);
	        email.setText(message);
	        logger.info("send email fonction => " + m.getProfessor().getEmail() + " - " + subject);
	        // sends the e-mail
	        mailSender.send(email);
		}
		
		m.setState(s.getState());
		m = sm.updateMission(m);

		return "redirect:/mission";
	}
	
	
	@RequestMapping(value="/advMission", method=RequestMethod.POST)
	public String advMission(@RequestParam(value = "idMiss") String idMission, 
			@RequestParam(value = "driver") String driver, RedirectAttributes attributes) {
		if (idMission == null)
			attributes.addFlashAttribute("errr", "id mission doit �tre remplit");
		Mission m = sm.getMission(Integer.parseInt(idMission));
		logger.info("inside mission  = " + m.getSubject());
		logger.info("driver  = " + driver);
		logger.info("id mission  = " + idMission);
		List<Transport> tr = sm.getAllTransportByMission(m.getIdMission());
		for (Transport transport : tr) {
			logger.info("inside transport list = " + transport.getTypeTransport());
			if (transport.getTypeTransport().toLowerCase().contains("universit")) {
				logger.info("inside transport list = " + transport.getTypeTransport());
				transport.setDriver(driver);
				sm.updateTransport(transport);
				break;
			}
		}
		State s = m.getState();
		m.setState(s.getState());
		m = sm.updateMission(m);

		return "redirect:/mission";
	}


	@RequestMapping(value="/rejectMission", method=RequestMethod.POST)
	public String rejectMission(@RequestParam(value = "idMission") String idMission, 
			@RequestParam(value = "raison") String raison, RedirectAttributes attributes) {
		if (idMission == null)
			attributes.addFlashAttribute("errr", "id mission doit �tre remplit");
		Mission m = sm.getMission(Integer.parseInt(idMission));
		m.setRejectionRaison(raison);
		m.setState(sm.getState(6));
		m = sm.updateMission(m);

		return "redirect:/mission";
	}


	@RequestMapping(value="/deleteMission/{idm}", method=RequestMethod.GET)
	public String deleteMission(@PathVariable String idm, RedirectAttributes attributes) {
		if (idm == null)
			attributes.addFlashAttribute("errd", "id mission doit �tre remplit");
		sm.deleteMission(Integer.parseInt(idm));
		return "redirect:/mission";
	}


	@RequestMapping(value="/printMission/{idm}", method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> printMission(@PathVariable String idm, RedirectAttributes attributes) {
		if (idm == null)
			attributes.addFlashAttribute("errd", "id mission doit �tre remplit");
		Mission m = sm.getMission(Integer.parseInt(idm));
		m.setState(sm.getState(1));

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
			attributes.addFlashAttribute("errd", "id mission doit �tre remplit");
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
