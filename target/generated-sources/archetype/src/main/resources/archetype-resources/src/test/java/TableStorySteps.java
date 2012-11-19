#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;

import ${package}.mtm.Student;

public class TableStorySteps {
	
	
	private  Map<Integer, String> generated_table = new HashMap<Integer, String>();
	private List<Integer> ids = new ArrayList<Integer>();
	Integer id;
	String message;
	
	tempService ts =null;
	
	
	@BeforeScenario
	public void beforeScenario(){
		ts = new tempService();
	}
	
	static class tempService
	{
		private  Map<Integer, String> static_ids = new HashMap<Integer, String>();
		
		public tempService(){
		static_ids.put(1,"message 1");
		static_ids.put(2,"message 2");
		static_ids.put(3,"message 3");
		static_ids.put(4,"message 4");
		}
		
		
		public String myService(Integer id)
		{
			return static_ids.get(id);
		}
		
	}

	
	@Given("m_ids and messages exist")
	public void given()
	{
		System.out.println("dusyhjlksajdialksjd");
		/*
		for (Parameters row : table.getRowsAsParameters())
		{
			generated_table.put(row.valueAs("ids", Integer.class), row.valueAs("messages", String.class));
		}*/
	}
	

	@When("you select <m_id>")
	public void when(@Named("id") Integer id)
	{
		this.id = id;
	}
	
	@Then("you get <message>")
	public void then(@Named("message") String message)
	{
		this.message = message;
		
		Assert.assertEquals(message, ts.myService(id));
	}
	
}
