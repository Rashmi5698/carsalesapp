package com.cg.cars.entities;
import javax.persistence.*;
@Entity
@Table(name="Iuser")

public class User {
	@Id
	private Long userId;
	@Column
	private String password;
	private String role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*public User(Long userId, String password, String role) {
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
