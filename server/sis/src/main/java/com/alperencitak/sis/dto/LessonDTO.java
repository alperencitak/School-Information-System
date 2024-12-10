package com.alperencitak.sis.dto;

import java.util.Set;

public class LessonDTO {

	private Integer lesson_id;
	private String lesson_code;
	private String lesson_name;
	private Boolean is_mandatory;
	private Integer credit;
	private String department;
    private Set<SelectedLessonDTO> selections;
    private Integer quota;
    
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
	public Set<SelectedLessonDTO> getSelections() {
		return selections;
	}
	public void setSelections(Set<SelectedLessonDTO> selections) {
		this.selections = selections;
	}
	public Integer getQuota() {
		return quota;
	}
	public void setQuota(Integer quota) {
		this.quota = quota;
	}
    
}
