package com.alperencitak.sis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.SelectedLesson;

public interface SelectedLessonRepository extends JpaRepository<SelectedLesson, Integer> {

	@Override
	Optional<SelectedLesson> findById(Integer id);

	List<SelectedLesson> findByStudent_StudentId(Integer id);

	List<SelectedLesson> findByLesson_LessonId(Integer id);

	@Override
	void deleteById(Integer id);

}
