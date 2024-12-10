package com.alperencitak.sis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_students")
public class UserStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	
	@NotNull(message = "Username cannot be null")
	@Size(max = 100, message = "Username cannot exceed 100 characters")
	@Column(name = "username")
	private String username;
	
	@NotNull(message = "Password hash cannot be null")
	@Size(max = 255, message = "Password hash cannot exceed 255 characters")
	@Column(name = "password_hash")
	private String password_hash;
	
	@NotNull(message = "Role cannot be null")
	@Size(max = 50, message = "Role cannot exceed 50 characters")
	@Column(name = "role")
	private String role;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "related_id", referencedColumnName = "student_id")
	private Student student;

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
