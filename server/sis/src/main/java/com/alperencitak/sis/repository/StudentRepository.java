package com.alperencitak.sis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alperencitak.sis.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Override
	Optional<Student> findById(Integer id);

	Optional<Student> findByEmail(String email);
	
	List<Student> findByInstructor_InstructorId(Integer id);

	@Override
	void deleteById(Integer id);
}
