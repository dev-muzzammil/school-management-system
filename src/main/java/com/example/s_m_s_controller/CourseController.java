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

import com.example.s_m_s_entities.Course;
import com.example.s_m_s_service.CourseService;

@RestController
@RequestMapping("/course")

public class CourseController {

	
	@Autowired
	private CourseService courseService;
	
	
	
	@GetMapping("/{id}")
	public Optional<Course> getCourseById (@PathVariable int id){
		return (courseService.findCourseById(id));		
	}
	
	

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
	
    
	@GetMapping("/{courseId}/student")
	public List<Integer> getStudentsIdsByCourseid (@PathVariable Integer courseId){
		return courseService.getStudentsIdsByCourseid(courseId);
	}
    
	@GetMapping("/{courseId}/studentnames")
	public List<String> getStudentsNamesByCourseid (@PathVariable Integer courseId){
		return courseService.getStudentsNamesByCourseid(courseId);
	}
		
    
	
    @PostMapping(consumes = "application/json" ,  produces = "application/json")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) throws IOException{
        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
    }
    

    @PostMapping(
    	    path = "/addAll",
    	    consumes = "application/json",
    	    produces = "application/json"
    )	    
    public ResponseEntity<List<Course>> createCourse(@RequestBody List<Course> course) {
        List<Course> savedCourses = courseService.saveAllCourse(course);
        return ResponseEntity.ok(savedCourses);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable int id ,  @RequestBody Course updatedCourse) {
        return ResponseEntity.ok(courseService.updateCourse(id, updatedCourse));
    }
    
	
	
    
	@DeleteMapping("/{id}")
	public String deleteCourse (@PathVariable int id) {
		courseService.deleteCourse(id);
	    return "Admin with ID " + id + " deleted successfully!";		
	}
	
	
}












/*

POST: http://localhost:8080/course

{
  "cname": "Java Core",
  "author": "James Gosling",
  "teacher": {
    "name": "Imran Khan",
    "subject": "Java",
    "email": "imrankhan@example.com"
  },
  "students": [
    {
      "name": "Muzzammil Khan",
      "phone": 9988776655,
      "email": "muzzammil@example.com"
    },
    {
      "name": "Ali Khan",
      "phone": 1122334455,
      "email": "alikhan@example.com"
    }
  ]
}


{
    "id": 6,
    "cname": "Java",
    "author": "Michael Johnson",
    "students": [
        {
            "id": 6,
            "name": "Hamza Sheikh Updated",
            "phone": 8765432100,
            "email": "hamza.updated@example.com"
        },
        {
            "id": 7,
            "name": "Aisha Khan",
            "phone": 9876543211,
            "email": "aisha.khan@example.com"
        },
        {
            "id": 8,
            "name": "Omar Farooq",
            "phone": 9123456789,
            "email": "omar.farooq@example.com"
        },
        {
            "id": 9,
            "name": "Fatima Zahra",
            "phone": 9234567890,
            "email": "fatima.zahra@example.com"
        },
        {
            "id": 10,
            "name": "Ali Raza",
            "phone": 9345678901,
            "email": "ali.raza@example.com"
        },
        {
            "id": 11,
            "name": "Sarah Ahmed",
            "phone": 9456789012,
            "email": "sarah.ahmed@example.com"
        },
        {
            "id": 12,
            "name": "Yusuf Malik",
            "phone": 9567890123,
            "email": "yusuf.malik@example.com"
        },
        {
            "id": 13,
            "name": "Zainab Noor",
            "phone": 9678901234,
            "email": "zainab.noor@example.com"
        },
        {
            "id": 14,
            "name": "Bilal Hussain",
            "phone": 9789012345,
            "email": "bilal.hussain@example.com"
        },
        {
            "id": 15,
            "name": "Hassan Javed",
            "phone": 9890123456,
            "email": "hassan.javed@example.com"
        }
    ]
}

http://localhost:8080/course/addAll 
[
  {
    "id": 101,
    "cname": "Java Backend",
    "author": "Muzzz",
    "students": [
      {
        "id": 1,
        "name": "Ayaan",
        "phone": 9876543210,
        "email": "ayaan@example.com"
        
      },
      {
        "id": 2,
        "name": "Sara",
        "phone": 9123456789,
        "email": "sara@example.com",
        "courses": []
      }
    ]
  },
  {
    "id": 102,
    "cname": "Spring Boot",
    "author": "Muzzz",
    "students": [
      {
        "id": 3,
        "name": "Zain",
        "phone": 9988776655,
        "email": "zain@example.com",
        "courses": []
      }
    ]
  }
]



PUT:  http://localhost:8080/course/1.
{
  "cname": "Advanced Java",
  "author": "Michael Johnson"
}


*/