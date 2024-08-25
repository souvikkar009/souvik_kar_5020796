package com.olbs.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationForm {
	@NotNull
	@Size(min = 2, max = 40)
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Min(6)
	private String password;
}
