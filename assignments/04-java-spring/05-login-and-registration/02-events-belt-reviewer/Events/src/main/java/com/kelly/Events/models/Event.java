package com.kelly.Events.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String eventName;
	@NotBlank
	private String eventLocation;
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd") //to get from HTML
	private Date eventDate;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	private String state;
	//Events hosted by one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User host;
    //Event Messages
    @OneToMany(mappedBy="event", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> eventMessages;
    //Events attended by User
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_attending",
    	joinColumns = @JoinColumn(name="event_id"),
    	inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<User> usersAttending;
    public Event() {
    	
    }
    @PrePersist
    public void onCreate() {
    	this.createdAt = new Date();
    }
    @PreUpdate
    public void onUpdate() {
    	this.updatedAt = new Date();
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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<Message> getEventMessages() {
		return eventMessages;
	}

	public void setEventMessages(List<Message> eventMessages) {
		this.eventMessages = eventMessages;
	}

	public List<User> getUsersAttending() {
		return usersAttending;
	}

	public void setUsersAttending(List<User> usersAttending) {
		this.usersAttending = usersAttending;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    
    
}
