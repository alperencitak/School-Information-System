package com.alperencitak.sis.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alperencitak.sis.dto.UserInstructorDTO;
import com.alperencitak.sis.exception.NotFoundException;
import com.alperencitak.sis.mapper.UserInstructorMapper;
import com.alperencitak.sis.model.UserInstructor;
import com.alperencitak.sis.repository.UserInstructorRepository;
import com.alperencitak.sis.request.CreateUserInstructorRequest;

@Service
public class UserInstructorService {

	private final UserInstructorRepository userInstructorRepository;
	private final UserInstructorMapper userInstructorMapper;
	private final PasswordEncoder passwordEncoder;

	public UserInstructorService(UserInstructorRepository userInstructorRepository,
			UserInstructorMapper userInstructorMapper,
			PasswordEncoder passwordEncoder) {
		this.userInstructorRepository = userInstructorRepository;
		this.userInstructorMapper = userInstructorMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public UserInstructorDTO getById(Integer id) {
		return userInstructorMapper.toUserInstructorDTO(userInstructorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User not found by id: " + id)));
	}

	public UserInstructorDTO getByInstructorId(Integer id) {
		return userInstructorMapper.toUserInstructorDTO(userInstructorRepository.findByInstructor_InstructorId(id)
				.orElseThrow(() -> new NotFoundException("User not found by related id: " + id)));
	}

	public void deleteById(Integer id) {
		userInstructorRepository.deleteById(id);
	}

	public UserInstructorDTO save(CreateUserInstructorRequest createUserInstructorRequest) {
		UserInstructor userInstructor = userInstructorMapper.toCreateUserInstructor(createUserInstructorRequest);
		String encodePassword = passwordEncoder.encode(createUserInstructorRequest.getPassword());
		userInstructor.setPasswordHash(encodePassword);
		return userInstructorMapper.toUserInstructorDTO(userInstructorRepository.save(userInstructor));
	}
	
	public UserInstructorDTO validateUser(String username, String password) {
		UserInstructor userInstructor = userInstructorRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("Username not found: " + username));
		if(passwordEncoder.matches(password, userInstructor.getPasswordHash())) {
			return userInstructorMapper.toUserInstructorDTO(userInstructor);
		}
		return null;
	}
}
