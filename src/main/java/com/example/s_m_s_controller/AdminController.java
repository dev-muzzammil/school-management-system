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

import com.example.s_m_s_entities.Admin;
import com.example.s_m_s_service.AdminService;

@RestController
@RequestMapping("/admin")

public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("/{id}")
	public Optional<Admin> getAdminBYId (@PathVariable int id){
		return (adminService.findAdminById(id));
	}
	
	
	@PostMapping
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) throws IOException{
		Admin savedAdmin = adminService.saveAdmin(admin);
		return ResponseEntity.ok(savedAdmin);
	}

	
	@PutMapping("/{id}")
    public ResponseEntity<Admin> updateStudent(@PathVariable int id , @RequestBody Admin updatedAdmin) {
        return ResponseEntity.ok(adminService.updateAdmin(id, updatedAdmin));
    }	

	
	@DeleteMapping("/{id}")
	public String deleteAdmin(@PathVariable int id) {
		adminService.deleteAdmin(id);  // ✅ Call the delete method
	    return "Admin with ID " + id + " deleted successfully!";
 	}
	
}




















/*
 
POST:  http://localhost:8080/admin
{
  "id": 1,
  "name": "Muzzz Admin",
  "phone": 9998887777,
  "email": "muzzz.admin@example.com",
  "teacher": [
    {
      "id": 101,
      "name": "Imran Khan",
      "subject": "History",
      "email": "imran@school.com"
    },
    {
      "id": 102,
      "name": "Fatima Zahra",
      "subject": "Science",
      "email": "fatima@school.com"
    }
  ]
}

POST:  http://localhost:8080
{
  "name": "Tariq Khan",
  "phone": 1234567890,
  "email": "tariqkhan@example.com",
  "teacher": [
    {
      "name": "Imran Khan",
      "subject": "Java",
      "email": "imrankhan@example.com",
      "course": {
        "cname": "Java Core",
        "author": "James Gosling"
      },
      "students": [
        {
          "name": "Muzzammil Khan",
          "phone": 9988776655,
          "email": "muzzammil@example.com"
        }
      ]
    }
  ]
}


PUT:  http://localhost:8080/admin/1

{
  "name": "Muzzammil Khan",
  "phone": 9876543210,
  "email": "adminali@school.com",
  "teacher": [
    {
      "id": 101,
      "name": "Imran Khan",
      "subject": "History Updated",
      "email": "imran_updated@school.com"
    },
    {
      "id": 102,
      "name": "Fatima Zahra",
      "subject": "Biology",
      "email": "fatima_bio@school.com"
    }
  ]
}

*/
