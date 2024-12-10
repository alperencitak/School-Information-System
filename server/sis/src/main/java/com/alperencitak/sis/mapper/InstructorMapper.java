package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;

import com.alperencitak.sis.dto.InstructorDTO;
import com.alperencitak.sis.model.Instructor;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
	
	InstructorDTO toInstructorDTO(Instructor instructor);

	Instructor toInstructor(InstructorDTO instructorDTO);
	
}
