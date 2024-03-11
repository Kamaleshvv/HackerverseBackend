package com.Hackerverse.bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Team {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int teamId;
	private String name;
	private int leaderId;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Idea idea;

	public Team(String name, int leaderId, Idea idea) {
		super();
		this.name = name;
		this.leaderId = leaderId;
		this.idea = idea;
	}
	public Team() {
		
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}
	public Idea getIdea() {
		return idea;
	}
	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	
}
