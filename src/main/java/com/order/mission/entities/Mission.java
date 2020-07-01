package com.order.mission.entities;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMission;
	private String subject;
	@ManyToOne
	@JoinColumn(name = "destination")
	private Ville destination;
	private Date departureTime;
	private Date returnTime;
	private Date creationDate;
	private Date expiryDate;
	private String rejectionRaison;
	private String comment;
	@ManyToOne
	@JoinColumn(name = "id_state")
	private State state;
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	@ManyToOne
	@JoinColumn(name = "id_departement")
	private Departement departement;
	@ManyToMany()
	@JoinTable(name = "mission_trans", joinColumns = @JoinColumn(name = "id_mission"),
	inverseJoinColumns = @JoinColumn(name="id_trans"))
	private Collection<Transport> transport;
	@OneToMany(mappedBy = "mission")
	private Collection<JustificationDocument> justificationDocument;
	@OneToMany
	private Collection<DetailMission> detailMission;

	public Mission() {
		super();
	}

	public Mission(int idMission, String subject, Ville destination, Date departureTime, Date returnTime,
			Date creationDate, Date expiryDate, String rejectionRaison, String comment) {
		super();
		this.idMission = idMission;
		this.subject = subject;
		this.destination = destination;
		this.departureTime = departureTime;
		this.returnTime = returnTime;
		this.creationDate = creationDate;
		this.expiryDate = expiryDate;
		this.rejectionRaison = rejectionRaison;
		this.comment = comment;
	}

	public Mission(String subject, Ville destination, Date departureTime, Date returnTime, Date creationDate,
			Date expiryDate, String rejectionRaison, String comment) {
		super();
		this.subject = subject;
		this.destination = destination;
		this.departureTime = departureTime;
		this.returnTime = returnTime;
		this.creationDate = creationDate;
		this.expiryDate = expiryDate;
		this.rejectionRaison = rejectionRaison;
		this.comment = comment;
	}

	public int getIdMission() {
		return idMission;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Ville getDestination() {
		return destination;
	}

	public void setDestination(Ville destination) {
		this.destination = destination;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Collection<Transport> getTransport() {
		return transport;
	}

	public void setTransport(Collection<Transport> transport) {
		this.transport = transport;
	}

	public Collection<JustificationDocument> getJustificationDocument() {
		return justificationDocument;
	}

	public void setJustificationDocument(Collection<JustificationDocument> justificationDocument) {
		this.justificationDocument = justificationDocument;
	}

	public Collection<DetailMission> getDetailMission() {
		return detailMission;
	}

	public void setDetailMission(Collection<DetailMission> detailMission) {
		this.detailMission = detailMission;
	}

}