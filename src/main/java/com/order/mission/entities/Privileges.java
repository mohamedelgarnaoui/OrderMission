package com.order.mission.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Privileges {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPriv;
	@Column(nullable = false, unique = true)
	private String name;
	@ManyToMany(mappedBy = "privileges")
	private Collection<ProfessorGrade> gradeProfessors;
	
	public Privileges() {
		super();
	}
	
	public Privileges(int idPriv, String name) {
		super();
		this.idPriv = idPriv;
		this.name = name;
	}
	
	public Privileges(String name) {
		super();
		this.name = name;
	}

	public int getIdPriv() {
		return idPriv;
	}
	
	public void setIdPriv(int idPriv) {
		this.idPriv = idPriv;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<ProfessorGrade>  getGradeProfessors() {
		return gradeProfessors;
	}
	
	public void setGradeProfessors(Collection<ProfessorGrade> gradeProfessors) {
		this.gradeProfessors = gradeProfessors;
	}

}