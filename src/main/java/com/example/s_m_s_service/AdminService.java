package com.example.s_m_s_service;

import java.util.List;
import java.util.Optional;

import com.example.s_m_s_entities.Admin;

public interface AdminService {

	
	Optional<Admin> findAdminById(int id);

	List<Admin> getAllAdmins();
	
	Admin saveAdmin(Admin admin);

	Admin updateAdmin(int id , Admin updatedAdmin);
	
	String deleteAdmin(int id);
}
