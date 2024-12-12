package com.alperencitak.sis.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperencitak.sis.dto.SelectedLessonDTO;
import com.alperencitak.sis.service.SelectedLessonService;

@RestController
@RequestMapping("/selectedlesson")
public class SelectedLessonController {

	private final SelectedLessonService selectedLessonService;

	public SelectedLessonController(SelectedLessonService selectedLessonService) {
		this.selectedLessonService = selectedLessonService;
	}

	@GetMapping("/{id}")
	ResponseEntity<SelectedLessonDTO> getSelectedLessonById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(selectedLessonService.getById(id));
	}

	@GetMapping("/student/{id}")
	ResponseEntity<List<SelectedLessonDTO>> getSelectedLessonByStudentId(@PathVariable("id") Integer id){
		return ResponseEntity.ok(selectedLessonService.getByStudentId(id));
	}

	@GetMapping("/lesson/{id}")
	ResponseEntity<List<SelectedLessonDTO>> getSelectedLessonByLessonId(@PathVariable("id") Integer id){
		return ResponseEntity.ok(selectedLessonService.getByLessonId(id));
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Void> deleteSelectedLessonById(@PathVariable("id") Integer id){
		selectedLessonService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/add_selectedlesson")
	ResponseEntity<SelectedLessonDTO> addSelectedLesson(@RequestBody SelectedLessonDTO selectedLessonDTO){
		return ResponseEntity.ok(selectedLessonService.save(selectedLessonDTO));
	}

}
