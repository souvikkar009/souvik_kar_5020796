package com.ems.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dtos.EmployeeDto;
import com.ems.entitites.Department;
import com.ems.entitites.Employee;
import com.ems.repositories.DepartmentRepository;
import com.ems.repositories.EmployeeRepository;
import com.ems.services.EmployeeServices;

@Service
public class EmployeeServiceImplementations implements EmployeeServices{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Employee addEmployee(EmployeeDto employeeDto) {
		Department department = departmentRepository.findById(employeeDto.getDeptId()).orElse(null);
		Employee employee = new Employee();
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setDepartment(department);
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public String deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		return "Employee with id: " + employeeId + " is deleted.";
	}

	@Override
	public Employee updateEmployee(EmployeeDto employeeDto) {
		Department department = departmentRepository.findById(employeeDto.getDeptId()).orElse(null);
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setDepartment(department);
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeRepository.findById(employeeId).get();
		
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findByName(name).forEach(employee -> employees.add(employee));
		return employees;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee -> employees.add(employee));
		return employees;
	}

}
