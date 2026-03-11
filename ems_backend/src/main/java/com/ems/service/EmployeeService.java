package com.ems.service;

import java.util.List;

import com.ems.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long empId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long empId, EmployeeDto updatedEmployeeDto);
	
	void deleteEmployee(Long empId);
}
