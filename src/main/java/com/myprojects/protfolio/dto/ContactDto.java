package com.myprojects.protfolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

	@Size(min=2, max=30, message="Invalid Name Length")
	@NotBlank(message="Name cannot be empty")
	private String name; 
	
	@Size(min=8, max=50, message="Invalid Email Length")
	@NotBlank(message="Email cannot be empty")
	private String email; 
	
	@Size(min=4, max=50, message="Invalid Subject Length")
	@NotBlank(message="Subject cannot be empty")
	private String subject;
	
	@Size(min=4, max=1000, message="Invalid message Length")
	@NotBlank(message="Message cannot be empty")
	private String message; 
		
	}

