package com.order.mission.services;

import java.util.List;

import com.order.mission.dao.IDaoMission;
import com.order.mission.entities.DetailMission;
import com.order.mission.entities.DocumentType;
import com.order.mission.entities.JustificationDocument;
import com.order.mission.entities.Mission;
import com.order.mission.entities.State;
import com.order.mission.entities.Transport;

public class ServiceMissionImpl implements IServiceMission {

	IDaoMission dao;
	
	public void setDao(IDaoMission dao) {
		this.dao = dao;
	}

	@Override
	public Mission AddMission(Mission m) {
		return dao.AddMission(m);
	}

	@Override
	public Mission deleteMission(int idMission) {
		return dao.deleteMission(idMission);
	}

	@Override
	public Mission updateMission(Mission m) {
		return dao.updateMission(m);
	}

	@Override
	public Mission getMission(int idMission) {
		return dao.getMission(idMission);
	}

	@Override
	public List<Mission> getAllMission() {
		return dao.getAllMission();
	}

	@Override
	public DocumentType AddDocumentType(DocumentType dt) {
		return dao.AddDocumentType(dt);
	}

	@Override
	public DocumentType deleteDocumentType(int idDocumentType) {
		return dao.deleteDocumentType(idDocumentType);
	}

	@Override
	public DocumentType updateDocumentType(DocumentType dt) {
		return dao.updateDocumentType(dt);
	}

	@Override
	public DocumentType getDocumentType(int idDocumentType) {
		return dao.getDocumentType(idDocumentType);
	}

	@Override
	public List<DocumentType> getAllDocumentType() {
		return dao.getAllDocumentType();
	}

	@Override
	public JustificationDocument AddJustificationDocument(JustificationDocument jd) {
		return dao.AddJustificationDocument(jd);
	}

	@Override
	public JustificationDocument deleteJustificationDocument(int idJustificationDocument) {
		return dao.deleteJustificationDocument(idJustificationDocument);
	}

	@Override
	public JustificationDocument updateJustificationDocument(JustificationDocument jd) {
		return dao.updateJustificationDocument(jd);
	}

	@Override
	public JustificationDocument getJustificationDocument(int idJustificationDocument) {
		return dao.getJustificationDocument(idJustificationDocument);
	}

	@Override
	public List<JustificationDocument> getAllJustificationDocument() {
		return dao.getAllJustificationDocument();
	}

	@Override
	public DetailMission AddDetailMission(DetailMission dm) {
		return dao.AddDetailMission(dm);
	}

	@Override
	public DetailMission deleteDetailMission(int idDetailMission) {
		return dao.deleteDetailMission(idDetailMission);
	}

	@Override
	public DetailMission updateDetailMission(DetailMission dm) {
		return dao.updateDetailMission(dm);
	}

	@Override
	public DetailMission getDetailMission(int idDetailMission) {
		return dao.getDetailMission(idDetailMission);
	}

	@Override
	public List<DetailMission> getAllDetailMission() {
		return dao.getAllDetailMission();
	}

	@Override
	public Transport AddTransport(Transport t) {
		return dao.AddTransport(t);
	}

	@Override
	public Transport deleteTransport(int idTransport) {
		return dao.deleteTransport(idTransport);
	}

	@Override
	public Transport updateTransport(Transport t) {
		return dao.updateTransport(t);
	}

	@Override
	public Transport getTransport(int idTransport) {
		return dao.getTransport(idTransport);
	}

	@Override
	public List<Transport> getAllTransport() {
		return dao.getAllTransport();
	}

	@Override
	public State AddState(State s) {
		return dao.AddState(s);
	}

	@Override
	public State deleteState(int idState) {
		return dao.deleteState(idState);
	}

	@Override
	public State updateState(State s) {
		return dao.updateState(s);
	}

	@Override
	public State getState(int idState) {
		return dao.getState(idState);
	}

	@Override
	public List<State> getAllState() {
		return dao.getAllState();
	}

}
