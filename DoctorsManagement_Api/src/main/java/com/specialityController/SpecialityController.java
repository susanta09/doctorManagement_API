package com.specialityController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API_ExpectionHandler.ResourceNotFoundException;
import com.entity.Speciality;
import com.specialityServer.SpecialityServer;
@RestController
@RequestMapping("/api")
public class SpecialityController {
	@Autowired
	private SpecialityServer specialityServer;
	@PostMapping("/specialies")
	public ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality speciality)
	{
		return new ResponseEntity<Speciality>(specialityServer.inserSpeciality(speciality),HttpStatus.CREATED);
	}
	@GetMapping("/specialies")
	public List<Speciality> getAllSpeciality()
	{
		return specialityServer.getAll();
	}
	@GetMapping("/specialies/{Speciality}")
	public ResponseEntity<List<Speciality>> getBySpeciality(@PathVariable("Speciality") String Speciality)throws ResourceNotFoundException
	{
		return new ResponseEntity<List<Speciality>>(specialityServer.getByName(Speciality),HttpStatus.CREATED);
	}

}
