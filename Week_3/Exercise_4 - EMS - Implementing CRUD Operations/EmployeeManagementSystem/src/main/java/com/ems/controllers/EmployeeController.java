package com.ems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dtos.EmployeeDto;
import com.ems.entitites.Employee;
import com.ems.services.EmployeeServices;

@RestController
@RequestMapping("ems/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeServices employeeServices;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<>(employeeServices.addEmployee(employeeDto), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int employeeId) {
		return new ResponseEntity<>(employeeServices.deleteEmployee(employeeId), HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<Employee>(employeeServices.updateEmployee(employeeDto), HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int employeeId) {
		return new ResponseEntity<>(employeeServices.getEmployeeById(employeeId), HttpStatus.OK);

	}

	@GetMapping("/getByEmail/{email}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable("email") String email) {
		return new ResponseEntity<>(employeeServices.getEmployeeByEmail(email), HttpStatus.OK);

	}

	@GetMapping("/getByName/{name}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Employee>> getDepartmentByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(employeeServices.getEmployeesByName(name), HttpStatus.OK);

	}

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Employee>> allDepartment() {
		return new ResponseEntity<List<Employee>>(employeeServices.getAllEmployees(), HttpStatus.OK);
	}

}
