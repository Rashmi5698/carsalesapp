package com.cg.cars.services.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cg.cars.entities.Admin;
import com.cg.cars.exceptions.AdminNotFoundException;
import com.cg.cars.model.AdminDTO;
import java.util.Optional;
import com.cg.cars.repository.AdminRepository;
import com.cg.cars.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.util.AdminUtils;

@Service
public class AdminServiceImpl implements AdminService {
	static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminRepository adminRepository;
	/*
	 * Description : This method Adds new Admin Input Param : Admin Object Return
	 * Value : AdminDTO Object Exception : AdminNotFoundException
	 */

	public AdminDTO addAdmin(Admin iAdmin) {
		LOGGER.info("addAdmin() service is initiated");
		Admin adminEntity = adminRepository.save(iAdmin);
		LOGGER.info("addAdmin() service has executed");
		return AdminUtils.convertToAdminDto(adminEntity);
	}

	/*
	 * Description : This method Shows existing Admin by ID Input Param : Long
	 * Object Return Value : AdminDTO Object Exception : AdminNotFoundException
	 */
	public AdminDTO getAdminById(Long id) throws AdminNotFoundException {
		LOGGER.info("viewAdmin() service is initiated");
		Optional<Admin> existAdmin = adminRepository.findById(id);
		if (existAdmin.isPresent()) {
			Admin admin = existAdmin.get();
			LOGGER.info("viewAdmin() service has executed");
			return AdminUtils.convertToAdminDto(admin);
		} else {
			throw new AdminNotFoundException("Admin with id not present");
		}

	}

	/*
	 * Description : This method Shows all existing Admins Object Return Value:
	 * List<AdminDTO>
	 */

	@Override
	public List<AdminDTO> getAllAdmins() {
		LOGGER.info("viewAllAdmin() service is initiated");
		List<Admin> adminList = adminRepository.findAll();
		LOGGER.info("viewAllAdmin() service has executed");
		return AdminUtils.convertToAdminDtoList(adminList);
	}

	/*
	 * Description : This method Updates existing Admin Input Param : AdminDTO
	 * Object Return Value : Admin Object Exception : AdminNotFoundException
	 */

	public Admin updateAdminById(Long id, Admin adminRequest) throws AdminNotFoundException {
		LOGGER.info("updateAdmin() service is initiated");
		return adminRepository.findById(id).map(admin -> {
			admin.setPassword(adminRequest.getPassword());
			admin.setUser(adminRequest.getUser());
			LOGGER.info("updateAdmin() service has executed");
			return adminRepository.save(admin);
		}).orElseThrow(() -> new AdminNotFoundException("Admin with id not present"));

	}

	/*
	 * Description : This method Deletes existing Admin Input Param : Long Return
	 * Value : AdminDTO Object Exception : AdminNotFoundException
	 */
	public AdminDTO deleteAdminById(Long id) throws AdminNotFoundException {
		LOGGER.info("deleteAdmin() service is initiated");
		Admin adminexist = adminRepository.findById(id).orElse(null);
		if (adminexist == null)
			throw new AdminNotFoundException("Admin with id not present");
		else
			adminRepository.delete(adminexist);
		LOGGER.info("deleteAdmin() service has executed");
		return AdminUtils.convertToAdminDto(adminexist);
	}

}
