package com.alperencitak.sis.dto;

import java.util.Set;

public class LessonDTO {

	private Integer lessonId;
	private String lessonCode;
	private String lessonName;
	private Boolean isMandatory;
	private Integer credit;
	private String department;
    private Set<SelectedLessonDTO> selections;
    private Integer quota;

	public Integer getLessonId() {
		return lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public String getLessonCode() {
		return lessonCode;
	}
	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public Boolean getIsMandatory() {
		return isMandatory;
	}
	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
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
