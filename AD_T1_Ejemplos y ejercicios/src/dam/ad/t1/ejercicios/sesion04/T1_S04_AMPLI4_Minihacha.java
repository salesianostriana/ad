package dam.ad.t1.ejercicios.sesion04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * AMPLI 4. MiniHacha
 * 
 * Implementar una aplicación que sea capaz de trocear un fichero en otros ficheros más pequeños. 
 * 
 * La sintaxis de llamada debe ser:
 * 
 * 	<code>java MiniHacha <ruta_del_fichero_a_trocear> <tamaño_del_trozo_en_KB> <directorio_donde_almacenar_los_trozos></code>
 * 
 * El programa debe abrir el fichero a trocear, e ir copiando la cantidad de bytes indicada 
 * en el segundo argumento en nuevos ficheros. El nombre de los nuevos ficheros 
 * (es decir, de los diferentes trozos) debe ser el mismo del fichero original, 
 * teniendo como prefijo el número del fichero: 000<nombre>, 001<nombre>, .... 
 * El tercer agumento debe ser el nombre de un directorio existente dónde almacenar los trozos.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 4.  
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1_S04_AMPLI4_Minihacha {

	// Fin de fichero
	private static final int EOF = -1;
	// Tamaño de 1 KB
	private static final int K = 1024;
	// Tomamos de las propiedades del sistema el separador. Eso hará que nuestra
	// aplicación tenga menos problemas entre Win, Linux o Mac.
	private static final String separator = File.separator;

	public static void main(String[] args) {

		if (args.length != 3) {
			System.err
					.println("Error de sintaxis: java T1S04_AMPLI4_MiniHacha <ruta_del_fichero_a_trocear> <tamaño_del_trozo_en_KB> <directorio_donde_almacenar_los_trozos>");
			return;
		}

		String path_origen = args[0];
		int tam;
		try {
			tam = Integer.parseInt(args[1]);
		} catch (NumberFormatException ex) {
			// En caso de error de parseo, tomamos como tamaño del trozo 256 KB
			tam = 256;
		}

		String dir_destino = args[2];

		// El directorio debe existir, así que tiramos un poco de internet, y
		// comprobamos
		// haciendo uso de Java NIO.2 si existe, y en caso contrario, lo
		// creamos.

		if (!Files.exists(Paths.get(dir_destino))) {
			try {
				Files.createDirectory(Paths.get(dir_destino));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Contador de trozos
		int n_fichero = 1;

		// Creamos el flujo de entrada y el buffer, como solemos hacer
		// usualmente:
		BufferedInputStream in = null;
		byte[] buffer = new byte[tam * K];
		int c;

		try {
			in = new BufferedInputStream(new FileInputStream(path_origen));

			while ((c = in.read(buffer, 0, buffer.length)) != EOF) {
				// El flujo de salida lo tenemos que construir para cada parte
				// en la que vamos a escribir.

				// El nombre del fichero sigue el formato de las
				// especificaciones de más arriba
				String filename = String.format("%03d", n_fichero)
						+ getFileName(path_origen);
				// El path completo del fichero "parte"
				String path_destino = dir_destino + separator + filename;

				// Construimos el flujo sobre la ruta recién montada
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(path_destino));

				// Escribimos los datos
				out.write(buffer, 0, c);

				// Cerramos este flujo
				out.close();

				// Incrementamos el número de fichero
				n_fichero++;

			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * Este método, un poco rústico, recibe una ruta y devuelve lo que sería el
	 * nombre del fichero, es decir, la última parte, que viene después del
	 * último separador de path
	 * 
	 * @param <code>path</code>, ruta de la cual queremos extraer el nombre de
	 * fichero
	 * 
	 * @return Nombre del fichero como una cadena de caracteres
	 */
	public static String getFileName(String path) {
		if (path.contains(separator)) {
			String[] spliteado = path.split(separator);
			return spliteado[spliteado.length - 2];
		} 
		
		return path;
	}

}
