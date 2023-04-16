package com.patientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API_ExpectionHandler.ResourceNotFoundException;
import com.dector_repo.CityRepo;
import com.dector_repo.DoctorRepository;
import com.dto.PatientDto;
import com.entity.City;
import com.entity.Doctor;
import com.entity.Patient;
import com.patientRepo.PatientRepository;
@Service
public class PatientServicesImpl implements PatientServices{
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private CityRepo cityRepo;
	@Autowired 
	private DoctorRepository doctorRepository;
	
	public Patient bindFromDto(PatientDto dto)
	{
		Patient p=new Patient();
		p.setpName(dto.getpName());
		p.setEmail(dto.getEmail());
		p.setPhNo(dto.getPhNo());
		p.setSympton(dto.getSymptom());
		City c=cityRepo.findByName(dto.getCity());
		p.setCity(c);
		return p;
		
	}

	@Override
	public Patient insertData(PatientDto dto,Integer did) {
		Patient p=bindFromDto(dto);
		Doctor d=doctorRepository.findById(did).get();
		p.setDoctor(d);
		
		return patientRepository.save(p);
	}
	

	@Override
	public String deleteDataById(Integer id) {
		patientRepository.findById(id)
		   .orElseThrow(()->new ResourceNotFoundException(id+" resources is not founded."));
		patientRepository.deleteById(id);
		return "Patient data successfuly deleted.";
	}

	@Override
	public List<Patient> getAllData() {
			return patientRepository.findAll();
	}

	@Override
	public Patient getById(Integer id) {
		patientRepository.findById(id)
		   .orElseThrow(()->new ResourceNotFoundException(id+" resources is not founded."));
		return patientRepository.findById(id).get();
	}

}
