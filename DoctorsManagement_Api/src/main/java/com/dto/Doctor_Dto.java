package com.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Doctor_Dto {
	private Integer d_id;
	//@NotNull(message = "name can not be null")
	@Pattern(regexp = "^[a-zA-z]{3,}$",
			  message ="Name (should be at least 3 characters)")
	private String d_name;
	@Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$",
			message = "Email (should be a valid email address)")
	private String email;
	//@NotNull(message = "Phone number can not be null")
	@Pattern(regexp = "^(0|91)?[7-9][0-9]{9}$",
			  message ="Enter the valid phone number.first 0 or 91 optional but actual number must be 10 digits" )
	private String phNo;
	//@NotNull(message = "name can not be null")
	@Pattern(regexp = "^[a-zA-z]{1,20}$",
			  message ="City (should be at max 20 characters)")
	private String d_city;
	@NotNull(message = "speciality can not be null")
	private String speciality;
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_city() {
		return d_city;
	}
	public void setD_city(String d_city) {
		this.d_city = d_city;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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
	

}
