package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.SelectedLessonDTO;
import com.alperencitak.sis.model.SelectedLesson;

@Mapper(componentModel = "spring")
public interface SelectedLessonMapper {

	@Mapping(source = "student.student_id", target = "student_id")
	@Mapping(source = "instructor.instructor_id", target = "instructor_id")
	SelectedLessonDTO toSelectedLessonDTO(SelectedLesson selectedLesson);
	
	@Mapping(source = "student_id", target = "student.student_id")
	@Mapping(source = "instructor_id", target = "instructor.instructor_id")
	SelectedLesson toSelectedLesson(SelectedLessonDTO selectedLessonDTO);
	
}
