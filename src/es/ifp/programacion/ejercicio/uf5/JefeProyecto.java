package es.ifp.programacion.ejercicio.uf5;
/**
 * Clase Jefe de proyecto que permite asignar un numero de empleado y tipo de persona JP, es una extensión de la Clase Persona.
 * @author Kevin Luna Botey
 *
 */
public class JefeProyecto extends Persona {
	private byte numeroEmpleado;
	private static String tipoJefe="JP";
	/**
	 * Contructor de la clase Jefe proyecto
	 * @param nombre debes aportar el Nombre del cliente
	 * @param apellido los 2 apellidos del Jefe (Si existen)
	 * @param dni l dni del empleado
	 * @param numeroEmpleado debe comprender un numero entre el 1 y el 100
	 */
	public JefeProyecto(String nombre, String apellido, String dni, byte numeroEmpleado) {
		super(nombre, apellido, dni);
		if (numeroEmpleado < 100 && numeroEmpleado > 1)
			this.numeroEmpleado=numeroEmpleado;
		else {
			System.out.println("El numero de empleado no se ha guardado porque debe comprender un numero entre 1 y 100");
		}
	}
	
	/**
	 * Permite la obtencion del numero de empleado
	 * @return the numeroEmpleado obtienes el numero de empleado
	 */
	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}
	
	/**
	 * permite modificar el numero de empleado
	 * @param numeroEmpleado the numeroEmpleado to set
	 */
	public void setNumeroEmpleado(byte numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
	
	/**
	 * permite la obtencion del tipo de persona
	 * @return the tipoJefe retorna el tipo Jefe de proyercto (JP)
	 */
	public static String getTipoJefe() {
		return tipoJefe;
	}
	
	/**
	 * Retorna el tipo de cliente bajo la implementacion del metodo getTipo. Tal y como la clase parde indica.
	 */
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return getTipoJefe();
	}
	
	/**
	 * Sobreescribe el metodo toString() para adaptarlo a las necesidades de la clase.
	 * @return the String obtienes un String con todos los datos de la clase
	 */
	@Override
	public String toString() {
		if (this.getNumeroEmpleado() < 100 && this.getNumeroEmpleado() > 1)
			return  super.toString() + "\n" +
					"Tipo= "+ this.getTipo() + "\n" + 
					"Numero de empleado= " + this.getNumeroEmpleado();
		else
			return  super.toString() + "\n" +
			"Tipo= "+ this.getTipo() + "\n" + 
			"Numero de empleado= Erroneo, prueba con un numero del 1 al 100";
	}
	
}
