#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import ${package}.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Page<Product> findByProductName(String productName, Pageable pageable);

}
