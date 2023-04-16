package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Speciality {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer symptom_id;
	private String symptom;
	private String speciality;
	public Integer getSymptom_id() {
		return symptom_id;
	}
	public void setSymptom_id(Integer symptom_id) {
		this.symptom_id = symptom_id;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
}
