package dam.ad.t1.ejercicios.sesion02;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Ampliación 3. Generación de primos almacenados como tipo long usando buffering
 * 
 * Mejorar el ejercicio AMPLI2 ((copiando y pegando en un nuevo proyecto o al menos 
 * en una nueva clase) usando buffering.
 * 
 *  
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 2. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S02_AMPLI3 {

	public static void main(String[] args) {

		// Comprobamos que nos han pasado el argumentos que necesitamos. En caso
		// contrario, imprimimos la sintaxis de llamada a la aplicación
		if (args.length != 2) {
			System.err
					.println("Sintaxis erronea: java T1S021_AMPLI3_ImprimirPrimerosNumerosPrimos <nombre_fichero> <N>");
		} else {

			// Tomamos el nombre (o path) del fichero donde almacenaremos el
			// contenido
			String path = args[0];

			// En caso de que no se pueda parsear el argumento que nos han
			// proporcionado, estableceremos como tope los 100 primeros números
			// primos.
			int n;
			try {
				n = Integer.parseInt(args[1]);
			} catch (NumberFormatException ex) {
				n = 100;
			}

			// Ahora, tal y como lo hicimos en el ejemplo, definimos el flujo
			DataOutputStream out = null;

			try {
				// Lo instanciamos, pero usando el path proporcionado en la
				// línea de argumentos
				out = new DataOutputStream(new BufferedOutputStream(
						new FileOutputStream(path)));

				// Imprimimos los bytes correspondientes a los N primeros
				// números primos. El enfoque es diferente al ejercicio 2, ya
				// que no sabemos cuantos números tenemos que recorrer para
				// encontrar
				// los N primeros primos.
				int contadorPrimos = 0;

				long i = 1;

				while (contadorPrimos <= n) {
					if (isPrimo(i)) {
						System.out.println(i);
						out.writeLong(i);
						contadorPrimos++;
					}
					i++;
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

	/*
	 * Este método sirve para comprobar que un número es primo. Se hace mediante
	 * un test de primalidad muy básico, que busca los divisores desde 2 hasta
	 * sqrt(n).
	 * 
	 * @param n Número sobre el que vamos a testear su primalidad
	 * 
	 * @return <code>true</code>, en caso de que el número sea primo
	 * <code>false</code>, en otro caso.
	 */
	public static boolean isPrimo(long n) {

		// Eliminamos el signo
		n = Math.abs(n);

		// Tope hasta el cual buscamos divisores
		long tope = (long) Math.round(Math.sqrt(n));

		// Contador. Comenzamos en 2, puesto que el 1 es divisor de cualquier
		// número
		long cont = 2;

		// Flag que nos servirá para parar el bucle en caso de encontrar un
		// divisor.
		boolean divisorEncontrado = false;

		// Bucle que busca los divisores
		while (!divisorEncontrado && cont <= tope) {
			// Si nuestro número es divisible (es decir, el resto de dividirlo
			// es 0),
			// entonces no es primo
			if (n % cont == 0) {
				divisorEncontrado = true;
			} else {
				cont++;
			}
		}

		// Si encontramos un divisor (divisorEncontrado = true), entonces no es
		// primo.
		// Por eso lo devolvemos negado.
		return !divisorEncontrado;
	}

}
