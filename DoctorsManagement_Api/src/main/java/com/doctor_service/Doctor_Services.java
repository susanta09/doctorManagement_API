package com.doctor_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Doctor_Dto;
import com.entity.Doctor;
@Service
public interface Doctor_Services {
	public Doctor insertDoctorData(Doctor_Dto doctor_Dto);
    public List<Doctor> getAllData();
    public Doctor getById(Integer id);
    public String deleteById(Integer id);
    public Doctor updateById(Integer id,Doctor_Dto doctor_Dto);
    public Doctor getBySymptomAndCity(String symptom,String city);
}
