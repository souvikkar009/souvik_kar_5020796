package com.olbs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.olbs.entities.Customer;

import jakarta.persistence.LockModeType;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
//	@Override
//    @Lock(value = LockModeType.OPTIMISTIC)
//    Optional<Customer> findById(Integer integer);
	
	public Optional<Customer> findByEmail(String email);

	public Optional<List<Customer>> findByName(String name);
}
