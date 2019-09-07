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
	public static String FLATCLUBES = "data/Clubes.txt";
	public static String SEARCHROUTE ="data/owners.dat";
	
		public Holding(){
			clubs = new ArrayList<Club>();
			//loadClub();
			setUpClub();
			loadClub();
		}
		
		public String addClub(String a, String b ,String c, String d) {
			String msg = "Todo Perfecto";
			try{
				clubs.add(new Club(a,b,c,d));
			}catch(NullPointerException e){
				msg = "Falla a la hora de agregar";
			}
			
			setUpClub();
			return msg;
			
			
		}
		public String flatReader(){
			String tmp = "";
			try {
				
				File file = new File(FLATCLUBES);
				FileReader filRe = new FileReader(file);
				BufferedReader bufferRead = new BufferedReader(filRe);
			
				 
				 bufferRead.close();
				 filRe.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return tmp;
		}
		public String setUpClub() {
			String tmp = "";
			
			try{
				File file = new File(FLATCLUBES);
				FileWriter filwri =  new FileWriter(file);
				BufferedWriter  buffer = new BufferedWriter(filwri);
				
				for(int i = 0; i < clubs.size();i++) {
				filwri.write(clubs.get(i).toString());
				}
				
				filwri.close();
				buffer.close();
	
			}catch(Exception e){
				e.printStackTrace();
			}
			return tmp;
		}
		public String searchClubToAdOwner(String id, String ownerID,String name, String lastName,  String date) throws NoPrameterFoundedException  {
			String msg = "Agregado exitosamente";
			OwnerOfPet tmpOwner = null;
			try {
				for(int i = 0; i<clubs.size(); i++){
					if(clubs.get(i).getId().equals(id)){
						tmpOwner = creatEOwner( id,  name,  lastName, date );
						clubs.get(i).getOwners().add(tmpOwner);		
						//saveClub(tmpOwner);
					}
				}
			}catch(NullPointerException e){
				
			}
			
			
			return msg;
		}
	
		
		public OwnerOfPet creatEOwner(String id, String name, String lastName, String bornDate){
			OwnerOfPet owner = new OwnerOfPet( id,  name,  lastName,  bornDate);
			return owner;
		}
		/*
		public void saveClub(OwnerOfPet owner)  {
			
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
		*/
		public String  addAPetToAnOwner(String id, String petId, String petName, String petType, String gender, String date){
			String msg = "Todo ha salido bien";
			
				for(int i = 0; i<clubs.size(); i++){
					if(clubs.get(i).getId().equals(id)){
						clubs.get(i).searchOwnerToAddApet(id, petId, petName, petType, gender, date);
					
					}
				}
			
			return msg;
		}
		public void organizeWithId(){
			for(int i = clubs.size(); i>0; i--){
				
				for(int j = 0; j<clubs.size(); j++){
					Club insert = (Club)clubs.get(j);
					Club actual = (Club)clubs.get(j+1);
					
					if(insert.compareClubWithId(actual)>0){
						 clubs.set(j+1, insert);
						 clubs.set(j, actual);
					 }
				}
			}
		}
		public void organizeWithName(){
			for(int i = clubs.size(); i>0; i--){
				for(int j =0; j<clubs.size(); j++) {
					Club insert = (Club)clubs.get(j);
					Club actual = (Club)clubs.get(j+1);
					
					if(insert.compareClubWithName(actual)>0){
						clubs.set(j+1, insert);
						clubs.set(j, actual);
					}
				}
			}
		}
		public void organizeWithDate(){
			for(int i = clubs.size(); i>0; i--){
				for(int j = 0; j<clubs.size(); i++){
					Club insert = (Club)clubs.get(j);
					Club actual = (Club)clubs.get(j+1);
					
					if(insert.compareClubWithDateOfCreation(actual)>0){
						clubs.set(j, actual);
						clubs.set(j+1, insert);
					}
				}
				
			}
		}
		
		
		public void loadClub(){
			String saveString = null;
			ArrayList<Club> c;
			c = new ArrayList<Club>();
			try {
				File	file = new File(FLATCLUBES);
				FileReader	frReader = new FileReader(file);
				BufferedReader	bufferRead = new BufferedReader(frReader);
				
				while((saveString = bufferRead.readLine())!= null){
					//saveString = bufferRead.readLine();
					
					String[] parts = saveString.split("-");
					String part1 = parts[0];
					String part2 = parts[1];
					String part3 = parts[2];
					String part4 = parts[3];
					
					Club club = new Club(part1, part2, part3, part4);
					c.add(club);
					
				}
				c = clubs;
				
				
			
				
				bufferRead.close();
				frReader.close();
				
				
				
			}
			catch(Exception e){
				System.out.println("Ayyyy que man tan de malas");
			}
				
		
		
	}
		
		
		
	
}