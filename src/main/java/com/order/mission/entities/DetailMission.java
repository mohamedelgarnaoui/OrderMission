package com.order.mission.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetailMission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetail;
	private String libelle;
	private String value;
	@ManyToOne
	@JoinColumn(name = "id_mission")
	private Mission mission;

	public DetailMission() {
		super();
	}

	public DetailMission(int idDetail, String libelle, String value) {
		super();
		this.idDetail = idDetail;
		this.libelle = libelle;
		this.value = value;
	}

	public DetailMission(String libelle, String value) {
		super();
		this.libelle = libelle;
		this.value = value;
	}

	public int getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(int idDetail) {
		this.idDetail = idDetail;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}


}
