/**
 * 
 */
package dam.ad.t1.ejercicios.sesion00;

/*
 * INTRO 2. Sumador de N n�meros
 * 
 * Implementar una aplicaci�n Java que sea capaz de recoger todos los argumentos 
 * que se le pasen por la l�nea de comandos, y que sume todos aquellos que sean 
 * n�meros enteros (si se le pasan otro tipo de argumentos, debe descartarlos). 
 * El resultado de la suma se debe imprimir por consola.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesi�n 0. 
 * 
 * @author Luis Miguel L�pez Maga�a
 * 
 */
public class T1S00_INTRO2 {

	public static void main(String[] args) {

		// Comprobamos que nos han pasado al menos 1 par�metro por la l�nea de
		// argumentos
		if (args.length < 1) {
			System.out
					.println("No se ha pasado ning�n par�metro por la l�nea de argumentos");
		} else {
			// En caso positivo...
			
			int acumulador = 0;
			
			for (String argumento : args) {
				try {
					//Parseamos el n�mero
					int n = Integer.parseInt(argumento);
					acumulador += n;
				} catch (NumberFormatException ex) {
					//No hacemos nada; dejamos que siga parseando y sumando el siguiente
				}
				
			}
			System.out.println("El resultado de la suma es: " + acumulador);
		}

	}

}
