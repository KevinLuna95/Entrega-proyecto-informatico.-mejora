package es.ifp.programacion.ejercicio.uf5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import es.ifp.programacion.ejercicio.uf5.exception.NumeroEmpleadoException;

/**
 * Programa que permite la gestion de los proyectos de una empresa de desarroyo de software
 * Mediante la consola se puede crear, visualizar, buscar, modificar y eliminar proyectos.
 * Los proyectos tienen clientes y jefes de proyecto ademas de la informacion 
 * sobre el proyecto tales como el nombre, la descripcion y la fecha de creacion.
 * @author Kevin Luna botey
 * @version 0.0.1
 *
 */
public class ProgramaPrincipal {

	public static void main(String[] args) {
	
		List<Proyecto> proyectos = new ArrayList<Proyecto>();

		//Introduciendo datos manualmente para nutrir la estructura de datos. PRIMER PROYECTO
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<JefeProyecto> jefes = new ArrayList<JefeProyecto>();
		
		Cliente cliente = new Cliente("Pedro","Gonzalez Perez", "11223344L");
		clientes.add(cliente);
		cliente = new Cliente("Sandra","Romero Rios", "32315856Q");
		clientes.add(cliente);
		
		try {
			JefeProyecto jefe = new JefeProyecto("Laura","Salazar Franco", "99887744P", 11);
			jefes.add(jefe);
			jefe = new JefeProyecto("Gorka","Hernandez Tomas", "84523165A", 10);
			jefes.add(jefe);
		} catch (NumeroEmpleadoException e) {
			System.out.println("El numero de empleado no se ha guardado porque debe comprender un numero entre 1 y 100");
		}
		
		Proyecto proyecto = new Proyecto("PRO-12","Operacion Caixabank", 
				"Necesitan de un programa que les ayude a gestionar los prestamos de sus clientes", 
				new Date(), clientes, jefes);
		proyectos.add(proyecto);
		
		//Introduciendo datos manualmente para nutrir la estructura de datos. SEGUNDO PROYECTO
		clientes = new ArrayList<Cliente>();
		jefes = new ArrayList<JefeProyecto>();
		
		cliente = new Cliente("Ana","Perez Jimenez", "62315982P");
		clientes.add(cliente);
		cliente = new Cliente("Lorna","Montes Fernandez", "74521365D");
		clientes.add(cliente);
		// TODO REVISAR POR QUE PSCAR TIENE ERROR EN CLIENTE
		try {
			JefeProyecto jefe = new JefeProyecto("Oscar","Salas Gutierrez", "89513264U", 1);
			jefes.add(jefe);
			jefe = new JefeProyecto("Susana","Oliva Thomas", "84523165A", 2);
			jefes.add(jefe);
			
		} catch (NumeroEmpleadoException e) {
			System.out.println("El numero de empleado no se ha guardado porque debe comprender un numero entre 1 y 100");
		}
		
		proyecto = new Proyecto("PRO-13","Farmacia cruz calleja", 
				"Necesitan de un programa para la gestion de sus pacientes de SPD", 
				new Date(), clientes, jefes);
		proyectos.add(proyecto);

		//inicializando el menu
		menuGeneral(proyectos);
	}
	
