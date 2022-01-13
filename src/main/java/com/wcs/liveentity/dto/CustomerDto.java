package com.wcs.liveentity.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerDto {
	@NotBlank
	@Size(min=2, max = 100)
	private String firstname;
	
	@NotBlank
	@Size(min=2, max = 100)
	private String lastname;
	
	@NotBlank
	@Size(min=6, max = 150)
	private String email;
	
	@NotBlank
	@Size(min=2, max = 100)
	private String password;
	
	@NotBlank
	@Size(min=10, max = 150)
	private String address;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@NotBlank
	@Size(min=10, max = 100)
	private String phone;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
