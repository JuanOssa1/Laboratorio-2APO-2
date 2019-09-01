package main;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Club;

public class Main {
	private Scanner dataRead;
	private Club happyclub;
	
	public Main(){
		init();
	}
	
	
	
	public static void main(String[] args) {
		Main m = new Main();
		m.menu(0);
	}
	public void init(){
		dataRead = new Scanner(System.in);
		happyclub = new Club(null, null, null, null);
	}
	public void menu(int selected){
		int option = selected;
		if(option == 0){
			showMenuOptions();
			option = dataRead.nextInt();
			dataRead.nextLine();
		}
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
					System.out.println("Ingrese el tipo de mascotas permitidas para este club");
					String allowedPet = dataRead.nextLine();
					System.out.println(happyclub.setUpClub(year, month, day, clubId, clubName, allowedPet));
			
				break;
			case 2: ;
				break;
			case 3: ;
				break;
			case 4: ;
				break;
			case 5: ;
				break;
			case 6: ;
				break;
			case 7: ;
				break;
			case 8: ;
				break;
			}	
		}catch(InputMismatchException e){
			e.printStackTrace();
		}
		
	}
	public void showMenuOptions(){
		System.out.println("Escriba el numero de la opcion que desea seleccionar");
		System.out.println("1.  Registrar un club"); 
		System.out.println("2.  Registrar datos del duenio de una mascota"); 
		System.out.println("3.  Registrar mascotas"); 
		System.out.println("4.  Generar listado de clubes"); 
		System.out.println("5.  Generar listado de duenios"); 
		System.out.println("6.  Gnerar listado ordenado de mascotas");
		
		
		/*
		System.out.println("7.  Dar de alta una mascota hospitalizada y entregar informe liberar sala en la cual se encontraba Agregar historia eliminada a historial de historias clinicas");
		System.out.println("8.  Calcular ingresos por concepto de hospitalizaciones");
		System.out.println("9.  Identificar numero de cuarto que ocupa una mascota mediante su nombre");
		System.out.println("10. Consultar datos si un animal ya ha sido hospitalizado antes en historial de historias clinicas ");																												
		System.out.println("11. Consultar datos de contacto del dueño de un animal hospitalizado a partir del nombre de su dueño o el nombre del animal");
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
