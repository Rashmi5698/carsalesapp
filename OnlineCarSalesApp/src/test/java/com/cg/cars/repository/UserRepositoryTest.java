package com.cg.cars.repository;

import org.junit.runner.RunWith;

import com.cg.cars.entities.Admin;
import com.cg.cars.entities.User;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.entities.User;
import org.junit.Test;
import org.junit.Assert;
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
public class UserRepositoryTest {

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewUser()  {
		User user = getUser();
		User saveInDb = testEntityManager.persist(user);
		User getFromInDb = UserRepository.findById(saveInDb.getUserId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetUserById() throws UserNotFoundException {
		User user = new User();
		user.setUserId(178L);
		user.setPassword("Reshmi");
		user.setRole("Analyst");
		// Insert Data into in memory database
		User saveInDb = testEntityManager.persist(user);
		// Get Data from DB
		User getInDb = UserRepository.findById(user.getUserId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllUsers()  {
		User user1 = new User();
		user1.setUserId(128L);
		user1.setPassword("Reni");
		user1.setRole("Analyst");

		User user2 = new User();
		user2.setUserId(12L);
		user2.setPassword("Ramya");
		user2.setRole("Accounts");
		// Save into in memory database
		testEntityManager.persist(user1);
		testEntityManager.persist(user2);

		// Retrieve all tickets
		List<User> userList = (List<User>) UserRepository.findAll();

		Assert.assertEquals(2, userList.size());
	}

	@Test
	public void testDeleteUserById() throws UserNotFoundException  {
		User user1 = new User();
		user1.setUserId(12L);
		user1.setPassword("Reni");
		user1.setRole("Analyst");

		User user2 = new User();
		user2.setUserId(128L);
		user2.setPassword("Reni");
		user2.setRole("Analyst");

		User user = testEntityManager.persist(user1);
		testEntityManager.persist(user2);

		// delete one ticket DB
		testEntityManager.remove(user);

		List<User> users = (List<User>) UserRepository.findAll();
		Assert.assertEquals(users.size(), 1);
	}

	@Test
	public void testUpdateUserById() throws UserNotFoundException {
		User user2 = new User();
		user2.setUserId(12L);
		user2.setPassword("Ramya");
		user2.setRole("Accounts");

		User saveInDb = testEntityManager.persist(user2);

		User getFromDb = UserRepository.findById(user2.getUserId()).get();

		assertThat(getFromDb).isEqualTo(saveInDb);

	}

	private User getUser() {
		User user1 = new User();
		user1.setUserId(12L);
		user1.setPassword("Reni");
		user1.setRole("Analyst");
		return user1;

	}
}
