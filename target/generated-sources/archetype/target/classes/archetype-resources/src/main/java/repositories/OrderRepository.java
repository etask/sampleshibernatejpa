#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ${package}.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	
	List<Order> findByCustomerFirstname(String firstname);
	
}
