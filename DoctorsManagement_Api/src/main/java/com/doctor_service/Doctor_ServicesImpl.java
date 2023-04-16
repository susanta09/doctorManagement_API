package com.doctor_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API_ExpectionHandler.ResourceNotFoundException;
import com.dector_repo.CityRepo;
import com.dector_repo.DoctorRepository;
import com.dector_repo.SpecialityRepo;
import com.dto.Doctor_Dto;
import com.entity.City;
import com.entity.Doctor;
import com.entity.Speciality;

import ch.qos.logback.core.joran.conditional.ElseAction;
@Service
public class Doctor_ServicesImpl implements Doctor_Services {

	@Autowired
	private DoctorRepository repository;
	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private SpecialityRepo specialityRepo;
	
	public Doctor buildFrom_dto(Doctor_Dto doctor_Dto)
	{
		Doctor d=new Doctor();
		d.setD_name(doctor_Dto.getD_name());
		d.setEmail(doctor_Dto.getEmail());
		d.setPhNo(doctor_Dto.getPhNo());
		String k=doctor_Dto.getD_city();
		System.out.println(k);
		City c=cityRepo.findByName(k);
		System.out.println("city "+c);
		d.setCity(c);

	   List<Speciality> p=specialityRepo.findBySpeciality(doctor_Dto.getSpeciality());
	   System.out.println("p "+p);
	   List<Speciality> sp=new ArrayList<Speciality>();
	   for (Speciality speciality : p) {
		if(speciality!=null)
		{
			sp.add(speciality);
		}
	}
	     d.setSpeciality(sp);
		
		return d;
	}
	@Override
	public Doctor insertDoctorData(Doctor_Dto doctor_Dto) {
        	Doctor d=buildFrom_dto(doctor_Dto);	
        	List<Speciality>spli=d.getSpeciality();
        	System.out.println(spli);
        	if(d.getCity()!=null)
        	{
        		if(d.getSpeciality()!=null)
        		{
        			return repository.save(d);
        		}
        		else
        		{
        		 throw new ResourceNotFoundException(doctor_Dto.getSpeciality()+" Speciality is not available.");
        		}
        	}
        	else {
			  throw new ResourceNotFoundException(doctor_Dto.getD_city()+" city is not available");
        	}
	}
	@Override
	public List<Doctor> getAllData() {
		List<Doctor> li=repository.findAll();
		return li;
	}
	@Override
	public Doctor getById(Integer id) {
		
		Doctor d= repository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Resource is not found"+id));
		return d;
	}
	@Override
	public String deleteById(Integer id) {
		repository.findById(id)
		             .orElseThrow(()->new ResourceNotFoundException("Resource is not found"+id));
		 repository.deleteById(id);
		 return "Delete operation is successfully done.";
	}
	@Override
	public Doctor updateById(Integer id,Doctor_Dto Dto) {
		repository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Resource is not found"+id));
		
		Doctor d=buildFrom_dto(Dto);	
		d.setD_id(id);
    	if(d.getCity()!=null)
    	{
    		if(d.getSpeciality()!=null)
    		{
    			return repository.save(d);
    		}
    		else
   		{
    		 throw new ResourceNotFoundException(Dto.getSpeciality()+" Speciality is not available.");
    		}
    	}
    	else {
		  throw new ResourceNotFoundException(Dto.getD_city()+" city is not available");
    	}
	}
	@Override
	public Doctor getBySymptomAndCity(String symptom, String city) {
		System.out.println(symptom+"    "+city);
		Speciality sp = specialityRepo.findBySymptom(symptom);
		System.out.println(sp);
		City c=cityRepo.findByName(city);
		Doctor doctor = repository.findBySpeciality(sp);

		System.out.println(c);
		if(c!=null)
		{
			if(doctor!=null)
			{
				if(doctor.getCity().getName().equals(city))
				{
					return doctor;
				}
				else {
					throw new ResourceNotFoundException("There isn’t any doctor present at your location for your symptom");
				}
			}else {
				throw new ResourceNotFoundException("There isn’t any doctor present at your location for your symptom");
			}
		}
		else
		{
				throw new ResourceNotFoundException("We are still waiting to expand to your location");
		}

		
	}

	

}
