package com.alperencitak.sis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "instructors")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private Integer instructor_id;
	
	@NotNull(message = "Full name cannot be null")
	@Size(max = 100, message = "Full name cannot exceed 100 characters")
	@Column(name = "full_name")
	private String full_name;
	
	@Size(max = 50, message = "Title cannot exceed 50 characters")
	@Column(name = "title")
	private String title;
	
	@NotNull(message = "Department cannot be null")
	@Size(max = 100, message = "Department cannot exceed 100 characters")
	@Column(name = "department")
	private String department;
	
	@NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
	@Size(max = 100, message = "Email cannot exceed 100 characters")
	@Column(name = "email", unique = true)
	private String email;

	public Integer getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(Integer instructor_id) {
		this.instructor_id = instructor_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
