package main;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.*;


public class Main {
	private Scanner dataRead;
	private Holding happyholding;
	
	public Main(){
		init();
	}
	
	
	
	public static void main(String[] args) {
		Main m = new Main();
		m.menu(0);
	}
	public void init(){
		dataRead = new Scanner(System.in);
		happyholding = new Holding();
		
	}
	public void menu(int selected){
		boolean complete = true;
		
	
		
		int option = selected;
		if(option == 0){
			showMenuOptions();
		
			try {
				
			option = dataRead.nextInt();dataRead.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("Bueno, esto es embarazoso, ClubsLosVinedos" +"\n" + "ha tenido un problema al encontrar valores diferentes a numeros. Puede estar causado por que no ingresaste numeros" +"\n"+ "te suplicamos que vuelvas a correr el programa, Gracias!");
				//auxiliarMenu(0);
			}

				
			
			
			}

		
		if(option ==1) { 
			System.out.println("Ingrese el id del club a crear");
			String clubId = dataRead.nextLine();
			System.out.println("Ingrese el nombre del club");
			String clubName = dataRead.nextLine();
			Calendar date = Calendar.getInstance();
			int year = date.get(Calendar.YEAR);
			int month = date.get(Calendar.MONTH);
			int day = date.get(Calendar.DAY_OF_MONTH);
			String dateactual = Integer.toString(year+month+day);
			System.out.println("Ingrese el tipo de mascotas permitidas para este club");
			String allowedPet = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println(happyholding.addClub(clubId, clubName, dateactual, allowedPet));
		}else if(option == 2) {
			System.out.println("REGISTRO DE DUENIO DE MASCOTA");
			System.out.println("");
			System.out.println("Ingrese el id del club al cual quiere agregar");
			String clubIdSearch = dataRead.nextLine();
			System.out.println("Ingrese la una ID para crearla");
			String id = dataRead.nextLine();
			System.out.println("Ingrese su nombre");
			String name = dataRead.nextLine();
			System.out.println("Ingrese su apellido");
			String lastname = dataRead.nextLine();
			System.out.println("FECHA DE NACIMIENTO");
			System.out.println("");
			System.out.println("Ingrese su anio en numeros de nacimiento");
			int yearDuenio = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese su mes de nacimiento en numeros");
			int monthDuenio = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese su dia de nacimiento en numeros");
			int dayDuenio = dataRead.nextInt();dataRead.nextLine();
			String dateactualborn = Integer.toString(yearDuenio+monthDuenio+dayDuenio);
		try {
			happyholding.searchClubToAdOwner(clubIdSearch, id, name, lastname, dateactualborn);
		} catch (NoPrameterFoundedException e) {
			System.out.println("Ingreso los valores fuera de los rangos de las fechas permitidas");
		}
			
			System.out.println("NOS ALEGRA QUE SEA INTEGRANTE DE ESTE PRESTIGIOSO CLUB, PARA COMPLETAR EL REGISTRO DEBE DE TENER AL MENOS UNA MASCOTA");
			
			System.out.println("REGISTRO DE MASCOTA");
			System.out.println("");
			System.out.println("Ingrese el id de la mascota");
			String petId = dataRead.nextLine();
			System.out.println("Ingrese el nombre de la mascota");
			String petName = dataRead.nextLine();
			System.out.println("Ingrese el dia de nacimiento");
			int petbornDay =	dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el mes de nacimiento");
			int petBornMonth = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el anio de nacimiento");
			int petBornYear = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese la raza del animal");
			String typePet = dataRead.nextLine();
			System.out.println("Ingrese el sexo de su mascota");
			String genderOfPet = dataRead.nextLine();
			String dateactualborn2 = Integer.toString(petBornYear+petBornMonth+petbornDay);
			happyholding.addAPetToAnOwner(id, petId, petName, typePet, genderOfPet,dateactualborn2 );
			menu(0);
		}else if(option == 3) {
			System.out.println("REGISTRO DE MASCOTA");
			System.out.println("");
			System.out.println("Ingrese id del cliente al que quiere agregar la mascota");
			String clientIdP = dataRead.nextLine();
			System.out.println("Ingrese el id de la mascota");
			String petIdP = dataRead.nextLine();
			System.out.println("Ingrese el nombre de la mascota");
			String petNameP = dataRead.nextLine();
			System.out.println("Ingrese el dia de nacimiento");
			int petbornDayP =	dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el mes de nacimiento");
			int petBornMonthP = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el anio de nacimiento");
			int petBornYearP = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese la raza del animal");
			String typePetP = dataRead.nextLine();
			System.out.println("Ingrese el genro de su mascota");
			String petGender = dataRead.nextLine();
			String dateactualborn3 = Integer.toString(petBornYearP+petBornMonthP+petbornDayP);
			happyholding.addAPetToAnOwner(clientIdP, petIdP, petNameP, typePetP, petGender, dateactualborn3);
		}else if(option == 4) {
			System.out.println("Ordenar Clubes por ID");
	        happyholding.organizeWithId();
			System.out.println(happyholding.ShoWArrayList()); 
			menu(0);
		}else if(option == 5) {
			System.out.println("Ordenar Clubes por nombre");
			happyholding.organizeWithName(); 
			System.out.println(happyholding.ShoWArrayList()); 
			menu(0);
		}else if(option == 6) {
			System.out.println("Ordenar Clubes por Fecha"); 
			happyholding.organizeWithDate();
			System.out.println(happyholding.ShoWArrayList()); 
			menu(0); 
		}else if(option == 7) {
			System.out.println("Eliminar Club por id");
			System.out.println("Ingrese el id del club que desea eliminar");
			String idRemove = dataRead.nextLine();
			System.out.println(happyholding.deleteClubWithId(idRemove));
			menu(0);
		}else if(option == 8) {
			System.out.println("Eliminar Club por id");
			System.out.println("Ingrese el id del club que desea eliminar");
			String nameRemove = dataRead.nextLine();
			System.out.println(happyholding.deleteClubWithName(nameRemove));
			menu(0);
		}
		else if(option == 9) {
			System.out.println("Mostrando Listado.."); 
			happyholding.organizeClubByNumberOfOwners();
			System.out.println(happyholding.ShoWArrayList());
			dataRead.nextLine();
			menu(0);
		}else if(option == 10) {
			System.out.println("Mostrando Listado");
			 happyholding.organizeOwnersByNumberOfPet();	 	
			 System.out.println(happyholding.ShoWArrayListOwners());
			 dataRead.nextLine();
			 menu(0);
		}else if(option == 11) {
			System.out.println("Borrando porfavor espera!");
			 System.out.println("Ingrese el id del club");
			 String clubIdDelete = dataRead.nextLine();
			 System.out.println("Ingrese el Id del cliente");
			 String ownerId = dataRead.nextLine();
			 System.out.println(happyholding.searchClubToDelete(clubIdDelete, ownerId));
			 menu(0);
		}else if(option == 12) {
			System.out.println("Ingrese el nombre del duenio");
			String ownerNameToDelete = dataRead.nextLine();
			System.out.println("Ingrese el nombre del club");
			String clubNameToSearch = dataRead.nextLine();
			System.out.println(happyholding.searchClubToDeleteByAnOwnerName(clubNameToSearch, ownerNameToDelete));
		}
			//happyholding.setUpClub();
			//happyholding.runClubs();
		else if(option == 13) {
			System.out.println("Eliminar mascota con su id");
			System.out.println("");
			System.out.println("Ingrese el id del club");
			String clubId = dataRead.nextLine();
			System.out.println("Ingrese el id del duenio");
			String ownerId = dataRead.nextLine();
			System.out.println("Ingrese el id de la mascota");
			String petId = dataRead.nextLine();
			System.out.println(happyholding.searchApetWithClubOwnerAndPetId(clubId, ownerId, petId));
			
		}else if(option == 14) {
			System.out.println("Eliminar mascota con su nombre");
			System.out.println("");
			System.out.println("Ingrese el nombre del club");
			String clubId = dataRead.nextLine();
			System.out.println("Ingrese el nombre del duenio");
			String ownerId = dataRead.nextLine();
			System.out.println("Ingrese el nombre de la mascota");
			String petId = dataRead.nextLine();
			System.out.println(happyholding.searchApetWithClubOwnerAndPetName(clubId, ownerId, petId));
		
		}else if(option == 15) {
			System.out.println("GRACIAS!!!!");
			/*
			for(Club clubVipCrack: happyholding.getClubs()) {
				clubVipCrack.fileCreator();
			}
			*/
		}else if(option == 17) {
			System.out.println("Ingrese el id del club que quiere buscar");
			happyholding.organizeWithId();
			String id = dataRead.nextLine();
			//long save1 = 0;
			long t1 = System.nanoTime();
			System.out.println(happyholding.binarySearchingById(id));
			long t2 = System.nanoTime();
			long save1 = t2-t1; 
			System.out.println("por binario se demoro" + save1);	
			long t3 = System.nanoTime();
			System.out.println(happyholding.traitionalSearchWithId(id));
			long t4 = System.nanoTime();
			long save2 = t4-t3;
			System.out.println("Por tradicional tardo" + save2);
			menu(0);
		}else if(option == 16) {
			happyholding.OrganizeOwnersById();
			System.out.println(happyholding.ShoWArrayListOwners());
			menu(0);
		}else if(option == 18) {
			happyholding.OrganizeOwnersByName();
			System.out.println(happyholding.ShoWArrayListOwners());
			menu(0);
		}else if(option == 19) {
			happyholding.OrganizeOwnersByLastName();
			System.out.println(happyholding.ShoWArrayListOwners());
			menu(0); 
		}else if(option == 20) {
			happyholding.OrganizeOwnersBybornDate();
			System.out.println(happyholding.ShoWArrayListOwners());
			menu(0);
 
		}else if(option == 21) {
			
		}else if(option == 22) {
			
		}
		
		
		
		
		
		else {
				System.out.println("Valores no validos!");
				
			}
		
		
		
	
	}
	
	
	
