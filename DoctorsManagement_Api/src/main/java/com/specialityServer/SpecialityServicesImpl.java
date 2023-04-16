package com.specialityServer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API_ExpectionHandler.ResourceNotFoundException;
import com.dector_repo.SpecialityRepo;
import com.entity.Speciality;
@Service
public class SpecialityServicesImpl implements SpecialityServer{
	@Autowired
	private SpecialityRepo repo;

	@Override
	public Speciality inserSpeciality(Speciality speciality) {
		
		return repo.save(speciality);
	}

	@Override
	public List<Speciality> getAll() {
		
		return repo.findAll();
	}

	@Override
	public List<Speciality> getByName(String name) {
	 List<Speciality>li=repo.findBySpeciality(name);
		 if(li!=null)
		 {
			 return li;
		 }
		throw new ResourceNotFoundException(name+" Speciality is not availabe. ");
	}

	@Override
	public String deleteSpeciality(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
