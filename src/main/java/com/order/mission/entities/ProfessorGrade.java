package com.order.mission.entities;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ProfessorGrade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGrade;
	private String grade;
	@ManyToMany(mappedBy = "professorGrade")
	private Collection<Professor> professors;
	@ManyToMany()
	@JoinTable(name="priv_grade", joinColumns=@JoinColumn(name="idGrade"),
	inverseJoinColumns=@JoinColumn(name="idPriv"))
	private Collection<Privileges> privileges;

	public ProfessorGrade() {

	}

	public ProfessorGrade(String grade) {
		super();
		this.grade = grade;
	}

	public int getIdGrade() {
		return idGrade;
	}

	public void setIdGrade(int idGrade) {
		this.idGrade = idGrade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Collection<Professor> getProfessors() {
		return professors;
	}

	public void setProfessor(Collection<Professor> professors) {
		this.professors = professors;
	}

	public Collection<Privileges> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privileges> privileges) {
		this.privileges = privileges;
	}

}