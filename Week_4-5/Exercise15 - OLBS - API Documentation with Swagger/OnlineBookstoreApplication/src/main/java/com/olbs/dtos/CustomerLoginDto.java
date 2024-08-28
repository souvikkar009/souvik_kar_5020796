package com.olbs.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginDto {
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be blank")
	String email;

	@NotBlank(message = "Password can not be blank")
	@Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
	private String password;
}
