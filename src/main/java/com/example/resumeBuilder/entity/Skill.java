package com.example.resumeBuilder.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Skill {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	 
	 private String name;
	 @ManyToOne
	    @JoinColumn(name = "user_id")
	    @JsonBackReference
	    private User user; 
	 public Skill() {
		 
	 }
	 
	 public Skill(Long id, String name, User user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}

	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public User getUser() {
		 return user;
	 }
	 public void setUser(User user) {
		 this.user = user;
	 }
	 
	 
	 
}
