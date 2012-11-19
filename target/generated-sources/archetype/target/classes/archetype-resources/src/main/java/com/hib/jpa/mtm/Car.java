#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package com.hib.jpa.mtm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int carId;
	
	@Column
	@NotNull
	private String make;
	
	@ManyToOne
	//@JoinColumn(name="studentId")
	private Student student;
	
	

	public Car(){
	}
	
	public Car(String make){
		this.make= make;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public Student getStudent() {
		return student;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	
	
	
	
	
}
