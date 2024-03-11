package com.Hackerverse.bean;

import java.util.List;

public class TeamCreationInput {

	private String teamName;
	List<User> users;

	public TeamCreationInput(String teamName, List<User> users) {
		super();
		this.teamName = teamName;
		this.users = users;
	}
	public TeamCreationInput() {
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
