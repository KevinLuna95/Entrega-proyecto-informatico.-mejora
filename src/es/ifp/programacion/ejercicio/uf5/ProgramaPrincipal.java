package es.ifp.programacion.ejercicio.uf5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Gestion de un proyecto informatico:
 * Se desea implementar una gestión para un proyecto informático. Un proyecto se compone de
 * información de su jefe de proyecto y del cliente del proyecto.
 * 
 * @author kkevi
 *
 */
public class ProgramaPrincipal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char opcion = '0';
		Cliente cliente = new Cliente("Pedro","Gonzalez Perez", "11223344L");
		JefeProyecto jefe = new JefeProyecto("Laura","Salazar Franco", "99887744P",10);
		Cliente cliente2 = new Cliente("Sandra","Romero Rios", "32315856Q");
		JefeProyecto jefe2 = new JefeProyecto("Gorka","Hernandez Tomas", "84523165A",10);
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<JefeProyecto> jefes = new ArrayList<JefeProyecto>();
		
		clientes.add(cliente);
		clientes.add(cliente2);
		jefes.add(jefe);
		jefes.add(jefe2);
		
		Proyecto proyecto = new Proyecto("PRO-12","Operacion Caixabank", "Necesitan de un programa que les ayude a gestionar los "
				+ "prestamos de sus clientes", new Date(), clientes, jefes);
		
		System.out.println(proyecto.toString());

		System.out.println("Bienvenido al sistema de gestion de proyectos informaticos");
		
		do {
			System.out.println("========================== MENU ==========================");
			System.out.println("1. Crear un proyecto");
			System.out.println("2. Ver todos los proyectos");
			System.out.println("3. Ver un proyecto");
			System.out.println("4. Modificar un proyecto");
			System.out.println("5. Eliminar un proyecto");
			System.out.println("0. Salir");
			System.out.println("==========================================================");
			System.out.println("Escoge una opcion de 0 al 5");
			opcion = sc.nextLine().charAt(0);
			
			switch(opcion) {
			case '1': crearProyecto(jefes, clientes);
				break;
			case '2':
				break;
			case '3':
				break;
			case '4':
				break;
			case '5':
				break;
			case '0': System.out.println("Fin del programa.");
				break;
			default: System.out.println("La opción no es correcta. Prueba con numeros entre el 0 y el 5");
			}
					
			
		}while(opcion != '0');
	}
	
	public static void crearProyecto(List<JefeProyecto> jefes, List<Cliente> clientes) {
		
	}
	
	public static void crearCliente(List<Cliente> clientes) {
		String nombre ="";
		String apellidos ="";
		String dni ="";
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Sistema de creación de clientes");
		System.out.println("Indica el nombre del cliente:");
		nombre = sc.nextLine();
		System.out.println("Indica los apellidos del cliente:");
		apellidos = sc.nextLine();
		System.out.println("Indica el DNI del cliente:");
		dni = sc.nextLine();
		
		Cliente cliente = new Cliente(nombre, apellidos, dni);
		clientes.add(cliente);
		
		
	}
	
	public static void crearJefe(List<JefeProyecto> jefes) {
		String nombre ="";
		String apellidos ="";
		String dni ="";
		int numeroEmpleado = 0;
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Sistema de creación de jefes de proyecto");
		System.out.println("Indica el nombre del jefe de proyecto:");
		nombre = sc.nextLine();
		System.out.println("Indica los apellidos del jefe de proyecto:");
		apellidos = sc.nextLine();
		System.out.println("Indica el DNI del jefe de proyecto:");
		dni = sc.nextLine();
		System.out.println("Indica el numero de empleado del jefe de proyecto:");
		numeroEmpleado = Integer.parseInt(sc.nextLine());
				
		JefeProyecto jefe = new JefeProyecto(nombre, apellidos, dni, numeroEmpleado);
		jefes.add(jefe);
		
		
	}

}
