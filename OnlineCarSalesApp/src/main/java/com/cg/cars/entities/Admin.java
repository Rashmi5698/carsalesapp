package com.cg.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "Admin")

public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
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

	public Admin() {
		super();

	}

}
