package com.alperencitak.sis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{

	Optional<Lesson> findById(Integer id);
	
	Optional<Lesson> findByLessonCode(String code);
	
	void deleteById(Integer id);
}
