package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Club {
	private ArrayList<OwnerOfPet> owners;
	private String id;
	private String name;
	private Calendar dateOfCreation;
	private String allowedPet;
	public Club(String id, String name, String allowedPet, Calendar dateOfCreation) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfCreation = dateOfCreation;
		this.allowedPet = allowedPet;
		owners = new ArrayList<OwnerOfPet>();
	}
	public String getId() {
		return id;
	}
	public ArrayList<OwnerOfPet> getOwners() {
		return owners;
	}
	public void setOwners(ArrayList<OwnerOfPet> owners) {
		this.owners = owners;
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
	public Calendar getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Calendar dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getAllowedPet() {
		return allowedPet;
	}
	public void setAllowedPet(String allowedPet) {
		this.allowedPet = allowedPet;
	}
	public String toString(){
		return id + name + dateOfCreation + allowedPet;
	}

	public OwnerOfPet creatEOwner(String id, String name, String lastName, Calendar bornDate){
		
		OwnerOfPet owner = new OwnerOfPet( id,  name,  lastName,  bornDate);
		owners.add(owner);
		
		return owner;
	}
	
}