package com.pizzamanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO extends UserDTO {

	@NotNull(message = "Customer name cannot be blank")
	@Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters")
	private String customerName;

	@NotNull(message = "Customer mobile cannot be null")
	private Long customerMobile;

	@NotNull(message = "Customer email cannot be blank")
	@Email(message = "Invalid email format")
	private String customerEmail;

	@NotNull(message = "Customer address cannot be blank")
	private String customerAddress;
}
