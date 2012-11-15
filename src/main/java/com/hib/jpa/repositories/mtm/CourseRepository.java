package com.hib.jpa.repositories.mtm;

import org.springframework.data.repository.CrudRepository;

import com.hib.jpa.mtm.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	java.util.List<Course> findByCourseNameLike(String courseName);

}
