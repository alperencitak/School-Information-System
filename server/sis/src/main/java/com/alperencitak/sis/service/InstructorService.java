package com.alperencitak.sis.service;

import org.springframework.stereotype.Service;

import com.alperencitak.sis.dto.InstructorDTO;
import com.alperencitak.sis.exception.NotFoundException;
import com.alperencitak.sis.mapper.InstructorMapper;
import com.alperencitak.sis.model.Instructor;
import com.alperencitak.sis.repository.InstructorRepository;

@Service
public class InstructorService {

	private final InstructorRepository instructorRepository;
	private final InstructorMapper instructorMapper;

	public InstructorService(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
		this.instructorRepository = instructorRepository;
		this.instructorMapper = instructorMapper;
	}

	public InstructorDTO getById(Integer id) {
		return instructorMapper.toInstructorDTO(instructorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Instructor not found by id: " + id)));
	}
	
	public InstructorDTO getByEmail(String email) {
		return instructorMapper.toInstructorDTO(instructorRepository.findByEmail(email)
				.orElseThrow(() -> new NotFoundException("Instructor not found by email: " + email)));
	}

	public void deleteById(Integer id) {
		instructorRepository.deleteById(id);
	}
	
	public InstructorDTO save(InstructorDTO instructorDTO) {
		Instructor instructor = instructorMapper.toInstructor(instructorDTO);
		instructorRepository.save(instructor);
		return instructorMapper.toInstructorDTO(instructor);
	}
	
}
