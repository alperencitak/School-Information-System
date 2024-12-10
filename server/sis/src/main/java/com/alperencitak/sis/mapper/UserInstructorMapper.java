package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.UserInstructorDTO;
import com.alperencitak.sis.model.UserInstructor;

@Mapper(componentModel = "spring")
public interface UserInstructorMapper {

	@Mapping(source = "instructor.instructor_id", target = "instructor_id")
	UserInstructorDTO toUserInstructorDTO(UserInstructor userInstructor);
	
	@Mapping(source = "instructor_id", target = "instructor.instructor_id")
	UserInstructor toUserInstructor(UserInstructorDTO userInstructorDTO);
	
}
