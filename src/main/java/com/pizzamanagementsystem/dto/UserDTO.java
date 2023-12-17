package com.pizzamanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	@NotNull(message = "User ID cannot be null")
	private Integer userId;

	@NotNull(message = "User name should not be blank")
	@Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters")
	private String userName;

	@NotNull(message = "Password should not be blank")
	private String password;

	@NotNull(message = "User role should not be blank")
	private String userRole;
}
