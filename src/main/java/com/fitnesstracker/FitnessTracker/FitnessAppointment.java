package com.fitnesstracker.FitnessTracker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class FitnessAppointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String address;
	private String trainerPreference;
	private boolean Physio;
	private String pack;
	private byte weeks;
	private double ammount;
	
	//public long getId() {
	//	return id;
	//}
	//public void setId(long id) {
	//	this.id = id;
	//}
	//public String getName() {
	//	return name;
	//}
	//public void setName(String name) {
	//	this.name = name;
	//}
	//public byte getAge() {
	//	return age;
	//}
	//public void setAge(byte age) {
	//	this.age = age;
	//}
	//public String getEmail() {
	//	return email;
	//}
	//public void setEmail(String email) {
	//	this.email = email;
	//}
	//public String getPhoneNo() {
	//	return phoneNo;
	//}
	//public void setPhoneNo(String phoneNo) {
	//	this.phoneNo = phoneNo;
	//}
	//public String getAddress() {
	//	return address;
	//}
	//public void setAddress(String address) {
	//	this.address = address;
	//}
	//public String getTrainerPreference() {
	//	return trainerPreference;
	//}
	//public void setTrainerPreference(String trainerPreference) {
	//	this.trainerPreference = trainerPreference;
	//}
	//public boolean isPhysio() {
	//	return Physio;
	//}
	//public void setPhysio(boolean physio) {
	//	Physio = physio;
	//}
	//public String getPack() {
	//	return pack;
	//}
	//public void setPack(String pack) {
	//	this.pack = pack;
	//}
	//public byte getWeeks() {
	//	return weeks;
	//}
	//public void setWeeks(byte weeks) {
	//	this.weeks = weeks;
	//}
	//public double getAmmount() {
	//	return ammount;
	//}
	//public void setAmmount(double ammount) {
	//	this.ammount = ammount;
	//}
	

}
