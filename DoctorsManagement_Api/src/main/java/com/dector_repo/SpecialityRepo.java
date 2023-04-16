package com.dector_repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Speciality;

public interface SpecialityRepo extends JpaRepository<Speciality, Integer> {
   public List<Speciality> findBySpeciality(String speciality);
   public Speciality findBySymptom(String symptom);
}
