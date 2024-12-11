package com.alperencitak.sis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperencitak.sis.dto.LessonDTO;
import com.alperencitak.sis.service.LessonService;

@RestController
@RequestMapping("/lessons")
public class LessonController {

	private final LessonService lessonService;

	public LessonController(LessonService lessonService) {
		this.lessonService = lessonService;
	}
	
	@GetMapping("/{id}")
	ResponseEntity<LessonDTO> getLessonById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(lessonService.getById(id));
	}
	
	@GetMapping("/code/{code}")
	ResponseEntity<LessonDTO> getLessonByCode(@PathVariable("code") String code){
		return ResponseEntity.ok(lessonService.getByLessonCode(code));
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<Void> deleteLessonById(@PathVariable("id") Integer id){
		lessonService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/add_lesson")
	ResponseEntity<LessonDTO> addLesson(@RequestBody LessonDTO lessonDTO){
		return ResponseEntity.ok(lessonService.save(lessonDTO));
	}
	
}
