package dam.ad.t1.ejemplos.sesion02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
 * Ejemplo de como usar buffering para escribir un array completo de datos en una sola operación.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 2. Ejemplo 1
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S02_Ejemplo02_Buffering {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.err
					.println("Error en la sintaxis: java T1S02_Ejemplo02_Buffering <fichero>");
			return;
		}

		// Primero vamos a leer un fichero completo para almacenarlo en memoria
		byte[] fichero = null;
		try {
			fichero = leerFichero(args[0]);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Creamos el flujo de salida. Y siempre lo haremos así, en dos paso:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		BufferedOutputStream out = null;

		try {
			// Instanciamos el flujo de salida hacia un fichero
			// En este momento es dónde podemos apreciar la "decoración", es
			// decir,
			// construimos un flujo a partir de otro flujo.
			out = new BufferedOutputStream(new FileOutputStream(
					"out_buffering.dat"));

			// El tamaño del buffer lo podemos fijar nosotros. Probaremos, en
			// este caso,
			// con 1024 bytes (1KB)
			int TAM = 1024;
			// Esta variable nos indicará cuando debemos salir del bucle
			long bytes_copiados = 0;
			// Numero de iteraciones que llevamos. Nos sirve para ir
			// avanzando en el rango que copiamos del array original "fichero"
			int n = 0;

			// Ahora, tenemos que recorrer el array fichero, y copiarlo en
			// buffer, para
			// poder escribir buffer en el fichero
			while (bytes_copiados <= fichero.length) {
				// Copiamos el rango adecuado
				byte[] buffer = Arrays.copyOfRange(fichero, n * TAM,
						((n + 1) * TAM) - 1);

				// Escribimos el buffer en la salida
				out.write(buffer, 0, buffer.length);

				// Incrementamos índices y contadores.
				n++;
				bytes_copiados += buffer.length;
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

	/*
	 * Este método nos servirá para leer un fichero cualquiera de forma completa
	 * en memoria, y almacenarlo en un array de bytes.
	 * 
	 * @param path Ruta del fichero a leer
	 * 
	 * @return Fichero completo en un <code>byte []</code> <code>null</code> en
	 * otro caso.
	 */
	public static byte[] leerFichero(String path) throws IOException {
		return Files.readAllBytes(Paths.get(path));
	}

}
