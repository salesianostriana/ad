package ad.t2.stax.ejemplos.writer.event;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class EjemploSencillo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();

		try {
			XMLEventWriter writer = factory
					.createXMLEventWriter(new FileWriter("output_event.xml"));

			XMLEvent event = eventFactory.createStartDocument();
			writer.add(event);

			event = eventFactory.createStartElement("jenkov",
					"http://jenkov.com", "document");
			writer.add(event);

			event = eventFactory.createNamespace("jenkov", "http://jenkov.com");
			writer.add(event);

			event = eventFactory.createAttribute("attribute", "value");
			writer.add(event);

			event = eventFactory.createEndElement("jenkov",
					"http://jenkov.com", "document");
			writer.add(event);

			writer.flush();
			writer.close();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
