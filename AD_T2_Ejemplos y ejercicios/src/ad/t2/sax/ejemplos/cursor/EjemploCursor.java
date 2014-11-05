package ad.t2.sax.ejemplos.cursor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class EjemploCursor {
	// La ruta del documento XML, al ser una ruta relativa suele ser el directorio
	// principal del proyecto (p.e. /home/usuario/eclipse/workspace/proyecto)
	public static final String DOCUMENTO_XML = "parking.xml";
	public static final String ELEMENTO_PLAZA = "plaza";
	
	public int numeroDePlazas() {	
		int numeroPlazas = 0;
		
		XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
		InputStream inputStream = null;
		XMLStreamReader xmlStreamReader = null;
		
		try {
			inputStream = new FileInputStream(DOCUMENTO_XML);
			xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
			
			while (xmlStreamReader.hasNext()) {
				xmlStreamReader.next();

				if (xmlStreamReader.isStartElement() && ELEMENTO_PLAZA.equals(xmlStreamReader.getLocalName())) {
					numeroPlazas++;
				}				
			}
		} catch (XMLStreamException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				xmlStreamReader.close();
				inputStream.close();
			} catch (XMLStreamException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return numeroPlazas;
	}
	
	public static void main(String[] args) {
		EjemploCursor lector = new EjemploCursor();
		System.out.println("Número de plazas: " + lector.numeroDePlazas());
	}
}