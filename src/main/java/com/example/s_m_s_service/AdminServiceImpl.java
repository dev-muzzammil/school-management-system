package com.example.s_m_s_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.s_m_s_entities.Admin;
import com.example.s_m_s_entities.Teacher;
import com.example.s_m_s_repository.AdminRepository;

@Service

public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	
	@Override
	public Optional<Admin> findAdminById(int id){
		return (adminRepository.findById(id));
	}
	
	
	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}
	
	
	@Override
	public Admin saveAdmin(Admin admin) {
	    for (Teacher teacher : admin.getTeacher()) {
	        teacher.setAdmin(admin);  // Set the admin manually for each teacher
	    }
	    return adminRepository.save(admin);
	}

	
	@Override
	public Admin updateAdmin(int id , Admin updatedAdmin) {
		updatedAdmin.setId(id);
		return adminRepository.save(updatedAdmin);
	}
	
	
	@Override
	public String deleteAdmin(int id) {
		adminRepository.deleteById(id);
		return "Admin with Id: " + id + " deleted";
	}
	
	
}
