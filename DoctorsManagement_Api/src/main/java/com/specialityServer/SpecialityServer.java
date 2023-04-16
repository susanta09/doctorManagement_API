package com.specialityServer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Speciality;
@Service
public interface SpecialityServer {
	 public Speciality inserSpeciality(Speciality speciality);
	    public List<Speciality> getAll();
	    public List<Speciality> getByName(String name);
	    public String deleteSpeciality(String name);

}
