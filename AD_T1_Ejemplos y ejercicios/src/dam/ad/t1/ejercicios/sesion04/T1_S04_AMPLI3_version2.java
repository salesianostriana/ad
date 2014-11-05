package dam.ad.t1.ejercicios.sesion04;


/*
 * AMPLI 3. Comparativa del tama�o del buffer.
 * 
 * Para el ejercicio 7, probar diferentes tama�os de buffer, 
 * y realizar con Excel o un programa similar una gr�fica estad�stica 
 * que indique para diferentes tama�os de buffer, el tiempo de ejecuci�n 
 * del programa para copiar el mismo fichero.
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesi�n 4. Ampliaci�n 3, versi�n 2.
 * 
 * @author Luis Miguel L�pez Maga�a
 * 
 */
public class T1_S04_AMPLI3_version2 {

	private final static int K = 1024;

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err
					.println("Error de sintaxis: java T1S04_AMPLI3 <fichero_entrada> <fichero_salida>");
			return;
		}
		
		/* 
		 * Tras estudiar la gr�fica obtenida con la versi�n 1, comprobamos que entre 8KB
		 * y 8MB parece no haber mucha diferencia. Vamos a intentar afinar, para obtener
		 * una gr�fica con mayor nivel de detalle. Para ello, a�adiremos muchos m�s valorse intermedios.
		 * 
		 */
		for(int i = 8*K; i <= 8*K*K; i+= 8*K) {
			//Usamos el m�todo del ejercicio 7
			T1_S04_Ejercicio07_CopyBytesBuff.copy_bytes_buff(args[0], args[1], i, false);
		}

	}

	

}
