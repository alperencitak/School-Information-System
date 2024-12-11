package com.alperencitak.sis.service;

import org.springframework.stereotype.Service;

import com.alperencitak.sis.dto.LessonDTO;
import com.alperencitak.sis.exception.NotFoundException;
import com.alperencitak.sis.mapper.LessonMapper;
import com.alperencitak.sis.repository.LessonRepository;

@Service
public class LessonService {
	
	private final LessonRepository lessonRepository;
	private final LessonMapper lessonMapper;
	
	public LessonService(LessonRepository lessonRepository, LessonMapper lessonMapper) {
		this.lessonRepository = lessonRepository;
		this.lessonMapper = lessonMapper;
	}
	
	public LessonDTO getLessonById(Integer id) {
		return lessonMapper.toLessonDTO(lessonRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Lesson not found by id: " + id)));
	}
	
	public LessonDTO getByLessonCode(Integer code) {
		return lessonMapper.toLessonDTO(lessonRepository.findByLessonCode(code)
				.orElseThrow(() -> new NotFoundException("Lesson not found by lesson code: " + code)));
	}
	
	public void deleteById(Integer id) {
		lessonRepository.deleteById(id);
	}
	
}
