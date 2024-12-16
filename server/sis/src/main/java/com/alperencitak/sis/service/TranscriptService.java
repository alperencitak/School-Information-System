package com.alperencitak.sis.service;

import java.util.List;
import java.util.stream.Collectors;

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

	public List<TranscriptDTO> getByStudentId(Integer id) {
		return transcriptRepository.findByStudent_StudentId(id).stream()
				.map(transcriptMapper::toTranscriptDTO)
				.collect(Collectors.toList());
	}

	public List<TranscriptDTO> getByLessonId(Integer id) {
		return transcriptRepository.findByLesson_LessonId(id).stream()
				.map(transcriptMapper::toTranscriptDTO)
				.collect(Collectors.toList());
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
