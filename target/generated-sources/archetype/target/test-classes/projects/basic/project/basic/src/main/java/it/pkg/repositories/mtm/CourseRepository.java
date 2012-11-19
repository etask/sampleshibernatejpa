package it.pkg.repositories.mtm;

import org.springframework.data.repository.CrudRepository;

import it.pkg.mtm.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	java.util.List<Course> findByCourseNameLike(String courseName);

}
