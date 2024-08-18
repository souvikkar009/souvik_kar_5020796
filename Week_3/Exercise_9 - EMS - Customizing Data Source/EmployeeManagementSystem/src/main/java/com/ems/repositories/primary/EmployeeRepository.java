package com.ems.repositories.primary;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.dtos.EmployeeDto;
import com.ems.entitites.primary.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findByName(String name);

	public Employee findByEmail(String email);

	@Query(value = "SELECT e FROM Employees e WHERE e.name LIKE %?1%", nativeQuery = true)
	public Page<Employee> findByNameContaining(String nameFragment, Pageable pageable);

	@Query(value = "SELECT e FROM Employees e WHERE e.email LIKE %?1%", nativeQuery = true)
	public Page<Employee> findByEmailContaining(String emailFragment, Pageable pageable);

	@Query(value = "SELECT new com.ems.dtos.EmployeeDto(e.id, e.name, e.email, e.dept_id) FROM Employees e", nativeQuery = true)
	List<EmployeeDto> findAllEmployeeDtos();
}