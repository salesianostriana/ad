package dam.ad.t1.ejemplos.sesion00;

/*
 * En este ejemplo se muestra como comprobar si se han pasado argumentos a este programa,
 * y en tal caso, se imprime por consola el primero de ellos.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesi�n 0. Ejemplo 1
 * 
 * @author Luis Miguel L�pez Maga�a
 * 
 */
public class T1S00_Ejemplo01 {

	public static void main(String[] args) {
		
		//Comprobamos que nos han pasado al menos 1 par�metro por la l�nea de argumentos
		if (args.length < 1) {
			System.out.println("No se ha pasado ning�n par�metro por la l�nea de argumentos");
		} else {
			//En caso positivo, imprimimos el primero por la consola.
			//Recordemos que, al tratarse de un array, comenzamos a contar en 0.
			System.out.println("El primer par�metro es: " + args[0]);
		}
		
	}
	
	
}
