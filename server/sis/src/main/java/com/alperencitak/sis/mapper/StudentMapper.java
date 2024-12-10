package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.StudentDTO;
import com.alperencitak.sis.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
	
	@Mapping(source = "instructor.instructor_id", target = "instructor_id")
	StudentDTO toStudentDTO(Student student);
	
	@Mapping(source = "instructor_id", target = "instructor.instructor_id")
	Student toStudent(StudentDTO studentDTO);
	
}
