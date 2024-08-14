package com.ems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entitites.Department;
import com.ems.entitites.Employee;
import com.ems.services.DepartmentServices;

@RestController
@RequestMapping("ems/api/department")
public class DepartmentControlller {
	@Autowired
	private DepartmentServices departmentServices;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return new ResponseEntity<>(departmentServices.addDepartment(department), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") int departmentId) {
		return new ResponseEntity<>(departmentServices.deleteDepartment(departmentId), HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		return new ResponseEntity<Department>(departmentServices.updateDepartment(department), HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int departmentId) {
		return new ResponseEntity<>(departmentServices.getDepartmentById(departmentId), HttpStatus.OK);

	}

	@GetMapping("/getByName/{name}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Department> getDepartmentByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(departmentServices.getDepartmentByName(name), HttpStatus.OK);

	}
	
	@GetMapping("/searchByName/{name}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<Department>> searchByName(@PathVariable("name") String nameFragment,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(departmentServices.searchDepartmentByName(nameFragment, pageable), HttpStatus.OK);
	}

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Department>> allDepartment() {
		return new ResponseEntity<List<Department>>(departmentServices.getAllDepartment(), HttpStatus.OK);
	}
}
