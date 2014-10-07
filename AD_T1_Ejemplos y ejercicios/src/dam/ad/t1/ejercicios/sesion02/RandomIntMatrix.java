package dam.ad.t1.ejercicios.sesion02;

import java.util.Random;

/*
 * Clase de utilidades con m�todos para crear e imprimir matrices bidimensionales enteras con datos aleatorios
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesi�n 2.
 * 
 * @author Luis Miguel L�pez Maga�a
 * 
 */
public class RandomIntMatrix {

	
	
	
	/*
	 * Este m�todo recibe el tama�o de la matriz a construir, y devuelve
	 * una matriz bidimensional de datos aleatorios, con el tama�o
	 * proporcionado.
	 * 
	 * @param filas			N�mero de filas de la matriz
	 * @param columnas		N�mero de columnas de la matriz.
	 * @return				Matriz <code>int[][]</code> de datos aleatorios
	 */
	public static int[][] randomIntMatrix(int filas, int columnas) {
		int[][] m = new int[filas][columnas];

		Random r = new Random();

		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				m[i][j] = r.nextInt();

		return m;
	}
	
	
	/*
	 * Este m�todo recibe el tama�o de la matriz a construir, y devuelve
	 * una matriz bidimensional de datos aleatorios, con el tama�o
	 * proporcionado.
	 * 
	 * @param filas			N�mero de filas de la matriz
	 * @param columnas		N�mero de columnas de la matriz.
	 * @return				Matriz <code>byte[][]</code> de datos aleatorios
	 */
	public static byte[][] randomByteMatrix(int filas, int columnas) {
		byte[][] m = new byte[filas][columnas];

		Random r = new Random();

		for (int i = 0; i < filas; i++)
			for (int j = 0; j < columnas; j++)
				m[i][j] = (byte) (r.nextInt(256) - 128);

		return m;
	}
	

	/*
	 * Este m�todo recibe como argumento una matriz entera bidimensinonal
	 * y la imprime convenientemente por consola.
	 * 
	 * @param m				Matriz a imprimir
	 */
	public static void printIntMatrix(int[][] m) {
		int filas = m.length;
		int columnas = m[0].length;
		System.out.println("Filas: " + filas + " - Columnas: " + columnas);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++)
				System.out.print(m[i][j] + "\t");
			System.out.println();
		}
	}

}