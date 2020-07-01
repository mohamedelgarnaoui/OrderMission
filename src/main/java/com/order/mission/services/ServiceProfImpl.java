package com.order.mission.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.order.mission.dao.IDaoProfessor;
import com.order.mission.entities.Departement;
import com.order.mission.entities.Pays;
import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.entities.ProfessorGrade;
import com.order.mission.entities.Ville;

@Transactional
public class ServiceProfImpl implements IServiceProf {

	IDaoProfessor dao;
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceProfImpl.class);

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public void setDao(IDaoProfessor dao) {
		this.dao = dao;
	}

	@Override
	public Professor addProfessor(Professor p) {
		p.setPassword(bCryptPasswordEncoder.encode(p.getPassword()));
		return dao.addProfessor(p);
	}

	@Override
	public Professor deleteProfessor(int idProfessor) {
		return dao.deleteProfessor(idProfessor);
	}

	@Override
	public Professor updateProfessor(Professor p) {
		return dao.updateProfessor(p);
	}

	@Override
	public Professor getProfessor(int idProfessor) {
		return dao.getProfessor(idProfessor);
	}

	@Override
	public Professor getProfessor(String username) {
		return dao.getProfessor(username);
	}

	@Override
	public List<Professor> getAllProfessor() {
		return dao.getAllProfessor();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Professor getConnectedProf() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (SimpleGrantedAuthority simpleGrantedAuthority : authorities) {
			logger.info("the authorité for the current user is = " + simpleGrantedAuthority.getAuthority());
		}

		logger.info("this the username of the connected user : " + username);
		return getProfByMatricule(username);
	}

	@Override
	public ProfessorGrade addProfessorGrade(ProfessorGrade pg) {
		return dao.addProfessorGrade(pg);
	}

	@Override
	public ProfessorGrade deleteProfessorGrade(int idProfessorGrade) {
		return dao.deleteProfessorGrade(idProfessorGrade);
	}

	@Override
	public ProfessorGrade updateProfessorGrade(ProfessorGrade pg) {
		return dao.updateProfessorGrade(pg);
	}

	@Override
	public ProfessorGrade getProfessorGrade(int idProfessorGrade) {
		return dao.getProfessorGrade(idProfessorGrade);
	}

	@Override
	public List<ProfessorGrade> getAllProfessorGrade() {
		return dao.getAllProfessorGrade();
	}

	@Override
	public Privileges addPrivileges(Privileges pv) {
		return dao.addPrivileges(pv);
	}

	@Override
	public Privileges deletePrivileges(int idPrivileges) {
		return dao.deletePrivileges(idPrivileges);
	}

	@Override
	public Privileges updatePrivileges(Privileges pv) {
		return dao.updatePrivileges(pv);
	}

	@Override
	public Privileges getPrivileges(int idPrivileges) {
		return dao.getPrivileges(idPrivileges);
	}

	@Override
	public List<Privileges> getAllPrivileges() {
		return dao.getAllPrivileges();
	}

	@Override
	public Departement addDepartement(Departement dp) {
		return dao.addDepartement(dp);
	}

	@Override
	public Departement deleteDepartement(int idDepartement) {
		return dao.deleteDepartement(idDepartement);
	}

	@Override
	public Departement updateDepartement(Departement pd) {
		return dao.updateDepartement(pd);
	}

	@Override
	public Departement getDepartement(int idDepartement) {
		return dao.getDepartement(idDepartement);
	}

	@Override
	public List<Departement> getAllDepartement() {
		return dao.getAllDepartement();
	}

	@Override
	public Professor loginProf(String username, String password) {
		return dao.loginProf(username, password);
	}

	@Override
	public List<Privileges> getAllPreviligeByProf(int idProfessor) {
		List<ProfessorGrade> grade = new ArrayList<ProfessorGrade>();
		List<Privileges> privList = new ArrayList<Privileges>();
		grade = dao.getAllGradeByProf(idProfessor);

		for (ProfessorGrade professorGrade : grade) {
			privList.addAll(dao.getAllPreviligeByGrade(professorGrade.getIdGrade()));
		}
		return privList;
	}

	@Override
	public Privileges givProfPrivileg(Privileges pv, Professor p, ProfessorGrade pg) {
		return dao.givProfPrivileg(pv, p, pg);
	}

	@Override
	public List<ProfessorGrade> getAllGradeByProf(int idProfessor) {
		return dao.getAllGradeByProf(idProfessor);
	}

	@Override
	public Professor updateStatusProf(Professor p) {
		return dao.upStatusProf(p);
	}

	@Override
	public Professor getProfByMatricule(String username) {
		return dao.getProfByMatricule(username);
	}

	@Override
	public Ville addVille(Ville v) {
		return dao.addVille(v);
	}

	@Override
	public List<Ville> getAllVille() {
		// TODO Auto-generated method stub
		return dao.getAllVille();
	}

	@Override
	public List<Ville> getAllVilleByPays(Pays p) {
		// TODO Auto-generated method stub
		return dao.getAllVilleByPays(p);
	}

	@Override
	public Pays addPays(Pays p) {
		return dao.addPays(p);
	}

	@Override
	public List<Pays> getAllPays() {
		return dao.getAllPays();
	}

	@Override
	public Ville getVille(int idVille) {
		return dao.getVille(idVille);
	}

	@Override
	public Pays getPays(String name) {
		return dao.getPays(name);
	}


}
