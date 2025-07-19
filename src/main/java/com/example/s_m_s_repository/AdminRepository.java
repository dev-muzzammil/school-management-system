 package com.example.s_m_s_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.s_m_s_entities.Admin;

@Repository

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
