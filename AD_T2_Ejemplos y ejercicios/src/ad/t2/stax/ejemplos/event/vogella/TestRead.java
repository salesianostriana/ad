package ad.t2.stax.ejemplos.event.vogella;

import java.util.List;



public class TestRead {
	public static void main(String args[]) {
		StAXParser read = new StAXParser();
		List<Item> readConfig = read.readConfig("config.xml");
		for (Item item : readConfig) {
			System.out.println(item);
		}
	}
}