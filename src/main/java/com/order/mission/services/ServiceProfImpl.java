package com.order.mission.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.order.mission.dao.IDaoProfessor;
import com.order.mission.entities.Departement;
import com.order.mission.entities.Mission;
import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.entities.ProfessorGrade;

@Transactional
public class ServiceProfImpl implements IServiceProf {

	IDaoProfessor dao;
	
	public void setDao(IDaoProfessor dao) {
		this.dao = dao;
	}

	@Override
	public Professor addProfessor(Professor p) {
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
	public Professor getProfessor(String matricule) {
		return dao.getProfessor(matricule);
	}

	@Override
	public List<Professor> getAllProfessor() {
		return dao.getAllProfessor();
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
	public Professor loginProf(String matricule, String password) {
		return dao.loginProf(matricule, password);
	}

	@Override
	public List<Mission> getAllMissionByProf(int idProfessor) {
		return dao.getAllMissionByProf(idProfessor);
	}

	@Override
	public List<Privileges> getallpreviligebyprof(int idProfessor) {
		return dao.getallpreviligebyprof(idProfessor);
	}

	@Override
	public Privileges givProfPrivileg(Privileges pv, Professor p, ProfessorGrade pg) {
		return dao.givProfPrivileg(pv, p, pg);
	}

	@Override
	public List<ProfessorGrade> getallgradbyprof(int idProfessor) {
		return dao.getallgradbyprof(idProfessor);
	}

	@Override
	public Professor upStatusProf(Professor p) {
		return dao.upStatusProf(p);
	}

}
