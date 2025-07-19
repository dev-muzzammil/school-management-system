package com.example.s_m_s_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.s_m_s_entities.Student;

@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("SELECT s.id FROM Student s JOIN s.courses c WHERE c.id = :courseId")	
	
	List<Integer>  findStudentIdsByCourseId (@Param ("courseId") Integer courseId);
		

	@Query("SELECT s.name FROM Student s JOIN s.courses c WHERE c.id = :courseId")
	
	List<String> findStudentNamesByCourseId(@Param("courseId") Integer courseId);


}
