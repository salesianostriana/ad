package dam.ad.t1.ejemplos.sesion05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * En este ejemplo vamos copiar un fichero de texto en otro
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 5. Ejemplo 4
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S05_Ejemplo04 {

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
		BufferedWriter bw = null;

		try {
			
			br = new BufferedReader(new FileReader(args[0]));
			bw = new BufferedWriter(new FileWriter(args[1]));
			
			
			String linea;
			
			while((linea = br.readLine()) != null) {
				bw.write(linea);
				//bw.write('\n');
				bw.newLine();
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
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.err.println("Error en el cierre de flujo");
					e.printStackTrace();
				}
			}
		}

	}

}
