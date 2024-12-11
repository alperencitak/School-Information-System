package com.alperencitak.sis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.Transcript;

public interface TranscriptRepository extends JpaRepository<Transcript, Integer>{

	Optional<Transcript> findById(Integer id);
	
	Optional<Transcript> findByStudentId(Integer id);

	Optional<Transcript> findByLessonId(Integer id);
	
	void deleteById(Integer id);
}
