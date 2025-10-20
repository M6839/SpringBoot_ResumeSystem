package com.example.resumeBuilder.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String github;
    private String portfolio;
    private String linkedin;
    private String phone;
    private String location;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Skill> skills ;

    
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Education> education;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Experience> experience;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Project> projects;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Certifications> certifications;
    
public User() {
	
}

public User(Long id, String name, String email, String password, String github, String portfolio, String linkedin,
		String phone, String location, List<Skill> skills, List<Education> education,
		List<Experience> experience, List<Project> projects, List<Certifications> certifications) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.github = github;
	this.portfolio = portfolio;
	this.linkedin = linkedin;
	this.phone = phone;
	this.location = location;
	this.skills = skills;
	this.education = education;
	this.experience = experience;
	this.projects = projects;
	this.certifications = certifications;
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

public String getGithub() {
	return github;
}

public void setGithub(String github) {
	this.github = github;
}

public String getPortfolio() {
	return portfolio;
}

public void setPortfolio(String portfolio) {
	this.portfolio = portfolio;
}

public String getLinkedin() {
	return linkedin;
}

public void setLinkedin(String linkedin) {
	this.linkedin = linkedin;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public List<Skill> getSkills() {
	return skills;
}

public void setSkills(List<Skill> skills) {
	this.skills = skills;
}


public List<Education> getEducation() {
	return education;
}

public void setEducation(List<Education> education) {
	this.education = education;
}

public List<Experience> getExperience() {
	return experience;
}

public void setExperience(List<Experience> experience) {
	this.experience = experience;
}

public List<Project> getProjects() {
	return projects;
}

public void setProjects(List<Project> projects) {
	this.projects = projects;
}

public List<Certifications> getCertifications() {
	return certifications;
}

public void setCertifications(List<Certifications> certifications) {
	this.certifications = certifications;
}


}	