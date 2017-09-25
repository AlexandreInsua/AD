package UD01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class Exemplo17 {
	public static void main(final String[] args) {
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		Persona p = new Persona();
		
		try {
			fs = new FileOutputStream("Personas01.txt", true);
			os = new ObjectOutputStream(fs);
		
			for (int i = 0; i < 5; i++) {
				// Persona p = new Persona();
				System.out.println("Introduce el nombre del empleado: ");
				p.setNombre(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());
				System.out.println("Introduce la edad del empleado: ");
				p.setEdad(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine().trim()));
				os.writeObject(p);
			}
			os.close();
		} catch (FileNotFoundException fne) {
			System.out.println("Error en el fichero");
		} catch (IOException ioe) {
			System.out.println("Error E/L");
		}
	}
}
