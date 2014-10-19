package dam.ad.t1.ejemplos.sesion05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * En este ejemplo vamos a leer el contenido de un fichero de texto, y lo vamos
 * a imprimir por consola tal cual, todo ello haciendo uso de la técnica de buffering
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 5. Ejemplo 3
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S05_Ejemplo03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length != 1) {
			System.err
					.println("Error de sintaxis. java T1S05_Ejemplo03 <ruta_del_fichero_a_leer>");
			return;
		}

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(args[0]));

			String linea;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (FileNotFoundException ex) {
			System.err
					.println("La ruta del fichero no es válida o el fichero no existe");
		} catch (IOException e) {
			System.err.println("Error en la lectura del fichero");
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
		}

	}

}
