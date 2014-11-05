package dam.ad.t1.ejercicios.sesion04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import dam.ad.t1.ejemplos.sesion02.T1S02_Ejemplo03;

/*
 * Ejercicio 7. CopyBytesBuff. Copia de ficheros con buffering.
 * 
 * Modificar (copiando y pegando en un nuevo proyecto o al menos en una nueva clase) el ejercicio 5, 
 * para que tanto la lectura como la escritura del fichero se haga con buffering.
 * 
 * NOTA: Se debe imprimir por consola el tiempo que se ha tardado en efectuar esta operaci�n (en formato humanizado).
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesi�n 4. 
 * 
 * @author Luis Miguel L�pez Maga�a
 * 
 */
public class T1_S04_Ejercicio07_CopyBytesBuff {

	// -1 = EOF (End of file - Final de fichero)
	private static final int EOF = -1;

	// Tama�o del buffer, tanto de lectura como escritura
	private static final int TAM = 4 * 1024*1024;

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err
					.println("Error de sintaxis: java T1S04_Ejercicio07_CopyBytesBuff <fichero_entrada> <fichero_salida>");
			return;
		}

		copy_bytes_buff(args[0], args[1], TAM, true);

	}

	/*
	 * Este m�todo realiza la copia de un fichero en otro, haciendo uso de
	 * buffering, e imprimiendo por consola el tiempo en el que ha realizado la
	 * operaci�n
	 * 
	 * @param path_origen 		Ruta del fichero a copiar
	 * @param path_destino 		Ruta d�nde vamos a crear la copia
	 * @param tamanio			Tama�o en bytes del buffer a usar
	 * @param humanized			Indica si la salida por consola se mostrar� humanizada, o por el contrario
	 * 							se mostrar� en formato tabular, indicando primero el tama�o del buffer y despu�s
	 * 							el tiempo en segundos.
	 */
	public static void copy_bytes_buff(String path_origen, String path_destino, int tamanio, boolean humanized) {
		// Creamos los dos flujos (de entrada y de salida). Y siempre lo haremos
		// as�, en dos pasos:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		BufferedOutputStream out = null;
		BufferedInputStream in = null;

		try {
			// Instanciamos ambos flujos.
			in = new BufferedInputStream(new FileInputStream(path_origen));
			out = new BufferedOutputStream(new FileOutputStream(path_destino));

			int c;

			byte[] buffer = new byte[tamanio];

			long ini = System.currentTimeMillis();

			while ((c = in.read(buffer, 0, tamanio)) != EOF) {
				out.write(buffer, 0, c);
			}

			long fin = System.currentTimeMillis();

			if (humanized) {
					System.out.println("Tiempo de la operaci�n: "
					+ T1S02_Ejemplo03.humanizeTime(fin - ini)
					+ " (Tama�o del buffer:" + tamanio + " bytes)");
			} else {
				System.out.println(tamanio+"\t"+(fin-ini)/1000.f);
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
