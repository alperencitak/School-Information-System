package com.alperencitak.sis.dto;

import java.time.LocalDate;

public class SelectedLessonDTO {
	
	private Long selectionId;
	private Integer student_id;
	private Integer lesson_id;
	private LocalDate selectionDate;
	private Boolean isApproved = Boolean.FALSE;
	
	public Long getSelectionId() {
		return selectionId;
	}
	public void setSelectionId(Long selectionId) {
		this.selectionId = selectionId;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getLesson_id() {
		return lesson_id;
	}
	public void setLesson_id(Integer lesson_id) {
		this.lesson_id = lesson_id;
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
