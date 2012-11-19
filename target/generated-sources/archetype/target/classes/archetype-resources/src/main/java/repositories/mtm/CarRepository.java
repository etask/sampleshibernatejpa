#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories.mtm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import ${package}.mtm.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
	
	//@Query("select c from Car c where c.student.studentlastname = ?1")
	List<Car> findByStudent_Studentlastname(String lastname);
	
	
	
	

}
