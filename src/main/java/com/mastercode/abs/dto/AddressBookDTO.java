package com.mastercode.abs.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressBookDTO {
	
	@Pattern(regexp = "^[A-Z][a-zA-z]{3,15}$", message = "Entered Name is Invalid.Try Again")
	private String name;
	private String city;
	private String state;
	@Pattern(regexp = "^[0-9]{6}$", message = "Invalid Zip Number.Try Again")
	private String zip;
	private String email;
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone Number is Invalid")
	private String phone;
}