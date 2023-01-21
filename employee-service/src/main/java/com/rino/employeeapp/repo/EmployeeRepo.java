package com.rino.employeeapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rino.employeeapp.entity.EmployeeDetail;

public interface EmployeeRepo extends JpaRepository<EmployeeDetail, Integer> {

}
