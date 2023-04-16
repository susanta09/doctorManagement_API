package com.patientController;

import java.util.List;

import javax.validation.Valid;

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
import com.doctor_service.Doctor_Services;
import com.dto.PatientDto;
import com.entity.Doctor;
import com.entity.Patient;
import com.patientService.PatientServices;

@RestController
@RequestMapping("/api")
public class PatientController {
	@Autowired
	private PatientServices patientServices;
	@Autowired
	private Doctor_Services doctor_Services;
	@PostMapping("/patients")
	public ResponseEntity<Patient> addPatient(@Valid @RequestBody PatientDto dto)throws ResourceNotFoundException
	{   
		  Doctor d=doctor_Services.getBySymptomAndCity( dto.getSymptom(),dto.getCity());
		    return new ResponseEntity<Patient>(patientServices.insertData(dto,d.getD_id()),HttpStatus.CREATED);
	}
	@GetMapping("/patients")
	public List<Patient>getAllPatient()
	{
		return patientServices.getAllData();
	}
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getByPatientId(@PathVariable("id") Integer id)throws ResourceNotFoundException
	{
		return new ResponseEntity<Patient>(patientServices.getById(id),HttpStatus.CREATED);
	}
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id") Integer id)throws ResourceNotFoundException
	{
		return new ResponseEntity<String>(patientServices.deleteDataById(id),HttpStatus.CREATED);
	}

}
