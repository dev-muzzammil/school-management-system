package com.example.s_m_s_entities;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name="courses")

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String cname;
	private String author;
	
	
	@OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
	@JsonBackReference(value = "teacher-course")
	private Teacher teacher;

	
	@ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();

	
	
}
