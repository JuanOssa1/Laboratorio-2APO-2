package model;

import java.util.ArrayList;
import java.util.Calendar;

public class OwnerOfPet {
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
}
