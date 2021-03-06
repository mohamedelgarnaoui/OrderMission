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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProfessor;
	private String email;
	private String matricule;
	private String password;
	private String lastName;
	private String firstName;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	private String adresses;
	private String city;
	private String phone;
	private String mobile;
	private String numCIN;
	private String resume;
	private String photo;
	private String CINPrinted;
	private String status;
	private String profession;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name="id_departement")
	private Departement departement;
	@ManyToMany()
	@JoinTable(name = "grades_profs",
		joinColumns = @JoinColumn(name = "idProfessor"),
		inverseJoinColumns =@JoinColumn(name = "idGrade"))
	private Collection<ProfessorGrade> professorGrade;
	@OneToMany(mappedBy = "professor")
	private Collection<Mission> mission;
	
	public Professor() {
		super();
	}
	
	public Professor(int idProfessor, String email,String matricule, String password, String lastName, String firstName, Date birthDate,
			String adresses, String city, String phone, String mobile, String numCIN, String resume, String photo,
			String CINPrinted, String status) {
		super();
		this.idProfessor = idProfessor;
		this.email = email;
		this.matricule = matricule;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.adresses = adresses;
		this.city = city;
		this.phone = phone;
		this.mobile = mobile;
		this.numCIN = numCIN;
		this.resume = resume;
		this.photo = photo;
		this.CINPrinted = CINPrinted;
		this.status = status;
	}
	public Professor(String email,String matricule, String password, String lastName, String firstName, Date birthDate, String adresses,
			String city, String phone, String mobile, String numCIN, String resume, String photo, String CINPrinted, String status,
			String profession) {
		super();
		this.email = email;
		this.matricule = matricule;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.adresses = adresses;
		this.city = city;
		this.phone = phone;
		this.mobile = mobile;
		this.numCIN = numCIN;
		this.resume = resume;
		this.photo = photo;
		this.CINPrinted = CINPrinted;
		this.status = status;
		this.profession = profession;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
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

	public String getcINPrinted() {
		return CINPrinted;
	}

	public void setcINPrinted(String cINPrinted) {
		this.CINPrinted = cINPrinted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Collection<ProfessorGrade> getProfessorGrade() {
		return professorGrade;
	}

	public void setProfessorGrade(Collection<ProfessorGrade> professorGrade) {
		this.professorGrade = professorGrade;
	}

	public Collection<Mission> getMission() {
		return mission;
	}

	public void setMission(Collection<Mission> mission) {
		this.mission = mission;
	}

	public String getCINPrinted() {
		return CINPrinted;
	}

	public void setCINPrinted(String cINPrinted) {
		CINPrinted = cINPrinted;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

}