package dam.ad.t1.ejercicios.sesion01;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Ejercicio 2. Escribir los N primeros números enteros con nombre de fichero personalizado
 *
 * Modificar (copiando y pegando en un nuevo proyecto o al menos en una nueva clase) el ejercicio 
 * anterior para que el nombre del fichero también sea recogido por la línea de argumentos, con la 
 * siguiente sintaxis:
 * <pre>java ImprimirPrimerosNumeros <nombre_fichero> <N></pre>
 * 
 *  
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 1. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S01_Ejercicio02_ImprimirPrimerosNumeros {

	public static void main(String[] args) {

		// Comprobamos que nos han pasado el argumentos que necesitamos. En caso
		// contrario, imprimimos la sintaxis de llamada a la aplicación
		if (args.length != 2) {
			System.err
					.println("Sintaxis erronea: java T1S01_Ejercicio02_ImprimirPrimerosNumeros <nombre_fichero> <N>");
		} else {
			
			//Tomamos el nombre (o path) del fichero donde almacenaremos el contenido
			String path = args[0];
			
			// En caso de que no se pueda parsear el argumento que nos han
			// proporcionado, estableceremos como tope los 100 primeros números.
			int n;
			try {
				n = Integer.parseInt(args[1]);
			} catch (NumberFormatException ex) {
				n = 100;
			}

			// Ahora, tal y como lo hicimos en el ejemplo, definimos el flujo
			FileOutputStream out = null;

			try {
				//Lo instanciamos, pero usando el path proporcionado en la línea de argumentos
				out = new FileOutputStream(path);

				// Imprimimos los bytes correspondientes a los N primeros
				// números.
				for (int i = 0; i < n; i++) {
					out.write(n);
				}

			} catch (IOException ex) {
				System.err.println("Error de entrada salida");
			} finally {
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
	
	
	

}
