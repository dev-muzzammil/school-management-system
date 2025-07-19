package com.example.s_m_s_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.s_m_s_entities.Student;
import com.example.s_m_s_repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public Optional<Student> findStudentById (int id){
		return (studentRepository.findById(id));
	}
	
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	
	@Override
	public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


	@Override
	public Student updateStudent(int id, Student updatedStudent) {
		updatedStudent.setId(id);	
		return studentRepository.save(updatedStudent);
	}

	
	@Override
	public String deleteStudent(int id) {
	        studentRepository.deleteById(id);
	        return "Student with ID " + id + " deleted";
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
