package com.alperencitak.sis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.SelectedLesson;

public interface SelectedLessonRepository extends JpaRepository<SelectedLesson, Integer> {

	Optional<SelectedLesson> findById(Integer id);

	List<SelectedLesson> findByStudentId(Integer id);

	List<SelectedLesson> findByLessonId(Integer id);
	
	void deleteById(Integer id);
	
}
