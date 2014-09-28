/**
 * 
 */
package dam.ad.t1.ejercicios.sesion00;

/*
 * INTRO 1. Recoger e imprimir todos los argumentos
 * 
 * Implementar una aplicaci�n Java que sea capaz de recoger todos los argumentos que se le pasen 
 * por la l�nea de comandos, y los imprima (cada uno en una l�nea diferente) por consola.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesi�n 0. 
 * 
 * @author Luis Miguel L�pez Maga�a
 * 
 */
public class T1S00_INTRO1 {

	public static void main(String[] args) {

		// Comprobamos que nos han pasado al menos 1 par�metro por la l�nea de
		// argumentos
		if (args.length < 1) {
			System.out
					.println("No se ha pasado ning�n par�metro por la l�nea de argumentos");
		} else {
			// En caso positivo, imprimimos todos los existentes por la consola.
			for (String argumento : args) {
				System.out.println(argumento);
			}
		}

	}

}
