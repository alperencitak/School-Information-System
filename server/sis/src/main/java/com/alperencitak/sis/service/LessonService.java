package com.alperencitak.sis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.alperencitak.sis.dto.LessonDTO;
import com.alperencitak.sis.exception.NotFoundException;
import com.alperencitak.sis.mapper.LessonMapper;
import com.alperencitak.sis.model.Lesson;
import com.alperencitak.sis.repository.LessonRepository;

import jakarta.transaction.Transactional;

@Service
public class LessonService {

	private final LessonRepository lessonRepository;
	private final LessonMapper lessonMapper;

	public LessonService(LessonRepository lessonRepository, LessonMapper lessonMapper) {
		this.lessonRepository = lessonRepository;
		this.lessonMapper = lessonMapper;
	}

	public LessonDTO getById(Integer id) {
		return lessonMapper.toLessonDTO(lessonRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Lesson not found by id: " + id)));
	}

	@Transactional
	public LessonDTO getByLessonCode(String code) {
		return lessonMapper.toLessonDTO(lessonRepository.findLessonByLessonCode(code)
				.orElseThrow(() -> new NotFoundException("Lesson not found by lesson code: " + code)));
	}
	
	public List<LessonDTO> getAllLessons(){
		return lessonRepository.findAll().stream()
				.map(lessonMapper::toLessonDTO)
				.collect(Collectors.toList());
	}

	public void deleteById(Integer id) {
		lessonRepository.deleteById(id);
	}

	public LessonDTO save(LessonDTO lessonDTO) {
		Lesson lesson = lessonMapper.toLesson(lessonDTO);
		lessonRepository.save(lesson);
		return lessonMapper.toLessonDTO(lesson);
	}

}
