package com.alperencitak.sis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.alperencitak.sis.dto.SelectedLessonDTO;
import com.alperencitak.sis.exception.NotFoundException;
import com.alperencitak.sis.mapper.SelectedLessonMapper;
import com.alperencitak.sis.model.SelectedLesson;
import com.alperencitak.sis.repository.SelectedLessonRepository;

@Service
public class SelectedLessonService {

	private final SelectedLessonRepository selectedLessonRepository;
	private final SelectedLessonMapper selectedLessonMapper;

	public SelectedLessonService(SelectedLessonRepository selectedLessonRepository,
			SelectedLessonMapper selectedLessonMapper) {
		this.selectedLessonRepository = selectedLessonRepository;
		this.selectedLessonMapper = selectedLessonMapper;
	}

	public SelectedLessonDTO getById(Integer id) {
		return selectedLessonMapper.toSelectedLessonDTO(selectedLessonRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Selected Lesson not found by id: " + id)));
	}

	public List<SelectedLessonDTO> getByStudentId(Integer id) {
		return selectedLessonRepository.findByStudent_StudentId(id)
				.stream()
				.map(selectedLesson -> selectedLessonMapper.toSelectedLessonDTO(selectedLesson))
				.collect(Collectors.toList());
	}

	public List<SelectedLessonDTO> getByLessonId(Integer id) {
		return selectedLessonRepository.findByLesson_LessonId(id)
				.stream()
				.map(selectedLesson -> selectedLessonMapper.toSelectedLessonDTO(selectedLesson))
				.collect(Collectors.toList());
	}

	public void deleteById(Integer id) {
		selectedLessonRepository.deleteById(id);
	}

	public SelectedLessonDTO save(SelectedLessonDTO selectedLessonDTO) {
		SelectedLesson selectedLesson = selectedLessonMapper.toSelectedLesson(selectedLessonDTO);
		if(selectedLessonDTO.getSelectionId() != null) {
			selectedLesson.setSelectionId(selectedLessonDTO.getSelectionId());
		}
		selectedLessonRepository.save(selectedLesson);
		return selectedLessonMapper.toSelectedLessonDTO(selectedLesson);
	}

}
