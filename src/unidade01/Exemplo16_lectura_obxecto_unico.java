package unidade01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Exemplo16_lectura_obxecto_unico {

	public static void main(final String[] args) {
		FileInputStream fs = null; 
		ObjectInputStream ois =null;
		System.out.println("Nome \t Idade");
		try {
			fs = new FileInputStream("Persoas.txt");
			ois = new ObjectInputStream(fs);
			// só recupera o primeiro obxecto
			// os debe realizar un casting al tipo original
			Persoa p = (Persoa) ois.readObject();
			System.out.println(p.getNombre() + "\t " + p.getEdad());
			ois.close();
		} catch (ClassNotFoundException cnf) {
			System.out.println("Erro a clase");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error no ficheiro");
		} catch (IOException ioe) {
			System.out.println("Erro E/L");
		}
	}
}
