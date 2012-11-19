package it.pkg.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.pkg.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Page<Product> findByProductName(String productName, Pageable pageable);

}
