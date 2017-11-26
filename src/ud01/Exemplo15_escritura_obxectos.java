package ud01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* 
 * Exemplo que escribe obxecto Persoa nun ficheiro en disco
 */
public class Exemplo15_escritura_obxectos {
	public static void main(final String[] args) {
		// Creamos o obxetos que nos permiten escribir
		File f = new File("Persoas.txt");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			// Declaramos un obxecto usando o construtor o escríbimolo
			Persoa p = new Persoa("Marta", 32);
			oos.writeObject(p);

			// Escribimos un obxecto pasándoo como argumento
			oos.writeObject(new Persoa("Ana", 27));
			oos.close();
		} catch (FileNotFoundException fne) {
			System.out.println("Erro no ficheiro");
		} catch (IOException ioe) {
			System.out.println("Erro E/L");
		}
	}
}
