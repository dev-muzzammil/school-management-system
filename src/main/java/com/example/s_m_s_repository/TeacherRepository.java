package com.example.s_m_s_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.s_m_s_entities.Teacher;

@Repository

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}

