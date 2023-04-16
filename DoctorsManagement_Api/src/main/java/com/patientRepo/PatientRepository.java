package com.patientRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
