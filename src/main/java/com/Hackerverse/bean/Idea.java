package com.Hackerverse.bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Idea {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int ideaId;
	private String ideaTitle;
	private String description;
	private String status;
	private String domain;
	private int teamId;
	private String submissionLink;
	private int panelistId;
	
	public Idea() {
		
	}
	public Idea(String ideaTitle, String description, String status, String domain, int teamId, String submissionLink,
			int panelistId) {
		super();
		this.ideaTitle = ideaTitle;
		this.description = description;
		this.status = status;
		this.domain = domain;
		this.teamId = teamId;
		this.submissionLink = submissionLink;
		this.panelistId = panelistId;
	}


	public int getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}
	public String getIdeaTitle() {
		return ideaTitle;
	}
	public void setIdeaTitle(String ideaTitle) {
		this.ideaTitle = ideaTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getSubmissionLink() {
		return submissionLink;
	}
	public void setSubmissionLink(String submissionLink) {
		this.submissionLink = submissionLink;
	}
	public int getPanelistId() {
		return panelistId;
	}
	public void setPanelistId(int panelistId) {
		this.panelistId = panelistId;
	}
	
}
