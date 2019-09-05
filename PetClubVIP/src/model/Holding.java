package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Holding implements Serializable {
	private ArrayList<Club> clubs;
	public static String SEARCHROUTE ="C:/Users/Juan Ossa/OneDrive/Universidad Semestre 3/APO 2/Laboratorios/Laboratorio 2 APO 2/Betas/Java/PetClubVIP/serial/work.dat";
	
		public Holding(){
			clubs = new ArrayList<Club>();
			
		}
		public String flatReader(){
			String tmp = "";
			try {
				
				File file = new File("Clubes.txt" );
				FileReader filRe = new FileReader(file);
				BufferedReader bufferRead = new BufferedReader(filRe);
			
				 
				 bufferRead.close();
				 filRe.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return tmp;
		}
		public String setUpClub(int year, int month, int day, String id, String name, String allowedPet ){
			String tmp = "";
			Club club = new Club(id, name, allowedPet, createDates( year,  month,  day));
			try{
				File file = new File("Clubes.txt");
				FileWriter filwri =  new FileWriter(file, true);
				BufferedWriter  buffer = new BufferedWriter(filwri);
				clubs.add(club);
				
				filwri.write(club.toString());
				
				filwri.close();
				buffer.close();
	
			}catch(Exception e){
				e.printStackTrace();
			}
			return tmp;
		}
		public String searchClubToAdOwner(String id, String ownerID,String name, String lastName,  int year, int month, int day) throws NoPrameterFoundedException  {
			String msg = "Agregado exitosamente";
			OwnerOfPet tmpOwner = null;
			try {
				for(int i = 0; i<clubs.size(); i++){
					if(clubs.get(i).getId().equals(id)){
						tmpOwner = creatEOwner( id,  name,  lastName, createDates( year,  month,  day));
						clubs.get(i).getOwners().add(tmpOwner);		
						saveOwner(tmpOwner);
					}
				}
			}catch(NullPointerException e){
				
			}
			
			
			return msg;
		}
		public Calendar createDates(int year, int month, int day) throws NoPrameterFoundedException{
			Calendar date = null;
			boolean dateV = true;
		
			
			if(year>2019 || month>12 || day>31 ){
				try {
					throw new NoPrameterFoundedException("Ha ingresado uno o mas valores que exceden la fecha actual");
				}catch(NoPrameterFoundedException e){
					
				}
			}
			date = new GregorianCalendar(year, month, day);
			
			return date;
		}
		
		public OwnerOfPet creatEOwner(String id, String name, String lastName, Calendar bornDate){
			OwnerOfPet owner = new OwnerOfPet( id,  name,  lastName,  bornDate);
			return owner;
		}
		public void saveOwner(OwnerOfPet owner)  {
			
			FileOutputStream file = null;
			
			try {
				file = new FileOutputStream(SEARCHROUTE);
				ObjectOutputStream duct = new ObjectOutputStream(file);
				duct.writeObject(owner);
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
			finally{
				
				try{
					file.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			
		}
		public void addAPetToAnOwner(String id, String petId, String petName, String petType, String gender, int year, int month, int day){
			for(int i = 0; i<clubs.size(); i++){
				if(clubs.get(i).getId().equals(id)){
				clubs.get(i).searchOwnerToAddApet(id, petId, petName, petType, gender, year, month, day);
				}
			}
		}
	
}