package com.alperencitak.sis.dto;

public class TranscriptDTO {

	private Integer transcript_id;
	private Integer student_id;
	private Integer lesson_id;
	private String grade;
	private String semester;
	
	public Integer getTranscript_id() {
		return transcript_id;
	}
	public void setTranscript_id(Integer transcript_id) {
		this.transcript_id = transcript_id;
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
