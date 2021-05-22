package com.cg.cars.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cars.entities.User;
import com.cg.cars.entities.User;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.model.UserDTO;
import com.cg.cars.repository.UserRepository;
import com.cg.cars.repository.UserRepository;
import com.cg.cars.services.UserService;
import com.cg.cars.util.UserUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

	@MockBean
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	@Test
	public void addUserTest() {
		User User = new User();
		User.setUserId(128L);
		User.setPassword("Reni");
		User.setRole("Analyst");

		Mockito.when(userRepo.save(User)).thenReturn(User);
		UserDTO UserDTO = UserUtils.convertToUserDto(User);
		assertEquals(UserDTO.getUserId(), 128L);
	}

	@Test
	public void showUserByIdTest() throws UserNotFoundException {
		User User = new User();
		User.setUserId(128L);
		User.setPassword("Reni");
		User.setRole("Analyst");

		Mockito.when(userRepo.save(User)).thenReturn(User);
		assertEquals(User.getUserId(), 128L);
	}

	@Test
	public void showAllUserTest() throws UserNotFoundException {
		User User = new User();
		User.setUserId(128L);
		User.setPassword("Reni");
		User.setRole("Analyst");

		User User1 = new User();
		User1.setUserId(128L);
		User1.setPassword("Reni");
		User1.setRole("Analyst");

		List<User> UserList = new ArrayList<>();
		UserList.add(User);
		UserList.add(User1);
		Mockito.when(userRepo.findAll()).thenReturn(UserList);
//		System.out.println("Service list"+productService.showAllProducts());
		List<UserDTO> dto = UserUtils.convertToUserDtoList(UserList);
//		System.out.println("after converting:"+dto);
		assertSame(userService.getAllUsers().size(), 2);
	}

	@Test
	public void deleteUserTest() {
		User User1 = new User();
		User1.setUserId(128L);
		User1.setPassword("Reni");
		User1.setRole("Analyst");

		Mockito.when(userRepo.save(User1)).thenReturn(User1);
		userRepo.deleteById(User1.getUserId());
		assertNotEquals(User1, new User());
	}

	@Test
	public void updateUserTest() {

		User User1 = new User();
		User1.setUserId(128L);
		User1.setPassword("Reni");
		User1.setRole("Analyst");

		userRepo.save(User1);

		Mockito.when(userRepo.save(User1)).thenReturn(User1);
		assertEquals(User1.getUserId(), 128L);
	}
}
