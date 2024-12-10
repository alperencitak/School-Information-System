package com.alperencitak.sis.dto;

public class UserInstructorDTO {

	private Integer user_id;
	private String username;
	private String role;
	private Integer instructor_id;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(Integer instructor_id) {
		this.instructor_id = instructor_id;
	}
	
}
