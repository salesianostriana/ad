package dam.ad.t1.ejercicios.sesion03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import dam.ad.t1.ejercicios.sesion02.RandomIntMatrix;

/*
 * Ejercicio 6. MatrixViewer: visor de matrices enteras como datos binarios
 * 
 *  Implementar una aplicación, complementaria a las de los ejercicio 3 y 4, 
 *  que sea capaz de leer de un fichero una matriz transformada, e imprimirla 
 *  por consola en forma matricial (por filas y columnas). Recordamos que el 
 *  formato de estos ficheros era:
 *  
 *  	- Un número entero, que indica el número de filas
 *  	- Otro número de entero, que indica el número de columnas
 *  	- Todos los números de la matriz, escribiendo primero todos los datos de 
 *  	  la primera fila, después de los de la segunda, y así sucesivamente.
 *  
 *  La sintaxis de llamada, por tanto, sería:
 *  
 *  	<code>java MatrixViewer <fichero_matriz></code>
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 3. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S03_Ejercicio06_MatrixViewer {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.err
					.println("Error de sintaxis: java T1S03_Ejercicio06_MatrixViewer <fichero_matriz>");
			return;
		}

		String path = args[0];

		// Creamos el flujo de entrada. Y siempre lo haremos así, en dos pasos:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		DataInputStream in = null;

		int n_filas, n_columnas;
		int[][] matriz;

		try {
			// Instanciamos el flujo de entrada desde el fichero
			// En este momento es dónde podemos apreciar la "decoración", es
			// decir,
			// construimos un flujo a partir de otro flujo.
			in = new DataInputStream(new FileInputStream(path));

			/*
			 * La lectura la vamos a realizar de forma conveniente, es decir:
			 * 
			 *    1º: Nº de filas
			 *    2º: Nº de columnas
			 *    3º: Instanciamos la matriz con estos datos
			 *    4º: Vamos leyendo las diferentes filas, y guardándolas en la matriz instanciada
			 * 
			 */
			n_filas = in.readInt();
			n_columnas = in.readInt();
			
			matriz = new int[n_filas][n_columnas];
			
			for(int row = 0; row < n_filas; row++) {
				for(int col = 0; col < n_columnas; col++) {
					matriz[row][col] = in.readInt();
				}
			}
			
			//Para comprobar que todo es correcto, imprimimos la matriz por pantalla.
			RandomIntMatrix.printIntMatrix(matriz);
			

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
