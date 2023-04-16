package com.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class PatientDto {
	@Pattern(regexp = "^[a-zA-z]{3,}$",
			  message ="Name (should be at least 3 characters)")
	private String pName;
	@Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$",
			message = "Email (should be a valid email address)")
	private String email;
	@Pattern(regexp = "^(0|91)?[7-9][0-9]{9}$",
			  message ="Enter the valid phone number.first 0 or 91 optional but actual number must be 10 digits" )
	private String phNo;
	@Pattern(regexp = "^[a-zA-z]{3,20}$",
			  message ="City (should be at max 20 characters)")
	private String city;
	@NotNull(message = "symptom can not be null")
	private String symptom;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

}
