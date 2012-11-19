package it.pkg;

import junit.framework.Assert;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import it.pkg.mtm.Car;
import it.pkg.mtm.Student;


public class SampleStorySteps {
	
	private Car car;
	private Student student;
	
	
	@BeforeScenario
	public void beforeScenario(){
		this.car = null;
		this.student = new Student();
		student.getCars().clear();		
	}
	
	@Given("a car of make $BMW")
	public void givenOneMakeCar(Car car)
	{
		this.car = car;
	}
	/*
	@Given("the make exists")
	public void givenMakeExists()
	{
		
	}*/
	
	@When("student adds the car to his collection")
	public void whenStudentAddsTheCarToHisCollection()
	{
		student.getCars().add(car);
	}
	
	@Then("student owns the car")
	public void thenStudentOwnsTheCar()
	{
		Assert.assertTrue(student.getCars().contains(car));
		Assert.assertEquals(car.getCarId(), student.getCars().iterator().next().getCarId());
		//Assert.assertNull(student);
	}


}
