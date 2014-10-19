package dam.ad.t1.ejemplos.sesion05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * En este ejemplo vamos a leer el contenido de un fichero de texto, y lo vamos
 * a imprimir por consola tal cual.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 5. Ejemplo 1
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S05_Ejemplo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length != 1) {
			System.err.println("Error de sintaxis. java T1S05_Ejemplo01 <ruta_del_fichero_a_leer>");
			return;
		}
		
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(args[0]);
			
			int caracter;
			
			while ((caracter = fr.read()) != -1) {
				System.out.print((char)caracter);
			}
			
			
		} catch (FileNotFoundException ex) {
			System.err.println("La ruta del fichero no es válida o el fichero no existe");
		} catch (IOException e) {
			System.err.println("Error en la lectura del fichero");
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					System.err.println("Error en el cierre de flujo");
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

}
