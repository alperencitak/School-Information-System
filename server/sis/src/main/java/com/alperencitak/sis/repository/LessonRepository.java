package com.alperencitak.sis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.alperencitak.sis.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{

	@Override
	Optional<Lesson> findById(Integer id);

	@Procedure(name = "GetLessonByLessonCode")
	Optional<Lesson> findByLessonCode(@Param("in_lesson_code") String lesson_code);

	@Override
	void deleteById(Integer id);
}
