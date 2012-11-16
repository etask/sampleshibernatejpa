package com.hib.jpa;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import com.hib.jpa.mtm.Car;

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
