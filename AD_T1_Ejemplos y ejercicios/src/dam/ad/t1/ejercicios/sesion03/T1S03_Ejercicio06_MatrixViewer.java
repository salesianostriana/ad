package dam.ad.t1.ejercicios.sesion03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import dam.ad.t1.ejercicios.sesion02.RandomIntMatrix;

/*
 * Ejercicio 6. MatrixViewer: visor de matrices enteras como datos binarios
 * 
 *  Implementar una aplicaci�n, complementaria a las de los ejercicio 3 y 4, 
 *  que sea capaz de leer de un fichero una matriz transformada, e imprimirla 
 *  por consola en forma matricial (por filas y columnas). Recordamos que el 
 *  formato de estos ficheros era:
 *  
 *  	- Un n�mero entero, que indica el n�mero de filas
 *  	- Otro n�mero de entero, que indica el n�mero de columnas
 *  	- Todos los n�meros de la matriz, escribiendo primero todos los datos de 
 *  	  la primera fila, despu�s de los de la segunda, y as� sucesivamente.
 *  
 *  La sintaxis de llamada, por tanto, ser�a:
 *  
 *  	<code>java MatrixViewer <fichero_matriz></code>
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesi�n 3. 
 * 
 * @author Luis Miguel L�pez Maga�a
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

		// Creamos el flujo de entrada. Y siempre lo haremos as�, en dos pasos:
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
			// En este momento es d�nde podemos apreciar la "decoraci�n", es
			// decir,
			// construimos un flujo a partir de otro flujo.
			in = new DataInputStream(new FileInputStream(path));

			/*
			 * La lectura la vamos a realizar de forma conveniente, es decir:
			 * 
			 *    1�: N� de filas
			 *    2�: N� de columnas
			 *    3�: Instanciamos la matriz con estos datos
			 *    4�: Vamos leyendo las diferentes filas, y guard�ndolas en la matriz instanciada
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
