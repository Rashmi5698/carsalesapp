package com.cg.cars.services.impl;

import java.util.List;
import java.util.Optional;

import com.cg.cars.entities.Admin;
import com.cg.cars.exceptions.AdminNotFoundException;
import com.cg.cars.model.AdminDTO;
import com.cg.cars.services.AdminService;
import com.cg.cars.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.AdminUtils;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	
public AdminDTO addAdmin(Admin iAdmin){
	Admin adminEntity=adminRepository.save(iAdmin);
	return AdminUtils.convertToAdminDto(adminEntity);
}




public AdminDTO getAdminById(Long id) throws AdminNotFoundException{
	Optional<Admin> existAdmin=adminRepository.findById(id);
	if(existAdmin.isPresent()) {
		Admin admin=existAdmin.get();
	return AdminUtils.convertToAdminDto(admin);
}
	else {
		throw new AdminNotFoundException("Admin with id not present");
	}
	
}


public List<AdminDTO> getAllAdmins(){
		List<Admin> adminList=adminRepository.findAll();
		return AdminUtils.convertToAdminDtoList(adminList);
		}

public Admin updateAdminById(Long id, Admin adminRequest) throws AdminNotFoundException{
    return adminRepository.findById(id).map( admin-> {
    	admin.setPassword(adminRequest.getPassword());
    	admin.setUser(adminRequest.getUser());
    	    return adminRepository.save(admin);
    }).orElseThrow(()-> new AdminNotFoundException("Admin with id not present"));
    
}

public AdminDTO deleteAdminById(Long id)throws AdminNotFoundException {
	Admin adminexist=adminRepository.findById(id).orElse(null);
	if(adminexist==null)
		throw new AdminNotFoundException("Admin with id not present");
	else
		adminRepository.delete(adminexist);
	return AdminUtils.convertToAdminDto(adminexist);
	}

}





