package com.ems.services;

import java.util.List;

import com.ems.dtos.EmployeeDto;
import com.ems.entitites.Employee;

public interface EmployeeServices {
	public Employee addEmployee(EmployeeDto employeeDto);

	public String deleteEmployee(int employeeId);

	public Employee updateEmployee(EmployeeDto employee);

	public Employee getEmployeeById(int employeeId);

	public List<Employee> getEmployeesByName(String name);

	public Employee getEmployeeByEmail(String email);

	public List<Employee> getAllEmployees();
}
