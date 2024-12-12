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
    private Integer lessonId;

    @NotNull(message = "Lesson code cannot be null")
    @Size(max = 20, message = "Lesson code cannot exceed 20 characters")
    @Column(name = "lesson_code", unique = true)
    private String lessonCode;

    @NotNull(message = "Lesson name cannot be null")
    @Size(max = 100, message = "Lesson name cannot exceed 100 characters")
    @Column(name = "lesson_name")
    private String lessonName;

    @NotNull(message = "Lesson requirement cannot be null")
    @Column(name = "is_mandatory")
    private Boolean isMandatory;

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

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

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
}
