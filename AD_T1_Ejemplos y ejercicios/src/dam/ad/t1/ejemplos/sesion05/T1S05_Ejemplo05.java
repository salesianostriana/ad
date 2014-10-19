package dam.ad.t1.ejemplos.sesion05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Mejora del ejemplo anterior haciendo uso de un PrintWriter
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 5. Ejemplo 5
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S05_Ejemplo05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length != 2) {
			System.err
					.println("Error de sintaxis. java T1S05_Ejemplo04 <ruta_del_fichero_a_leer> <ruta_del_fichero_a_escribir>");
			return;
		}

		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			
			br = new BufferedReader(new FileReader(args[0]));
			pw = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
			
			
			String linea;
			
			while((linea = br.readLine()) != null) {
				pw.println(linea);
			}
			
			

		} catch (FileNotFoundException ex) {
			System.err.println("La ruta del fichero no es válida");
		} catch (IOException e) {
			System.err.println("Error en la escritura del fichero");
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("Error en el cierre de flujo");
					e.printStackTrace();
				}
			}
			if (pw != null) {
				pw.close();
			}
		}

	}

}
