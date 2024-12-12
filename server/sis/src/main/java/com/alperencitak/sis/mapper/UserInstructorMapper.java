package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.UserInstructorDTO;
import com.alperencitak.sis.model.UserInstructor;
import com.alperencitak.sis.request.CreateUserInstructorRequest;

@Mapper(componentModel = "spring")
public interface UserInstructorMapper {

	@Mapping(source = "instructor.instructorId", target = "instructorId")
	UserInstructorDTO toUserInstructorDTO(UserInstructor userInstructor);

	@Mapping(source = "instructorId", target = "instructor.instructorId")
	@Mapping(target = "passwordHash", ignore = true)
	UserInstructor toUserInstructor(UserInstructorDTO userInstructorDTO);

	@Mapping(target = "userId", ignore = true)
    @Mapping(source = "instructorId",target = "instructor.instructorId")
	UserInstructor toCreateUserInstructor(CreateUserInstructorRequest request);
	
}
