package unidade01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Exemplo16_lectura_obxectos {
	public static void main(final String[] args) throws IOException {
		FileInputStream fs = null;
		ObjectInputStream ois = null;
		System.out.println("Nombre \t Edad");
		try {
			fs = new FileInputStream("Persoas.txt");
			ois = new ObjectInputStream(fs);
			
			// lectura do ficheiro mentres haxa obxectos
			while (true) { 
				// os debe realizar un castingal tipo original
				Persoa p = (Persoa) ois.readObject();
				System.out.println(p.getNombre() + "\t" + p.getEdad());
			}
		} catch (ClassNotFoundException cnf) {
			System.out.println("Error la clase");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error en el fichero");
		} catch (IOException ioe) {
			// System.out.println("Error E/L");
		}
		ois.close();
	}
}