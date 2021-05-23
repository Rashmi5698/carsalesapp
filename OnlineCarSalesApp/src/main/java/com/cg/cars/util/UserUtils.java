package com.cg.cars.util;

import com.cg.cars.model.UserDTO;
import com.cg.cars.entities.User;
import java.util.List;
import java.util.ArrayList;

public class UserUtils {
	private UserUtils() {
	}
	//converting into screen class
	public static List<UserDTO> convertToUserDtoList(List<User> list){
		List<UserDTO> dtolist=new ArrayList<UserDTO>();
		for(User user :list)
			dtolist.add(convertToUserDto(user));
		return dtolist;
}
	
	/*public static User convertToUser(UserDTO dto) {
		User iuser= new User();
		
		iuser.setPassword(dto.getPassword());
		iuser.setRole(dto.getRole());
		iuser.setUserId(dto.getUserId());
	return iuser;	
	}*/
	
	public static UserDTO convertToUserDto(User iuser ) {
		UserDTO dto=new UserDTO();
		dto.setUserId(iuser.getUserId());
		dto.setPassword(iuser.getPassword());
		dto.setRole(iuser.getRole());
		
	return dto;	
	}
}
