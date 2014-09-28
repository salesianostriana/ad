/**
 * 
 */
package dam.ad.t1.ejercicios.sesion00;

/*
 * INTRO 2. Sumador de N números
 * 
 * Implementar una aplicación Java que sea capaz de recoger todos los argumentos 
 * que se le pasen por la línea de comandos, y que sume todos aquellos que sean 
 * números enteros (si se le pasan otro tipo de argumentos, debe descartarlos). 
 * El resultado de la suma se debe imprimir por consola.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 0. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S00_INTRO2 {

	public static void main(String[] args) {

		// Comprobamos que nos han pasado al menos 1 parámetro por la línea de
		// argumentos
		if (args.length < 1) {
			System.out
					.println("No se ha pasado ningún parámetro por la línea de argumentos");
		} else {
			// En caso positivo...
			
			int acumulador = 0;
			
			for (String argumento : args) {
				try {
					//Parseamos el número
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
