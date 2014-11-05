package dam.ad.t1.ejemplos.sesion05;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/*
 * En este ejemplo vamos a escribir el contenido de una cadena de caracteres en un fichero
 * 
 * Salesianos Triana
 * Desarrollo de Aplicaciones Multiplataforma
 * Acceso a Datos
 * Tema 1. Sesión 5. Ejemplo 2
 * 
 * @author Luis Miguel López Magaña
 * 
 */
public class T1S05_Ejemplo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String mensaje = "Gallia est omnis divisa in partes tres\n, quarum unam incolunt Belgae, aliam Aquitani, tertiam qui ipsorum lingua Celtae, nostra Galli appellantur. Hi omnes lingua, institutis, legibus inter se differunt. Gallos ab Aquitanis Garumna flumen, a Belgis Matrona et Sequana dividit. Horum omnium fortissimi sunt Belgae, propterea quod a cultu atque humanitate provinciae longissime absunt, minimeque ad eos mercatores saepe commeant atque ea quae ad effeminandos animos pertinent important, proximique sunt Germanis, qui trans Rhenum incolunt, quibuscum continenter bellum gerunt. Qua de causa Helvetii quoque reliquos Gallos virtute praecedunt, quod fere cotidianis proeliis cum Germanis contendunt, cum aut suis finibus eos prohibent aut ipsi in eorum finibus bellum gerunt. Eorum una, pars, quam Gallos obtinere dictum est, initium capit a flumine Rhodano, continetur Garumna flumine, Oceano, finibus Belgarum, attingit etiam ab Sequanis et Helvetiis flumen Rhenum, vergit ad septentriones. Belgae ab extremis Galliae finibus oriuntur, pertinent ad inferiorem partem fluminis Rheni, spectant in septentrionem et orientem solem. Aquitania a Garumna flumine ad Pyrenaeos montes et eam partem Oceani quae est ad Hispaniam pertinet; spectat inter occasum solis et septentriones. ";

		if (args.length != 1) {
			System.err
					.println("Error de sintaxis. java T1S05_Ejemplo02 <ruta_del_fichero_a_escribir>");
			return;
		}

		FileWriter fw = null;

		try {
			fw = new FileWriter(args[0]);

			for(int c : mensaje.toCharArray()) {
				fw.write(c);
			}

		} catch (FileNotFoundException ex) {
			System.err
					.println("La ruta del fichero no es válida");
		} catch (IOException e) {
			System.err.println("Error en la escritura del fichero");
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.err.println("Error en el cierre de flujo");
					e.printStackTrace();
				}
			}
		}

	}

}
