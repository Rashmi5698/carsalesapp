package com.cg.cars.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cars.services.AdminService;

import com.cg.cars.services.AdminService;
import com.cg.cars.model.AdminDTO;

import com.cg.cars.entities.Admin;

import com.cg.cars.exceptions.AdminNotFoundException;
import com.cg.cars.entities.Admin;

//@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/cars")
public class AdminController {
	
	
	@Autowired
	private AdminService adminService;
	@PostMapping("/add-Admin")
	public ResponseEntity<Object> insertAdmin(@RequestBody Admin admin)
	{
		AdminDTO adminDTO = null;
		ResponseEntity<Object> adminResponse = null;
		adminDTO =adminService.addAdmin(admin);
		adminResponse = new ResponseEntity<Object>(adminDTO, HttpStatus.ACCEPTED);
		return adminResponse;
	}
	@GetMapping("/view-Admin/{id}")
	public ResponseEntity getAdminById(@PathVariable Long id)throws  AdminNotFoundException {
	
		AdminDTO adminDTO = adminService.getAdminById(id);
		
		return new ResponseEntity(adminDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/view-all-Admin")
	public List<AdminDTO> viewAllAdmins() {
		
		return adminService.getAllAdmins();
	}
	
	@DeleteMapping("/delete-Admin/{id}")
	public ResponseEntity<Object> deleteAdminById(@PathVariable Long id) throws AdminNotFoundException{
	
		adminService.deleteAdminById(id);
	
		return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);
}
@PutMapping("/update-Admin/{id}")
	
    public ResponseEntity updateAdmin(@PathVariable Long id, @RequestBody Admin adminRequest) throws AdminNotFoundException {
		adminService.updateAdminById(id,adminRequest);
		return new ResponseEntity("Updated ", HttpStatus.OK);
	}

}
