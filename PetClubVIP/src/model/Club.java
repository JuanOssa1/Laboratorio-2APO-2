package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Club  implements Serializable{
	private ArrayList<OwnerOfPet> owners;
	private String id;
	private String name;
	private String dateOfCreation;
	private String allowedPet;
	public Club(String id, String name, String allowedPet, String dateOfCreation) {
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
	public String getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(String dateOfCreation) {
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

	public OwnerOfPet creatEOwner(String id, String name, String lastName, String bornDate){
		
		OwnerOfPet owner = new OwnerOfPet( id,  name,  lastName,  bornDate);
		owners.add(owner);
		
		return owner;
	}
	public void searchOwnerToAddApet(String id, String petId, String petName, String petType, String gender, String date){
		
		for(int i = 0; i< owners.size(); i++){
			if(owners.get(i).getName().equalsIgnoreCase(id)){
				owners.get(i).addPetToAnOwner(petId, petName, petType, gender, date);
			}
		}
		
	}
	public int compareClubWithId(Club club){
		return club.getId().compareTo(id);
	}
	public int compareClubWithName(Club club){
		return club.getName().compareTo(name);
	}
	public int compareClubWithDateOfCreation(Club club){
		return club.getDateOfCreation().compareTo(dateOfCreation);
	}
	
	
	public void organizeWithId(){
		for(int i = owners.size(); i>0; i--){
			
			for(int j = 0; j<owners.size(); j++){
				OwnerOfPet insert = (OwnerOfPet)owners.get(j);
				OwnerOfPet actual = (OwnerOfPet)owners.get(j+1);
				
				if(insert.compareOwnerWithId(actual)>0){
					owners.set(j+1, insert);
					owners.set(j, actual);
				 }
			}
		}
	}
	public void organizeWithName(){
		for(int i = owners.size(); i>0; i--){
			for(int j =0; j<owners.size(); j++) {
				OwnerOfPet insert = (OwnerOfPet)owners.get(j);
				OwnerOfPet actual = (OwnerOfPet)owners.get(j+1);
				
				if(insert.compareOwnerWithName(actual)>0){
					owners.set(j+1, insert);
					owners.set(j, actual);
				}
			}
		}
	}
	public void organizeWithLastName(){
		for(int i = owners.size(); i>0; i--){
			for(int j = 0; j<owners.size(); i++){
				OwnerOfPet insert = (OwnerOfPet)owners.get(j);
				OwnerOfPet actual = (OwnerOfPet)owners.get(j+1);
				
				if(insert.compareOwnerWithLastName(actual)>0){
					owners.set(j, actual);
					owners.set(j+1, insert);
				}
			}
			
		}
	}
	public void organizeWithDate(){
		for(int i = owners.size(); i>0; i--){
			for(int j = 0; j<owners.size(); i++){
				OwnerOfPet insert = (OwnerOfPet)owners.get(j);
				OwnerOfPet actual = (OwnerOfPet)owners.get(j+1);
				
				if(insert.compareOwnerWithBornDate(actual)>0){
					owners.set(j, actual);
					owners.set(j+1, insert);
				}
			}
			
		}
	}
	
	
	
	//
}