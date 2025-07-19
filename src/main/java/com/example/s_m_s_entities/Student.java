package com.example.s_m_s_entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name="students")

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private Long phone;
	private String email;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id")
	@JsonBackReference(value = "teacher-students")
	private Teacher teacher;

	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }) 
	@JoinTable(
	    name= "student_course",
	    joinColumns =  @JoinColumn(name = "student_id"),
	    inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private List<Course> courses = new ArrayList<>();
	
}
