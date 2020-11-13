package com.kelly.DojoOverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

@Entity
@Table(name="questions")
public class Question{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String text;
	private String stringTags;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(mappedBy="question", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name= "tags_questions",
		joinColumns = @JoinColumn(name="question_id"),
		inverseJoinColumns = @JoinColumn(name="tag_id"))
	private List<Tag> tags;
	

		
	public Question() {
			
	}
	
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getStringTags() {
		return stringTags;
	}
	public void setStringTags(String stringTags) {
		this.stringTags = stringTags;
	}
	
}