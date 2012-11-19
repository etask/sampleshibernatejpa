#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories.mtm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ${package}.mtm.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	List<Student> findByStudentlastnameLikeAndStudentNameNotLike(String studentlastname, String studentName);

}
