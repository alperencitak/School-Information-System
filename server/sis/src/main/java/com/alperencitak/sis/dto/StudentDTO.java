package com.alperencitak.sis.dto;

import java.time.LocalDate;
import java.util.Set;

public class StudentDTO {

	private Integer studentId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer instructorId;
    private LocalDate enrollmentDate;
    private Set<SelectedLessonDTO> selections;
    private UserStudentDTO userStudent;

	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Set<SelectedLessonDTO> getSelections() {
		return selections;
	}
	public void setSelections(Set<SelectedLessonDTO> selections) {
		this.selections = selections;
	}
	public UserStudentDTO getUserStudent() {
		return userStudent;
	}
	public void setUserStudent(UserStudentDTO userStudent) {
		this.userStudent = userStudent;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

}
