package com.order.mission.services;

import java.util.List;

import com.order.mission.entities.Departement;
import com.order.mission.entities.Pays;
import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.entities.ProfessorGrade;
import com.order.mission.entities.Ville;

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
	public Professor getConnectedProf();

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

	public List<Privileges> getAllPreviligeByProf(int idProfessor);

	public Privileges givProfPrivileg(Privileges pv, Professor p, ProfessorGrade pg);

	public List<ProfessorGrade> getAllGradeByProf(int idProfessor);

	public Professor updateStatusProf(Professor p);

	//ville
	public Ville addVille(Ville v);
	public List<Ville> getAllVille();
	public List<Ville> getAllVilleByPays(Pays p);
	public Ville getVille(int idVille);
	//pays
	public Pays addPays(Pays p);
	public List<Pays> getAllPays();
	public Pays getPays(String name);


}
