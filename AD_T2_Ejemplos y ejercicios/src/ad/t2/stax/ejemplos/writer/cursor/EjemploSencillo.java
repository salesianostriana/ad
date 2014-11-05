package ad.t2.stax.ejemplos.writer.cursor;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class EjemploSencillo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XMLOutputFactory factory = XMLOutputFactory.newInstance();

		try {
			XMLStreamWriter writer = factory
					.createXMLStreamWriter(new FileWriter("output.xml"));

			writer.writeStartDocument();
			writer.writeStartElement("document");
			writer.writeStartElement("data");
			writer.writeAttribute("name", "value");
			writer.writeCharacters("La parte contratante de la primera parte sera igual a la parte contratante de la primera parte.");
			writer.writeEndElement();
			writer.writeEndElement();
			writer.writeEndDocument();

			writer.flush();
			writer.close();

		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
