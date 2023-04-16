package com.cityServer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API_ExpectionHandler.ConstraintViolationException;
import com.API_ExpectionHandler.ResourceNotFoundException;
import com.dector_repo.CityRepo;
import com.entity.City;
@Service
public class CityServices_Impl implements CityServices {
 
	@Autowired
	private CityRepo repo; 
	@Override
	public City inserCity(City city) {
		
		return repo.save(city);
	}

	@Override
	public List<City> getAll() {
		
		return repo.findAll();
	}

	@Override
	public City getByName(String name) {
	 City cl=repo.findByName(name);
		if(cl!=null)
		{
			return cl;
		}
	  throw new ResourceNotFoundException(name +"City is not found ");	
	}

	@Override
	public String deleteCity(String name) {
		 City c=repo.findByName(name);
			if(c!=null)
			{ 
				throw new ConstraintViolationException("Doctor Entity reffer to the city entity. so that query voilent data intrigrity");
			}
		throw new ResourceNotFoundException("city"+name+" is not found ");
	}

}
