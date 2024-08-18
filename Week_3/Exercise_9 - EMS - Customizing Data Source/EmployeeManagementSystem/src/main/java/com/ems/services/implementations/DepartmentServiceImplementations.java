package com.ems.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ems.entitites.secondary.Department;
import com.ems.repositories.secondary.DepartmentRepository;
import com.ems.services.DepartmentServices;

@Service
public class DepartmentServiceImplementations implements DepartmentServices {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public String deleteDepartment(int departmentId) {
		departmentRepository.deleteById(departmentId);
		return "Department with department id: " + departmentId + " is deleted.";
	}

	@Override
	public Department updateDepartment(Department department) {
		departmentRepository.save(department);
		return department;
	}

	@Override
	public Department getDepartmentById(int departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public Department getDepartmentByName(String name) {
		return departmentRepository.findByName(name);
	}

	@Override
	public List<Department> getAllDepartment() {
		List<Department> departments = new ArrayList<>();
		departmentRepository.findAll().forEach(department -> departments.add(department));
		return departments;
	}

	@Override
	public Page<Department> searchDepartmentByName(String nameFragemnt, Pageable pageable) {
		Page<Department> departments = departmentRepository.findByNameContaining(nameFragemnt, pageable);
		return departments;
	}

}
