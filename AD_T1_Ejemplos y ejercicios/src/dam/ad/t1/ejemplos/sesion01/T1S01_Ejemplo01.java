package dam.ad.t1.ejemplos.sesion01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Ejemplo de como imprimir bytes en un fichero
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 1. Ejemplo 1
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S01_Ejemplo01 {

	public static void main(String[] args) {

		// Creamos el flujo de salida. Y siempre lo haremos así, en dos paso:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		FileOutputStream out = null;

		try {
			//Instanciamos el flujo de salida hacia un fichero
			out = new FileOutputStream("primero.dat");
			
			//Escribimos algunos bytes.
			for(int i = 0; i < 100; i++) {
				out.write(i);
			}
			
		} catch (FileNotFoundException ex) {			
			System.err.println("Fichero o ruta no encontrada");			
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
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
