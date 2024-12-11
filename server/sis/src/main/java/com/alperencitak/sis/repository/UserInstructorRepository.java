package com.alperencitak.sis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.UserInstructor;

public interface UserInstructorRepository extends JpaRepository<UserInstructor, Integer>{

	Optional<UserInstructor> findById(Integer id);
	
	Optional<UserInstructor> findByRelatedId(Integer id);
	
	void deleteById(Integer id);
}
