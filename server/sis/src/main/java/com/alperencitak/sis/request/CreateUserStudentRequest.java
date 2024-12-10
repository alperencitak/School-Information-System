package com.alperencitak.sis.request;

public class CreateUserStudentRequest {

	private String username;
    private String password_hash;
    private String role;
    private Integer instructor_id;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword_hash() {
		return password_hash;
	}
	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
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
