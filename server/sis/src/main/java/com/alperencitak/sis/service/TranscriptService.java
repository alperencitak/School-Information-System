package com.alperencitak.sis.service;

import org.springframework.stereotype.Service;

import com.alperencitak.sis.dto.TranscriptDTO;
import com.alperencitak.sis.exception.NotFoundException;
import com.alperencitak.sis.mapper.TranscriptMapper;
import com.alperencitak.sis.model.Transcript;
import com.alperencitak.sis.repository.TranscriptRepository;

@Service
public class TranscriptService {

	private final TranscriptRepository transcriptRepository;
	private final TranscriptMapper transcriptMapper;

	public TranscriptService(TranscriptRepository transcriptRepository, TranscriptMapper transcriptMapper) {
		this.transcriptRepository = transcriptRepository;
		this.transcriptMapper = transcriptMapper;
	}

	public TranscriptDTO getById(Integer id) {
		return transcriptMapper.toTranscriptDTO(transcriptRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Transcript not found by id: " + id)));
	}

	public TranscriptDTO getByStudentId(Integer id) {
		return transcriptMapper.toTranscriptDTO(transcriptRepository.findByStudent_StudentId(id)
				.orElseThrow(() -> new NotFoundException("Transcript not found by student id: " + id)));
	}

	public TranscriptDTO getByLessonId(Integer id) {
		return transcriptMapper.toTranscriptDTO(transcriptRepository.findByLesson_LessonId(id)
				.orElseThrow(() -> new NotFoundException("Transcript not found by lesson id: " + id)));
	}

	public void deleteById(Integer id) {
		transcriptRepository.deleteById(id);
	}

	public TranscriptDTO save(TranscriptDTO transcriptDTO) {
		Transcript transcript = transcriptMapper.toTranscript(transcriptDTO);
		transcriptRepository.save(transcript);
		return transcriptMapper.toTranscriptDTO(transcript);
	}

}
