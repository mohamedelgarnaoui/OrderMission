package com.order.mission.model;

import java.io.File;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.order.mission.entities.Departement;
import com.order.mission.entities.Mission;
import com.order.mission.entities.Professor;
import com.order.mission.entities.State;
import com.order.mission.entities.Transport;
import com.order.mission.entities.Ville;

public class MissionModel {
	private String idMission;
	@NotNull @NotEmpty
	private String subject;
	@NotNull
	private String destination;
	@NotEmpty @NotNull
	private String departureTime;
	private String returnTime;
	private String creationDate;
	@NotEmpty @NotNull
	private String expiryDate;
	private String rejectionRaison;
	private String comment;
	@NotNull
	private String moyenTrans;
	private State state;
	private String professor;
	@NotNull @NotEmpty
	private String departement;
	private File justif;
	private boolean isupdate;
	private String image;
	
	private List<Departement> departements;
	private List<Ville> villes;
	private List<Transport> transports;
	
	// for add some element when we need them
	private String departementName;
	private String nameVille;
	private String pays;
	
	private Professor prof;
	
	private List<Mission> missions;
	
	
	public String getIdMission() {
		return idMission;
	}
	public void setIdMission(String idMission) {
		this.idMission = idMission;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getRejectionRaison() {
		return rejectionRaison;
	}
	public void setRejectionRaison(String rejectionRaison) {
		this.rejectionRaison = rejectionRaison;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getMoyenTrans() {
		return moyenTrans;
	}
	public void setMoyenTrans(String moyenTrans) {
		this.moyenTrans = moyenTrans;
	}
	public File getJustif() {
		return justif;
	}
	public boolean isIsupdate() {
		return isupdate;
	}
	public void setIsupdate(boolean isupdate) {
		this.isupdate = isupdate;
	}
	public void setJustif(File justif) {
		this.justif = justif;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public List<Departement> getDepartements() {
		return departements;
	}
	public String getNameVille() {
		return nameVille;
	}
	public void setNameVille(String nameVille) {
		this.nameVille = nameVille;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getDepartementName() {
		return departementName;
	}
	public void setDepartementName(String departementName) {
		this.departementName = departementName;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public List<Ville> getVilles() {
		return villes;
	}
	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}
	public List<Transport> getTransports() {
		return transports;
	}
	public void setTransports(List<Transport> transports) {
		this.transports = transports;
	}
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		this.prof = prof;
	}
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
