package com.alperencitak.sis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "transcripts")
public class Transcript {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transcript_id")
	private Integer transcript_id;
	
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "lesson_id", nullable = false)
	private Lesson lesson;
	
	@NotNull(message = "Grade cannot be null")
	@Size(max = 2, message = "Grade cannot exceed 2 characters")
	@Column(name = "grade")
	private String grade;
	
	@NotNull(message = "Semester cannot be null")
	@Size(max = 20, message = "Semester cannot exceed 20 characters")
	@Column(name = "semester")
	private String semester;

	public Integer getTranscript_id() {
		return transcript_id;
	}

	public void setTranscript_id(Integer transcript_id) {
		this.transcript_id = transcript_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
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
