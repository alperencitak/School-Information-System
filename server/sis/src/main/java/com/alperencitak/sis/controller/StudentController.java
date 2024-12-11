package com.alperencitak.sis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperencitak.sis.dto.StudentDTO;
import com.alperencitak.sis.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/{id}")
	ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(studentService.getById(id));
	}
	
	@GetMapping("/email/{email}")
	ResponseEntity<StudentDTO> getStudentByEmail(@PathVariable("email") String email){
		return ResponseEntity.ok(studentService.getByEmail(email));
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Void> deleteStudentById(@PathVariable("id") Integer id){
		studentService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/add_student")
	ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO){
		return ResponseEntity.ok(studentService.save(studentDTO));
	}
	
}
