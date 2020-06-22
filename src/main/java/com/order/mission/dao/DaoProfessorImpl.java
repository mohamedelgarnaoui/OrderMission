package com.order.mission.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.order.mission.entities.Departement;
import com.order.mission.entities.Mission;
import com.order.mission.entities.Privileges;
import com.order.mission.entities.Professor;
import com.order.mission.entities.ProfessorGrade;

public class DaoProfessorImpl implements IDaoProfessor {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Professor addProfessor(Professor p) {
		em.persist(p);
		return p;
	}

	@Override
	public Professor deleteProfessor(int idProfessor) {
		Professor p = em.find(Professor.class, idProfessor);
		em.remove(p);
		return p;
	}

	@Override
	public Professor updateProfessor(Professor p) {
		em.merge(p);
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
		return pg;
	}

	@Override
	public ProfessorGrade deleteProfessorGrade(int idProfessorGrade) {
		ProfessorGrade pg = em.find(ProfessorGrade.class, idProfessorGrade);
		em.remove(pg);
		return pg;
	}

	@Override
	public ProfessorGrade updateProfessorGrade(ProfessorGrade pg) {
		em.merge(pg);
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
		return pv;
	}

	@Override
	public Privileges deletePrivileges(int idPrivileges) {
		Privileges pv = em.find(Privileges.class, idPrivileges);
		em.remove(pv);
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
		return dp;
	}

	@Override
	public Departement deleteDepartement(int idDepartement) {
		Departement dp = em.find(Departement.class, idDepartement);
		em.remove(dp);
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

	@Override
	public List<Mission> getAllMissionByProf(int idProfessor) {
		Query q = em.createQuery("select M FROM Mission M WHERE M.professor.idProfessor=:idP");
		q.setParameter("idP", idProfessor);
		return q.getResultList();
	}

	@Override
	public List<Privileges> getallpreviligebyprof(int idProfessor) {
		Query q =em.createQuery("select pr from Privileges pr and ProfessorGrade pg "
								+ "where pr.gradeProfessor.idGrade=pg.idGrade"
								+ "and pg.professor.idProfessor=:idp");
		q.setParameter("idp",idProfessor);
		return q.getResultList();
	}

	@Override
	public Privileges givProfPrivileg(Privileges pv,Professor p,ProfessorGrade pg) {
		pv.setGradeProfessor(pg);
		em.persist(pv);
		pg.setProfessor(p);
		em.merge(pg);
		return pv;
	}

	@Override
	public List<ProfessorGrade> getallgradbyprof(int idProfessor) {
		Query q = em.createQuery("select pg from ProfessorGrade pg "
				+ "where pg.professor.idProfessor=:idp");
		q.setParameter("idp", idProfessor);
		return q.getResultList();
	}

	@Override
	public Professor upStatusProf(Professor p) {
		em.merge(p);
		return p;
	}

}
