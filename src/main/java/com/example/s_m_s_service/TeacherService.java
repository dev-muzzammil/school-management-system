package com.example.s_m_s_service;

import java.util.List;
import java.util.Optional;

import com.example.s_m_s_entities.Teacher;

public interface TeacherService {

	Optional<Teacher> findTeacherById(int id);
	
	List<Teacher> getAllTeachers();

	Teacher saveTeacher(Teacher teacher) ;
	
	Teacher updateTeacher(int id , Teacher updatedTeacher) ;
	
	String deleteTeacher(int id) ;
}
