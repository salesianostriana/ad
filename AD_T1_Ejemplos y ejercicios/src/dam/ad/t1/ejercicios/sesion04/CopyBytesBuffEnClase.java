package dam.ad.t1.ejercicios.sesion04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesBuffEnClase {

	/**
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		if (args.length != 2) {
			System.err.println("Solo se pueden dos argumento");
		} else {
			BufferedInputStream bi = new BufferedInputStream(
					new FileInputStream(args[0]));
			BufferedOutputStream bo = new BufferedOutputStream(
					new FileOutputStream(args[1]));
			byte[] br = new byte[1024];
			int var;
			while ((var = bi.read(br, 0, br.length)) != -1) {
				bo.write(br, 0, var);
			}
			bi.close();
			bo.close();

		}

	}

}
