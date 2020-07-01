package com.order.mission.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.order.mission.entities.Departement;
import com.order.mission.entities.Pays;
import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.entities.ProfessorGrade;
import com.order.mission.entities.Ville;

public class DaoProfessorImpl implements IDaoProfessor {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Professor addProfessor(Professor p) {
		em.persist(p);
		em.flush();
		return p;
	}

	@Override
	public Professor deleteProfessor(int idProfessor) {
		Professor p = em.find(Professor.class, idProfessor);
		em.remove(p);
		em.flush();
		return p;
	}

	@Override
	public Professor updateProfessor(Professor p) {
		em.merge(p);
		em.flush();
		return p;
	}

	@Override
	public Professor getProfessor(int idProfessor) {
		return em.find(Professor.class, idProfessor);
	}

	@Override
	public Professor getProfessor(String matricule) {
		return em.find(Professor.class, matricule);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> getAllProfessor() {
		Query q = em.createQuery("select p from Professor p");
		return q.getResultList();
	}

	@Override
	public ProfessorGrade addProfessorGrade(ProfessorGrade pg) {
		em.persist(pg);
		em.flush();
		return pg;
	}

	@Override
	public ProfessorGrade deleteProfessorGrade(int idProfessorGrade) {
		ProfessorGrade pg = em.find(ProfessorGrade.class, idProfessorGrade);
		em.remove(pg);
		em.flush();
		return pg;
	}

	@Override
	public ProfessorGrade updateProfessorGrade(ProfessorGrade pg) {
		em.merge(pg);
		em.flush();
		return pg;
	}

	@Override
	public ProfessorGrade getProfessorGrade(int idProfessorGrade) {
		return em.find(ProfessorGrade.class, idProfessorGrade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessorGrade> getAllProfessorGrade() {
		Query q = em.createQuery("select pg from ProfessorGrade pg");
		return q.getResultList();
	}

	@Override
	public Privileges addPrivileges(Privileges pv) {
		em.persist(pv);
		em.flush();
		return pv;
	}

	@Override
	public Privileges deletePrivileges(int idPrivileges) {
		Privileges pv = em.find(Privileges.class, idPrivileges);
		em.remove(pv);
		em.flush();
		return pv;
	}

	@Override
	public Privileges updatePrivileges(Privileges pv) {
		em.merge(pv);
		return pv;
	}

	@Override
	public Privileges getPrivileges(int idPrivileges) {
		return em.find(Privileges.class, idPrivileges);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Privileges> getAllPrivileges() {
		Query q = em.createQuery("select p from Privileges p");
		return q.getResultList();
	}

	@Override
	public Departement addDepartement(Departement dp) {
		em.persist(dp);
		em.flush();
		return dp;
	}

	@Override
	public Departement deleteDepartement(int idDepartement) {
		Departement dp = em.find(Departement.class, idDepartement);
		em.remove(dp);
		em.flush();
		return dp;
	}

	@Override
	public Departement updateDepartement(Departement pd) {
		em.merge(pd);
		return pd;
	}

	@Override
	public Departement getDepartement(int idDepartement) {
		return em.find(Departement.class, idDepartement);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departement> getAllDepartement() {
		Query q = em.createQuery("select dp from Departement dp");
		return q.getResultList();
	}

	@Override
	public Professor loginProf(String matricule, String password) {
		Query q = em.createQuery("select P FROM Professor P WHERE P.matricule = :m and P.password = :pass");
		q.setParameter("m", matricule);
		q.setParameter("pass", password);
		return (Professor) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Privileges> getAllPreviligeByGrade(int idGrade) {
		Query q =em.createQuery("select pr from Privileges pr JOIN pr.gradeProfessors gr where gr.idGrade = :idg");
		q.setParameter("idg",idGrade);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProfessorGrade> getAllGradeByProf(int idProf) {
		Query q =em.createQuery("select g from ProfessorGrade g JOIN g.professors p where p.idProfessor = :idp");
		q.setParameter("idp",idProf);
		return q.getResultList();
	}

	@Override
	public Privileges givProfPrivileg(Privileges pv,Professor p,ProfessorGrade pg) {
		pv.getGradeProfessors().add(pg);
		em.persist(pv);
		em.flush();
		pg.getProfessors().add(p);
		em.merge(pg);
		return pv;
	}

	@Override
	public Professor upStatusProf(Professor p) {
		em.merge(p);
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Professor getProfByMatricule(String matricule) {
		Query q = em.createQuery("select p from Professor p where p.matricule = :m");
		q.setParameter("m", matricule);
		return (Professor) q.getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public Ville addVille(Ville v) {
		em.persist(v);
		em.flush();
		return v;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ville> getAllVille() {
		Query q = em.createQuery("select v from Ville v");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ville> getAllVilleByPays(Pays p) {
		Query q = em.createQuery("select v from Ville v where v.pays = :pays");
		q.setParameter("pays", p.getName());
		return q.getResultList();
	}

	@Override
	public Pays addPays(Pays p) {
		em.persist(p);
		em.flush();
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pays> getAllPays() {
		Query q = em.createQuery("select p from Pays p");
		return q.getResultList();
	}

	@Override
	public Ville getVille(int idVille) {
		return em.find(Ville.class, idVille);
	}

	@Override
	public Pays getPays(String name) {
		return em.find(Pays.class, name);
	}

	

}
