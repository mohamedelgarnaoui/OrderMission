package com.order.mission.model;

import java.util.Date;

import com.order.mission.entities.Departement;
import com.order.mission.entities.Professor;
import com.order.mission.entities.State;

public class MissionModel {
	private int idMission;
	private String subject;
	private String destination;
	private Date departureTime;
	private Date returnTime;
	private Date creationDate;
	private Date expiryDate;
	private String rejectionRaison;
	private String comment;
	private State state;
	private Professor professor;
	private Departement departement;
	
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getRejectionRaison() {
		return rejectionRaison;
	}
	public void setRejectionRaison(String rejectionRaison) {
		this.rejectionRaison = rejectionRaison;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getIdMission() {
		return idMission;
	}
	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}
	
	
}
