package com.alperencitak.sis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

	@Override
	Optional<Instructor> findById(Integer id);

	Optional<Instructor> findByEmail(String email);

	@Override
	void deleteById(Integer id);
}
