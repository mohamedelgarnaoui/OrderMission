package com.order.mission.model;

public class LoginModel {

	private String matricule;
	private String password;
	
	public LoginModel(String matricule, String password) {
		super();
		this.matricule = matricule;
		this.password = password;
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
	
	
	
}
