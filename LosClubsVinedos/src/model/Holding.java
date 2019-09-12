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
	public static String FLATCLUBES = "data//Clubes.txt";
	public static String FLATOWNERS = "data//OwnersToSerialize.txt";
	public static String FLATPETS = "data//PetsToSerialize.txt";

	
		public Holding(){
	
			clubs = loadClub();
			isEmptyTheArrayList();
			load();
			
		}
		
		private void isEmptyTheArrayList() {
			
			for(int i = 0; i < clubs.size();i++) {
				if(clubs.get(i).getOwners().isEmpty()) {
					adderOfOwners();
					adderOfOwners1();
				}
				
			}
			
		}
		
		public ArrayList<Club> getClubs() {
			return clubs;
		}

		public void setClubs(ArrayList<Club> clubs) {
			this.clubs = clubs;
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
		/*
		public String readerOdTheClubs(){
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
		*/
		public void setUpClub() {
			String tmp = "";
			
			try{
				File file = new File(FLATCLUBES);
				FileWriter filwri =  new FileWriter(file);
				BufferedWriter  buffer = new BufferedWriter(filwri);
				
				for(int i = 0; i < clubs.size();i++) {
					buffer.write(clubs.get(i).getId()+","+clubs.get(i).getName()+","+clubs.get(i).getDateOfCreation()+","+clubs.get(i).getAllowedPet());
					buffer.newLine();
				}
				
				buffer.close();
				filwri.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			//return tmp;
		}
		public void searchClubToAdOwner(String id, String ownerID,String name, String lastName,  String date) throws NoPrameterFoundedException  {
			String msg = "Agregado exitosamente";
			OwnerOfPet tmpOwner = null;
			try {
				for(int i = 0; i<clubs.size(); i++){
					if(clubs.get(i).getId().equals(id)){
						tmpOwner = creatEOwner( id,  name,  lastName, date );
						clubs.get(i).getOwners().add(tmpOwner);	
						adderOfOwners();
						
					}
				}
			}catch(NullPointerException e){
				
			}
			
			
			//return msg;
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
		/*
		public String organizeWithId(){
			
			String info = "";
			for(int i = clubs.size(); i>0; i--){
				
				for(int j = 0; j<clubs.size(); j++){
					Club insert = (Club)clubs.get(j);
					Club actual = (Club)clubs.get(j+1);
					
					if(insert.compareClubWithId(actual)>0){
						 clubs.set(j+1, insert);
						 clubs.set(j, actual);
					 }
				}
				info = clubs.get(i).toString();
			}
			return info;
		}
		*/
		public void organizeWithId(){
			String info = "";
			for (int i = 1; i<clubs.size(); i++){
				for(int j = i; j>0 && clubs.get(j-1).compareClubWithId(clubs.get(j)) > 0; j--){
					Club tmp = clubs.get(j);
					clubs.set(j, clubs.get(j-1));
					clubs.set(j-1, tmp);
				
				}
				
			}
			
			
		}
		public void organizeWithName(){
			
		
			for (int i = 1; i<clubs.size(); i++){
				for(int j = i; j>0 && clubs.get(j-1).compareClubWithName(clubs.get(j)) > 0; j--){
					Club tmp = clubs.get(j);
					clubs.set(j, clubs.get(j-1));
					clubs.set(j-1, tmp);
					
				}
				
			}
		
			
		}
		public void organizeWithDate(){
			
			
			for (int i = 1; i<clubs.size(); i++){
				for(int j = i; j>0 && clubs.get(j-1).compareClubWithDateOfCreation(clubs.get(j)) > 0; j--){
					Club tmp = clubs.get(j);
					clubs.set(j, clubs.get(j-1));
					clubs.set(j-1, tmp);
					
				}
			
				
			}
			
			
		}
		
		
		public ArrayList<Club> loadClub(){
			ArrayList<Club> c = new ArrayList<Club>();
			try {
				File	file = new File(FLATCLUBES);
				FileReader	frReader = new FileReader(file);
				BufferedReader	bufferRead = new BufferedReader(frReader);
				String saveString;
//				if((saveString = bufferRead.readLine())!= null){
					while((saveString = bufferRead.readLine())!= null){
	
						String[] parts = saveString.split(",");
						String part1 = parts[0];
						String part2 = parts[1];
						String part3 = parts[2];
						String part4 = parts[3];
						c.add(new Club(part1, part2, part3, part4));
//					}
				}
				
				//clubs = c;
				
				
			//Esta guardando el archivo pero no lo esta leyendo
				
				bufferRead.close();
				frReader.close();
				
			}
			catch(Exception e){
				System.out.println("Ayyyy que man tan de malas");
				e.printStackTrace();
			}
			return c;
				
		
		
		}
////////////////////////////////////////////////////////////////////CANTIDAS DE OWNERS A SERIALIZAR////////////////////////////////////////////////////////////////////////////////////////////////////////
		public void adderOfOwners(){

            File file = new File(FLATOWNERS);
            try {
                FileReader filRe = new FileReader(file);
                BufferedReader bufferRead = new BufferedReader(filRe);
                for (int i = 0; i<clubs.size(); i++) {
                    int centinel = 0;
                    String tmp = bufferRead.readLine();
                    while((tmp)!=null && centinel < 2) { 
                        //tmp = bufferRead.readLine();
                        String[] parts = tmp.split(",");
                        String part1 = parts[0];
                        String part2 = parts[1];
                        String part3 = parts[2];
                        String part4 = parts[3];
                        clubs.get(i).creatEOwner(part1, part2, part3, part4);
                        runClubs();
                        centinel++;
                        tmp = bufferRead.readLine();


                    }
                    
                }


                 bufferRead.close();
                 filRe.close();

            }
            catch(Exception e){
                e.printStackTrace();
            }
            
  


        }
	
		
/////////////////////////////////////////////////////////ACA DEFINO LA CANTIDAD DE PETS QUE QUIERO AGREGAR///////////////////////////////////////////////////////////////////////////////////////
		
		public void adderOfOwners1(){
			int centinel = 0;
			
			File file = new File(FLATPETS);
			try {
				FileReader filRe = new FileReader(file);
				BufferedReader bufferRead = new BufferedReader(filRe);
				String tmp;
				for(Club clubss:clubs) {
					
				for (int i = 0; i<clubss.getOwners().size(); i++) {
					while(centinel<1 && (tmp=bufferRead.readLine())!=null) {
						//tmp=bufferRead.readLine();
						String[] parts = tmp.split(",");
						String part1 = parts[0];
						String part2 = parts[1];
						String part3 = parts[2];
						String part4 = parts[3];
						String part5 = parts[4];
						clubss.getOwners().get(i).addPetToAnOwner(part1, part2, part3, part4, part5);/*creatEOwner(part1, part2, part3, part4)*/;
						runClubs();
						centinel++;
					}
					
				}
				 
				 bufferRead.close();
				 filRe.close();
				
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
			
		}
	
		public String deleteClubWithId(String id ){
			String msg = "";
			boolean t = false;
			for(int i = 0; i<clubs.size() && !t; i++ ){
				if(clubs.get(i).getId().equals(id)){
					t = true;
					msg = clubs.get(i).toString();
					clubs.remove(clubs.get(i));
				}
			}
			setUpClub();
			return msg;
		}
		public String deleteClubWithName(String name){
			String msg = "";
			for(int i = 0; i<clubs.size(); i++){
				if(clubs.get(i).getName().equals(name)) {
					msg = clubs.get(i).toString();
					clubs.remove(clubs.get(i));
				}
				
			}
			setUpClub();
			return msg;
		}
		public void organizeClubByNumberOfOwners() {
			Club tmp = null;
			Club tmp1 = null;
			for(int i = clubs.size(); i>0; i--) {
				for(int j = 0; j<-1-1; j++ ) {
					if(clubs.get(j).numberOfOwners(clubs.get(j), clubs.get(j+1))>0) {
						tmp = clubs.get(j);
						tmp1 = clubs.get(j+1);
						clubs.set(j, tmp1);
						clubs.set(j+1, tmp);
					}
					else {
						clubs.set(j, tmp);
						clubs.set(j+1, tmp1);
					}
				}
			}
		}
		
		
		public String ShoWArrayList() {
			String msg = "";
			for(int i = 0; i<clubs.size(); i++){
			msg +=	clubs.get(i).toString();
			}
			return msg;
		}
		public void organizeOwnersByNumberOfPet() {
			for(int i = 0; i<clubs.size(); i++) {
				clubs.get(i).organizeOwnersByNumberOfPet();
			}
		}
		public String ShoWArrayListOwners() {
			String msg = "";
			for(int i = 0; i<clubs.size(); i++){
			msg +=	clubs.get(i).getOwners().toString();
			}
			return msg;
		}
		public String searchClubToDelete(String clubId, String ownerId) {
			String msg = "";
			for(int i = 0; i<clubs.size(); i++) {
				if(clubs.get(i).getId().equals(clubId)) {
					try {
						msg =clubs.get(i).searchOwnerToDeleteWithId(ownerId); 
					} catch (NotFoundedAnythingException e) {
						System.out.println("No encontre datos");
					}
				}
			}
			return msg;
		}
		public void runClubs() {
			for (int i = 0; i < clubs.size(); i++) {
				clubs.get(i).fileCreator();
			} 
		}
		public void load() {
			for (Club club : clubs) {
				club.loadOwner();
			}
		}
		public String binarySearchingById(String id){
			//organizeWithId();
			String clubInfo = "";
			boolean finded = false;
			int startAt = 0;
			int deadAt = clubs.size()-1; 
			while((startAt <= deadAt) && finded == false) {
				int mediumValue = (startAt + deadAt)/2; 
				if(clubs.get(mediumValue).getId().equals(id)) { 
					clubInfo = clubs.get(mediumValue).toString();
					finded = true;
				}
				else if(clubs.get(mediumValue).compareClubWithId(id)>0) {
					deadAt = mediumValue -1;
				}
				else{
					startAt = mediumValue+1;
				}
			}
			
			return clubInfo;
		}
	
		
///////////////////////////////////////////////////////////METODOS QUE NO ESTAN EN DIAGRAMA//////////////////////////////////////////////////////////////////////////
		public String traitionalSearchWithId(String id) {
			String msg = "";
			for(int i = 0; i<clubs.size(); i++) {
				if(clubs.get(i).getId().equals(id)) {
					msg = clubs.get(i).toString();
				}
			}
			return msg;
		}
		
		
		public String searchApetWithClubOwnerAndPetId(String clubId, String ownerId, String petId) {
			String msg = "";
			for(int i = 0; i<clubs.size(); i++) {
				if(clubs.get(i).getId().equals(clubId)) { 
					try {
						msg = clubs.get(i).searchApetWithClubOwnerAndPetId(ownerId,petId );
					} catch (NotFoundedAnythingException e) {
						System.out.println("No hay informacion que mostar lo siento mucho");
					}
					
					//msg = clubs.get(i).toString();
				}
			}
			return msg; 
		}
		
		
		
		public String searchApetWithClubOwnerAndPetName(String clubName, String ownerName, String petName) {
			String msg = "";
			for(int i = 0; i<clubs.size(); i++) {
				if(clubs.get(i).getId().equals(clubName)) {
					
					try {
						msg = clubs.get(i).searchApetWithClubOwnerAndPetName(ownerName,petName );
					}catch(NotFoundedAnythingException e) {
						System.out.println("No hay informacion que mostrar");
					}
					
					
					
					
					
					//msg = clubs.get(i).toString();
				}
			}
			return msg; 
		}
		
		
		
		
	
}