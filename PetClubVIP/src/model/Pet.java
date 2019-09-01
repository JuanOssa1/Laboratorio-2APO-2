package model;

import java.util.Calendar;

public class Pet {
	private String petId;
	private String petName;
	private Calendar bornDate;
	private String petType;
	public Pet(String petId, String petName, Calendar bornDate, String petType) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.bornDate = bornDate;
		this.petType = petType;
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
	public Calendar getBornDate() {
		return bornDate;
	}
	public void setBornDate(Calendar bornDate) {
		this.bornDate = bornDate;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	 
}
