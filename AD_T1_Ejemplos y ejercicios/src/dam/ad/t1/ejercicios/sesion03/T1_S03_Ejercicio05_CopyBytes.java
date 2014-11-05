package dam.ad.t1.ejercicios.sesion03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import dam.ad.t1.ejemplos.sesion02.T1S02_Ejemplo03;

/*
 * Ejercicio 5. CopyBytes. Copiando ficheros byte a byte
 * 
 * Implementar una aplicación que recoja por la línea de argumentos la ruta 
 * de un fichero, el que va a ser copiado, y la ruta de otro, en el cual va 
 * a ser copiado. El programa debe leer todos los bytes del fichero de la 
 * ruta del primer argumento, y copiarlos en el fichero de la ruta del 
 * segundo argumento. La sintaxis de llamada sería:
 * 		<code>java CopyBytes <fichero_entrada> <fichero_salida></code>
 * 
 * NOTA: Se debe imprimir por consola el tiempo que se ha tardado en efectuar 
 * esta operación (en formato humanizado).
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 3. Ejercicio 5. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1_S03_Ejercicio05_CopyBytes {

	// -1 = EOF (End of file - Final de fichero)
	private static final int EOF = -1;

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err
					.println("Error de sintaxis: java T1S03_Ejercicio05_CopyBytes <fichero_entrada> <fichero_salida>");
			return;
		}

		// Creamos los dos flujos (de entrada y de salida). Y siempre lo haremos
		// así, en dos pasos:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		FileOutputStream out = null;
		FileInputStream in = null;

		try {
			// Instanciamos ambos flujos.
			in = new FileInputStream(args[0]);
			out = new FileOutputStream(args[1]);

			// Vamos leyendo byte a byte, y del mismo modo, lo vamos escribiendo
			int c;
			
			//Tomamos el momento inicial
			long ini = System.currentTimeMillis();
			
			while((c = in.read()) != EOF) {
				out.write(c);
			}
			
			//Y ahora el momento final
			long fin = System.currentTimeMillis();
			
			//Imprimimos el resultado humanizado por consola
			System.out.println("Tiempo: " + T1S02_Ejemplo03.humanizeTime(fin-ini));
			
			

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
