package com.example.s_m_s_controller;

import java.io.IOException;
import java.util.List;
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

import com.example.s_m_s_entities.Student;
import com.example.s_m_s_service.StudentService;

@RestController
@RequestMapping("/student")

public class StudentController {
	
	@Autowired
	private StudentService studentService;
	

	@GetMapping("/{id}")
	public Optional<Student> getStudentBYId (@PathVariable int id){
		return (studentService.findStudentById(id));
	}
	
	
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

	
    

    @PostMapping(consumes = "application/json" ,  produces = "application/json")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws IOException{
    	Student savedStudent = studentService.saveStudent(student);
    	return ResponseEntity.ok(savedStudent);
}
    
    

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id , @RequestBody Student updatedStudent) {
        return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
    }
	
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	    return "Student with ID " + id + " deleted successfully!";		
	}
	

}




































/*

POST: http://localhost:8080/student

{
  "name": "Muzzammil Khan",
  "phone": 9988776655,
  "email": "muzzammil@example.com",
  "teacher": {
    "name": "Fazil Khan",
    "subject": "Python",
    "email": "imrankhan@example.com",
    "course": {
      "cname": "Python Core",
      "author": "James Gosling"
    }
  },
  "courses": [
    {
      "cname": "Python Core",
      "author": "James Gosling"
    }
  ]
}


{
    "id": 10,
    "name": "John Doe",
    "phone": 9876543210,
    "email": "john.doe@example.com",
    "courses": [
        {
            "id": 101,
            "cname": "Java Basics",
            "author": "John Smith"
        },
        {
            "id": 102,
            "cname": "Spring Boot Fundamentals",
            "author": "Jane Doe"
        },
        {
            "id": 103,
            "cname": "Python for Data Science",
            "author": "Michael Johnson"
        },
        {
            "id": 104,
            "cname": "Web Development with React",
            "author": "Alice Brown"
        },
        {
            "id": 105,
            "cname": "Database Management with MySQL",
            "author": "Robert White"
        },
        {
            "id": 6,
            "cname": "Machine Learning with TensorFlow",
            "author": "Emma Watson"
        },
        {
            "id": 7,
            "cname": "Cybersecurity Fundamentals",
            "author": "Liam Carter"
        },
        {
            "id": 8,
            "cname": "Cloud Computing with AWS",
            "author": "Sophia Martinez"
        },
        {
            "id": 9,
            "cname": "Mobile App Development with Flutter",
            "author": "Daniel Adams"
        },
        {
            "id": 10,
            "cname": "Blockchain and Cryptocurrency",
            "author": "James Anderson"
        }
    ]
}


PUT: http://localhost:8080/student/1
{
    "name": "Hamza Sheikh Updated",
    "phone": 8765432100,
    "email": "hamza.updated@example.com",
    "course": {
        "id": 3
    }
}

       
    

*/

