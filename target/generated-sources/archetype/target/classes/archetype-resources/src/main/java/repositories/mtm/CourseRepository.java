#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repositories.mtm;

import org.springframework.data.repository.CrudRepository;

import ${package}.mtm.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	java.util.List<Course> findByCourseNameLike(String courseName);

}
