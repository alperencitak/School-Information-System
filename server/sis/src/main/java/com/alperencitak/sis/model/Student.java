package com.alperencitak.sis.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer studentId;

	@NotNull(message = "First name cannot be null.")
	@Size(max = 50, message = "First name cannot exceed 50 characters")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "Last name cannot be null.")
	@Size(max = 50, message = "Last name cannot exceed 50 characters")
	@Column(name = "last_name")
	private String lastName;

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
	private LocalDate enrollmentDate;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<SelectedLesson> selections;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private UserStudent userStudent;

	@PrePersist
	public void prePersist() {
		if(this.enrollmentDate == null) {
			this.enrollmentDate = LocalDate.now();
		}
	}

	public UserStudent getUserStudent() {
		return userStudent;
	}

	public void setUserStudent(UserStudent userStudent) {
		this.userStudent = userStudent;
	}

	public Set<SelectedLesson> getSelections() {
		return selections;
	}

	public void setSelections(Set<SelectedLesson> selections) {
		this.selections = selections;
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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

}
