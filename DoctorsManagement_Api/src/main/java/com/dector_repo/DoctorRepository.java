package com.dector_repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Doctor;
import com.entity.Speciality;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	public Doctor findBySpeciality(Speciality specality);

}
