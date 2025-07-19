package com.example.s_m_s_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.s_m_s_entities.Admin;
import com.example.s_m_s_entities.Teacher;
import com.example.s_m_s_repository.AdminRepository;
import com.example.s_m_s_repository.TeacherRepository;

@Service

public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private AdminRepository adminRepoistory;
	
	
	@Override
	public Optional<Teacher> findTeacherById(int id){
		return (teacherRepository.findById(id));
	}
	
	
	@Override
	public List<Teacher> getAllTeachers(){
		return teacherRepository.findAll();
	}
	
	
	@Override
	public Teacher saveTeacher(Teacher teacher) {
		Admin admin = teacher.getAdmin();
		
		if (admin != null) {
			Optional<Admin> existingAdmin = adminRepoistory.findById(admin.getId());
			if (existingAdmin.isPresent()) {
				teacher.setAdmin(existingAdmin.get());				
			}
			else {
				Admin savedAdmin = adminRepoistory.save(admin);
				teacher.setAdmin(savedAdmin);
			}
			admin = adminRepoistory.save(admin);
		}
		return teacherRepository.save(teacher);
	}
	
	
	@Override
	public Teacher updateTeacher(int id , Teacher updatedTeacher) {
		updatedTeacher.setId(id);
		return teacherRepository.save(updatedTeacher);
	}
	
	
	@Override
	public String deleteTeacher(int id) {
		teacherRepository.deleteById(id);
		return "Teacher with Id " + id + " deleted";
	}
}
