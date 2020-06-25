package com.order.mission.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDep;
	private String name;
	@OneToMany(mappedBy = "departement")
	private Collection<Professor> professors;
	@OneToMany(mappedBy = "departement")
	private Collection<Mission> missions;

	public Departement() {
		super();
	}

	public Departement(int idDep, String name) {
		super();
		this.idDep = idDep;
		this.name = name;
	}

	public Departement(String name) {
		super();
		this.name = name;
	}

	public int getIdDep() {
		return idDep;
	}

	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Collection<Professor> professors) {
		this.professors = professors;
	}

	public Collection<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Collection<Mission> missions) {
		this.missions = missions;
	}

}
