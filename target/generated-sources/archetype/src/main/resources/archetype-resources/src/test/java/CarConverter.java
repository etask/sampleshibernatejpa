#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import ${package}.mtm.Car;

public class CarConverter implements ParameterConverter 
{
	
	private Map<String,Car> validCars = new HashMap<String,Car>();
	
	public CarConverter(){
		super();
		
		Car bmw = new Car("BMW");
		bmw.setCarId(1);
		Car fiat = new Car("FIAT");
		fiat.setCarId(2);
		validCars.put("BMW", bmw);
		validCars.put("FIAT", fiat);
		
	}
	
	@Override
	public boolean accept(Type type)
	{
		if (type instanceof Class<?>){
			return Car.class.isAssignableFrom((Class<?>) type);
		}
		return false;
	}
	
	@Override
	public Object convertValue(String value, Type type){
		return validCars.get(value);
	}
	

}
