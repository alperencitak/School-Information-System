package com.alperencitak.sis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperencitak.sis.dto.UserStudentDTO;
import com.alperencitak.sis.request.CreateUserStudentRequest;
import com.alperencitak.sis.request.UserLoginRequest;
import com.alperencitak.sis.service.UserStudentService;

@RestController
@RequestMapping("/user_students")
public class UserStudentController {

	private final UserStudentService userStudentService;

	public UserStudentController(UserStudentService userStudentService) {
		this.userStudentService = userStudentService;
	}

	@GetMapping("/{id}")
	ResponseEntity<UserStudentDTO> getUserStudentById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(userStudentService.getById(id));
	}

	@GetMapping("/student/{id}")
	ResponseEntity<UserStudentDTO> getUserStudentByStudentId(@PathVariable("id") Integer id){
		return ResponseEntity.ok(userStudentService.getByStudentId(id));
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Void> deleteStudentById(@PathVariable("id") Integer id){
		userStudentService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/login")
	ResponseEntity<UserStudentDTO> login(@RequestBody UserLoginRequest userLoginRequest) {
		return ResponseEntity.ok(userStudentService.validateUser(userLoginRequest.getUsername(), userLoginRequest.getPassword()));
	}
	
	@PostMapping("/register")
	ResponseEntity<UserStudentDTO> register(@RequestBody CreateUserStudentRequest createUserStudentRequest){
		return ResponseEntity.ok(userStudentService.save(createUserStudentRequest));
	}

}
