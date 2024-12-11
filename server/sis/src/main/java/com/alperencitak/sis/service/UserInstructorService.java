package com.alperencitak.sis.service;

import org.springframework.stereotype.Service;

import com.alperencitak.sis.dto.UserInstructorDTO;
import com.alperencitak.sis.exception.NotFoundException;
import com.alperencitak.sis.mapper.UserInstructorMapper;
import com.alperencitak.sis.repository.UserInstructorRepository;

@Service
public class UserInstructorService {

	private final UserInstructorRepository userInstructorRepository;
	private final UserInstructorMapper userInstructorMapper;
	
	public UserInstructorService(UserInstructorRepository userInstructorRepository,
			UserInstructorMapper userInstructorMapper) {
		this.userInstructorRepository = userInstructorRepository;
		this.userInstructorMapper = userInstructorMapper;
	}
	
	public UserInstructorDTO getById(Integer id) {
		return userInstructorMapper.toUserInstructorDTO(userInstructorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User not found by id: " + id)));
	}
	
	public UserInstructorDTO getByInstructorId(Integer id) {
		return userInstructorMapper.toUserInstructorDTO(userInstructorRepository.findByRelatedId(id)
				.orElseThrow(() -> new NotFoundException("User not found by related id: " + id)));
	}
	
}
