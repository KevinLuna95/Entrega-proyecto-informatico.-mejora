package es.ifp.programacion.ejercicio.uf5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Permite leer un fichero de arriba hacia abajo linea por linea
 * @author Kevin Luna Botey
 *
 */
public class LeerFichero {
	private File archivo;
	private FileReader fr;
	private BufferedReader br;

	/**
	 * constructor para leer un fichero
	 * @param archivo indica el archivo que deseas leer
	 */
	public LeerFichero(File archivo) {
		this.archivo=archivo;
	}
	

	/**
	 * Lee el fichero para retornar un string con los datos del proyecto
	 * @return un String de aquello que lee.
	 */
	public String leer() {
		String respuesta="";
		String linea="";
		try {
			
			if(!this.archivo.exists())
				System.out.println("No se puede leer, el fichero "+archivo+" no existe");
			
			fr = new FileReader(this.archivo);
			br = new BufferedReader(fr);
			
			linea= br.readLine();
			while (linea != null) {
				respuesta += linea;
				respuesta += "\n";
				linea= br.readLine();
			}
			
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return respuesta;
	}
	
}
