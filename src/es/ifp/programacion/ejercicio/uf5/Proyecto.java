package es.ifp.programacion.ejercicio.uf5;

import java.util.Date;
import java.util.LinkedList;
/**
 * Permite crear un proyecto y manejar diferentes clientes y jefes de proyecto mediante la escritura y lectura en ficheros .txt
 * @author Kevin Luna botey
 *
 */
public class Proyecto {
	private String idProyecto;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private LinkedList<Cliente> clientes;
	private LinkedList<JefeProyecto> jefes;
	
	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param clientes Indica el LinfedList de los jefes
	 * @param jefes Indica el LinfedList de los clientes
	 */
	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			LinkedList<Cliente> clientes, LinkedList<JefeProyecto> jefes) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.clientes = clientes;
		this.jefes = jefes;

	}
	
	/** 
	 * Getter que permite obtener el id del proyecto
	 * @return the idProyecto
	 */
	public String getIdProyecto() {
		return idProyecto;
	}
	
	/** Un ID no debería poder cambiarse nunca. para eso tenemos otros parametros como referencia o numero de proyecto
	 * No obstante el ejercicio no indica la restriccion de modificar este campo y por eso mantengo el setter
	 * @param idProyecto the idProyecto to set cambia la instancia del id proyecto
	 */
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	
	/**
	 * Getter que permite obtener el nombre
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Metodo que permite cambiar la instanciación de nombre. ademas modifica el nombre de los archivos.
	 * @param nombre the nombre to set cambia la instancia de nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Getter que permite obtener la decripcion
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
	
	/**
	 * Metodo que permite cambiar la instanciación de descripcion
	 * @param descripcion the descripcion to set cambia la instancia de descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Getter que permite obtener la fecha de inicio 
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return this.fechaInicio;
	}
	
	/**
	 * Metodo que permite cambiar la instanciación de fecha de inicio
	 * @param fechaInicio the fechaInicio to set cambia la instancia de fecha
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	/**
	 * una clase que retorna un LinkedList con los clientes que contenga el proyecto
	 * @return el LinkedList de clientes
	 */
	public LinkedList<Cliente> getClientes(){
		return this.clientes;
	}
	
	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(LinkedList<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * una clase que retorna un LinkedList con los jefes que contenga el proyecto
	 * @return el LinkedList de jefes
	 */
	public LinkedList<JefeProyecto> getJefes(){
		return this.jefes;
	}
	
	/**
	 * @param jefes the jefes to set
	 */
	public void setJefes(LinkedList<JefeProyecto> jefes) {
		this.jefes = jefes;
	}

	/**
	 * Retorna un formato de String para el correcto visionado por consola de los parametros obligatorios de proyecto
	 * @return  una estructura para mostrar los datos del Proyecto
	 */
	public String toStringProyecto() {
		return  "====================================================================="+"\n" +
				"--------------------------DATOS DE PROYECTO--------------------------"+"\n" +
				"====================================================================="+"\n" +
				"Nombre de proyecto: "+ this.getNombre()+"\n"+
				"ID Proyecto: "+ this.getIdProyecto()+"\n"+
				"Descripcion: "+ this.getDescripcion()+"\n"+
				"Fecha de inico: "+ this.getFechaInicio()+"\n";
	}
	
	/**
	 * Retorna un formato de String para el correcto visionado por consola de los clientes
	 * @return una estructura para mostrar los datos de Cliente1
	 */
	public String toStringCliente1() {
		int size = this.clientes.size();
		String respuesta =  "====================================================================="+"\n" +
							"----------------------------DATOS CLIENTE----------------------------"+"\n" +
							"====================================================================="+"\n";
		for (int i=0;i<size;i++) {
			respuesta += "-----------------------CLIENTE "+(i+1)+"-----------------------"+"\n"
						 +clientes.get(i).toString()+"\n";
		}
		return respuesta;
	}

	/**
	 * Retorna un formato de String para el correcto visionado por consola de los jefes
	 * @return una estructura para mostrar los datos de Jefe1
	 */
	public String toStringJefe1() {
		int size = this.jefes.size();
		String respuesta =  "====================================================================="+"\n" +
				"-------------------------DATOS JEFE PROYECTO-------------------------"+"\n" +
				"====================================================================="+"\n";
		for (int i=0;i<size;i++) {
			respuesta += "-------------------------JEFE "+(i+1)+"-------------------------"+"\n"
					+jefes.get(i).toString()+"\n";
		}
		return respuesta;
		
	}
	
	/**
	 * Muestra los datos adecuadamente formateados del proyecto, incluyendo sus clientes y jefes de proyecto
	 * @return una estructura para mostrar TODOS los datos del proyecto
	 */
	@Override
	public String toString() {
		return this.toStringProyecto()+"\n"+this.toStringCliente1()+"\n"+this.toStringJefe1();
	}
}
