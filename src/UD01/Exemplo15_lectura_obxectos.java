package UD01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Exemplo15_lectura_obxectos {

	public static void main(final String[] args) {
		System.out.println("Nome \t Idade");
		try {
			FileInputStream fs = new FileInputStream("Persoas.txt");
			ObjectInputStream os = new ObjectInputStream(fs);
			// solo recupera un objeto
			// os debe realizar un casting al tipo original
			Persoa p = (Persoa) os.readObject();
			System.out.println(p.getNombre() + "\t " + p.getEdad());
			os.close();
		} catch (ClassNotFoundException cnf) {
			System.out.println("Erro a clase");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error no ficheiro");
		} catch (IOException ioe) {
			System.out.println("Erro E/L");
		}
	}
}
