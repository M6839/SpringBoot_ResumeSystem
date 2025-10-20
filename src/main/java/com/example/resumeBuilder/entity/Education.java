package com.example.resumeBuilder.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="education")
public class Education {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String instistution;
	private String degree;
	private String year;
	private String cgpa;
	private String achievements;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
	
	public Education() {
		
	}

	public Education(Long id, String instistution, String degree, String year, String cgpa, String achievements,
			User user) {
		super();
		this.id = id;
		this.instistution = instistution;
		this.degree = degree;
		this.year = year;
		this.cgpa = cgpa;
		this.achievements = achievements;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstistution() {
		return instistution;
	}

	public void setInstistution(String instistution) {
		this.instistution = instistution;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}