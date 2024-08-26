package com.olbs.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

	private Integer id;
	
	@Size(min = 2, max = 40)
	private String name;
	
	@Email
	private String email;
	@Min(6)
	private String password;

}
