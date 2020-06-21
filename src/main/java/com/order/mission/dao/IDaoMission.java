package com.order.mission.dao;

import java.util.List;

import com.order.mission.entities.DetailMission;
import com.order.mission.entities.DocumentType;
import com.order.mission.entities.JustificationDocument;
import com.order.mission.entities.Mission;
import com.order.mission.entities.State;
import com.order.mission.entities.Transport;

public interface IDaoMission {

	//mission
	public Mission AddMission(Mission m);
	public Mission deleteMission(int idMission);
	public Mission updateMission(Mission m);
	public Mission getMission(int idMission);
	public List<Mission> getAllMission();

	//DocumentType
	public DocumentType AddDocumentType(DocumentType dt);
	public DocumentType deleteDocumentType(int idDocumentType);
	public DocumentType updateDocumentType(DocumentType dt);
	public DocumentType getDocumentType(int idDocumentType);
	public List<DocumentType> getAllDocumentType();

	//JustificationDocument
	public JustificationDocument AddJustificationDocument(JustificationDocument jd);
	public JustificationDocument deleteJustificationDocument(int idJustificationDocument);
	public JustificationDocument updateJustificationDocument(JustificationDocument jd);
	public JustificationDocument getJustificationDocument(int idJustificationDocument);
	public List<JustificationDocument> getAllJustificationDocument();

	//DetailMission
	public DetailMission AddDetailMission(DetailMission dm);
	public DetailMission deleteDetailMission(int idDetailMission);
	public DetailMission updateDetailMission(DetailMission dm);
	public DetailMission getDetailMission(int idDetailMission);
	public List<DetailMission> getAllDetailMission();

	//Transport
	public Transport AddTransport(Transport t);
	public Transport deleteTransport(int idTransport);
	public Transport updateTransport(Transport t);
	public Transport getTransport(int idTransport);
	public List<Transport> getTransport();

	//State
	public State AddState(State s);
	public State deleteState(int idState);
	public State updateState(State s);
	public State getState(int idState);
	public List<State> getAllState();

}