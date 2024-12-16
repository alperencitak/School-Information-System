package com.alperencitak.sis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.Transcript;

public interface TranscriptRepository extends JpaRepository<Transcript, Integer>{

	@Override
	Optional<Transcript> findById(Integer id);

	List<Transcript> findByStudent_StudentId(Integer id);

	List<Transcript> findByLesson_LessonId(Integer id);

	@Override
	void deleteById(Integer id);
}
