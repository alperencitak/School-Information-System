package com.alperencitak.sis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperencitak.sis.dto.UserInstructorDTO;
import com.alperencitak.sis.request.CreateUserInstructorRequest;
import com.alperencitak.sis.service.UserInstructorService;

@RestController
@RequestMapping("/user_instructors")
public class UserInstructorController {

	private final UserInstructorService userInstructorService;

	public UserInstructorController(UserInstructorService userInstructorService) {
		this.userInstructorService = userInstructorService;
	}

	@GetMapping("/{id}")
	ResponseEntity<UserInstructorDTO> getUserInstructorById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(userInstructorService.getById(id));
	}

	@GetMapping("/instructor/{id}")
	ResponseEntity<UserInstructorDTO> getUserInstructorByInstructorId(@PathVariable("id") Integer id){
		return ResponseEntity.ok(userInstructorService.getByInstructorId(id));
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Void> deleteInstructorById(@PathVariable("id") Integer id){
		userInstructorService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/add_user_instructor")
	ResponseEntity<UserInstructorDTO> addUserInstructor(@RequestBody CreateUserInstructorRequest createUserInstructorRequest){
		return ResponseEntity.ok(userInstructorService.save(createUserInstructorRequest));
	}

}
