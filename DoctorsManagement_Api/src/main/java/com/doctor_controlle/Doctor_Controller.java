package com.doctor_controlle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API_ExpectionHandler.ResourceNotFoundException;
import com.doctor_service.Doctor_Services;
import com.dto.Doctor_Dto;
import com.entity.Doctor;

@RestController
@RequestMapping("/api")
public class Doctor_Controller {
	@Autowired
	private Doctor_Services doctor_Services;
	@PostMapping("/doctors")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor_Dto doctor_Dto)throws ResourceNotFoundException
	{
		return new ResponseEntity<Doctor>(doctor_Services.insertDoctorData(doctor_Dto),HttpStatus.CREATED);
	}
	@GetMapping("/doctors")
	public List<Doctor> getAll()
	{
		return doctor_Services.getAllData();
	}
	@GetMapping("/doctors/{id}")
	public ResponseEntity<Doctor> gebyDoctorId(@PathVariable("id") Integer id)throws ResourceNotFoundException
	{
		return new ResponseEntity<Doctor>(doctor_Services.getById(id),HttpStatus.CREATED);
	}
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable("id") Integer id)throws ResourceNotFoundException
	{
		return new ResponseEntity<>(doctor_Services.deleteById(id),HttpStatus.CREATED);
	}
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor>updateByDoctorId(@Valid @RequestBody Doctor_Dto dto,@PathVariable("id") Integer id)throws ResourceNotFoundException
	{
		return new ResponseEntity<Doctor>(doctor_Services.updateById(id, dto),HttpStatus.CREATED);
	}
	@GetMapping("/doctors/{symptom}/{city}")
    public ResponseEntity<Doctor> findDoctorBySymptomAndCity(@PathVariable("symptom") String symptom,@PathVariable("city") String city )throws ResourceNotFoundException
    {
		return new ResponseEntity<Doctor>(doctor_Services.getBySymptomAndCity(symptom, city),HttpStatus.CREATED);
    }
}
