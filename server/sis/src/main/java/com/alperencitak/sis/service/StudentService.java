package com.alperencitak.sis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.alperencitak.sis.dto.StudentDTO;
import com.alperencitak.sis.exception.NotFoundException;
import com.alperencitak.sis.mapper.StudentMapper;
import com.alperencitak.sis.model.Student;
import com.alperencitak.sis.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	private final StudentMapper studentMapper;

	public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
		this.studentRepository = studentRepository;
		this.studentMapper = studentMapper;
	}

	public StudentDTO getById(Integer id) {
		return studentMapper.toStudentDTO(studentRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Student not found by id: " + id)));
	}

	public StudentDTO getByEmail(String email) {
		return studentMapper.toStudentDTO(studentRepository.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Student not found by email: " + email)));
	}
	
	public List<StudentDTO> getByInstructorId(Integer id){
		return studentRepository.findByInstructor_InstructorId(id).stream()
				.map(studentMapper::toStudentDTO)
				.collect(Collectors.toList());
	}

	public void deleteById(Integer id) {
		studentRepository.deleteById(id);
	}

	public StudentDTO save(StudentDTO studentDTO) {
		Student student = studentMapper.toStudent(studentDTO);
		studentRepository.save(student);
		return studentMapper.toStudentDTO(student);
	}

}
