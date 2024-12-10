package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.UserStudentDTO;
import com.alperencitak.sis.model.UserStudent;

@Mapper(componentModel = "spring")
public interface UserStudentMapper {

	@Mapping(source = "student.student_id", target = "student_id")
	UserStudentDTO toUserStudentDTO(UserStudent userStudent);
	
	@Mapping(source = "student_id", target = "student.student_id")
	UserStudent toUserStudent(UserStudentDTO userStudentDTO);
	
}
