package com.cg.cars.model;

import org.springframework.stereotype.Component;
import com.cg.cars.entities.User;

@Component
public class AdminDTO {

	private Long adminId;
	private String password;
	private User user;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AdminDTO() {
		super();

	}

}
