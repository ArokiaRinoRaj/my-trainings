package com.rino.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rino.addressapp.dto.AddressDTO;
import com.rino.addressapp.entity.Address;
import com.rino.addressapp.repo.AddressRepo;

@Service
public class AddressService {

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	ModelMapper modelMapper;

	public AddressDTO getAddressByEmployeeId(int id) {

		Address address = addressRepo.findById(id).get();

		AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
		return addressDTO;

	}

}
