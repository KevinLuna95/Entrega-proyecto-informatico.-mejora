package es.ifp.programacion.ejercicio.uf5;

import es.ifp.programacion.ejercicio.uf5.exception.NumeroEmpleadoException;

/**
 * Clase Jefe de proyecto que permite asignar un numero de empleado y tipo de persona JP, es una extensión de la Clase Persona.
 * @author Kevin Luna Botey
 *
 */
public class JefeProyecto extends Persona {
	private int numeroEmpleado;
	private static String tipoJefe="JP";

	/**
	 * Contructor de la clase Jefe proyecto
	 * @param nombre debes aportar el Nombre del cliente
	 * @param apellido los 2 apellidos del Jefe (Si existen)
	 * @param dni l dni del empleado
	 * @param numeroEmpleado debe comprender un numero entre el 1 y el 100
	 * @throws NumeroEmpleadoException Controla que el numero de empleado contenga un numero entre el 1 y el 100
	 */
	public JefeProyecto(String nombre, String apellido, String dni, int numeroEmpleado) throws NumeroEmpleadoException{
		super(nombre, apellido, dni);
		if (numeroEmpleado > 0 && numeroEmpleado < 101)
			this.numeroEmpleado=numeroEmpleado;
		else 
			throw new NumeroEmpleadoException("El numero de empleado no se ha guardado porque debe comprender un numero entre 1 y 100");
		
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
 * @throws NumeroEmpleadoException Controla que el numero de empleado contenga un numero entre el 1 y el 100
 */
	public void setNumeroEmpleado(int numeroEmpleado) throws NumeroEmpleadoException{
		if (numeroEmpleado <= 100 && numeroEmpleado > 1)
			this.numeroEmpleado = numeroEmpleado;
		else {
			throw new NumeroEmpleadoException("El numero de empleado no se ha guardado porque debe comprender un numero entre 1 y 100");
		}
		
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
				return  super.toString() + "\n" +
					"Tipo= "+ this.getTipo() + "\n" + 
					"Numero de empleado= " + this.getNumeroEmpleado();
	}
	
}
