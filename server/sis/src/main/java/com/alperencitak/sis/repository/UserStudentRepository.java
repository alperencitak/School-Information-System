package com.alperencitak.sis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.UserStudent;

public interface UserStudentRepository extends JpaRepository<UserStudent, Integer>{

	@Override
	Optional<UserStudent> findById(Integer id);

	Optional<UserStudent> findByStudent_StudentId(Integer id);

	@Override
	void deleteById(Integer id);

}
