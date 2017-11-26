package ud01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Exemplo15_escritura_obxectos_problema_instanciacion {

	/*
	 * Exemplo de ficheiro que non cambia o valor do obxecto por estar
	 * instanciado unha única vez
	 * 
	 */

	public static void main(final String[] args) {
		escribirDisco();
		leerDisco();
	}

	// metodo para escribir objetos en un fichero en disco
	static void escribirDisco() {
		// creamos los objetos que nos permiten escribir en disco objetos
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			fs = new FileOutputStream("Personas01.txt");
			os = new ObjectOutputStream(fs);
			// instanciamos la clase Persona una vez fuera del bucle
			Persoa p = new Persoa();
			for (int i = 0; i < 5; i++) {
				// A INSTANCIA DEBE ESTAR AQUÍ PARA EVITAR O ERRO
				// Persoa p = new Persoa();
				// introducimos los datos por teclado
				p.setNombre(introducirDatos("Introduce el nombre del empleado: "));
				p.setEdad(Integer.parseInt(introducirDatos("Introduce la edad del empleado: ")));
				// escribimos el objeto p en el disco
				os.writeObject(p);
			}
			os.close();
		} catch (FileNotFoundException fne) {
			System.out.println("Error en el fichero");
		} catch (IOException ioe) {
			System.out.println("Error E/L");
		}
	}
	// metodo para escribir objetos en un fichero en disco

	static void leerDisco() {
		// creamos los objetos que nos permiten leer del disco objetos
		// abrimos el fichero de lectura
		FileInputStream fs = null;
		ObjectInputStream os = null;
		System.out.println("Nombre \t Edad");
		try {
			fs = new FileInputStream("Personas01.txt");
			os = new ObjectInputStream(fs);
			while (true) { // lectura del fichero mientras haya objetos
				// os debe realizar un castingal tipo original
				Persoa p = (Persoa) os.readObject();
				System.out.println(p.getNombre() + "\t" + p.getEdad());
			}
		} catch (ClassNotFoundException cnf) {
			System.out.println("Error la clase");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error en el fichero");
		} catch (IOException ioe) {
		}
	}// fin metodo leerDisco()
		// metodo para introducir datos desde el teclado

	static String introducirDatos(String mensaje) {
		@SuppressWarnings("unused")
		BufferedReader br = null;
		try {
			System.out.println("--------------------------------------------------------");
			System.out.print(mensaje);
			return (new BufferedReader(new InputStreamReader(System.in))).readLine();
		} catch (IOException ioe) {
			System.out.println("\nError interno en sistema de entrada/salida\n");
		}
		return "";
	}
}
