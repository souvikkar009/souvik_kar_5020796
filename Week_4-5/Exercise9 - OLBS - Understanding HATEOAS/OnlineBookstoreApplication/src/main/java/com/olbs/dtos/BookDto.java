package com.olbs.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

	private Integer id;
	
	@Min(2)
	private String title;
	
	@Size(min = 2, max = 40)
	private String author;
	
	@Positive(message = "pos")
	private Integer price;
	
	@Size(min = 2)
	private String isbn;
}
