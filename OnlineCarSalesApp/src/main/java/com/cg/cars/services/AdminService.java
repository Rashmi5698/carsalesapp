package com.cg.cars.services;

import java.util.List;

import com.cg.cars.entities.Admin;
import com.cg.cars.exceptions.AdminNotFoundException;
import com.cg.cars.model.AdminDTO;



public interface AdminService {
	
	public AdminDTO addAdmin(Admin iAdmin);
	
	public AdminDTO getAdminById(Long id) throws AdminNotFoundException;
	
	public List<AdminDTO> getAllAdmins();
	
	public Admin updateAdminById(Long id, Admin AdminRequest) throws AdminNotFoundException;
	
	public AdminDTO deleteAdminById(Long id)throws AdminNotFoundException;

	
	


	
}