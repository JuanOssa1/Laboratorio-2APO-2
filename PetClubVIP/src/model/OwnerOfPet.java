package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OwnerOfPet implements Serializable {
	/**
	 * 
	 */
	public static String SEARCHROUTE = "cargadores/SerializedPets"; 
	private static final long serialVersionUID = 1108525721666481918L;
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
		fileCreatorPet();
		loadPet();
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
		Pet pet = new Pet( petId,  petName, petType,   gender,  date);
		pets.add(pet);
		fileCreatorPet();
	}
	public int compareOwnerWithId(OwnerOfPet owner){
		return owner.getId().compareTo(id);
	}
	public int compareOwnerWithName(OwnerOfPet owner){
		return owner.getName().compareTo(name);
	}
	public int compareOwnerWithLastName(OwnerOfPet owner){
		return owner.getLastName().compareTo(lastname);
	}
	public int compareOwnerWithBornDate(OwnerOfPet owner){
		return owner.getBornDate().compareTo(bornDate);
	}
	
	
	public void organizeWithId(){
		for(int i = pets.size(); i>0; i--){
			
			for(int j = 0; j<pets.size(); j++){
				Pet insert = (Pet)pets.get(j);
				Pet actual = (Pet)pets.get(j+1);
				
				if(insert.comparePetWithId(actual)>0){
					pets.set(j+1, insert);
					pets.set(j, actual);
				 }
			}
		}
	}
	
	public void organizeWithName(){
		for(int i = pets.size(); i>0; i--){
			
			for(int j = 0; j<pets.size(); j++){
				Pet insert = (Pet)pets.get(j);
				Pet actual = (Pet)pets.get(j+1);
				
				if(insert.comparePetWithName(actual)>0){
					pets.set(j+1, insert);
					pets.set(j, actual);
				 }
			}
		}
	}
	public void organizeWithBornDate(){
		for(int i = pets.size(); i>0; i--){
			
			for(int j = 0; j<pets.size(); j++){
				Pet insert = (Pet)pets.get(j);
				Pet actual = (Pet)pets.get(j+1);
				
				if(insert.comparePetWithBornDate(actual)>0){
					pets.set(j+1, insert);
					pets.set(j, actual);
				 }
			}
		}
	}
	public void organizeWithType(){
		for(int i = pets.size(); i>0; i--){
			
			for(int j = 0; j<pets.size(); j++){
				Pet insert = (Pet)pets.get(j);
				Pet actual = (Pet)pets.get(j+1);
				
				if(insert.comparePetWithType(actual)>0){
					pets.set(j+1, insert);
					pets.set(j, actual);
				 }
			}
		}
	}
	public void organizeWithGender(){
		for(int i = pets.size(); i>0; i--){
			
			for(int j = 0; j<pets.size(); j++){
				Pet insert = (Pet)pets.get(j);
				Pet actual = (Pet)pets.get(j+1);
				
				if(insert.comparePetWithGender(actual)>0){
					pets.set(j+1, insert);
					pets.set(j, actual);
				 }
			}
		}
	}
	/*
	public String HEYHEYHEY(){
		String tmp = "";
		for(int i =0;i<pets.size(); i++){
			tmp+= pets.get(i).getPetName();
		}
		return tmp;
	}
	*/
		public void fileCreatorPet()  {
			
			
			
			try {
				
				ObjectOutputStream duct = new ObjectOutputStream(new FileOutputStream(SEARCHROUTE));
				duct.writeObject(pets);
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
		public void loadPet(){
			FileInputStream archivoCodificadoEntrada = null;
			//File file = new File(SEARCHROUTE);
			ArrayList<Pet> p;
			
			try {
				
				/*if(file.exists()){*/
					archivoCodificadoEntrada = new FileInputStream(SEARCHROUTE);
					ObjectInputStream conductoEntrada = new ObjectInputStream(archivoCodificadoEntrada);
					p = (ArrayList<Pet>)conductoEntrada.readObject();
					pets = p;
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
	
	
}
