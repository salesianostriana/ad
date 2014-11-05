package dam.ad.t1.ejercicios.sesion02;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Ejercicio 4. MatrixTransformBuffered: escribiendo matrices de enteros como datos binarios 
 * usando buffering
 * 
 * Modificar (copiando y pegando en un nuevo proyecto o al menos en una nueva clase) el ejercicio anterior, 
 * para realizar la escritura de las matrices mediante buffering.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 2. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S02_Ejercicio04_MatrixTransformBuffered {

	public static void main(String[] args) {

		if (args.length != 3) {
			System.err
					.println("Error de sintaxis: java T1S02_Ejercicio03_MatrixTransform <n_filas> <n_columnas> <fichero_salida>");
			return;
		}

		// Parseamos el número de filas y columnas. En caso de error, cambiamos
		// el dato por 4 (valor por defecto)
		int n_filas, n_columnas;

		try {
			n_filas = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			n_filas = 4;
		}

		try {
			n_columnas = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
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
			out = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(path)));

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
			for (int row = 0; row < n_filas; row++) {
				for (int col = 0; col < n_columnas; col++) {
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
