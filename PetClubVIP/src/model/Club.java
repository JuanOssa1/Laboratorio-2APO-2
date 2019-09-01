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
	private ArrayList<Club> clubs;
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
		clubs = new ArrayList<Club>();
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
	public String flatReader(){
		String tmp = "";
		try {
			
			File file = new File("sujeeto.txt");
			FileReader filRe = new FileReader(file);
			BufferedReader bufferRead = new BufferedReader(filRe);
			
			 tmp += bufferRead.readLine();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return tmp;
	}
	public String setUpClub(int year, int month, int day, String id, String name, String allowedPet ){
		String tmp = "";
		Calendar date = new GregorianCalendar(year, month, day);
		Club club = new Club(id, name, allowedPet, date);
		try{
			File file = new File("sujeeto.txt");
			FileWriter filwri =  new FileWriter(file);
			BufferedWriter  buffer = new BufferedWriter(filwri);
			PrintWriter pWri = new PrintWriter(buffer);
			clubs.add(club);
			
			for(int i = 0; i<clubs.size();i++){
				if(clubs.get(i) != null){
					tmp = flatReader();
					filwri.write(clubs.get(i).toString() + tmp) ;
					filwri.append(tmp);
					//tmp = flatReader();
				}
			}
			filwri.close();
			buffer.close();
		
			//Como guardar varios sin SOBREESCRIBIR
		}catch(Exception e){
			e.printStackTrace();
		}
		return tmp;
	}
}
