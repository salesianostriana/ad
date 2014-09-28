package dam.ad.t1.ejemplos.sesion00;

/*
 * En este ejemplo se muestra como comprobar si se han pasado argumentos a este programa,
 * y en tal caso, se imprime por consola el primero de ellos.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 0. Ejemplo 1
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S00_Ejemplo01 {

	public static void main(String[] args) {
		
		//Comprobamos que nos han pasado al menos 1 parámetro por la línea de argumentos
		if (args.length < 1) {
			System.out.println("No se ha pasado ningún parámetro por la línea de argumentos");
		} else {
			//En caso positivo, imprimimos el primero por la consola.
			//Recordemos que, al tratarse de un array, comenzamos a contar en 0.
			System.out.println("El primer parámetro es: " + args[0]);
		}
		
	}
	
	
}
