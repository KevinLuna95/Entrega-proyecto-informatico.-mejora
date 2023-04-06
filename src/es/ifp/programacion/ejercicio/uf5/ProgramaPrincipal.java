package es.ifp.programacion.ejercicio.uf5;

import java.util.Date;

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
		Proyecto proyecto = new Proyecto("PRO-12","Operacion Caixabank", "Necesitan de un programa que les ayude a gestionar los "
				+ "prestamos de sus clientes", new Date(), cliente,cliente,cliente, jefe,jefe, jefe );
		
		System.out.println(proyecto.toStringInfo());
	}

}
