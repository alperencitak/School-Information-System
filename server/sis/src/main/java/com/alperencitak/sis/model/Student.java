package com.alperencitak.sis.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer student_id;
	
	@NotNull(message = "First name cannot be null.")
	@Size(max = 50, message = "First name cannot exceed 50 characters")
	@Column(name = "first_name")
	private String first_name;
	
	@NotNull(message = "Last name cannot be null.")
	@Size(max = 50, message = "Last name cannot exceed 50 characters")
	@Column(name = "last_name")
	private String last_name;
	
	@NotNull(message = "Email cannot be null")
	@Size(max = 100, message = "Email cannot exceed 100 characters")
	@Email(message = "Email should be valid")
	@Column(name = "email", unique = true)
	private String email;
	
	@NotNull(message = "Instructor ID cannot be null")
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	@NotNull(message = "Enrollment Date cannot be null")
	@Column(name = "enrollment_date")
	private LocalDate enrollment_date;
	
	@OneToMany(mappedBy = "student")
    private Set<Selected_Lesson> selections;
	
	@PrePersist
	public void prePersist() {
		if(this.enrollment_date == null) {
			this.enrollment_date = LocalDate.now();
		}
	}

	public Set<Selected_Lesson> getSelections() {
		return selections;
	}

	public void setSelections(Set<Selected_Lesson> selections) {
		this.selections = selections;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public LocalDate getEnrollment_date() {
		return enrollment_date;
	}

	public void setEnrollment_date(LocalDate enrollment_date) {
		this.enrollment_date = enrollment_date;
	}
	
}
