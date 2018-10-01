package com.videocall.app.aduiovideocall.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country {
	@Id
	@GeneratedValue
	private Integer id;
	private String countryName;
	private String countryCapital;
	
	public Country(){
		
	}
	
	
	public Country(String countryName, String countryCapital) {
		super();
		this.countryName = countryName;
		this.countryCapital = countryCapital;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", countryCapital=" + countryCapital + "]";
	}
	
	

}
