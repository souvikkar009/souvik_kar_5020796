package com.olbs.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	private String title;
	
	@Size(min = 2, max = 40)
	@NotNull
	private String author;
	
	@Positive(message = "pos")
	@NotNull
	private Integer price;
	
	@Size(min = 2)
	@NotNull
	private String isbn;
}
