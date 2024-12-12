package com.alperencitak.sis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alperencitak.sis.dto.StudentDTO;
import com.alperencitak.sis.model.Student;

@Mapper(componentModel = "spring", uses = SelectedLessonMapper.class)
public interface StudentMapper {

	@Mapping(source = "instructor.instructorId", target = "instructorId")
	StudentDTO toStudentDTO(Student student);

	@Mapping(source = "instructorId", target = "instructor.instructorId")
	Student toStudent(StudentDTO studentDTO);

}
