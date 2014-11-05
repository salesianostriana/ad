package dam.ad.t1.ejercicios.sesion04;


/*
 * AMPLI 3. Comparativa del tamaño del buffer.
 * 
 * Para el ejercicio 7, probar diferentes tamaños de buffer, 
 * y realizar con Excel o un programa similar una gráfica estadística 
 * que indique para diferentes tamaños de buffer, el tiempo de ejecución 
 * del programa para copiar el mismo fichero.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 4.  
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1_S04_AMPLI3 {

	private final static int K = 1024;

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err
					.println("Error de sintaxis: java T1S04_AMPLI3 <fichero_entrada> <fichero_salida>");
			return;
		}
		
		/* 
		 * Vamos a probar con todas las potencias de 2 multiplicando a 1KB, es decir:
		 * 1KB, 2KB, 4KB, 8KB, ..... 1MB
		 *
		 * 
		 */
		for(int i = 1; i <= K*K; i*=2) {
			//Usamos el método del ejercicio 7
			T1_S04_Ejercicio07_CopyBytesBuff.copy_bytes_buff(args[0], args[1], i*K, false);
		}

	}

	

}
