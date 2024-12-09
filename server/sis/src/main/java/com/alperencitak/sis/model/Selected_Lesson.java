package com.alperencitak.sis.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_lesson_selections")
public class Selected_Lesson {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "selection_id")
    private Long selectionId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Column(name = "selection_date", nullable = false)
    private LocalDate selectionDate;

    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved = Boolean.FALSE;
    
    @PrePersist
    public void prePersist() {
		if(this.selectionDate == null) {
			this.selectionDate = LocalDate.now();
		}
	}
}
