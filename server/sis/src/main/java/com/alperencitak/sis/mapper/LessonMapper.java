package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;

import com.alperencitak.sis.dto.LessonDTO;
import com.alperencitak.sis.model.Lesson;

@Mapper(componentModel = "spring")
public interface LessonMapper {

	LessonDTO toLessonDTO(Lesson lesson);
	
	Lesson toLesson(LessonDTO lessonDTO);
	
}
