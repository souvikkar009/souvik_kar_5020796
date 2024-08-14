package com.ems.services;

import java.util.List;

import com.ems.entitites.Department;

public interface DepartmentServices {
	public Department addDepartment(Department department);

	public String deleteDepartment(int departmentId);

	public Department updateDepartment(Department department);

	public Department getDepartmentById(int departmentId);

	public Department getDepartmentByName(String name);

	public List<Department> getAllDepartment();
}
