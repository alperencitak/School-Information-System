package com.alperencitak.sis.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alperencitak.sis.dto.UserStudentDTO;
import com.alperencitak.sis.exception.NotFoundException;
import com.alperencitak.sis.mapper.UserStudentMapper;
import com.alperencitak.sis.model.UserStudent;
import com.alperencitak.sis.repository.UserStudentRepository;
import com.alperencitak.sis.request.CreateUserStudentRequest;

@Service
public class UserStudentService {

	private final UserStudentRepository userStudentRepository;
	private final UserStudentMapper userStudentMapper;
	private final PasswordEncoder passwordEncoder;

	public UserStudentService(UserStudentRepository userStudentRepository,
			UserStudentMapper userStudentMapper,
			PasswordEncoder passwordEncoder) {
		this.userStudentRepository = userStudentRepository;
		this.userStudentMapper = userStudentMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public UserStudentDTO getById(Integer id) {
		return userStudentMapper.toUserStudentDTO(userStudentRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User not found by id: " + id)));
	}

	public UserStudentDTO getByStudentId(Integer id) {
		return userStudentMapper.toUserStudentDTO(userStudentRepository.findByStudent_StudentId(id)
				.orElseThrow(() -> new NotFoundException("User not found by related id: " + id)));
	}

	public void deleteById(Integer id) {
		userStudentRepository.deleteById(id);
	}

	public UserStudentDTO save(CreateUserStudentRequest createUserStudentRequest) {
		UserStudent userStudent = userStudentMapper.toCreateUserStudentRequest(createUserStudentRequest);
		String encodePassword = passwordEncoder.encode(createUserStudentRequest.getPassword());
		userStudent.setPasswordHash(encodePassword);
		return userStudentMapper.toUserStudentDTO(userStudentRepository.save(userStudent));
	}
	
	public UserStudentDTO validateUser(String username, String password) {
		UserStudent userStudent = userStudentRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("Username not found: " + username));
		if(passwordEncoder.matches(password, userStudent.getPasswordHash())) {
			return userStudentMapper.toUserStudentDTO(userStudent);
		}
		return null;
	}

}
