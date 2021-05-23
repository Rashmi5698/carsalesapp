package com.cg.cars.repository;

import org.junit.runner.RunWith;
import com.cg.cars.entities.Admin;
import com.cg.cars.entities.User;
import com.cg.cars.exceptions.AdminNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminRepositoryTest {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewAdmin() {
		Admin admin = getAdmin();
		Admin saveInDb = testEntityManager.persist(admin);
		Admin getFromInDb = adminRepository.findById(saveInDb.getAdminId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAdminById() throws AdminNotFoundException {
		Admin admin = new Admin();

		admin.setPassword("1ve16cs077");
		// Insert Data into in memory database
		Admin saveInDb = testEntityManager.persist(admin);
		// Get Data from DB
		Admin getInDb = adminRepository.findById(admin.getAdminId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllAdmins() throws Exception {
		Admin admin1 = new Admin();

		admin1.setPassword("rtef6");

		Admin admin2 = new Admin();

		admin2.setPassword("rtgsff6");
		// Save into in memory database
		testEntityManager.persist(admin1);
		testEntityManager.persist(admin2);

		// Retrieve all tickets
		List<Admin> adminList = (List<Admin>) adminRepository.findAll();

		Assert.assertEquals(2, adminList.size());
	}

	@Test
	public void testDeleteAdminById() throws Exception {
		Admin admin1 = new Admin();

		admin1.setPassword("ggdyued");

		Admin admin2 = new Admin();

		admin2.setPassword("ghgaj");

		Admin admin = testEntityManager.persist(admin1);
		testEntityManager.persist(admin2);

		testEntityManager.remove(admin);

		List<Admin> admins = (List<Admin>) adminRepository.findAll();
		Assert.assertEquals(admins.size(), 1);

	}

	@Test
	public void testUpdateAdminById() {
		Admin admin2 = new Admin();
		admin2.setPassword("ghgaj");

		Admin saveInDb = testEntityManager.persist(admin2);

		Admin getFromDb = adminRepository.findById(admin2.getAdminId()).get();

		assertThat(getFromDb).isEqualTo(saveInDb);

	}

	private Admin getAdmin() {
		Admin admin = new Admin();

		admin.setPassword("ramyashmi");
		return admin;

	}
}
