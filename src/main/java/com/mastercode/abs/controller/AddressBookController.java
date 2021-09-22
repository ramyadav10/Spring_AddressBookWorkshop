package com.mastercode.abs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mastercode.abs.service.IAddressBookService;

public class AddressBookController {

	@Autowired
	IAddressBookService addressbookservice;
	
	Logger log = LoggerFactory.getLogger(AddressBookController.class);
	
	
	@GetMapping("/retrive")
	public ResponseEntity<ResponseDTO> getAllData()
	{
		
	}
	
	@GetMapping("/retrive/{id}")
	public ResponseEntity<ResponseDTO> findById(@PathVariable int id)
	{
			}
	
	
	@PostMapping("/insert") 
	public ResponseEntity<ResponseDTO> addRecord( @RequestBody AddressBookDTO addressbookdto) //throws CustomException
	{
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateRecords( @RequestBody AddressBookDTO addressbookdto,@PathVariable int id)
	{
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable int id)
	{
	}

}
