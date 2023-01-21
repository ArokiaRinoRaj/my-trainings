package com.rino.addressapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rino.addressapp.dto.AddressDTO;
import com.rino.addressapp.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressDTO> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId){
		AddressDTO addressDTO = addressService.getAddressByEmployeeId(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(addressDTO);
	}

}

//http://localhost:8080/employee-app/api/address/1

//C - Post
//R - Get
//U - Put
//D - Delete