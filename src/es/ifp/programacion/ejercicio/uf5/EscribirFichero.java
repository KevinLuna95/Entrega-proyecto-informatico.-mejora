package es.ifp.programacion.ejercicio.uf5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Permite la escritura en un fichero
 * @author Kevin Luna Botey
 *
 */
public class EscribirFichero {
	private File archivoFile;
	private FileWriter fw;
	private BufferedWriter bw;
	private String escribir;
	
	/**
	 * Constructor para escribir en un fichero
	 * @param archivoFile archivo a escribir
	 * @param escribir texto a escribir
	 */
	public EscribirFichero(File archivoFile,String escribir) {
		this.archivoFile=archivoFile;
		this.escribir=escribir;
	}
	
	/**
	 * Escribe en un fichero
	 * El fichero siempre se sobreescribe cuando se instancia una clase proyecto.
	 */
	public void escribir() {
		try {
			
			if(!this.archivoFile.exists())
				this.archivoFile.createNewFile();
			
			fw = new FileWriter(this.archivoFile);
			bw = new BufferedWriter(fw);
			bw.write(escribir);
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
