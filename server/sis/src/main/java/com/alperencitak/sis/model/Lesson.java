package com.alperencitak.sis.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "lessons")
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id")
	private Integer lesson_id;
	
	@NotNull(message = "Lesson code cannot be null")
	@Size(max = 20, message = "Lesson code cannot exceed 20 characters")
	@Column(name = "lesson_code", unique = true)
	private String lesson_code;
	
	@NotNull(message = "Lesson name cannot be null")
	@Size(max = 100, message = "Lesson name cannot exceed 100 characters")
	@Column(name = "lesson_name")
	private String lesson_name;
	
	@NotNull(message = "Lesson requirement cannot be null")
	@Column(name = "is_mandatory")
	private Boolean is_mandatory;
	
	@NotNull(message = "Credit cannot be null")
	@Column(name = "credit")
	private Integer credit;
	
	@NotNull(message = "Department cannot be null")
	@Size(max = 100, message = "Department cannot exceed 100 characters")
	@Column(name = "department")
	private String department;
	
	@OneToMany(mappedBy = "lesson")
    private Set<SelectedLesson> selections;
    
    @NotNull(message = "Quota cannot be null")
    @Column(name = "quota")
    private Integer quota = 1000;

	public Set<SelectedLesson> getSelections() {
		return selections;
	}

	public void setSelections(Set<SelectedLesson> selections) {
		this.selections = selections;
	}

	public Integer getLesson_id() {
		return lesson_id;
	}

	public void setLesson_id(Integer lesson_id) {
		this.lesson_id = lesson_id;
	}

	public String getLesson_code() {
		return lesson_code;
	}

	public void setLesson_code(String lesson_code) {
		this.lesson_code = lesson_code;
	}

	public String getLesson_name() {
		return lesson_name;
	}

	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}

	public Boolean getIs_mandatory() {
		return is_mandatory;
	}

	public void setIs_mandatory(Boolean is_mandatory) {
		this.is_mandatory = is_mandatory;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
