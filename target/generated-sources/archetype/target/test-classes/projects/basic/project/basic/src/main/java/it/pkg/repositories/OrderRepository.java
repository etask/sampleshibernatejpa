package it.pkg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.pkg.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	
	List<Order> findByCustomerFirstname(String firstname);
	
}
