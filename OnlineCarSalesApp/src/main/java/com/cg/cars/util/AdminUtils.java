package com.cg.cars.util;

import com.cg.cars.model.AdminDTO;
import com.cg.cars.entities.Admin;
import java.util.List;
import java.util.ArrayList;

public class AdminUtils {
	private AdminUtils() {
	}
	//converting into screen class
	public static List<AdminDTO> convertToAdminDtoList(List<Admin> list){
		List<AdminDTO> dtolist=new ArrayList<AdminDTO>();
		for(Admin Admin :list)
			dtolist.add(convertToAdminDto(Admin));
		return dtolist;
}
	
	/*public static Admin convertToAdmin(AdminDTO dto) {
		Admin iAdmin= new Admin();
		iAdmin.setAdminId(dto.getAdminId());
		iAdmin.setPassword(dto.getPassword());
		iAdmin.setUser(dto.getUser());
	return iAdmin;	
	}*/
	
	public static AdminDTO convertToAdminDto(Admin iAdmin ) {
		AdminDTO dto=new AdminDTO();
		dto.setAdminId(iAdmin.getAdminId());
		dto.setPassword(iAdmin.getPassword());
		dto.setUser(iAdmin.getUser());
	
		
	return dto;	
	}
}
