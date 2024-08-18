package com.ems.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ems.dtos.EmployeeDto;
import com.ems.entitites.primary.Employee;

public interface EmployeeServices {
	public Employee addEmployee(EmployeeDto employeeDto);

	public String deleteEmployee(int employeeId);

	public Employee updateEmployee(EmployeeDto employee);

	public Employee getEmployeeById(int employeeId);

	public List<Employee> getEmployeesByName(String name);

	public Employee getEmployeeByEmail(String email);

	public List<Employee> getAllEmployees();
	
	public Page<Employee> searchEmployeeByName(String nameFragemnt, Pageable pageable);

	public Page<Employee> searchEmployeeByEmail(String emailFragemnt, Pageable pageable);
}
