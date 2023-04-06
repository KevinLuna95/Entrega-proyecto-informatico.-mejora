package es.ifp.programacion.ejercicio.uf5;
/**
 * Clase abstracta que define a una persona. Requiere nombre, apellido y DNI.
 * @author Kevin Luna Botey
 *
 */
public abstract class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	
	/**
	 * Clase persona, permite la gestion de personas fisicas
	 * @param nombre asigna un nombre
	 * @param apellido asigna 2 apellidos (Si existen)
	 * @param dni asigna el DNI
	 */
	public Persona(String nombre, String apellido, String dni) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
	}

	/**
	 * Permite obtener el nombre
	 * @return the nombre obtienes el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Permite obtener los apellidos
	 * @return the apellido obtienes los apellidos
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * permite obtener el dni
	 * @return the dni obtienes el DNI
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Metodo que debe retornar el tipo de persona que es. Ej: JP para el jefe de proyecto
	 * @return the tipo obtiene el tipo de Persona
	 */
	public abstract String getTipo();

	/**
	 * Sobreescribe el metodo toString() para adaptarlo a las necesidades de la clase.
	 * @return the String obtienes un String con todos los datos de la clase
	 */
	@Override
	public String toString() {
		return  "Nombre= " + this.getNombre() + "\n" +
				"Apellidos= " + this.getApellido() + "\n" +
				"DNI= " + this.getDni();
	}
}
