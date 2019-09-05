package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OwnerOfPet implements Serializable {
	private String id;
	private String name;
	private String lastName;
	private Calendar bornDate;
	private ArrayList<Pet> pets;
	public OwnerOfPet(String id, String name, String lastName, Calendar bornDate) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
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
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Calendar getBornDate() {
		return bornDate;
	}
	public void setBornDate(Calendar bornDate) {
		this.bornDate = bornDate;
	}
	public void addPetToAnOwner(String petId, String petName, String petType, String gender, int year, int month, int day){
		Pet pet = new Pet( petId,  petName,  createDates( year,  month,  day),  petType,  gender);
		pets.add(pet);
	}
	public Calendar createDates(int year, int month, int day){
		Calendar date = new GregorianCalendar(year, month, day);
		return date;
	}
}
