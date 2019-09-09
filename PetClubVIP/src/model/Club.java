package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Club  implements Serializable{
	/**
	 * 
	 */
	
	
	public static String SEARCHROUTE ="cargadores/SerializedOwners";
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

		fileCreator();
		loadOwner();
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
		return id+"-"+name+"-" + dateOfCreation+ "-" + allowedPet + "\n";
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
	public int compareClubWithId(String identification){
		return identification.compareTo(id);
	}
	
	/*
	public void organizeWithId(){

		String info = "";
		for (int i = 1; i<owners.size(); i++){
			for(int j = i; j>0 && owners.get(j-1).compareClubWithDateOfCreation(owners.get(j)) > 0; j--){
				OwnerOfPet tmp = owners.get(j);
				clubs.set(j, clubs.get(j-1));
				clubs.set(j-1, tmp);
				
			}
			info += clubs.get(i).toString();
		}
		return info;
	}
	*/
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
	
	
	
	
	
	
	//LLAMO ACA FILE CREATTOR 
	
	public void creatEOwner(String id, String name, String lastName, String bornDate){
		
		OwnerOfPet owner = new OwnerOfPet( id,  name,  lastName,  bornDate);
		owners.add(owner);
		fileCreator();
		
	}






	public void searchOwnerToAddApet(String id, String petId, String petName, String petType, String gender, String date){
		
		for(int i = 0; i< owners.size(); i++){
			if(owners.get(i).getName().equalsIgnoreCase(id)){
				owners.get(i).addPetToAnOwner(petId, petName, petType, gender, date);
			}
		}
		
	}
	
	
	
	
	
	
	//SERIALIZA
	
	public void fileCreator()  {
		
		
		
		try {
			
			ObjectOutputStream duct = new ObjectOutputStream(new FileOutputStream(SEARCHROUTE));
			duct.writeObject(owners);
			duct.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public void createFile(){
		
	}
	
	
	
	
	 
	
	
	//DESERIALIZA
	public void loadOwner(){
		FileInputStream archivoCodificadoEntrada = null;
		//File file = new File(SEARCHROUTE);
		ArrayList<OwnerOfPet> p;
		
		try {
			
			/*if(file.exists()){*/
				archivoCodificadoEntrada = new FileInputStream(SEARCHROUTE);
				ObjectInputStream conductoEntrada = new ObjectInputStream(archivoCodificadoEntrada);
				p = (ArrayList<OwnerOfPet>)conductoEntrada.readObject();
				owners = p;
			/*}*/
			/*
			else{
				
				file.createNewFile();
				
			}
			*/
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public int numberOfOwners(Club club1,Club club2){

		return club1.getOwners().size() - club2.getOwners().size();
	}
	
	
	public void organizeOwnersByNumberOfPet(){
		for(int i = 0; i < owners.size()-1; i++ ) {
			OwnerOfPet ownerQuantity = owners.get(i);
			int low = owners.get(i).numberOfPets(owners.get(i), owners.get(i+1));
			int position = i;
			for(int j = i+1; j < owners.size(); j++) {
				if(owners.get(j).numberOfPets(owners.get(j), owners.get(i))<low) {
					ownerQuantity = owners.get(j);
					 position = j;
				}
			}
			OwnerOfPet tmp = owners.get(i);
			owners.set(i, ownerQuantity);
			owners.set(position, tmp);
		}
	}
	public String searchOwnerToDeleteWithId(String idOwner) {
		String msg = "";
		for(int i = 0; i<owners.size(); i++) {
			if(owners.get(i).getId().equals(idOwner)) {
			 msg = owners.get(i).toString();
				owners.remove(i);
			}
		}
		return msg;
	}
	
	//
}