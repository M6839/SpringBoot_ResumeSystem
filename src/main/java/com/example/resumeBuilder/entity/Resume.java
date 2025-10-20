package com.example.resumeBuilder.entity;


import jakarta.persistence.*;


@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String headline;
    @Column(length = 2000)
    private String summary;
    @Column(length = 2000)
    private String json;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Resume() {
    	
    }
	public Resume(Long id, String headline, String summary, String json, User user) {
		super();
		this.id = id;
		this.headline = headline;
		this.summary = summary;
		this.json = json;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
    
}
