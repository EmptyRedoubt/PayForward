package com.SaladinA.PF.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phone")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long phoneId;
	public String phoneNumber;
	public String numberPriority;
	public String phoneType;
	
	private Prsn person;
	public Phone(Long phoneId, String phoneNumber, String numberPriority, String phoneType) {
		this.phoneId = phoneId;
		this.phoneNumber = phoneNumber;
		this.numberPriority = numberPriority;
		this.phoneType = phoneType;
	}
	public Long getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNumberPriority() {
		return numberPriority;
	}
	public void setNumberPriority(String numberPriority) {
		this.numberPriority = numberPriority;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
	
}
