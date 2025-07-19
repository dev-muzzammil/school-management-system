package com.example.s_m_s_service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.s_m_s_entities.Course;
import com.example.s_m_s_repository.CourseRepository;
import com.example.s_m_s_repository.StudentRepository;


@Service

public class CourseServiceImpl implements CourseService{

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Override
	public Optional<Course> findCourseById (int id){
		return (courseRepository.findById(id));
	}
	
	
	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	
	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}
	
	
	@Override
	public List<Course> saveAllCourse(List<Course> course) {
		return courseRepository.saveAll(course);
	}
	
	
	@Override
	public Course updateCourse(int id, Course updatedCourse) {
		updatedCourse.setId(id);
		return courseRepository.save(updatedCourse);
	}
	
	
	@Override
	public String deleteCourse (int id) {
		courseRepository.deleteById(id);
		return "Course With Id" + id + "Deleted";
	}

	
	@Override
	public List<Integer> getStudentsIdsByCourseid(Integer courseId){
		 return studentRepository.findStudentIdsByCourseId(courseId);
	 }
	
	
	@Override
	public List<String> getStudentsNamesByCourseid(Integer courseId){
		 return studentRepository.findStudentNamesByCourseId(courseId);
	 }

	
}
