package com.pizzamanagementsystem.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzamanagementsystem.dto.UserDTO;
import com.pizzamanagementsystem.entity.User;
import com.pizzamanagementsystem.exception.UserNotFoundException;
import com.pizzamanagementsystem.repository.UserRepository;

@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	/*
	 * for new user registration
	 */
	@Override
	public UserDTO registerUser(UserDTO userdto) {
		User user = modelMapper.map(userdto, User.class);
		User savedUser = userRepo.save(user);
		return modelMapper.map(savedUser, UserDTO.class);
	}

	/*
	 * for sign in
	 */
	@Override
	public UserDTO signIn(String userName, String password) {
		User userEntity = userRepo.findByUserName(userName);
		if (userEntity != null && userEntity.getPassword().equals(password)) {
			/*
			 * Map the userEntity to UserDTO
			 */
			return modelMapper.map(userEntity, UserDTO.class);
		} else {
			throw new UserNotFoundException("Invalid User or Password");
		}
	}

	/*
	 * for sign out
	 */
	@Override
	public String signOut() {
		return "User Signed out";
	}

}
