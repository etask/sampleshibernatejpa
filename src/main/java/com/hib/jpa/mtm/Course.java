package com.hib.jpa.mtm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;
	
	@Column
	@NotNull
	private String courseName;

	@ManyToMany(mappedBy="courses")	
	private Set<Student> students = new HashSet<Student>();
	
	
	
	public Course(){
	}
	
	public Course(String courseName)
	{
		this.courseName=courseName;
	}
	
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
