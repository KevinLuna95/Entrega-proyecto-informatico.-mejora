package es.ifp.programacion.ejercicio.uf5.exception;
/**
 * Permite el manejo de excepciones en el numero de empleado
 * @author Kevin Luna Botey
 *
 */
public class NumeroEmpleadoException extends Exception{
	/**
	 * Permite el manejo de excepciones en el numero de empleado
	 * @param mensaje Manejo del mensaje que retorna la excepcion
	 */
	public NumeroEmpleadoException(String mensaje) {
		super(mensaje);
	}
}
