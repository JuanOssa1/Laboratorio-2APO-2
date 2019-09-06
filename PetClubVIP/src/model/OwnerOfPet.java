package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OwnerOfPet implements Serializable {
	private String id;
	private String name;
	private String lastname;
	private String bornDate;
	private ArrayList<Pet> pets;
	public OwnerOfPet(String id, String name, String lastname, String bornDate) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.bornDate = bornDate;
		pets = new ArrayList<Pet>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getBornDate() {
		return bornDate;
	}
	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}
	public void addPetToAnOwner(String petId, String petName, String petType, String gender, String date){
		Pet pet = new Pet( petId,  petName,petType,   gender,  date);
		pets.add(pet);
	}
	
}
