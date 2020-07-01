package com.order.mission.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.order.mission.entities.DetailMission;
import com.order.mission.entities.DocumentType;
import com.order.mission.entities.JustificationDocument;
import com.order.mission.entities.Mission;
import com.order.mission.entities.State;
import com.order.mission.entities.Transport;

public class DaoMissionImpl implements IDaoMission{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Mission AddMission(Mission m) {
		em.persist(m);
		em.flush();
		return m;
	}

	@Override
	public Mission deleteMission(int idMission) {
		Mission m = getMission(idMission);
		em.remove(m);
		em.flush();
		return m;
	}

	@Override
	public Mission updateMission(Mission m) {
		em.merge(m);
		return m;
	}

	@Override
	public Mission getMission(int idMission) {
		return em.find(Mission.class, idMission);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mission> getAllMission() {
		Query q = em.createQuery("select m from Mission m");
		return q.getResultList();
	}

	@Override
	public DocumentType AddDocumentType(DocumentType dt) {
		em.persist(dt);
		return dt;
	}

	@Override
	public DocumentType deleteDocumentType(int idDocumentType) {
		DocumentType dt = getDocumentType(idDocumentType);
		em.remove(dt);
		return dt;
	}

	@Override
	public DocumentType updateDocumentType(DocumentType dt) {
		em.merge(dt);
		return dt;
	}

	@Override
	public DocumentType getDocumentType(int idDocumentType) {
		return em.find(DocumentType.class, idDocumentType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentType> getAllDocumentType() {
		Query q =  em.createQuery("select dt from DocumentType dt");
		return q.getResultList();
	}

	@Override
	public JustificationDocument AddJustificationDocument(JustificationDocument jd) {
		em.persist(jd);
		em.flush();
		return jd;
	}

	@Override
	public JustificationDocument deleteJustificationDocument(int idJustificationDocument) {
		JustificationDocument jd = getJustificationDocument(idJustificationDocument);
		em.remove(jd);
		return jd;
	}

	@Override
	public JustificationDocument updateJustificationDocument(JustificationDocument jd) {
		em.merge(jd);
		return jd;
	}

	@Override
	public JustificationDocument getJustificationDocument(int idJustificationDocument) {	
		return em.find(JustificationDocument.class, idJustificationDocument);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JustificationDocument> getAllJustificationDocument() {
		Query q = em.createQuery("select jd from JustificationDocument jd");
		return q.getResultList();
	}

	@Override
	public DetailMission AddDetailMission(DetailMission dm) {
		em.persist(dm);
		return dm;
	}

	@Override
	public DetailMission deleteDetailMission(int idDetailMission) {
		DetailMission dm = getDetailMission(idDetailMission);
		em.remove(dm);
		return dm;
	}

	@Override
	public DetailMission updateDetailMission(DetailMission dm) {
		em.merge(dm);
		return dm;
	}

	@Override
	public DetailMission getDetailMission(int idDetailMission) {
		return em.find(DetailMission.class, idDetailMission);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailMission> getAllDetailMission() {
		Query q = em.createQuery("select dm from DetailMission dm");
		return q.getResultList();
	}

	@Override
	public Transport AddTransport(Transport t) {
		em.merge(t);
		return t;
	}

	@Override
	public Transport deleteTransport(int idTransport) {
		Transport t = getTransport(idTransport);
		em.remove(t);
		em.flush();
		return t;
	}

	@Override
	public Transport updateTransport(Transport t) {
		em.merge(t);
		return t;
	}

	@Override
	public Transport getTransport(int idTransport) {
		return em.find(Transport.class, idTransport);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transport> getAllTransport() {
		Query q = em.createQuery("select t from Transport t");
		return q.getResultList();
	}

	@Override
	public State AddState(State s) {
		em.persist(s);
		em.flush();
		return s;
	}

	@Override
	public State deleteState(int idState) {
		State s = getState(idState);
		em.remove(s);
		em.flush();
		return s;
	}

	@Override
	public State updateState(State s) {
		em.merge(s);
		return s;
	}

	@Override
	public State getState(int idState) {
		return em.find(State.class , idState);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<State> getAllState() {
		Query q = em.createQuery("select s from State s");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mission> getAllMisssionByDepartement(int idDep) {
		Query q = em.createQuery("select m from Mission m where m.departement.idDep=:idD");
		q.setParameter("idD", idDep);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transport> getAllTransportByMission(int idMission) {
		Query q = em.createQuery("select t from Transport t JOIN t.missions m where m.idMission=:idm");
		q.setParameter("idm", idMission);
		return q.getResultList();
	}

	@Override
	public State getStatByMission(int idMission) {
		Query q = em.createQuery("select s from State where s.mission.idMission=:idm");
		q.setParameter("idm", idMission);
		return (State) q.getSingleResult();
	}

	@Override
	public DetailMission detailmissionByMission(int idMission) {
		Query q = em.createQuery("select dm from DetailMission dm where dm.mission.idMission=:idDm");
		q.setParameter("idDm", idMission);
		return (DetailMission) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JustificationDocument> getJustificationDocByMission(int idMission) {
		Query q = em.createQuery("select jd from JustificationDocument jd where jd.mission.idMission=:idm");
		q.setParameter("idm", idMission);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Mission> getAllMissionByProf(int idProfessor) {
		Query q = em.createQuery("select M FROM Mission M WHERE M.professor.idProfessor=:idP");
		q.setParameter("idP", idProfessor);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mission> getAllMissionByDepByState(int idDep, int idState) {
		Query q = em.createQuery("select m from Mission m where m.state.idState=:ids and m.departement.idDep = :idd");
		q.setParameter("ids", idState);
		q.setParameter("idd", idDep);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mission> getAllMissionByProfByState(int idProf, int idState) {
		Query q = em.createQuery("select m from Mission m where m.state.idState=:ids and m.professor.idProfessor = :idp");
		q.setParameter("ids", idState);
		q.setParameter("idp", idProf);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mission> getAllMissionByState(int idState) {
		Query q = em.createQuery("select m from Mission m where m.state.idState=:ids");
		q.setParameter("ids", idState);
		return q.getResultList();
	}

}
