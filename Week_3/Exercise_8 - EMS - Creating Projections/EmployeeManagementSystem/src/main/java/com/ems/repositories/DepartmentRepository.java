package com.ems.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.dtos.DepartmentDto;
import com.ems.entitites.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	public Department findByName(String deptName);

	@Query(value = "SELECT d FROM Departments d WHERE d.name LIKE %?1%", nativeQuery = true)
	public Page<Department> findByNameContaining(String nameFragment, Pageable pageable);

	@Query( value = "SELECT new com.ems.dtos.DepartmentDto(d.id, d.name) FROM Departments d", nativeQuery = true)
	List<DepartmentDto> findAllDepartmentDtos();
}