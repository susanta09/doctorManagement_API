package com.cityController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API_ExpectionHandler.ResourceNotFoundException;
import com.cityServer.CityServices;
import com.entity.City;
@RestController
@RequestMapping("/api")
public class CityController {
	@Autowired
	private CityServices services;
	
	@PostMapping("/citys")
	public ResponseEntity<City> addCity(@RequestBody City city)
	{
		return new ResponseEntity<City>(services.inserCity(city),HttpStatus.CREATED);
	}
	@GetMapping("/citys")
	public List<City> getAllCity()
	{
		return services.getAll();
	}
	@GetMapping("/citys/{name}")
	public ResponseEntity<City> getByCityName(@PathVariable("name") String name)throws ResourceNotFoundException
	{
		return new ResponseEntity<City>(services.getByName(name),HttpStatus.CREATED);
	}
	@DeleteMapping("/citys/{name}")
	public ResponseEntity<String> deleteByCityName(@PathVariable("name") String name)throws ResourceNotFoundException
	{
		return new ResponseEntity<String>(services.deleteCity(name),HttpStatus.CREATED);
	}

}
