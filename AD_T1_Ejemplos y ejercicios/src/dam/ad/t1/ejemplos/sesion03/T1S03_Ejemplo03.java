package dam.ad.t1.ejemplos.sesion03;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * En este ejemplo vamos a leer el contenido de un fichero que tiene n�meros enteros almacenados. 
 * Nos va a servir para ilustrar como manejar el final de fichero cuando no nos sirva el valor
 * EOF = -1; tendremos que hacer uso de una excepci�n.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesi�n 3. Ejemplo 1
 * 
 * @author Luis Miguel L�pez Maga�a
 * 
 */
public class T1S03_Ejemplo03 {

	public static void main(String[] args) {

		// Creamos el flujo de entrada. Y siempre lo haremos as�, en dos pasos:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		DataInputStream in = null;

		try {
			// Instanciamos el flujo de entrada desde el fichero
			in = new DataInputStream(new FileInputStream("primos.dat"));
			// Leemos todo su contenido
			try {
				
				int c;
				// En este caso, como el final de fichero se maneja mediante
				// una excepci�n, usamos un bucle infinito para leer ficheros.
				// El EOF (final de fichero), ser� manejado mediante una 
				// EOFException
				while (true) {
					//Leemos el n�mero entero
					c = in.readInt();
					// Realizamos el procesamiento que haya que realizar de la
					// informaci�n
					System.out.println(c);
				}
			} catch (EOFException ex) {
				//Acciones a ejecutar en caso de que lleguemos al final del fichero
				//En este caso, no hacemos nada, y dejamos que el programa termine.
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			/*
			 * El cierre de los flujos es muy importante, porque libera los
			 * recursos asociados a ellos. Siempre lo realizaremos en un bloque
			 * finally, para que se ejecute tanto si se produce una excepci�n
			 * como si no. Comprobaremos que la referencia no es nula y, en tal
			 * caso, invocaremos el m�todo de cierre (close()).
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
