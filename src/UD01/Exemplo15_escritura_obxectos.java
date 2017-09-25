package UD01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Exemplo15_escritura_obxectos {
	public static void main(final String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("Persoas.txt");
			oos = new ObjectOutputStream(fos);
			Persoa p = new Persoa("Marta", 32);
			oos.writeObject(p);
			oos.writeObject(new Persoa("Ana", 27));
			oos.close();
		} catch (FileNotFoundException fne) {
			System.out.println("Erro no ficheiro");
		} catch (IOException ioe) {
			System.out.println("Erro E/L");
		}
	}
}
