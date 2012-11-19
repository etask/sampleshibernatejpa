package it.pkg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.pkg.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByLastname(String lastname);

}
