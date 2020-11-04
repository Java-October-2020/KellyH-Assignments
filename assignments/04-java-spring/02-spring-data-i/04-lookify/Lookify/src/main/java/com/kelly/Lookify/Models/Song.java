package com.kelly.Lookify.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
//import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Song {
	
@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column
@Size(min = 5)
private	String artist;
@Column
@Size(min = 5)
private	String title;
@Column
@Size(min = 1, max = 10)
private	int rating;

@Column
private Date updatedAt;
@Column
private Date createdAt;



	public Song() {
		
	}

	public Song(String title, String artist, int rating, Date updatedAt, Date createdAt) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}