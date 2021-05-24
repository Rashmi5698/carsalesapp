package com.cg.cars.util;

import com.cg.cars.model.AdminDTO;
import com.cg.cars.entities.Admin;
import java.util.List;
import java.util.ArrayList;

public class AdminUtils {
	private AdminUtils() {
	}

	public static List<AdminDTO> convertToAdminDtoList(List<Admin> list) {
		List<AdminDTO> dtolist = new ArrayList<>();
		for (Admin Admin : list)
			dtolist.add(convertToAdminDto(Admin));
		return dtolist;
	}

	public static AdminDTO convertToAdminDto(Admin iAdmin) {
		AdminDTO dto = new AdminDTO();
		dto.setAdminId(iAdmin.getAdminId());
		dto.setPassword(iAdmin.getPassword());
		dto.setUser(iAdmin.getUser());

		return dto;
	}
}
