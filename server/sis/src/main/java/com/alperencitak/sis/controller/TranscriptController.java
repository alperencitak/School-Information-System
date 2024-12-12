package com.alperencitak.sis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alperencitak.sis.dto.TranscriptDTO;
import com.alperencitak.sis.service.TranscriptService;

@RestController
@RequestMapping("/transcripts")
public class TranscriptController {

	private final TranscriptService transcriptService;

	public TranscriptController(TranscriptService transcriptService) {
		this.transcriptService = transcriptService;
	}

	@GetMapping("/{id}")
	ResponseEntity<TranscriptDTO> getTranscriptById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(transcriptService.getById(id));
	}

	@GetMapping("/student/{id}")
	ResponseEntity<TranscriptDTO> getTranscriptByStudentId(@PathVariable("id") Integer id){
		return ResponseEntity.ok(transcriptService.getByStudentId(id));
	}

	@GetMapping("/lesson/{id}")
	ResponseEntity<TranscriptDTO> getTranscriptByLessonId(@PathVariable("id") Integer id){
		return ResponseEntity.ok(transcriptService.getByLessonId(id));
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Void> deleteTranscriptById(@PathVariable("id") Integer id){
		transcriptService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/add_transcript")
	ResponseEntity<TranscriptDTO> addTranscript(@RequestBody TranscriptDTO transcriptDTO){
		return ResponseEntity.ok(transcriptService.save(transcriptDTO));
	}

}
