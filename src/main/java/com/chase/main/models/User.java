package com.chase.main.models;

import java.util.Date;
import java.util.List;

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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


//<<---------------User Model--------------->>
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Size(min=1, max=255, message="Please input a username greater than one character")
	private String username;
	
	@Email(message="Invalid Email")
	@Size(min=1, max=255, message="Please input a valid email")
	private String email;
	
	@Size(min=6, max=255, message="Please input a password greater than 6 characters")
	private String password;
	
	@Size(min=6, max=255, message="Please input a password greater than 6 characters")
	@Transient
	private String confirmation;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
//	<<---------------One To Many Relationship--------------->>
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Tv> tv;
	
	
//	<<---------------Many To Many Relationship--------------->>
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "users_tvs", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "tv_id")
	    )
	
	private List<Tv> show;
	
//	<<---------------Defining Constructor--------------->>	
	public User() {
		
	}

	public User(@Size(min = 1, max = 255, message = "Please input a username greater than one character") String username,
		@Email(message = "Invalid Email") @Size(min = 1, max = 255, message = "Please input a valid email") String email,
		@Size(min = 6, max = 255, message = "Please input a password greater than 6 characters") String password,
		@Size(min = 6, max = 255, message = "Please input a password greater than 6 characters") String confirmation,
		List<Tv> ideas, List<Tv> idea) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmation = confirmation;
}

//	<<---------------Getters and Setters--------------->>
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
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

	
	public List<Tv> getShows() {
		return tv;
	}

	public void setIdeas(List<Tv> shows) {
		this.tv = tv;
	}

	public List<Tv> getShow() {
		return tv;
	}

	public void setIdea(List<Tv> show) {
		this.tv = show;
	}

	//	<<---------------Creating/Updating--------------->>
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}