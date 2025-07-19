package com.example.s_m_s_entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name="teacher")

public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String subject;
	private String email;
	
	
	@JsonManagedReference(value = "teacher-students")
	@OneToMany(mappedBy = "teacher" , cascade = CascadeType.ALL)	
	private List<Student> students;
	
	
	@JsonManagedReference(value = "teacher-course")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "admin_id")
	@JsonBackReference(value = "admin-teacher")
	private Admin admin;

	
	
}
