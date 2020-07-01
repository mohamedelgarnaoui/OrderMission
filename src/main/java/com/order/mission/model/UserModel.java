package com.order.mission.model;

import java.util.List;

import com.order.mission.entities.Professor;
import com.order.mission.entities.ProfessorGrade;

public class UserModel {
	private String email;
	private String username;
	private String password;
	private String passwordConfirm;
	private String lastName;
	private String firstName;
	private String birthDate;
	private String adresses;
	private String city;
	private String phone;
	private String mobile;
	private String numCIN;
	private String resume;
	private String photo;
	private String CINPrinted;
	private String status;
	private String departement;
	private String profession;
	private String grade;
	private String image;
	
	private String action;
	
	private Professor prof;
	private List<Professor> professors;
	private List<ProfessorGrade> grades;


	public UserModel() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAdresses() {
		return adresses;
	}

	public void setAdresses(String adresses) {
		this.adresses = adresses;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNumCIN() {
		return numCIN;
	}

	public void setNumCIN(String numCIN) {
		this.numCIN = numCIN;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getCINPrinted() {
		return CINPrinted;
	}

	public void setCINPrinted(String cINPrinted) {
		CINPrinted = cINPrinted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public List<ProfessorGrade> getGrades() {
		return grades;
	}

	public void setGrades(List<ProfessorGrade> grades) {
		this.grades = grades;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
