package com.order.mission.entities;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProfessorGrade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGrade;
	private String grade;
	@ManyToOne
	private Professor professor;
	@OneToMany
	private Collection<Privileges> privileges;

	public ProfessorGrade() {

	}

	public ProfessorGrade(int idGrade, String grade) {
		super();
		this.idGrade = idGrade;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Collection<Privileges> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privileges> privileges) {
		this.privileges = privileges;
	}

}