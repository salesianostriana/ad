package dam.ad.t1.ejemplos.sesion04;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * En este ejemplo vamos a leer el contenido de un fichero en formato binario, haciendo uso del buffering.
 * No se va a realizar nada especial con su contenido.
 * 
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 4. Ejemplo 1
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S04_Ejemplo01 {

	// -1 = EOF (End of file - Final de fichero)
	private static final int EOF = -1;
	
	//Tamaño del buffer de lectura
	private static final int TAM = 4*1024;
	
	
	public static void main(String[] args) {

		// Creamos el flujo de entrada. Y siempre lo haremos así, en dos pasos:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		BufferedInputStream in = null;

		try {
			// Instanciamos el flujo de entrada desde el fichero
			in = new BufferedInputStream(new FileInputStream("triana.jpg"));

			//Leemos todo su contenido, pero usando buffering (arrays de bytes)
			byte[] buffer = new byte[TAM];
			
			//El método read que es capaz de leer buffers, devuelve como número entero
			//la cantidad de bytes leidos, o -1, en caso de EOF.
			int cantidad_bytes;
			long size = 0;
			//Mientras haya datos que leer...
			while ((cantidad_bytes = in.read(buffer,0, buffer.length)) != EOF) {
				//Procesamiento a realizar....
				size += cantidad_bytes;
			}
			
			System.out.println("El tamaño del fichero es de " + size + " bytes");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			/*
			 * El cierre de los flujos es muy importante, porque libera los
			 * recursos asociados a ellos. Siempre lo realizaremos en un bloque
			 * finally, para que se ejecute tanto si se produce una excepción
			 * como si no. Comprobaremos que la referencia no es nula y, en tal
			 * caso, invocaremos el método de cierre (close()).
			 */
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
