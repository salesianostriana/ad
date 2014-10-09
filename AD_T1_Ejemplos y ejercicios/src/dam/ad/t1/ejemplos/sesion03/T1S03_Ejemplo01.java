package dam.ad.t1.ejemplos.sesion03;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * En este ejemplo vamos a leer el contenido de un fichero en formato binario, y vamos a imprimirlo
 * por pantalla.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 3. Ejemplo 1
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S03_Ejemplo01 {

	// -1 = EOF (End of file - Final de fichero)
	private static final int EOF = -1;
	
	
	public static void main(String[] args) {

		// Creamos el flujo de entrada. Y siempre lo haremos así, en dos pasos:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		FileInputStream in = null;

		try {
			// Instanciamos el flujo de entrada desde el fichero
			in = new FileInputStream("primero.dat");

			//Leemos todo su contenido
			int c;
			//Mientras haya datos que leer...
			while ((c = in.read()) != EOF) {
				//Realizamos el procesamiento que haya que realizar de la información
				System.out.println(c);
			}

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
