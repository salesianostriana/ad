package dam.ad.t1.ejemplos.sesion02;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Ejemplo de como escribir diferentes valores de tipos básicos en un fichero.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 2. Ejemplo 1
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S02_Ejemplo01 {

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
			out = new DataOutputStream(new FileOutputStream("tipos_basicos.dat"));
			
			//Escribimos algunos valores de tipos básicos
			out.writeInt(1);
			
			out.writeLong(1l);
			
			out.writeFloat(1f);
			
			out.writeDouble(1d);
			
			out.writeUTF("Don Bosco");
			
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

}
