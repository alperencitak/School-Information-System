package com.alperencitak.sis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.UserInstructor;

public interface UserInstructorRepository extends JpaRepository<UserInstructor, Integer>{

	@Override
	Optional<UserInstructor> findById(Integer id);

	Optional<UserInstructor> findByInstructor_InstructorId(Integer id);

	@Override
	void deleteById(Integer id);

}
