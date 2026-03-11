package com.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
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

	@Override
	public EmployeeDto getEmployeeById(Long empId) {
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee is not exists with given ID: "+ empId));
		return EmployeeMapper.mapEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream()
				.map((employee) -> EmployeeMapper.mapEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long empId, EmployeeDto updatedEmployeeDto) {
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(()->new ResourceNotFoundException("Employee is Not Exists with Given Id: "+empId));
		
		employee.setFirstName(updatedEmployeeDto.getFirstName());
		employee.setLastName(updatedEmployeeDto.getLastName());
		employee.setEmail(updatedEmployeeDto.getEmail());
		
		Employee updatedEmployee =  employeeRepository.save(employee);
		
		return EmployeeMapper.mapEmployeeDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long empId) {
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is Not Exists with Given ID: "+ empId));
		
		employeeRepository.delete(employee);
		
	}

}
