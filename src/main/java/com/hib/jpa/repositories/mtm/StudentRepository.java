package com.hib.jpa.repositories.mtm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hib.jpa.mtm.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	List<Student> findByStudentlastnameLikeAndStudentNameNotLike(String studentlastname, String studentName);

}
