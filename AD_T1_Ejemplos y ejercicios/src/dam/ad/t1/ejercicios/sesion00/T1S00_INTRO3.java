/**
 * 
 */
package dam.ad.t1.ejercicios.sesion00;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * INTRO 3. Ordenar N números
 * 
 * Implementar una aplicación Java que sea capaz de recoger todos los 
 * argumentos que se le pasen por la línea de comandos, y que ordene 
 * de menor a mayor todos aquellos que sean números enteros 
 * (si se le pasan otro tipo de argumentos, debe descartarlos). 
 * El resultado de la ordenación debe imprimirse por consola.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 0. 
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S00_INTRO3 {

	public static void main(String[] args) {

		// Comprobamos que nos han pasado al menos 1 parámetro por la línea de
		// argumentos
		if (args.length < 1) {
			System.out
					.println("No se ha pasado ningún parámetro por la línea de argumentos");
		} else {
			// En caso positivo...
			
			List<Integer> lista = new LinkedList<Integer>();
			
			for (String argumento : args) {
				try {
					//Parseamos el número
					Integer n = Integer.valueOf(argumento);
					//Lo añadimos a la lista
					lista.add(n);
				} catch (NumberFormatException ex) {
					//No hacemos nada; dejamos que siga parseando y sumando el siguiente
				}
				
			}
			//Ordenamos la lista
			Collections.sort(lista);
			
			//Imprimimos el resultado
			System.out.println("La lista resultante es: ");
			
			//Para que quede bien formateado, imprimimos todos los elementos
			//seguido de una coma, menos el último (que después, no lleva coma)
			for(int i = 0; i < lista.size() - 2; i++) {
				System.out.print(lista.get(i)+", ");
			}
			//Imprimimos el último elemento de la lista.
			System.out.println(lista.get(lista.size()-1));
		}

	}

}
