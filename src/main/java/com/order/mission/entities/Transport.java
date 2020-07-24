package com.order.mission.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Transport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransport;
	private String typeTransport;
	private String comment;
	private String driver;
	
	@ManyToMany(mappedBy = "transport")
	private Collection<Mission> missions;

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

	public Collection<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Collection<Mission> missions) {
		this.missions = missions;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

}