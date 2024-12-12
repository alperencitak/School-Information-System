package com.alperencitak.sis.dto;

import java.time.LocalDate;

public class SelectedLessonDTO {

	private Integer selectionId;
	private Integer studentId;
	private Integer lessonId;
	private LocalDate selectionDate;
	private Boolean isApproved = Boolean.FALSE;

	public Integer getSelectionId() {
		return selectionId;
	}
	public void setSelectionId(Integer selectionId) {
		this.selectionId = selectionId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getLessonId() {
		return lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public LocalDate getSelectionDate() {
		return selectionDate;
	}
	public void setSelectionDate(LocalDate selectionDate) {
		this.selectionDate = selectionDate;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

}
