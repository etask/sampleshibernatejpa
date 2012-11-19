package it.pkg.repositories.mtm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.pkg.mtm.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	List<Student> findByStudentlastnameLikeAndStudentNameNotLike(String studentlastname, String studentName);

}
