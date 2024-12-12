package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.LessonDTO;
import com.alperencitak.sis.model.Lesson;

@Mapper(componentModel = "spring", uses = SelectedLessonMapper.class)
public interface LessonMapper {

	@Mapping(source = "quota", target = "quota")
    @Mapping(source = "selections", target = "selections")
	LessonDTO toLessonDTO(Lesson lesson);

	@Mapping(source = "quota", target = "quota")
    @Mapping(source = "selections", target = "selections")
	Lesson toLesson(LessonDTO lessonDTO);

}
