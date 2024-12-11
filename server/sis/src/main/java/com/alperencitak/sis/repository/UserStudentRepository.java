package com.alperencitak.sis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.UserStudent;

public interface UserStudentRepository extends JpaRepository<UserStudent, Integer>{

	Optional<UserStudent> findById(Integer id);
	
	Optional<UserStudent> findByRelatedId(Integer id);

}
