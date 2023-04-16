package com.patientService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.PatientDto;
import com.entity.Patient;

@Service
public interface PatientServices {
	public Patient insertData(PatientDto dto,Integer did);
	public String deleteDataById(Integer id);
	public List<Patient> getAllData();
	public Patient getById(Integer id);

}
