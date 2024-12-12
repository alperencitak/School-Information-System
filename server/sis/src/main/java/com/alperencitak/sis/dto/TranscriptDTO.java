package com.alperencitak.sis.dto;

public class TranscriptDTO {

	private Integer transcriptId;
	private Integer studentId;
	private Integer lessonId;
	private String grade;
	private String semester;

	public Integer getTranscriptId() {
		return transcriptId;
	}
	public void setTranscriptId(Integer transcriptId) {
		this.transcriptId = transcriptId;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}

}
