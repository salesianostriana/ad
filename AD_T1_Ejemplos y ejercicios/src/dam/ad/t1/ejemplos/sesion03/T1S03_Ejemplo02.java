package dam.ad.t1.ejemplos.sesion03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * Ejemplo de como leer diferentes valores de tipos básicos de un fichero.
 * El fichero a leer se ha producido mediante la aplicación T1S02_Ejemplo1
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 3. Ejemplo 2
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S03_Ejemplo02 {

	public static void main(String[] args) {

		// Creamos el flujo de entrada. Y siempre lo haremos así, en dos pasos:
		// 1. Fuera del try...catch, definimos la referencia y la inicializamos
		// a null
		// 2. Dentro del try...catch la instanciamos
		// De esta manera, cuando queramos cerrar el flujo, tendremos acceso a
		// la referencia.
		DataInputStream in = null;

		try {
			//Instanciamos el flujo de desde el fichero
			
			//En este momento es dónde podemos apreciar la "decoración", es decir,
			//construimos un flujo a partir de otro flujo.
			in = new DataInputStream(new FileInputStream("tipos_basicos.dat"));
			
			/*
			 * Leemos los valores escritos. Recordemos que escribimos de la siguiente forma:
			 * 
			 * in.writeInt(1);
			 * in.writeLong(1l);
			 * in.writeFloat(1f);
			 * in.writeDouble(1d);
			 * in.writeUTF("Don Bosco");
			 * 
			 */
			
			//El primero, no es un entero; el método write(..) a secas escribe bytes,
			//como si se tratase de un FileOutputStream. Por ello, tenemos que leerlo
			//como tal.
			int i = in.readInt();
			System.out.println("Primer valor leído: " + i);
			
			//El segundo es un long
			long l = in.readLong();
			System.out.println("Segundo valor leído: " + l);
			
			//El tercero de un float
			float f = in.readFloat();
			System.out.println("Tercer valor leído: " + f);
			
			//El cuarto es un double
			double d = in.readDouble();
			System.out.println("Cuarto valor léido: " + d);
			
			//El último es una cadena de caracteres en formato UTF
			String s = in.readUTF();
			System.out.println("Quinto valor leído: " + s);
			
			
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
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
