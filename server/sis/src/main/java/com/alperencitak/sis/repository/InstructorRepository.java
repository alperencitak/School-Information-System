package com.alperencitak.sis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

	Optional<Instructor> findById(Integer id);
	
	Optional<Instructor> findByEmail(String email);
	
	void deleteById(Integer id);
}
