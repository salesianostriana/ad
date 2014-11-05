package dam.ad.t1.ejercicios.sesion02;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Ejercicio 3. MatrixTransform: escribiendo matrices de enteros como datos binarios
 * 
 * Desarrollar un programa, llamado MatrixTransform, que sea capaz de almacenar matrices 
 * de datos enteros (arrays bidimensionales, de tipo int[][]) en ficheros en formato binario.
 * El formato de los ficheros debe ser:
 * 			Un número entero que indicará el número de filas que tendrá la matriz.
 * 			Otro número entero que indicará las columnas que tendrá la matriz.
 * 			A partir de ahí, cada uno de los elementos de la matriz, almacenada por filas:
 * 
 * La sintaxis de llamada al programa deberá ser:
 * 
 * 	<code>java MatrixTransform <n_filas> <n_columnas> <fichero_salida></code>
 * 
 * Se proporciona la clase RandomIntMatrix, con métodos estáticos para generar una matriz de 
 * enteros aleatorios, así como para imprimirla por pantalla.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 2. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S02_Ejercicio03_MatrixTransform {

	public static void main(String[] args) {
		
		
		if (args.length != 3) {
			System.err.println("Error de sintaxis: java T1S02_Ejercicio03_MatrixTransform <n_filas> <n_columnas> <fichero_salida>");
			return;
		}
		
		
		//Parseamos el número de filas y columnas. En caso de error, cambiamos el dato por 4 (valor por defecto)
		int n_filas, n_columnas;
		
		try {
			n_filas = Integer.parseInt(args[0]);			
		} catch(NumberFormatException e) {
			n_filas = 4;
		}
		
		try {
			n_columnas = Integer.parseInt(args[1]);			
		} catch(NumberFormatException e) {
			n_columnas = 4;
		}
		
		String path = args[2];

		// Creamos el flujo de salida. Y siempre lo haremos así, en dos paso:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		DataOutputStream out = null;

		try {
			// Instanciamos el flujo de salida hacia un fichero
			// En este momento es dónde podemos apreciar la "decoración", es
			// decir,
			// construimos un flujo a partir de otro flujo.
			out = new DataOutputStream(new FileOutputStream(
					path));

			// Creamos la matriz aleatoria
			
			int[][] matriz = RandomIntMatrix.randomIntMatrix(n_filas,
					n_columnas);

			// Pasamos a imprimir los datos en el flujo

			// 1º, el num. de filas
			out.writeInt(n_filas);

			// 2º, el num. de columnas
			out.writeInt(n_columnas);

			// Por último, la matriz completa, recorrida de izquierda a derecha
			// y de arriba a abajo
			for(int row = 0; row < n_filas; row++) {
				for(int col = 0; col < n_columnas; col++) {
					out.writeInt(matriz[row][col]);
				}
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
