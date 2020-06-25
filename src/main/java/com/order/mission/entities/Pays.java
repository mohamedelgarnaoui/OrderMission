package com.order.mission.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pays {
	
	@Id
	private String name;

	public Pays() {
		super();
	}

	public Pays(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
