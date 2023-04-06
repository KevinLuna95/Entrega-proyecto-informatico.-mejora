package es.ifp.programacion.ejercicio.uf5;
/**
 * Clase que requiere de un id unico de cliente y del tipo de Persona CLI, es una extensión de la Clase Persona.
 * @author Kevin Luna Botey
 *
 */
public class Cliente extends Persona {
	private String idCliente;
	private static String tipoCliente="CLI";
	/**
	 * Introducción de datos del cliente para instanciar una clase Cliente
	 * @param nombre debes aportar el Nombre del cliente
	 * @param apellido debes aportar los apellidos del cliente
	 * @param dni debes aportar el DNI del cliente
	 */
	public Cliente(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
		//Aunque un id debe ser autoincremental y no random, he realizado esta operación para simular un id aleatorio real.
		this.idCliente="AB"+(Math.ceil(10000*Math.random()))*10;
	}

	/**
	 * Getter que permite la lectura del parámetro idCliente
	 * @return the idCliente obtienes el ID del cliente
	 */
	public String getIdCliente() {
		return idCliente;
	}

	/**
	 * Un ID no debería poder cambiarse nunca. para eso tenemos otros parametros como referencia o numero de cliente.
	 * No obstante el ejercicio no indica la restriccion de modificar este campo y por eso mantengo el setter
	 * @param idCliente the idCliente to set obtienes el id del Cliente
	 */
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * Getter que permite la lectura del parámetro tipoCliente
	 * @return the tipoCliente retorna el tipo de cliente (CLI)
	 */
	public static String getTipoCliente() {
		return tipoCliente;
	}

	/**
	 * Retorna el tipo de cliente bajo la implementacion del metodo getTipo. Tal y como la clase parde indica.
	 */
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return getTipoCliente();
	}

	/**
	 * Sobreescribe el metodo toString() para adaptarlo a las necesidades de la clase.
	 * @return the String obtienes un String con todos los datos de la clase
	 */
	public String toString() {
		return  super.toString() + "\n"+
				"ID cliente= " + this.getIdCliente() + "\n" +
				"Tipo= " + this.getTipo();
	}
}
