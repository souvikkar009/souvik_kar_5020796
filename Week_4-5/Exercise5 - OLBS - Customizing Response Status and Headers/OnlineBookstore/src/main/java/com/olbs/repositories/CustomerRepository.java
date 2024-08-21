package com.olbs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olbs.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
}
