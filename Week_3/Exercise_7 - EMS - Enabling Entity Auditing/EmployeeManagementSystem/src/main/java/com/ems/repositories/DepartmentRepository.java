package com.ems.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.entitites.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	public Department findByName(String deptName);
	
	@Query(value = "SELECT d FROM Departments d WHERE d.name LIKE %?1%", nativeQuery = true)
	public Page<Department> findByNameContaining(String nameFragment, Pageable pageable);
}