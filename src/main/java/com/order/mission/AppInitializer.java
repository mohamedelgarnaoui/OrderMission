package com.order.mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.order.mission.entities.Departement;
import com.order.mission.entities.Pays;
import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.entities.ProfessorGrade;
import com.order.mission.entities.State;
import com.order.mission.entities.Transport;
import com.order.mission.entities.Ville;
import com.order.mission.services.IServiceMission;
import com.order.mission.services.IServiceProf;

@Component
public class AppInitializer {


	@Autowired
	IServiceProf repo;

	@Autowired
	IServiceMission repom;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(AppInitializer.class);

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		Pays p = new Pays("Maroc");
//		p = repo.addPays(p);
//		repo.addVille( new Ville("Casablanca", p));
//		repo.addVille( new Ville("Rabat", p));
//		repo.addVille( new Ville("Eljadida", p));
//		repo.addVille( new Ville("Fès", p));
//		repo.addVille( new Ville("Tanger", p));
//		repo.addVille( new Ville("Marrakech", p));
//		repo.addVille( new Ville("Tetouan", p));
//		repo.addVille( new Ville("Agadir", p));
//		repo.addVille( new Ville("Ouajda", p));
//		repo.addVille( new Ville("Taza", p));
//		repo.addVille( new Ville("Elaayoun", p));
//		repo.addVille( new Ville("Eldakhla", p));
//
//
//		Departement dd = repo.addDepartement(new Departement("Informatique"));
//		repo.addDepartement(new Departement("Sience"));
//		repo.addDepartement(new Departement("Physique"));
//		repo.addDepartement(new Departement("Technologique"));
//		repo.addDepartement(new Departement("Economique"));
//
//		State s5 = repom.AddState(new State("Archiver", "Imprimer", 5));
//
//		State s4 = new State("Confirmer", "Confirmer", 5);
//		s4.setState(s5);
//		s4 = repom.AddState(s4);
//
//		State s3 = new State("Valider", "Valider", 10);
//		s3.setState(s4);
//		s3 = repom.AddState(s3);
//
//		State s2 = new State("Reçue", "Revenoyer", 3);
//		s2.setState(s3);
//		s2 = repom.AddState(s2);
//		
//		State s1 = new State("Rejeter", "Rejeter", 3);
//		s1.setState(s2);
//		s1 = repom.AddState(s1);
//
//
//		repom.AddTransport(new Transport("Voiture", ""));
//		repom.AddTransport(new Transport("Location", ""));
//		repom.AddTransport(new Transport("Train", ""));
//		repom.AddTransport(new Transport("Avion", ""));
//		repom.AddTransport(new Transport("Taxi", ""));
//
//
//		Privileges priv1 = repo.addPrivileges(new Privileges("PROF"));
//		Privileges priv2 = repo.addPrivileges(new Privileges("ADMIN"));
//		Privileges priv3 = repo.addPrivileges(new Privileges("DEPCHEF"));
//		Privileges priv4 = repo.addPrivileges(new Privileges("USER"));
//
//		Collection<Privileges> pp = new ArrayList<Privileges>();
//		pp.add(priv1);
//		ProfessorGrade pg1 = new ProfessorGrade("Professeur");
//		pg1.setPrivileges(pp);
//		pg1 = repo.addProfessorGrade(pg1);
//
//		pp = new ArrayList<Privileges>();
//		ProfessorGrade pg2 = new ProfessorGrade("ADMINISTRATOR");
//		pp.add(priv2);
//		pg2.setPrivileges(pp);
//		pg2 = repo.addProfessorGrade(pg2);
//
//		pp = new ArrayList<Privileges>();
//		ProfessorGrade pg3 = new ProfessorGrade("DEP_CHEF");
//		pp.add(priv3);
//		pp.add(priv4);
//		pg3.setPrivileges(pp);
//		pg3 = repo.addProfessorGrade(pg3);
//
//
//		Collection<ProfessorGrade> gradeList = new ArrayList<ProfessorGrade>();
//		gradeList.add(pg2);
//		gradeList.add(pg1);
//		gradeList.add(pg3);
//		Professor admin = new Professor("Admin@admin.com", "admin", "admin", "Administrator", "System", null, "", "Casablanca", "", "", "", "", "", "", "Active", "Administrateur d'application");
//		admin.setProfessorGrade(gradeList);
//		admin.setDepartement(dd);
//		admin = repo.addProfessor(admin);
//		logger.info("The encrypted pass word is ==> "+bCryptPasswordEncoder.encode("admin"));
//		Professor pr = repo.getProfByMatricule("admin");
//
//		List<Privileges> priv = repo.getAllPreviligeByProf(pr.getIdProfessor()); 
//
//		for (Privileges privileges :priv) {
//			logger.info("The priviliges for the admin website page ==> ", privileges.getName());
//		}
//		gradeList = new ArrayList<ProfessorGrade>();
//		gradeList.add(pg1);
//		
//		Professor pro = new Professor("med@prof.com", "mohamed", "medo", "SimoElga", "Mohamed", null, "", "Casablanca", "", "", "", "", "", "", "Active", "Professeur Java");
//		pro.setProfessorGrade(gradeList);
//		pro.setDepartement(dd);
//		pro = repo.addProfessor(pro);
		
	}
}
