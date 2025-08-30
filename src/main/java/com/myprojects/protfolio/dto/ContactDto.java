package com.myprojects.protfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

	private String name; 
	private String email; 
	private String subject; 
	private String message; 
		
	}

