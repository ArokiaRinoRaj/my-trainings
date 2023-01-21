package com.rino.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rino.employeeapp.dto.EmployeeDTO;
import com.rino.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeDTO> getEmployeeDetails(@PathVariable("id") int id) {

		EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
		//return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);

	}

}
