package com.mastercode.abs.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercode.abs.dto.AddressBookDTO;
import com.mastercode.abs.dto.ResponseDTO;
import com.mastercode.abs.entity.AddressBookEntity;
import com.mastercode.abs.service.IAddressBookService;

import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
public class AddressBookController {

	@Autowired
	IAddressBookService addressbookservice;
	
	@GetMapping("/retrive")
	public ResponseEntity<ResponseDTO> getAllData()
	{
		log.info("Here, I retrive all the details from AddressBook:");
		List<AddressBookEntity> entity = addressbookservice.getAllDetails();
		ResponseDTO dto = new ResponseDTO("retrive all data from database successfully:",entity);
		return (new ResponseEntity(dto,HttpStatus.OK));
	}
	
	@GetMapping("/retrive/{id}")
	public ResponseEntity<ResponseDTO> findById(@PathVariable int id)
	{
		log.info("Data will be retrived for id:" + id);
		AddressBookEntity entity = addressbookservice.getById(id);
		ResponseDTO dto = new ResponseDTO("data retrived successfully:",entity);
		return (new ResponseEntity(dto,HttpStatus.OK));
	}
	
	
	@PostMapping("/insert") 
	public ResponseEntity<ResponseDTO> addRecord(@Valid @RequestBody AddressBookDTO addressbookdto) //throws CustomException
	{
			log.info("Inserting data into AddressBook database");
			AddressBookEntity entity = addressbookservice.insertRecord(addressbookdto);
			ResponseDTO dto = new ResponseDTO("Data added successfully:",entity);
			return (new ResponseEntity(dto,HttpStatus.CREATED));
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateRecords(@Valid @RequestBody AddressBookDTO addressbookdto,@PathVariable int id)
	{
		AddressBookEntity entity = addressbookservice.updateRecord(id, addressbookdto);
		log.info("Record updated for id: " + id);
		ResponseDTO dto = new ResponseDTO("Record updated successully:",entity);
		return (new ResponseEntity(dto,HttpStatus.OK));
	}
	
		@RequestMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteRecordById(@PathVariable int id)
	{
		log.info("Data deleted for Id:" + id);
		AddressBookEntity entity = addressbookservice.deleteRecord(id);
		ResponseDTO dto = new ResponseDTO("Record deleted successfully:",entity);
		return (new ResponseEntity(dto,HttpStatus.OK));
	}
}
