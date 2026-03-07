package com.ems.service.impl;

import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import com.ems.mapper.EmployeeMapper;
import com.ems.repositry.EmployeeRepository;
import com.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee saveEmployee =  employeeRepository.save(employee);
		
		
		return EmployeeMapper.mapEmployeeDto(saveEmployee);
	}

}
