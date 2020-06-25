package com.order.mission.services;

import java.util.List;

import com.order.mission.entities.Departement;
import com.order.mission.entities.Mission;
import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.entities.ProfessorGrade;

public interface IServiceProf {

	//professor
	public Professor addProfessor(Professor p);
	public Professor deleteProfessor(int idProfessor);
	public Professor updateProfessor(Professor p);
	public Professor getProfessor(int idProfessor);
	public Professor getProfessor(String username);
	public List<Professor> getAllProfessor();
	public Professor loginProf(String username, String password);
	public Professor getProfByMatricule(String username);

	//professorgrand
	public ProfessorGrade addProfessorGrade(ProfessorGrade pg);
	public ProfessorGrade deleteProfessorGrade(int idProfessorGrade);
	public ProfessorGrade updateProfessorGrade(ProfessorGrade pg);
	public ProfessorGrade getProfessorGrade(int idProfessorGrade);
	public List<ProfessorGrade> getAllProfessorGrade();


	//privileges
	public Privileges addPrivileges(Privileges pv);
	public Privileges deletePrivileges(int idPrivileges);
	public Privileges updatePrivileges(Privileges pv);
	public Privileges getPrivileges(int idPrivileges);
	public List<Privileges> getAllPrivileges();

	//departement
	public Departement addDepartement(Departement dp);
	public Departement deleteDepartement(int idDepartement);
	public Departement updateDepartement(Departement pd);
	public Departement getDepartement(int idDepartement);
	public List<Departement> getAllDepartement();

	//getAllmissionByProf(p)
	public List<Mission> getAllMissionByProf(int idProfessor);

	//getallpreviligebyprof(p)
	public List<Privileges> getallpreviligebyprof(int idProfessor);

	//givProfPrivileg(prv)
	public Privileges givProfPrivileg(Privileges pv,Professor p,ProfessorGrade pg);

	//getallgradbyprof
	public List<ProfessorGrade> getallgradbyprof(int idProfessor);

	//upStatusProf
	public Professor upStatusProf(Professor p);


}
