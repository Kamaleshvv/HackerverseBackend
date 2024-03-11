package com.Hackerverse.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int submissionId;
	private int ideaId;
    private int judgeId;
    private int category1;
    private int category2;
    private int category3;
    private int category4;
    private int category5;
	private int netRating;
	
	public Submission() {
		
	}
	public Submission(int ideaId, int judgeId, int category1, int category2, int category3, int category4,
			int category5, int netRating) {
		super();
		this.ideaId = ideaId;
		this.judgeId = judgeId;
		this.category1 = category1;
		this.category2 = category2;
		this.category3 = category3;
		this.category4 = category4;
		this.category5 = category5;
		this.netRating = netRating;
	}
	
	public int getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(int submissionId) {
		this.submissionId = submissionId;
	}
	public int getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}
	public int getJudgeId() {
		return judgeId;
	}
	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}
	public int getCategory1() {
		return category1;
	}
	public void setCategory1(int category1) {
		this.category1 = category1;
	}
	public int getCategory2() {
		return category2;
	}
	public void setCategory2(int category2) {
		this.category2 = category2;
	}
	public int getCategory3() {
		return category3;
	}
	public void setCategory3(int category3) {
		this.category3 = category3;
	}
	public int getCategory4() {
		return category4;
	}
	public void setCategory4(int category4) {
		this.category4 = category4;
	}
	public int getCategory5() {
		return category5;
	}
	public void setCategory5(int category5) {
		this.category5 = category5;
	}
	public int getNetRating() {
		return netRating;
	}
	public void setNetRating(int netRating) {
		this.netRating = netRating;
	}
	
}
