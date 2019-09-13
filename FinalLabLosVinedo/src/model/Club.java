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
	
	
	public static String SEARCHROUTE ="cargadores//lointente.dat";
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

	@Override
	public String toString() {
		return "\nClub [owners=" + owners + ", id=" + id + ", name=" + name + ", dateOfCreation=" + dateOfCreation
				+ ", allowedPet=" + allowedPet + "]";
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
	
	
	public void organizeWithId(){

		
		for (int i = 1; i<owners.size(); i++){
			for(int j = i; j>0 ; j--){
				if(owners.get(j-1).compareOwnerWithId(owners.get(j)) > 0) {
					OwnerOfPet tmp = owners.get(j);
					owners.set(j, owners.get(j-1));
					owners.set(j-1, tmp);
				}else if(owners.get(j-1).compareOwnerWithId(owners.get(j)) < 0) {
					OwnerOfPet tmp = owners.get(j-1);
					owners.set(j, tmp);
					owners.set(j-1, owners.get(j));
				}
			}
		}
	}
	
	public void organizeWithName(){
		for (int i = 1; i<owners.size(); i++){
			for(int j = i; j>0 ; j--){
				if(owners.get(j-1).compareOwnerWithName(owners.get(j)) > 0) {
					OwnerOfPet tmp = owners.get(j);
					owners.set(j, owners.get(j-1));
					owners.set(j-1, tmp);
				}else if(owners.get(j-1).compareOwnerWithName(owners.get(j)) < 0) {
					OwnerOfPet tmp = owners.get(j-1);
					owners.set(j, tmp);
					owners.set(j-1, owners.get(j));
				}
			}
		}
	}
	public void organizeWithLastName(){
		for (int i = 1; i<owners.size(); i++){
			for(int j = i; j>0 ; j--){
				if(owners.get(j-1).compareOwnerWithLastName(owners.get(j)) > 0) {
					OwnerOfPet tmp = owners.get(j);
					owners.set(j, owners.get(j-1));
					owners.set(j-1, tmp);
				}else if(owners.get(j-1).compareOwnerWithLastName(owners.get(j)) < 0) {
					OwnerOfPet tmp = owners.get(j-1);
					owners.set(j, tmp);
					owners.set(j-1, owners.get(j));
				}
			}
		}
	}
	public void organizeWithDate(){
		for (int i = 1; i<owners.size(); i++){
			for(int j = i; j>0 ; j--){
				if(owners.get(j-1).compareOwnerWithBornDate(owners.get(j)) > 0) {
					OwnerOfPet tmp = owners.get(j);
					owners.set(j, owners.get(j-1));
					owners.set(j-1, tmp);
				}else if(owners.get(j-1).compareOwnerWithBornDate(owners.get(j)) < 0) {
					OwnerOfPet tmp = owners.get(j-1);
					owners.set(j, tmp);
					owners.set(j-1, owners.get(j));
				}
			}
		}
	}
	
	
	
	
	
	
	//LLAMO ACA FILE CREATTOR 
	
	public void creatEOwner(String id, String name, String lastName, String bornDate){
		
		OwnerOfPet owner = new OwnerOfPet( id,  name,  lastName,  bornDate);
		owners.add(owner);	
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
		File file = new File(SEARCHROUTE);
		ArrayList<OwnerOfPet> p;
		
		try {
			
			if(file.exists()){
				FileInputStream	fi = new FileInputStream(file);
				ObjectInputStream co = new ObjectInputStream(fi);
				p = (ArrayList<OwnerOfPet>)co.readObject();
				setOwners(p);
				co.close();
			}
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
	public String searchOwnerToDeleteWithId(String idOwner) throws NotFoundedAnythingException {
		String msg = "";
		for(int i = 0; i<owners.size(); i++) {
			if(owners.get(i).getId().equals(idOwner)) { 
			 msg = owners.get(i).toString();
				owners.remove(i);
			}if(msg == "") {
				throw new NotFoundedAnythingException("No pude");
			}
		}
		return msg;
	}
	
///////////////////////////////////////////////////////////METODOS QUE NO ESTAN EN DIAGRAMA//////////////////////////////////////////////////////////////////////////
	
	
	public String searchApetWithClubOwnerAndPetId(String ownerId, String petId) throws NotFoundedAnythingException{
		organizeWithId();
		String ownerInfo= "";
		boolean finded = false;
		int startAt = 0; 
		int deadAt = owners.size()-1; 
		while((startAt <= deadAt) && finded == false) {
			int mediumValue = (startAt + deadAt)/2; 
			if(owners.get(mediumValue).getId().equals(ownerId)) { 
				ownerInfo = owners.get(mediumValue).searchApetWithClubOwnerAndPetId(petId);
				finded = true;
			}
			else if(owners.get(mediumValue).compareOwnerWithId(petId)>0) {
				deadAt = mediumValue -1;
			}
			else{
				startAt = mediumValue+1;
			}
		}
		if(ownerInfo == "") {
			throw new NotFoundedAnythingException("No pude");
		}
		return ownerInfo;
	}
	
	
	
	
	public String searchApetWithClubOwnerAndPetName(String ownerName, String petName) throws NotFoundedAnythingException{
		String ownerInfo= "";
		for (int i = 0; i < owners.size(); i++) {
			if(owners.get(i).getName().equals(ownerName)) {
				ownerInfo = owners.get(i).searchApetWithClubOwnerAndPetName(petName);
			}if(ownerInfo == "") {
				throw new NotFoundedAnythingException("No pude");
			}
		}
		
		return ownerInfo;
	}
	
	
	public String searchOwnerToDeleteWithName(String ownerName) throws NotFoundedAnythingException  {
		String msg = "";
		for (int i = 0; i < owners.size(); i++) {
			if(owners.get(i).getId().equals(ownerName)) {
				msg = owners.get(i).getId();
				owners.remove(i); 
			}
		}
		if(msg == "") { 
			throw new NotFoundedAnythingException("Esto es embarazoso...");  
		}
		return msg;
	}
	
	
	//
}