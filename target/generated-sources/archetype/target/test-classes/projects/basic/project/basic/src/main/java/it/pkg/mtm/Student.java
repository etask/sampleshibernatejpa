package it.pkg.mtm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	@Column
	@NotNull
	private String studentName;
	
	@Column
	@NotNull
	private String studentlastname;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Car> cars = new HashSet<Car>();
	
	
	public String getStudentlastname() {
		return studentlastname;
	}

	public void setStudentlastname(String studentlastname) {
		this.studentlastname = studentlastname;
	}

	@Column
	private Date studentDateOfBirth;
	
	@ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable
	(	name="STUDENT_COURSE", 
		joinColumns={@JoinColumn(name="STU_ID", referencedColumnName="studentId")},
		inverseJoinColumns={@JoinColumn(name="C_ID", referencedColumnName="courseId")}
	)
	private Set<Course> courses = new HashSet<Course>();

	
	public Student(){		
	}
	
	public Student(String studentName, Date studentDateOfBirth){
		this.studentName=studentName;
		this.studentDateOfBirth=studentDateOfBirth;
	}
	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getStudentDateOfBirth() {
		return studentDateOfBirth;
	}

	public void setStudentDateOfBirth(Date studentDateOfBirth) {
		this.studentDateOfBirth = studentDateOfBirth;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}



	



	
	
}
