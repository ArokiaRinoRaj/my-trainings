package com.rino.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rino.employeeapp.dto.AddressDTO;
import com.rino.employeeapp.dto.EmployeeDTO;
import com.rino.employeeapp.entity.EmployeeDetail;
import com.rino.employeeapp.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${addressservice.base.url}")
	private String addressBaseUrl;

	public EmployeeDTO getEmployeeById(int id) {

		EmployeeDetail employee = employeeRepo.findById(id).get();
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		
		AddressDTO addressDTO = restTemplate.getForObject(addressBaseUrl+"/address/{id}", AddressDTO.class, id);
		employeeDTO.setAddressDTO(addressDTO);
		return employeeDTO;

	}

}
