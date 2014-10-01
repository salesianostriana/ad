package dam.ad.t1.ejemplos.sesion02;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Ejemplo de como escribir los N primeros números enteros
 * como un long, usando Buffering.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 2. Ejemplo 3
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S02_Ejemplo03 {

	private static final long N = 1234567891L;
	
	
	public static void main(String[] args) {

		// Creamos el flujo de salida. Y siempre lo haremos así, en dos paso:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		DataOutputStream out = null;

		try {
			//Instanciamos el flujo de salida hacia un fichero
			//En este momento es dónde podemos apreciar la "decoración", es decir,
			//construimos un flujo a partir de otro flujo.
			out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream("primeros_numeros_buffering.dat")));
			
			//Tomamos el momento inicial
			long ini = System.currentTimeMillis();
			
			
			//Escribimos los N primeros números, pero usando buffering.
			//A diferencia del ejemplo anterior, nos despreocupamos de llenar
			//buffer de algún tipo. Todo se hace internamente.
			for(long l = 0; l < N; l++) {
				out.writeLong(l);
			}
			
			
			//Tomamos el momento final e imprimimos el tiempo "humanizado"
			long fin = System.currentTimeMillis();
			
			System.out.println("Tiempo transcurrido: " + humanizeTime(fin-ini));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			/*
			 * El cierre de los flujos es muy importante, porque libera los
			 * recursos asociados a ellos. Siempre lo realizaremos en un bloque
			 * finally, para que se ejecute tanto si se produce una excepción
			 * como si no. Comprobaremos que la referencia no es nula y, en tal
			 * caso, invocaremos el método de cierre (close()).
			 */
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	/*
	 * Este método recibe un tiempo en milisegundos y lo devuelve
	 * en formato humanizado.
	 * 
	 * @param n		Tiempo en milisegundos, en formato <code>long</code>
	 * @return		Cadena de caracteres con el tiempo humanizado.
	 */
	public static String humanizeTime(long n) {
		if (n < 1000) {
			return n + " ms.";
		} else if (n < 60*1000) {
			return (n/1000f) + " s.";
		} else {
			return (n/(60*1000)) + " m. " + (n%(60*1000))/1000f + " s.";
		}
	}
	

}
