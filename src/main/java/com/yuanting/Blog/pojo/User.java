package com.yuanting.Blog.pojo;

import java.util.List;

public class User {

	private int userId;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private List<Role> roles;
	
	private Profile profile;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return this.username + " " + this.password + " " + this.roles.size();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
