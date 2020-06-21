package com.order.mission.entities;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idState;
	private String name;
	private Date startDate;
	private Date endDate;
	@OneToMany
	private Collection<Mission> mission;
	@OneToOne
	private State state;

	public State() {
		super();
	}

	public State(int idState, String name, Date startDate, Date endDate) {
		super();
		this.idState = idState;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public State(String name, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

}