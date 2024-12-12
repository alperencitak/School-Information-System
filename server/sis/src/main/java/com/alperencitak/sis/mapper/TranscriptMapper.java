package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.TranscriptDTO;
import com.alperencitak.sis.model.Transcript;

@Mapper(componentModel = "spring")
public interface TranscriptMapper {

	@Mapping(source = "student.studentId", target = "studentId")
	@Mapping(source = "lesson.lessonId", target = "lessonId")
	TranscriptDTO toTranscriptDTO(Transcript transcript);

	@Mapping(source = "studentId", target = "student.studentId")
	@Mapping(source = "lessonId", target = "lesson.lessonId")
	Transcript toTranscript(TranscriptDTO transcriptDTO);

}
