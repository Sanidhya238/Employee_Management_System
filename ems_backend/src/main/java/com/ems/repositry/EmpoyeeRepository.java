package com.ems.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Employee;

public interface EmpoyeeRepository extends JpaRepository<Employee, Long>{

}
