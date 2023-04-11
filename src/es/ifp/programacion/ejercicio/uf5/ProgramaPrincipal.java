package es.ifp.programacion.ejercicio.uf5;

import java.util.Date;
import java.util.LinkedList;

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
		
		Cliente cliente = new Cliente("Pedro","Gonzalez Perez", "11223344L");
		JefeProyecto jefe = new JefeProyecto("Laura","Salazar Franco", "99887744P",10);
		Cliente cliente2 = new Cliente("Sandra","Romero Rios", "32315856Q");
		JefeProyecto jefe2 = new JefeProyecto("Gorka","Hernandez Tomas", "84523165Ñ",10);
		LinkedList<Cliente> clientes = new LinkedList<Cliente>();
		LinkedList<JefeProyecto> jefes = new LinkedList<JefeProyecto>();
		
		clientes.add(cliente);
		clientes.add(cliente2);
		jefes.add(jefe);
		jefes.add(jefe2);
		
		Proyecto proyecto = new Proyecto("PRO-12","Operacion Caixabank", "Necesitan de un programa que les ayude a gestionar los "
				+ "prestamos de sus clientes", new Date(), clientes, jefes);
		System.out.println(proyecto.toString());
	}

}
