package dam.ad.t1.ejercicios.sesion01;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Ejercicio 1. Escribir los N primeros números enteros
 * 
 * Imprimir los N primeros números enteros en un fichero, llamado salida.dat, 
 * dónde N haya sido recogido por la línea de argumentos, 
 * de manera que la sintaxis de llamada al programa debe ser:
 * <pre>java ImprimirPrimerosNumeros <N></pre>
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 1. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S01_Ejercicio01_ImprimirPrimerosNumeros {

	public static void main(String[] args) {

		// Comprobamos que nos han pasado el argumentos que necesitamos. En caso
		// contrario, imprimimos la sintaxis de llamada a la aplicación
		if (args.length != 1) {
			System.err
					.println("Sintaxis erronea: java T1S01_Ejercicio01_ImprimirPrimerosNumeros <N>");
		} else {
			// En caso de que no se pueda parsear el argumento que nos han
			// proporcionado, estableceremos como tope los 100 primeros números.
			int n;
			try {
				n = Integer.parseInt(args[0]);
			} catch(NumberFormatException ex) {
				n = 100;
			}
			
			//Ahora, tal y como lo hicimos en el ejemplo, definimos el flujo
			FileOutputStream out = null; 
			
			try {
				out = new FileOutputStream("salida.dat");
				
				//Imprimimos los bytes correspondientes a los N primeros números.
				for(int i = 0; i < n; i++) {
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