	public void showMenuOptions(){
		System.out.println("Escriba el numero de la opcion que desea seleccionar");
		System.out.println("1.  Registrar un club"); 
		System.out.println("2.  Registrar datos del duenio de una mascota"); 
		System.out.println("3.  Registrar mascotas"); 
		System.out.println("4.  Ordenar Clubes por ID"); 
		System.out.println("5.  Ordenar Clubes por nombre"); 
		System.out.println("6.  Ordenar Clubes por Fecha");
		System.out.println("7.  Eliminar Club por id");
		System.out.println("8.  Eliminar Club por nombre");
		System.out.println("9.  Ordenar Club por numero de duenios");
		System.out.println("10. Ordenar dueños por numero de mascotas");																												
		System.out.println("11. Eliminar dueño con el id");
		System.out.println("12. Eliminar dueño con el Nombre");
		System.out.println("13. Eliminar animal con su id");
		System.out.println("14. Eliminar animal con su nombre");
		System.out.println("17. Buscar club con id con binario y con tradicional para ver las comparativas de tiempo");
		System.out.println("16. Ordenar duenios por id");
		System.out.println("18. Ordenar duenios por nombre");
		System.out.println("19. Ordenar duenios por apellido");
		System.out.println("20. Ordenar Duenios por fecha");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}