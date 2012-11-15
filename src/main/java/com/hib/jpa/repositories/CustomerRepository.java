package com.hib.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hib.jpa.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByLastname(String lastname);

}
