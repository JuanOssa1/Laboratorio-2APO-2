package model;

import java.io.Serializable;
import java.util.Calendar;

public class Pet implements Serializable{
	private String petId;
	private String petName;
	private String bornDate;
	private String petType;
	private String gender;
	public Pet(String petId, String petName, String bornDate, String petType, String gender) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.bornDate = bornDate;
		this.petType = petType;
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getBornDate() {
		return bornDate;
	}
	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	
	
	

	public int comparePetWithId(Pet pet){
		return pet.getPetId().compareTo(petId);
	}
	public int comparePetWithName(Pet pet){
		return pet.getPetName().compareTo(petName);
	}
	public int comparePetWithBornDate(Pet pet){
		return pet.getBornDate().compareTo(bornDate);
	}
	public int comparePetWithType(Pet pet){
		return pet.getPetType().compareTo(petType);
	}
	public int comparePetWithGender(Pet pet){
		return pet.getGender().compareTo(gender);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	 //
}