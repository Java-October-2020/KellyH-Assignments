package com.kelly.DojoOverflow.models;

import java.util.List;

public class NewQuestion{
	private String question;
	private List<Tag> tags;
	
	public NewQuestion() {
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}