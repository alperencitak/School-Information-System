package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.SelectedLessonDTO;
import com.alperencitak.sis.model.SelectedLesson;

@Mapper(componentModel = "spring")
public interface SelectedLessonMapper {

	@Mapping(source = "student.studentId", target = "studentId")
    @Mapping(source = "lesson.lessonId", target = "lessonId")
    @Mapping(source = "selectionDate", target = "selectionDate")
    @Mapping(source = "isApproved", target = "isApproved")
    @Mapping(source = "selectionId", target = "selectionId")
    SelectedLessonDTO toSelectedLessonDTO(SelectedLesson selectedLesson);

    @Mapping(source = "studentId", target = "student.studentId")
    @Mapping(source = "lessonId", target = "lesson.lessonId")
    @Mapping(source = "selectionDate", target = "selectionDate")
    @Mapping(source = "isApproved", target = "isApproved")
    @Mapping(source = "selectionId", target = "selectionId")
    SelectedLesson toSelectedLesson(SelectedLessonDTO selectedLessonDTO);

}
