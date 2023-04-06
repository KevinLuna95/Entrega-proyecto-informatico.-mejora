package es.ifp.programacion.ejercicio.uf5;

import java.io.File;
import java.util.Date;
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
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	private JefeProyecto jefe1;
	private JefeProyecto jefe2;
	private JefeProyecto jefe3;
	
	public File archivoCliente;
	public File archivoJefe;
	EscribirFichero escribirFicheroCliente;
	EscribirFichero escribirFicheroJefe;
	
	public LeerFichero leerFichero;
	
	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param cliente1 Indica el primer cliente
	 * @param jefe1 Indica el primer jefe
	 */
	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			Cliente cliente1, JefeProyecto jefe1) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.cliente1 = cliente1;
		this.jefe1 = jefe1;
		this.archivoCliente = new File(this.nombre+"Clientes.txt");
		this.archivoJefe = new File(this.nombre+"Jefes.txt");
		
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}
	
	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param cliente1 Indica el primer cliente
	 * @param cliente2 Indica el segundo cliente
	 * @param jefe1 Indica el primer jefe
	 */

	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			Cliente cliente1, Cliente cliente2, JefeProyecto jefe1) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.cliente1 = cliente1;
		this.cliente2 = cliente2;
		this.jefe1 = jefe1;
		this.archivoCliente = new File(this.nombre+"Clientes.txt");
		this.archivoJefe = new File(this.nombre+"Jefes.txt");

		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}
	
	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param cliente1 Indica el primer cliente
	 * @param cliente2 Indica el segundo cliente
	 * @param cliente3 Indica el tercer cliente
	 * @param jefe1 Indica el primer jefe
	 */
	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			Cliente cliente1, Cliente cliente2, Cliente cliente3, JefeProyecto jefe1) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.cliente1 = cliente1;
		this.cliente2 = cliente2;
		this.cliente3 = cliente3;
		this.jefe1 = jefe1;
		this.archivoCliente = new File(this.nombre+"Clientes.txt");
		this.archivoJefe = new File(this.nombre+"Jefes.txt");
		
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}
	
	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param cliente1 Indica el primer cliente
	 * @param jefe1 Indica el primer jefe
	 * @param jefe2 Indica el segundo jefe
	 */
	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			Cliente cliente1, JefeProyecto jefe1, JefeProyecto jefe2) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.cliente1 = cliente1;
		this.jefe1 = jefe1;
		this.jefe2 = jefe2;
		this.archivoCliente = new File(this.nombre+"Clientes.txt");
		this.archivoJefe = new File(this.nombre+"Jefes.txt");
		
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}

	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param cliente1 Indica el primer cliente
	 * @param jefe1 Indica el primer jefe
	 * @param jefe2 Indica el segundo jefe
	 * @param jefe3 Indica el tercer jefe
	 */
	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			Cliente cliente1, JefeProyecto jefe1,JefeProyecto jefe2, JefeProyecto jefe3) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.cliente1 = cliente1;
		this.jefe1 = jefe1;
		this.jefe2 = jefe2;
		this.jefe3 = jefe3;
		this.archivoCliente = new File(this.nombre+"Clientes.txt");
		this.archivoJefe = new File(this.nombre+"Jefes.txt");
		
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}
	
	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param cliente1 Indica el primer cliente
	 * @param cliente2 Indica el segundo cliente
	 * @param cliente3 Indica el tercer cliente
	 * @param jefe1 Indica el primer jefe
	 * @param jefe2 Indica el segundo jefe
	 */
	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			Cliente cliente1, Cliente cliente2, Cliente cliente3, JefeProyecto jefe1,JefeProyecto jefe2) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.cliente1 = cliente1;
		this.cliente2 = cliente2;
		this.cliente3 = cliente3;
		this.jefe1 = jefe1;
		this.jefe2 = jefe2;
		this.archivoCliente = new File(this.nombre+"Clientes.txt");
		this.archivoJefe = new File(this.nombre+"Jefes.txt");
		
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}
	
	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param cliente1 Indica el primer cliente
	 * @param cliente2 Indica el segundo cliente
	 * @param jefe1 Indica el primer jefe
	 * @param jefe2 Indica el segundo jefe
	 * @param jefe3 Indica el tercer jefe
	 */
	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			Cliente cliente1, Cliente cliente2, JefeProyecto jefe1,JefeProyecto jefe2, JefeProyecto jefe3) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.cliente1 = cliente1;
		this.cliente2 = cliente2;
		this.jefe1 = jefe1;
		this.jefe2 = jefe2;
		this.jefe3 = jefe3;
		this.archivoCliente = new File(this.nombre+"Clientes.txt");
		this.archivoJefe = new File(this.nombre+"Jefes.txt");
		
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}
	
	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param cliente1 Indica el primer cliente
	 * @param cliente2 Indica el segundo cliente
	 * @param jefe1 Indica el primer jefe
	 * @param jefe2 Indica el segundo jefe
	 */
	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			Cliente cliente1, Cliente cliente2, JefeProyecto jefe1,JefeProyecto jefe2) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.cliente1 = cliente1;
		this.cliente2 = cliente2;
		this.jefe1 = jefe1;
		this.jefe2 = jefe2;
		this.archivoCliente = new File(this.nombre+"Clientes.txt");
		this.archivoJefe = new File(this.nombre+"Jefes.txt");
		
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}
	
	/**
	 * Constructor de la clase proyecto
	 * @param idProyecto indica el ID del proyecto, rebe ser UNICO
	 * @param nombre Indica el nombre del proyecto
	 * @param descripcion Indica una descripcion
	 * @param fechaInicio Indica la fecha de inicio
	 * @param cliente1 Indica el primer cliente
	 * @param cliente2 Indica el segundo cliente
	 * @param cliente3 Indica el tercer cliente
	 * @param jefe1 Indica el primer jefe
	 * @param jefe2 Indica el segundo jefe
	 * @param jefe3 Indica el tercer jefe
	 */
	public Proyecto(String idProyecto, String nombre, String descripcion, Date fechaInicio,
			Cliente cliente1, Cliente cliente2, Cliente cliente3, JefeProyecto jefe1,JefeProyecto jefe2, JefeProyecto jefe3) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.cliente1 = cliente1;
		this.cliente2 = cliente2;
		this.cliente3 = cliente3;
		this.jefe1 = jefe1;
		this.jefe2 = jefe2;
		this.jefe3 = jefe3;
		this.archivoCliente = new File(this.nombre+"Clientes.txt");
		this.archivoJefe = new File(this.nombre+"Jefes.txt");
		
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
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
		archivoCliente.renameTo(new File(this.nombre+"Clientes.txt"));
		archivoJefe.renameTo(new File(this.nombre+"Jefes.txt"));
		archivoCliente=new File(this.nombre+"Jefes.txt");
		archivoJefe=new File(this.nombre+"Jefes.txt");
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
	 * Getter de la propiedad cliente 1
	 * @return the cliente1
	 */
	public Cliente getCliente1() {
		return this.cliente1;
	}

	/**
	 * Se sobreescribe el fichero para garantizar que los datos son acrualizados
	 * Como actualmente no sabemos buscar informacion en el archivo no puedo sustituir solo la sección cambiada.
	 * @param cliente1 the cliente1 to set
	 */
	public void setCliente1(Cliente cliente1) {
		this.cliente1 = cliente1;
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
	}

	/**
	 * 	 * Getter de la propiedad cliente 2
	 * @return the cliente2
	 */
	public Cliente getCliente2() {
		return this.cliente2;
	}

	/**
	 * Se sobreescribe el fichero para garantizar que los datos son acrualizados
	 * Como actualmente no sabemos buscar informacion en el archivo no puedo sustituir solo la sección cambiada.
	 * @param cliente2 the cliente2 to set
	 */
	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
	}

	/**
	 * Getter de la propiedad cliente 3
	 * @return the cliente3
	 */
	public Cliente getCliente3() {
		return this.cliente3;
	}

	/**
	 * Se sobreescribe el fichero para garantizar que los datos son acrualizados
	 * Como actualmente no sabemos buscar informacion en el archivo no puedo sustituir solo la sección cambiada.
	 * @param cliente3 the cliente3 to set
	 */
	public void setCliente3(Cliente cliente3) {
		this.cliente3 = cliente3;
		(escribirFicheroCliente= new EscribirFichero(archivoCliente,this.getClientes())).escribir();
	}

	/**
	 * Getter de la propiedad jefe 1
	 * @return the jefe1
	 */
	public JefeProyecto getJefe1() {
		return this.jefe1;
	}

	/**
	 * Se sobreescribe el fichero para garantizar que los datos son acrualizados
	 * Como actualmente no sabemos buscar informacion en el archivo no puedo sustituir solo la sección cambiada.
	 * @param jefe1 the jefe1 to set
	 */
	public void setJefe1(JefeProyecto jefe1) {
		this.jefe1 = jefe1;
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}

	/**
	 * Getter de la propiedad jefe 2
	 * @return the jefe2
	 */
	public JefeProyecto getJefe2() {
		return this.jefe2;
	}

	/**
	 * Se sobreescribe el fichero para garantizar que los datos son acrualizados
	 * Como actualmente no sabemos buscar informacion en el archivo no puedo sustituir solo la sección cambiada.
	 * @param jefe2 the jefe2 to set
	 */
	public void setJefe2(JefeProyecto jefe2) {
		this.jefe2 = jefe2;
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}

	/**
	 * Getter de la propiedad jefe 3
	 * @return the jefe3
	 */
	public JefeProyecto getJefe3() {
		return this.jefe3;
	}

	/**
	 * Se sobreescribe el fichero para garantizar que los datos son acrualizados
	 * Como actualmente no sabemos buscar informacion en el archivo no puedo sustituir solo la sección cambiada.
	 * @param jefe3 the jefe3 to set
	 */
	public void setJefe3(JefeProyecto jefe3) {
		this.jefe3 = jefe3;
		(escribirFicheroJefe = new EscribirFichero(archivoJefe,this.getJefes())).escribir();
	}
	

	/**
	 * Retorna un formato de String para el correcto visionado por consola del parametro
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
	 * Retorna un formato de String para el correcto visionado por consola del parametro
	 * @return una estructura para mostrar los datos de Jefe1
	 */
	public String toStringJefe1() {
		return  "---------------------------------------------------------------------"+"\n" +
				"------------------------DATOS JEFE PROYECTO 1------------------------"+"\n" +
				"---------------------------------------------------------------------"+"\n" +
				this.getJefe1()+"\n";
	}
	/**
	 * Retorna un formato de String para el correcto visionado por consola del parametro
	 * @return una estructura para mostrar los datos de Jefe2
	 */
	public String toStringJefe2() {
		return  "---------------------------------------------------------------------"+"\n" +
				"------------------------DATOS JEFE PROYECTO 2------------------------"+"\n" +
				"---------------------------------------------------------------------"+"\n" +
				this.getJefe2()+"\n";
	}
	
	/**
	 * Retorna un formato de String para el correcto visionado por consola del parametro
	 * @return una estructura para mostrar los datos de Jefe3
	 */
	public String toStringJefe3() {
		return  "---------------------------------------------------------------------"+"\n" +
				"------------------------DATOS JEFE PROYECTO 3------------------------"+"\n" +
				"---------------------------------------------------------------------"+"\n" +
				this.getJefe3()+"\n";
	}
	
	/**
	 * Retorna un formato de String para el correcto visionado por consola del parametro
	 * @return una estructura para mostrar los datos de Cliente1
	 */
	public String toStringCliente1() {
		return  "---------------------------------------------------------------------"+"\n" +
				"---------------------------DATOS CLIENTE 1---------------------------"+"\n" +
				"---------------------------------------------------------------------"+"\n" +
				this.getCliente1()+"\n";
	}
	
	/**
	 * Retorna un formato de String para el correcto visionado por consola del parametro
	 * @return una estructura para mostrar los datos de Cliente2
	 */
	public String toStringCliente2() {
		return  "---------------------------------------------------------------------"+"\n" +
				"---------------------------DATOS CLIENTE 2---------------------------"+"\n" +
				"---------------------------------------------------------------------"+"\n" +
				this.getCliente2()+"\n";
	}
	
	/**
	 * Retorna un formato de String para el correcto visionado por consola del parametro
	 * @return una estructura para mostrar los datos de Cliente3
	 */
	public String toStringCliente3() {
		return  "---------------------------------------------------------------------"+"\n" +
				"---------------------------DATOS CLIENTE 3---------------------------"+"\n" +
				"---------------------------------------------------------------------"+"\n" +
				this.getCliente3()+"\n";
	}
	
	/**
	 * Da el formato correcto a los datos leidos de BBDD y de la clase proyecto
	 * @return String con el formateo de proyecto
	 */
	public String toStringInfo() {
		String respuesta = this.toStringProyecto()+
				(leerFichero = new LeerFichero(archivoCliente)).leer()+
				(leerFichero = new LeerFichero(archivoJefe)).leer();
		return respuesta;
	}
	/**
		 * Formateo de 1 a 3 clientes en 1 proyecto.
		 * @return 1-3 clientes con el formato esperado
	 */
	public String getClientes() {
			if(this.getCliente2() == null)
				return  this.toStringCliente1();
			else
				if(this.getCliente3() == null)
					return  this.toStringCliente1()+this.toStringCliente2();
				else
					return this.toStringCliente1()+this.toStringCliente2()+this.toStringCliente3();
		}
	
		/**
		 * Formateo de 1 a 3 jefes en 1 proyecto.
		 * @return 1-3 jefes con el formato esperado
		 */
		public String getJefes() {
			if(this.getJefe2() == null)
				return  this.toStringJefe1();
			else {
				if(this.getJefe3() == null)
					return this.toStringJefe1()+this.toStringJefe2();
				else
					return  this.toStringJefe1()+this.toStringJefe2()+this.toStringJefe3();
			}
	}
}
