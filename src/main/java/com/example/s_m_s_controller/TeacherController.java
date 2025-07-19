package com.example.s_m_s_controller;

import java.io.IOException;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.s_m_s_entities.Teacher;
import com.example.s_m_s_service.TeacherService;

@RestController
@RequestMapping("/teacher")

public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	
	@GetMapping("/{id}")
	public Optional<Teacher> getTeacherById (@PathVariable int id) {
		return (teacherService.findTeacherById(id));
	} 
	
	
	@PostMapping(consumes = "application/json" ,  produces = "application/json")
	public ResponseEntity<Teacher> createTeacher (@RequestBody Teacher teacher) throws IOException{
		Teacher savedTeacher = teacherService.saveTeacher(teacher);
		return ResponseEntity.ok(savedTeacher);		
	} 
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Teacher> updateTeacher (@PathVariable int id , @RequestBody Teacher updatedTeacher){		
		return ResponseEntity.ok(teacherService.updateTeacher(id , updatedTeacher));
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteTeacher (@PathVariable int id) {
		teacherService.deleteTeacher(id);
		return "Teacher with ID " + id + " deleted successfully!";	
	}
}






















/*
 
POST:  http://localhost:8080/teacher
{
  "name": "Imran Khan",
  "subject": "JAVA",
  "email": "khanimran815@example.com",
  "students": [
    {
      "name": "Muzzammil Khan",
      "phone": 8815699644,
      "email": "khanmuzzammil815@gmail.com"
    }
  ],
  "course": {
    "cname": "JAVA",
    "author": "James Gosling"
  },
  "admin": {
    "name": "Tariq Khan",
    "phone": 12345678,
    "email": "tariqkhan123@example.com"
  }
}


PUT:  http://localhost:8080/teacher/201
{
  "name": "Imran Khan",
  "subject": "Modern History",
  "email": "imran_updated@school.com",
  "admin": {
    "id": 1
  }
}

  
 
*/
