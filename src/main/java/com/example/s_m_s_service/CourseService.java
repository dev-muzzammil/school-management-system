package com.example.s_m_s_service;

import java.util.List;
import java.util.Optional;

import com.example.s_m_s_entities.Course;

public interface CourseService {

	Optional<Course> findCourseById (int id);
	
	List<Course> getAllCourses() ;
	
	Course saveCourse(Course course) ;
	
	List<Course> saveAllCourse(List<Course> course) ;
	
	Course updateCourse(int id, Course updatedCourse) ;
	
	String deleteCourse (int id) ;
	
	List<Integer> getStudentsIdsByCourseid(Integer courseId);
	
	List<String> getStudentsNamesByCourseid(Integer courseId);
	
}
