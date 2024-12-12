package com.alperencitak.sis.service;

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

	public UserStudentService(UserStudentRepository userStudentRepository,
			UserStudentMapper userStudentMapper) {
		this.userStudentRepository = userStudentRepository;
		this.userStudentMapper = userStudentMapper;
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
		userStudentRepository.save(userStudent);
		return userStudentMapper.toUserStudentDTO(userStudent);
	}

}
