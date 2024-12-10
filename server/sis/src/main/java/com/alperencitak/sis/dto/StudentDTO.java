package com.alperencitak.sis.dto;

import java.time.LocalDate;

public class StudentDTO {

	private Integer student_id;
    private String first_name;
    private String last_name;
    private String email;
    private String instructor_id;
    private LocalDate enrollment_date;
    
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
	public String getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(String instructor_id) {
		this.instructor_id = instructor_id;
	}
	public LocalDate getEnrollment_date() {
		return enrollment_date;
	}
	public void setEnrollment_date(LocalDate enrollment_date) {
		this.enrollment_date = enrollment_date;
	}
    
}
