package com.order.mission.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransport;
	private String typeTransport;
	private String comment;
	@ManyToOne
	@JoinColumn(name = "id_mission")
	private Mission mission;

	public Transport() {
		super();
	}

	public Transport(int idTransport, String typeTransport, String comment) {
		super();
		this.idTransport = idTransport;
		this.typeTransport = typeTransport;
		this.comment = comment;
	}

	public Transport(String typeTransport, String comment) {
		super();
		this.typeTransport = typeTransport;
		this.comment = comment;
	}


	public int getIdTransport() {
		return idTransport;
	}

	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}

	public String getTypeTransport() {
		return typeTransport;
	}

	public void setTypeTransport(String typeTransport) {
		this.typeTransport = typeTransport;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

}