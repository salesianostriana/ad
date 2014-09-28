/**
 * 
 */
package dam.ad.t1.ejercicios.sesion00;

/*
 * INTRO 1. Recoger e imprimir todos los argumentos
 * 
 * Implementar una aplicación Java que sea capaz de recoger todos los argumentos que se le pasen 
 * por la línea de comandos, y los imprima (cada uno en una línea diferente) por consola.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 0. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S00_INTRO1 {

	public static void main(String[] args) {

		// Comprobamos que nos han pasado al menos 1 parámetro por la línea de
		// argumentos
		if (args.length < 1) {
			System.out
					.println("No se ha pasado ningún parámetro por la línea de argumentos");
		} else {
			// En caso positivo, imprimimos todos los existentes por la consola.
			for (String argumento : args) {
				System.out.println(argumento);
			}
		}

	}

}
