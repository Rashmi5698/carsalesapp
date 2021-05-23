package com.cg.cars.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cg.cars.model.AdminDTO;
import com.cg.cars.entities.Admin;
import com.cg.cars.exceptions.AdminNotFoundException;

@RestController
@RequestMapping("/api/cars")
public class AdminController {
	static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;

	/************************************************************************************
	 * Method: addAdmin 
	 * Description: It is used to add Admin into Admins table
	 * @param Admin: Admin's reference variable.
	 * @returns Admin:It returns Admin with details
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain  object in method parameter or return type.
	 ************************************************************************************/
	@PostMapping("/add-Admin")
	public ResponseEntity<Object> insertAdmin(@RequestBody Admin admin)throws AdminNotFoundException {
		LOGGER.info("add-Admin URL is opened");
		LOGGER.info("addAdmin() is initiated");
		AdminDTO adminDTO = null;
		ResponseEntity<Object> adminResponse = null;
		adminDTO = adminService.addAdmin(admin);
		adminResponse = new ResponseEntity<Object>(adminDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addAdmin() has executed");
		return adminResponse;
	}

	/************************************************************************************
	 * Method: getAdminById 
	 * Description: It is used to view Admin by id from Admins table
	 * @param Admin: Long id
	 * @returns Admin: It returns Admin with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@GetMapping("/view-Admin/{id}")
	public ResponseEntity getAdminById(@PathVariable Long id) throws AdminNotFoundException {
		LOGGER.info("view-Admin URL is opened");
		LOGGER.info("viewAdmin() is initiated");
		AdminDTO adminDTO = adminService.getAdminById(id);
		LOGGER.info("viewAdmin() has executed");
		return new ResponseEntity(adminDTO, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getAllAdmins 
	 * Description: It is used to view all Admins in Admins table
	 * @returns Admin: It returns Admin with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/

	@GetMapping("/view-all-Admin")
	public List<AdminDTO> viewAllAdmins() {
		LOGGER.info("view-all-Admin URL is opened");
		LOGGER.info("viewAllAdmin() is initiated");
		LOGGER.info("viewAllAdmin() has executed");
		return adminService.getAllAdmins();
	}

	/************************************************************************************
	 * Method: DeleteAdmin 
	 * Description: It is used to remove Admin from Admins table
	 * @param Admin: Long id
	 * @returns Admin: It returns Admin with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@DeleteMapping("/delete-Admin/{id}")
	public ResponseEntity<Object> deleteAdminById(@PathVariable Long id) throws AdminNotFoundException {
		LOGGER.info("delete-Admin URL is opened");
		LOGGER.info("deleteAdmin() is initiated");
		adminService.deleteAdminById(id);
		LOGGER.info("deleteAdmin() has executed");
		return new ResponseEntity("deleted successfully:", HttpStatus.ACCEPTED);
	}

	/************************************************************************************
	 * Method: updateAdmin 
	 * Description: It is used to update Admin into Admin table
	 * @param Admin: Admin's reference variable.
	 * @returns Admin: It returns Admin with details
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ************************************************************************************/
	@PutMapping("/update-Admin/{id}")

	public ResponseEntity updateAdmin(@PathVariable Long id, @RequestBody Admin adminRequest)
			throws AdminNotFoundException {
		LOGGER.info("update-Admin URL is opened");
		LOGGER.info("updateAdmin() is initiated");
		adminService.updateAdminById(id, adminRequest);
		LOGGER.info("updateAdmin() has executed");
		return new ResponseEntity("Updated ", HttpStatus.OK);
	}

}
