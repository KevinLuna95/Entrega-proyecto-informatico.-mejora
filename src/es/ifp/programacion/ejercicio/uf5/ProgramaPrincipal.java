package es.ifp.programacion.ejercicio.uf5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Gestion de un proyecto informatico:
 * Se desea implementar una gestión para un proyecto informático. Un proyecto se compone de
 * información de su jefe de proyecto y del cliente del proyecto.
 * 
 * @author Kevin Luna botey
 *
 */
public class ProgramaPrincipal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char opcion = '0';
		Cliente cliente = new Cliente("Pedro","Gonzalez Perez", "11223344L");
		JefeProyecto jefe = new JefeProyecto("Laura","Salazar Franco", "99887744P",(byte) 10);
		Cliente cliente2 = new Cliente("Sandra","Romero Rios", "32315856Q");
		JefeProyecto jefe2 = new JefeProyecto("Gorka","Hernandez Tomas", "84523165A",(byte) 10);
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<JefeProyecto> jefes = new ArrayList<JefeProyecto>();
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		
		clientes.add(cliente);
		clientes.add(cliente2);
		jefes.add(jefe);
		jefes.add(jefe2);

		Proyecto proyecto2 = new Proyecto("PRO-13","Operacion Caixabank", "Necesitan de un programa que les ayude a gestionar los "
				+ "prestamos de sus clientes", new Date(), clientes, jefes);
		proyectos.add(proyecto2);
		Proyecto proyecto = new Proyecto("PRO-12","Operacion Caixabank", "Necesitan de un programa que les ayude a gestionar los "
				+ "prestamos de sus clientes", new Date(), clientes, jefes);
		proyectos.add(proyecto);
		
		System.out.println(proyecto.toString());

		System.out.println("Bienvenido al sistema de gestion de proyectos informaticos");
		
		do {
			System.out.println("========================== MENU ==========================");
			System.out.println("1. Crear un proyecto");
			System.out.println("2. Ver todos los proyectos");
			System.out.println("3. Buscar un proyecto");
			System.out.println("4. Modificar un proyecto");
			System.out.println("5. Eliminar un proyecto");
			System.out.println("6. Salir");
			System.out.println("==========================================================");
			System.out.println("Escoge una opcion de 1 al 6");
			opcion = sc.nextLine().charAt(0);
			
			switch(opcion) {
			case '1': crearProyecto(proyectos);
				break;
			case '2': verProyectos(proyectos);
				break;
			case '3': 
				proyecto = buscarProyecto(proyectos,"buscar");
				if(proyecto != null)
					System.out.println(proyecto.toString());
				break;
			case '4':modificarProyecto(proyectos);
				break;
			case '5': eliminarProyecto(proyectos);
				break;
			case '6': System.out.println("Fin del programa.");
				break;
			default: System.out.println("La opción no es correcta. Prueba con numeros entre el 1 y el 6");
			}
					
		}while(opcion != '6');
	}
	
	private static void modificarProyecto(List<Proyecto> proyectos) {
		Scanner sc = new Scanner(System.in);
		String idProyecto = "";
		Iterator<Proyecto> it = proyectos.iterator();
		Proyecto proyecto = new Proyecto();
		Boolean band = false;
		System.out.println("Indica el ID del proyecto a modificar:");
		idProyecto = sc.nextLine();
		while(it.hasNext()) {
			proyecto = it.next();
			if (proyecto.getIdProyecto().equals(idProyecto)) {
				band = true;
				break;
			}
		}
		if(band == true) {
			menuModificarProyecto(proyecto);
			band = false;
		}
		else
			System.out.println("El ID del proyecto no ha sido encontrado.");
	}
	
	private static void menuModificarProyecto(Proyecto proyecto) {
		Scanner sc = new Scanner(System.in);
		char opcion = '0';
		System.out.println("==========================================================================");
		do {
		System.out.println("Bienvenido al menu para la modificacion de un proyecto");
		System.out.println("Indiaca una opcion a aplicar al proyecto con ID" + proyecto.getIdProyecto() + ":");
		System.out.println("1. Editar datos del proyecto");
		System.out.println("2. Crear cliente");
		System.out.println("3. Eliminar cliente");
		System.out.println("4. Crear jefe de proyecto");
		System.out.println("5. Eliminar jefe de proyecto");
		System.out.println("6. Salir");
		System.out.println("==========================================================================");
		opcion = sc.nextLine().charAt(0);
		
		switch(opcion) {
		case '1': cambiarDatosProyecto(proyecto);
			break;
		case '2': crearClientes(proyecto);
			break;
		case '3': eliminarClientes(proyecto);
			break;
		case '4': crearJefes(proyecto);
			break;
		case '5': eliminarJefes(proyecto);
			break;
		case '6':System.out.println("Saliendo del menu");
			break;
		default:System.out.println("Opcion incorrecta. Prueba con un numero del 1 al 6");
		}
		
		}while(opcion != '6');
		
		
	}
	
	private static void eliminarClientes(Proyecto proyecto) {
		Scanner sc= new Scanner(System.in);
		String dni ="";
		List<Cliente> clientes = proyecto.getClientes();
		Iterator<Cliente> it = clientes.iterator();
		Cliente cliente;
		
		System.out.println("Indica el DNI del cliente que deseas eliminar");
		dni = sc.nextLine();
		while(it.hasNext()) {
			cliente = it.next();
			if(cliente.getDni().equals(dni)) {
				it.remove();
				System.out.println("Cliente eliminado");
			}else
				System.out.println("El DNI del cliente no ha sido encontrado");
		}
	}
	
	private static void eliminarJefes(Proyecto proyecto) {
		Scanner sc= new Scanner(System.in);
		String dni ="";
		List<JefeProyecto> jefes = proyecto.getJefes();
		Iterator<JefeProyecto> it = jefes.iterator();
		JefeProyecto jefe;
		
		System.out.println("Indica el DNI del jefe que deseas eliminar");
		dni = sc.nextLine();
		while(it.hasNext()) {
			jefe = it.next();
			if(jefe.getDni().equals(dni)) {
				it.remove();
				System.out.println("Cliente eliminado");
			}else
				System.out.println("El DNI del cliente no ha sido encontrado");
		}
	}

	private static void crearJefes(Proyecto proyecto) {
		Scanner sc= new Scanner(System.in);
		String nombre ="";
		String apellidos ="";
		String dni ="";
		byte numeroEmpleado = 0;
		List<JefeProyecto> jefes = proyecto.getJefes();
		String siONo = "";

		System.out.println("Sistema de creacion de jefes de proyecto");
		System.out.println("Indica el nombre del jefe de proyecto:");
		nombre = sc.nextLine();
		System.out.println("Indica los apellidos del jefe de proyecto:");
		apellidos = sc.nextLine();
		System.out.println("Indica el DNI del jefe de proyecto:");
		dni = sc.nextLine();
		
			System.out.println("Indica el numero de empleado del jefe de proyecto (ente 1 y 100):");
			//Falta una comprobacion para evitar que le salte al usuario una excepcion si introduce texto.
			
			numeroEmpleado = (byte) Integer.parseInt(sc.nextLine());
			if(numeroEmpleado > 100) {
				//TODO Se puede hacer un throw
				System.out.println("El numero de empleado no se ha guardado porque debe comprender un numero entre 1 y 100");
			} else {
				JefeProyecto jefe = new JefeProyecto(nombre, apellidos, dni, numeroEmpleado);
				jefes.add(jefe);
				
				do {
					System.out.println("Cliente creado correctamente, deseas crear otro cliente mas? S/N");
					siONo = sc.nextLine();
					if (siONo.toUpperCase().equals("S")) {
						crearJefe();
						siONo = "N";
					}
					else if(!siONo.toUpperCase().equals("N")) {
						System.out.println("Respuesta incorrecta, selecciona S para si, N para no");
						siONo = sc.nextLine();
					}
				} while (!siONo.toUpperCase().equals("N"));
				
				}
	}
	
	private static void crearClientes(Proyecto proyecto) {
		Scanner sc = new Scanner(System.in);
		String nombre ="";
		String apellidos ="";
		String dni ="";
		List<Cliente> clientes = proyecto.getClientes();
		String siONo = "";
		
		System.out.println("Sistema de creacion de clientes");
		System.out.println("Indica el nombre del cliente:");
		nombre = sc.nextLine();
		System.out.println("Indica los apellidos del cliente:");
		apellidos = sc.nextLine();
		System.out.println("Indica el DNI del cliente:");
		dni = sc.nextLine();
		
		Cliente cliente = new Cliente(nombre, apellidos, dni);
		clientes.add(cliente);
		do {
			System.out.println("Cliente creado correctamente, deseas crear otro cliente mas? S/N");
			siONo = sc.nextLine();
			if (siONo.toUpperCase().equals("S")) {
				crearCliente();
				siONo = "N";
			}
			else if(!siONo.toUpperCase().equals("N")) {
				System.out.println("Respuesta incorrecta, selecciona S para si, N para no");
				siONo = sc.nextLine();
			}
		} while (!siONo.toUpperCase().equals("N"));
		
	}

	public static void cambiarDatosProyecto(Proyecto proyecto) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quieres cambiar el nombre? S/N");
		if(sc.nextLine().toUpperCase().equals("S")) {
		System.out.println("Indica el nuevo nombre del proyecto");
		proyecto.setNombre(sc.nextLine());
		}
		System.out.println("Quieres cambiar la descripcion? S/N");
		if(sc.nextLine().toUpperCase().equals("S")) {
			System.out.println("Indica la nueva descripcion del proyecto");
			proyecto.setDescripcion(sc.nextLine());
			}
		
	}

	private static void eliminarProyecto(List<Proyecto> proyectos) {
		Scanner sc = new Scanner(System.in);
		Proyecto proyecto = buscarProyecto(proyectos, "eliminar");
		if (proyecto == null) {
		}else if(proyectos.remove(proyecto)) {
			System.out.println("Confirma que deseas eliminar el proyecto con ID " + proyecto.getIdProyecto() + " S/N");
			if(sc.nextLine().toUpperCase().equals("S"))
				System.out.println("El proyecto con ID " + proyecto.getIdProyecto() + " ha sido eliminado correctamente");
			else
				System.out.println("El proyecto con ID " + proyecto.getIdProyecto() + " no ha sido eliminado");
		}
			else
				System.out.println("El proyecto con ID " + proyecto.getIdProyecto() + " no ha sido eliminado");
	}

	private static Proyecto buscarProyecto(List<Proyecto> proyectos, String accion) {
		Scanner sc = new Scanner(System.in);
		String idProyecto = "";
		Proyecto proyecto;
		Iterator<Proyecto> it = proyectos.iterator();
		Boolean band = false;
		
		System.out.println("Indica el ID del proyecto que deseas " + accion + ":");
		idProyecto = sc.nextLine();
		
		do {
			proyecto = it.next();
			if (proyecto.getIdProyecto().equals(idProyecto)) {
				System.out.println(proyecto);
				band = true;
			}
		} while (band == false && it.hasNext() == true);
		if (band == false) {
			System.out.println("El ID " + idProyecto + " no es correcto o no existe ningun proyecto con el ID " + idProyecto);
			return proyecto = null;
		}
		return proyecto;
	}

	public static void verProyectos(List<Proyecto> proyectos) {
		int size = proyectos.size();
		for (int i = 0;i<size;i++) {
			System.out.println(proyectos.get(i).toString());
		}
	}
	
	public static void crearProyecto(List<Proyecto> proyectos) {
		Scanner sc= new Scanner(System.in);
		String idProyecto = "";
		String nombreProyecto = "";
		String descripcionProyecto = "";
		
		System.out.println("Sistema de creacion de proyectos");
		System.out.println("Indica el ID del proyecto:");
		idProyecto = sc.nextLine();
		System.out.println("Indica el nombre del proyecto:");
		nombreProyecto = sc.nextLine();
		System.out.println("Indica la descripcion del proyecto:");
		descripcionProyecto = sc.nextLine();
		
		Proyecto proyecto = new Proyecto(idProyecto, nombreProyecto, descripcionProyecto, new Date(), crearCliente(), crearJefe());
		proyectos.add(proyecto);
		
	}
	
	public static List<Cliente> crearCliente() {
		Scanner sc= new Scanner(System.in);
		String nombre ="";
		String apellidos ="";
		String dni ="";
		List<Cliente> clientes = new ArrayList<Cliente>();
		String siONo = "";
		
		System.out.println("Sistema de creacion de clientes");
		System.out.println("Indica el nombre del cliente:");
		nombre = sc.nextLine();
		System.out.println("Indica los apellidos del cliente:");
		apellidos = sc.nextLine();
		System.out.println("Indica el DNI del cliente:");
		dni = sc.nextLine();
		
		Cliente cliente = new Cliente(nombre, apellidos, dni);
		clientes.add(cliente);
		do {
			System.out.println("Cliente creado correctamente, deseas crear otro cliente mas? S/N");
			siONo = sc.nextLine();
			if (siONo.toUpperCase().equals("S")) {
				crearCliente();
				siONo = "N";
			}
			else if(!siONo.toUpperCase().equals("N")) {
				System.out.println("Respuesta incorrecta, selecciona S para si, N para no");
				siONo = sc.nextLine();
			}
		} while (!siONo.toUpperCase().equals("N"));
		
		return clientes;
	}
	
	public static List<JefeProyecto> crearJefe() {
		Scanner sc= new Scanner(System.in);
		String nombre ="";
		String apellidos ="";
		String dni ="";
		byte numeroEmpleado = 0;
		List<JefeProyecto> jefes = new ArrayList<JefeProyecto>();
		String siONo = "";

		System.out.println("Sistema de creacion de jefes de proyecto");
		System.out.println("Indica el nombre del jefe de proyecto:");
		nombre = sc.nextLine();
		System.out.println("Indica los apellidos del jefe de proyecto:");
		apellidos = sc.nextLine();
		System.out.println("Indica el DNI del jefe de proyecto:");
		dni = sc.nextLine();
		
			System.out.println("Indica el numero de empleado del jefe de proyecto (ente 1 y 100):");
			//Falta una comprobacion para evitar que le salte al usuario una excepcion si introduce texto.
			
			numeroEmpleado = (byte) Integer.parseInt(sc.nextLine());
			if(numeroEmpleado > 100) {
				//TODO Se puede hacer un throw
				System.out.println("El numero de empleado no se ha guardado porque debe comprender un numero entre 1 y 100");
			} else {
				JefeProyecto jefe = new JefeProyecto(nombre, apellidos, dni, numeroEmpleado);
				jefes.add(jefe);
				
				do {
					System.out.println("Cliente creado correctamente, deseas crear otro cliente mas? S/N");
					siONo = sc.nextLine();
					if (siONo.toUpperCase().equals("S")) {
						crearJefe();
						siONo = "N";
					}
					else if(!siONo.toUpperCase().equals("N")) {
						System.out.println("Respuesta incorrecta, selecciona S para si, N para no");
						siONo = sc.nextLine();
					}
				} while (!siONo.toUpperCase().equals("N"));
				
				}
		return jefes;
		
	}
}
