package com.ems.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entitites.primary.Employee;
import com.ems.repositories.primary.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class EmployeeBatchProcessing {
	@Autowired
	private EmployeeRepository employeeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void batchInsertEmployees(List<Employee> employees) {
		int batchSize = 30;
		for (int i = 0; i < employees.size(); i++) {
			entityManager.persist(employees.get(i));
			if (i % batchSize == 0 && i > 0) {
				entityManager.flush();
				entityManager.clear();
			}
		}
	}
}
