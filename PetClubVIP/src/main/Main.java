package main;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Holding;
import model.NoPrameterFoundedException;

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
		boolean complete = false;
		int option = selected;
		if(option == 0){
			showMenuOptions();
			try {
				option = dataRead.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Lo sentimos no puede ingresar letras en este parametro");
				showMenuOptions();
			}
			
			dataRead.nextLine();
		}
		do {
			try{
				switch(option){
				
				case 1:System.out.println("Ingrese el id del club a crear");
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
						
						complete = true;
						menu(0);
					break;
				case 2: System.out.println("REGISTRO DE DUENIO DE MASCOTA");
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
						String dateactualborn2 = Integer.toString(yearDuenio+monthDuenio+dayDuenio);
						happyholding.addAPetToAnOwner(id, petId, petName, typePet, genderOfPet,dateactualborn2 );
						//System.out.println(happyholding.GOGOGO2());
						
						
						
						complete = true; 
						menu(0);
					break;
				case 3:	System.out.println("REGISTRO DE MASCOTA");
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
						
						complete = true;
						menu(0);
					break;
				case 4: System.out.println("Ordenar Clubes por ID");
				        happyholding.organizeWithId();
						System.out.println(happyholding.ShoWArrayList()); 
						complete = true;
						menu(0);
					break;
				case 5: System.out.println("Ordenar Clubes por nombre");
						happyholding.organizeWithName();
						System.out.println(happyholding.ShoWArrayList()); 
						complete = true;
						menu(0);
					break; 
				case 6: System.out.println("Ordenar Clubes por Fecha"); 
						happyholding.organizeWithDate();
						System.out.println(happyholding.ShoWArrayList()); 
						complete = true;
						menu(0);
					break;
				case 7: System.out.println("Eliminar Club por nombre");
						System.out.println("Ingrese el id del club que desea eliminar");
						String idRemove = dataRead.nextLine();
						System.out.println(happyholding.deleteClubWithId(idRemove));
					break;
				case 8: System.out.println("Eliminar Club por id");
						System.out.println("Ingrese el nombre del club que quiere eliminar");
						String nameRemove = dataRead.nextLine();
						System.out.println(happyholding.deleteClubWithName(nameRemove));
						
					break;
				case 9: System.out.println("Mostrando Listado.."); 
						happyholding.organizeClubByNumberOfOwners();
						System.out.println(happyholding.ShoWArrayList());
						dataRead.nextLine();
					break;
					
				case 10: System.out.println("Mostrando Listado");
					break;	
					
				case 11:;
					break;
				
				case 12:;
					break;
				
				case 13:;
					break;
					
				case 14:;
					break;
					
				case 15:;
					System.out.println("GRACIAS!!!!");
					complete = true;
					break;
					
				}	
			}catch(InputMismatchException e){
				//e.printStackTrace();
				System.out.println("Lo sentimos no puede ingresar letras en este parametro");
				
			}
		}while(complete == false);
		
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
		System.out.println("10. Ordenar due�os por numero de mascotas");																												
		System.out.println("11. Eliminar due�o con el id");
		System.out.println("12. Eliminar due�o con el Nombre");
		System.out.println("13. Eliminar animal con su id");
		System.out.println("14. Eliminar animal con su nombre");
		System.out.println("15. Cerrar el programa");
		
		
		
		/*
		System.out.println("7.  Dar de alta una mascota hospitalizada y entregar informe liberar sala en la cual se encontraba Agregar historia eliminada a historial de historias clinicas");
		System.out.println("8.  Calcular ingresos por concepto de hospitalizaciones");
		System.out.println("9.  Identificar numero de cuarto que ocupa una mascota mediante su nombre");
		System.out.println("10. Consultar datos si un animal ya ha sido hospitalizado antes en historial de historias clinicas ");																												
		System.out.println("11. Consultar datos de contacto del due�o de un animal hospitalizado a partir del nombre de su due�o o el nombre del animal");
		System.out.println("12. Mostar IMC de una mascota ya creada");
		System.out.println("13. Actualizar informacion de un usuario");
		System.out.println("14. Registar realizacion de un servicio");
		System.out.println("15. Calcular ingresos por concepto de servicios");
		System.out.println("16. Calular todos los ingresos");
		System.out.println("17. Calcular promedio por servicios");
		System.out.println("18. Promedio ganancia en una semana");
		System.out.println("19. Reporte");
		System.out.println("20. Agregar mas diagnosticos a historia clinica activa");
		System.out.println("21. Agregar mas sintomas a historia clinica activa");
		*/
	}
}