package com.rino.addressapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rino.addressapp.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {
	
	@Query(nativeQuery = true, value="select b.ID,b.LANE1,b.LANE2,b.STATE,b.ZIP from employee_detail a, address_detail b where a.id = b.EMPLOYEE_ID and b.EMPLOYEE_ID= ?1;")
	public Address getAddressByEmployeeId(int employeeId);
}


