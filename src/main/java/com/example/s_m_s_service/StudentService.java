package com.example.s_m_s_service;

import java.util.List;
import java.util.Optional;

import com.example.s_m_s_entities.Student;

public interface StudentService {

	Optional<Student> findStudentById (int id);
	
	List<Student> getAllStudents() ;
	
	Student saveStudent(Student student) ;
	
	Student updateStudent(int id, Student updatedStudent) ;
	
	String deleteStudent(int id) ;
	
	List<Integer> getStudentsIdsByCourseid(Integer courseId);
	
	List<String> getStudentsNamesByCourseid(Integer courseId);
	
}
