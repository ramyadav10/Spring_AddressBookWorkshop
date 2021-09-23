package com.mastercode.abs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercode.abs.dto.AddressDTO;
import com.mastercode.abs.dto.ResponseDTO;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;



@RestController
@RequestMapping("/address")
public class AddressBookController {

	private List<AddressDTO> list=new ArrayList<AddressDTO>();
	private static AtomicLong atomicLong=new AtomicLong();
	
	@GetMapping
	private ResponseEntity<ResponseDTO> getAll() {
		Log.info("get all data");
		ResponseDTO dto=new ResponseDTO("get all call successful",list);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@PostMapping
	private ResponseEntity<ResponseDTO> create(@RequestBody AddressDTO AddressData) {
		AddressData.setId(atomicLong.incrementAndGet());
		list.add(AddressData);
		ResponseDTO dto=new ResponseDTO("post call successful", AddressData);
		Log.info("data inserted.");
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<ResponseDTO> getById(@PathVariable int id){
		AddressDTO data =list.stream().filter(e->e.getId()==id).findFirst().get();
		ResponseDTO dto=new ResponseDTO("get id call successful", data);
		Log.info("data is retrived with id ->"+id);
		return new ResponseEntity<>(dto,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<ResponseDTO> updateById(@PathVariable int id,@RequestBody AddressDTO addressData){
		AddressDTO updateData=list.stream().filter(e->e.getId()==id).findFirst().get();
		updateData.setName(addressData.getName());
		updateData.setAddress(addressData.getAddress());
		updateData.setZip(addressData.getZip());
		ResponseDTO dto=new ResponseDTO("put call successful", updateData);
		Log.info("data updated with id ->"+id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<ResponseDTO> deleteById(@PathVariable int id) {
		AddressDTO addressData=list.stream().filter(e->e.getId()==id).findFirst().get();
		list.remove(addressData);
		ResponseDTO dto=new ResponseDTO("delete call successful", addressData);
		log.info("data deleted with id ->"+id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}

}
