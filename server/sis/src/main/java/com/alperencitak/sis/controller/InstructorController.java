package com.alperencitak.sis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperencitak.sis.dto.InstructorDTO;
import com.alperencitak.sis.service.InstructorService;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

	private final InstructorService instructorService;

	public InstructorController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	@GetMapping("/{id}")
	ResponseEntity<InstructorDTO> getInstructorById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(instructorService.getById(id));
	}

	@GetMapping("/email/{email}")
	ResponseEntity<InstructorDTO> getInstructorByEmail(@PathVariable("email") String email){
		return ResponseEntity.ok(instructorService.getByEmail(email));
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Void> deleteInstructorById(@PathVariable("id") Integer id){
		instructorService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/add_instructor")
	ResponseEntity<InstructorDTO> addInstructor(@RequestBody InstructorDTO instructorDTO){
		return ResponseEntity.ok(instructorService.save(instructorDTO));
	}

}
