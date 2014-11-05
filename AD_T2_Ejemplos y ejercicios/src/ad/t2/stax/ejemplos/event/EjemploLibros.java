package ad.t2.stax.ejemplos.event;


import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import java.io.*;

/**
 * Ejemplo de lectura de datos con StAX a trav�s del m�todo: Event Iterator API
 * @author Carlos Garc�a. Autentia.
 */
public class EjemploLibros {

	/**
	 * Imprime por la salida estandar el t�tulo del libro m�s 
 * caro de entre los 100 primeros libros
	 */
	public static void main(String[] args) {
		FileReader		reader = null;
		XMLEventReader 	parser = null;
		int			precioMasCaro  = Integer.MIN_VALUE;
		String		tituloMasCaro  = null;
		int 			currentPrecio  = 0; 
		String		currentTitle   = null;
		int 			currentPositon = 0;
		XMLEvent 		evt   = null;
		String   		tag  = null; 
		
		try {
			reader = new FileReader("libros.xml");
			parser  = XMLInputFactory.newInstance().createXMLEventReader(reader);
			while (parser.hasNext() && (currentPositon != 100)){
				evt = parser.nextEvent();
				
				if (evt.isStartElement()){
					tag = evt.asStartElement().getName().getLocalPart();
					
					if ("libro".equals(tag)){
						currentPositon++;
					} else if ("titulo".equals(tag)){
						currentTitle = parser.getElementText();
					} else if ("precio".equals(tag)){
						currentPrecio = Integer.valueOf(parser.getElementText()).intValue();
						if (currentPrecio > precioMasCaro){
							precioMasCaro = currentPrecio;
							tituloMasCaro = currentTitle;
						}
					}						
				}
			}
			
			System.out.println("El libro m�s caro es: " + tituloMasCaro);
		} catch (Exception ex) {
			// Para este tutorial no hacemos nada m�s que imprimir la excepci�n
			System.out.println(ex);
		} finally {
			try {
				reader.close();
			} catch (Exception ex){}			
			try {
				parser.close();
			} catch (Exception ex){}    	
		}		
	}
}