package com.pizzamanagementsystem.service;

import com.pizzamanagementsystem.dto.UserDTO;

public interface IUserService {
	UserDTO registerUser(UserDTO user);

	UserDTO signIn(String userName, String password);

	public String signOut();
}
