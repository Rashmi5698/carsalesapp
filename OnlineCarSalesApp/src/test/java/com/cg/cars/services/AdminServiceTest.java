package com.cg.cars.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import com.cg.cars.entities.Admin;
import com.cg.cars.exceptions.AdminNotFoundException;
import com.cg.cars.model.AdminDTO;
import com.cg.cars.repository.AdminRepository;
import com.cg.cars.util.AdminUtils;

import junit.framework.AssertionFailedError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

	@MockBean
	private AdminRepository adminRepo;

	@Autowired
	private AdminService adminService;

	@Test
	public void addAdminTest() {
		Admin Admin = new Admin();
		Admin.setAdminId(45L);
		Admin.setPassword("rtef6");

		Mockito.when(adminRepo.save(Admin)).thenReturn(Admin);
		AdminDTO AdminDTO = AdminUtils.convertToAdminDto(Admin);
		assertEquals(AdminDTO.getAdminId(), 45L);
	}

	@Test
	public void showAdminByIdTest() throws AdminNotFoundException {
		Admin Admin = new Admin();
		Admin.setAdminId(45L);
		Admin.setPassword("rtef6");

		Mockito.when(adminRepo.save(Admin)).thenReturn(Admin);
		assertEquals(Admin.getAdminId(), 45L);
	}

	@Test
	public void showAllAdminsTest() throws AdminNotFoundException {
		Admin Admin = new Admin();
		Admin.setAdminId(45L);
		Admin.setPassword("rtef6");

		Admin Admin1 = new Admin();
		Admin1.setAdminId(45L);
		Admin1.setPassword("rtef6");

		List<Admin> AdminsList = new ArrayList<>();
		AdminsList.add(Admin);
		AdminsList.add(Admin1);
		Mockito.when(adminRepo.findAll()).thenReturn(AdminsList);
//		System.out.println("Service list"+productService.showAllProducts());
		List<AdminDTO> dto = AdminUtils.convertToAdminDtoList(AdminsList);
//		System.out.println("after converting:"+dto);
		assertSame(adminService.getAllAdmins().size(), 2);
	}

	@Test
	public void deleteAdminTest() {
		Admin Admin = new Admin();
		Admin.setAdminId(45L);
		Admin.setPassword("rtef6");

		Mockito.when(adminRepo.save(Admin)).thenReturn(Admin);
		adminRepo.deleteById(Admin.getAdminId());
		assertNotEquals(Admin, new Admin());
	}

	@Test
	public void updateAdminTest() {

		Admin Admin = new Admin();
		Admin.setAdminId(45L);
		Admin.setPassword("rtef6");

		adminRepo.save(Admin);

		Mockito.when(adminRepo.save(Admin)).thenReturn(Admin);
		assertEquals(Admin.getAdminId(), 45L);
	}
	
	
}