	/**
	 * Se muesra un menu repetidamente hasta que el usuario utiliza el 6 para salir del programa
	 * @param proyectos Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
	private static void menuGeneral(List<Proyecto> proyectos) {
		Scanner sc = new Scanner(System.in);
		char opcion = '0';
		Proyecto proyecto;

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
			case '1': 
				crearProyecto(proyectos);
				break;
			case '2':
				verProyectos(proyectos);
				break;
			case '3': 
				proyecto = buscarProyecto(proyectos,"buscar");
				if(proyecto != null)
					System.out.println(proyecto.toString());
				break;
			case '4':
				ModificarProyecto(proyectos);
				break;
			case '5': 
				eliminarProyecto(proyectos);
				break;
			case '6': 
				System.out.println("Fin del programa.");
				break;
			default: System.out.println("La opcióon no es correcta. Prueba con numeros entre el 1 y el 6");
			}
					
		}while(opcion != '6');
	}
	
	/**
	 * Mostrara un menu y gestionara la respuesta del usuario para ayudarle a modificar los datos del proyecto 
	 * @param proyectos Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
	private static void ModificarProyecto(List<Proyecto> proyectos) {
		Scanner sc = new Scanner(System.in);
		
		Proyecto proyecto = buscarProyecto(proyectos, "modificar");
		if (proyecto != null) {
			String idProyecto = proyecto.getIdProyecto();
			char opcion = '0';
			System.out.println("==========================================================================");
			do {
			System.out.println("Bienvenido al menu para la modificacion de un proyecto");
			System.out.println("Indiaca una opcion a aplicar al proyecto con ID " + idProyecto + ":");
			System.out.println("1. Editar datos del proyecto");
			System.out.println("2. Crear cliente");
			System.out.println("3. Eliminar cliente");
			System.out.println("4. Crear jefe de proyecto");
			System.out.println("5. Eliminar jefe de proyecto");
			System.out.println("6. Salir");
			System.out.println("==========================================================================");
			opcion = sc.nextLine().charAt(0);
			
			switch(opcion) {
			case '1': 
				cambiarDatosProyecto(proyecto);
				break;
			case '2': 
				crearClientes(proyecto);
				break;
			case '3': 
				eliminarClientes(proyecto);
				break;
			case '4': 
				crearJefes(proyecto);
				break;
			case '5': 
				eliminarJefes(proyecto);
				break;
			case '6':
				System.out.println("Saliendo del menu");
				break;
			default:System.out.println("Opcion incorrecta. Prueba con un numero del 1 al 6");
			}
			
			}while(opcion != '6');
		}
	}
	
	/**
	 * Permite eliminar a clientes del arrayList asignado a la clase proyecto
	 * @param proyecto Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
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
	
	/**
	 * Permite eliminar a jefes de proyecto del arrayList asignado a la clase proyecto
	 * @param proyecto Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
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

	/**
	 * Permite la creacion de jefes de proyecto
	 * @param proyecto Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
	private static void crearJefes(Proyecto proyecto) {
		Scanner sc= new Scanner(System.in);
		String nombre ="";
		String apellidos ="";
		String dni ="";
		int numeroEmpleado = 0;
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
			
			numeroEmpleado = Integer.parseInt(sc.nextLine());

				JefeProyecto jefe;
				try {
					jefe = new JefeProyecto(nombre, apellidos, dni, numeroEmpleado);
					jefes.add(jefe);
				} catch (NumeroEmpleadoException e) {
					System.out.println("El numero de empleado no se ha guardado porque debe comprender un numero entre 1 y 100");
				}
				
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
	
	/**
	 * Permite la creacion de clientes
	 * @param proyecto Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
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

	/**
	 * Permite cambiar los datos de un proyecto tales como el nombre y la descripcion.
	 * @param proyecto Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
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

	/**
	 * Permite eliminar un proyecto de la lista de proyectos
	 * @param proyectos Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
	private static void eliminarProyecto(List<Proyecto> proyectos) {
		Scanner sc = new Scanner(System.in);
		Proyecto proyecto = buscarProyecto(proyectos, "eliminar");
		
		if (proyecto == null) {
		}else {
			//Instancio el id del proyecto dentro del else para evitar que si el id no corresponde con un proyecto se tenga que instanciar la variable.
			String idProyecto = proyecto.getIdProyecto();
			System.out.println("Confirma que deseas eliminar el proyecto con ID " + idProyecto + " S/N");
			if(sc.nextLine().toUpperCase().equals("S")) {
				proyectos.remove(proyecto);
				System.out.println("El proyecto con ID " + idProyecto + " ha sido eliminado correctamente");
			}
			else
				System.out.println("El proyecto con ID " + idProyecto + " no ha sido eliminado");
		}

	}

	/**
	 * Permite la busqueda de un proyecto para verificar su existencia.
	 * @param proyectos Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 * @param accion gestiona el texto de la accion que se va a ejecutar(comprension del usuario)
	 * @return
	 */
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
	
	/**
	 * Permite visualizar los proyectos existentes y su informacion dentro del programa
	 * @param proyectos Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
	public static void verProyectos(List<Proyecto> proyectos) {
		int size = proyectos.size();
		for (int i = 0;i<size;i++) {
			System.out.println(proyectos.get(i).toString());
		}
	}
	/**
	 * Solicita informacion al usuario y permite la creacion de un proyecto
	 * @param proyectos Un ArrayListde tipo proyecto donde se almacenan todos los proyectos
	 */
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
	
	/**
	 * Retorna una lista de clientes ademas de crear los clientes necesarios.
	 * @return una lista de clientes con los clientes que se han asignado previamente.
	 */
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
	
	/**
	 * Retorna una lista de jefes de proyecto ademas de crear los clientes necesarios.
	 * @return una lista de jefes con los jefes de proyecto que se han asignado previamente.
	 */
	public static List<JefeProyecto> crearJefe() {
		Scanner sc= new Scanner(System.in);
		String nombre ="";
		String apellidos ="";
		String dni ="";
		int numeroEmpleado = 0;
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
			
			numeroEmpleado = Integer.parseInt(sc.nextLine());

				JefeProyecto jefe;
				try {
					jefe = new JefeProyecto(nombre, apellidos, dni, numeroEmpleado);
					jefes.add(jefe);
				} catch (NumeroEmpleadoException e) {
					System.out.println("El numero de empleado no se ha guardado porque debe comprender un numero entre 1 y 100");
				}
				
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

		return jefes;
	}
}
