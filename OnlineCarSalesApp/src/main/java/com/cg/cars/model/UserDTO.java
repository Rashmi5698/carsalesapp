package com.cg.cars.model;

import org.springframework.stereotype.Component;
@Component
public class UserDTO {

	private Long userId;
	private String password;
	private String role;
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*public UserDTO(Long userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}*/
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/*@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}*/
	
}
