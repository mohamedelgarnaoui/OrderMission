package com.order.mission.entities;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idState;
	private String name;
	private String action;
	private int time;
	@OneToMany(mappedBy = "state")
	private Collection<Mission> mission;
	@OneToOne
	@JoinColumn(name = "id_state")
	private State state;
	@ManyToOne
	@JoinColumn(name = "id_priv")
	private Privileges privilege;
	
	public State() {
		super();
	}

	public State(int idState, String name, int time) {
		super();
		this.idState = idState;
		this.name = name;
		this.time = time;
	}

	public State(String name, String action, int time) {
		super();
		this.name = name;
		this.action = action;
		this.time = time;
	}

	public int getIdState() {
		return idState;
	}

	public void setIdState(int idState) {
		this.idState = idState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Collection<Mission> getMission() {
		return mission;
	}

	public void setMission(Collection<Mission> mission) {
		this.mission = mission;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Privileges getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privileges privilege) {
		this.privilege = privilege;
	}

}