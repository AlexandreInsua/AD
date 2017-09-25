package UD01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Exemplo16_FileInputStream_obxectos {
	public static void main(final String[] args) throws IOException {
		FileInputStream fs = null;
		ObjectInputStream os = null;
		System.out.println("Nombre \t Edad");
		try {
			fs = new FileInputStream("Personas01.txt");
			os = new ObjectInputStream(fs);
			while (true) { // lectura del fichero
				// os debe realizar un castingal tipo original
				Persona p = (Persona) os.readObject();
				System.out.println(p.getNombre() + "\t" + p.getEdad());
			}
		} catch (ClassNotFoundException cnf) {
			System.out.println("Error la clase");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error en el fichero");
		} catch (IOException ioe) {
			// System.out.println("Error E/L");
		}
		os.close();
	}
}