package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.TranscriptDTO;
import com.alperencitak.sis.model.Transcript;

@Mapper(componentModel = "spring")
public interface TranscriptMapper {

	@Mapping(source = "student.student_id", target = "student_id")
	@Mapping(source = "lesson.lesson_id", target = "lesson_id")
	TranscriptDTO toTranscriptDTO(Transcript transcript);
	
	@Mapping(source = "student_id", target = "student.student_id")
	@Mapping(source = "lesson_id", target = "lesson.lesson_id")
	Transcript toTranscript(TranscriptDTO transcriptDTO);
	
}
