package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.UserStudentDTO;
import com.alperencitak.sis.model.UserStudent;
import com.alperencitak.sis.request.CreateUserStudentRequest;

@Mapper(componentModel = "spring")
public interface UserStudentMapper {

	@Mapping(source = "student.studentId", target = "studentId")
	UserStudentDTO toUserStudentDTO(UserStudent userStudent);

	@Mapping(source = "studentId", target = "student.studentId")
	@Mapping(target = "passwordHash", ignore = true)
	UserStudent toUserStudent(UserStudentDTO userStudentDTO);

	@Mapping(target = "userId", ignore = true)
    @Mapping(source = "studentId",target = "student.studentId")
	UserStudent toCreateUserStudentRequest(CreateUserStudentRequest request);
	
}
