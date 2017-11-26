package ud01;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Exemplo que permite escribir e ler obxectos Alumno.
 * O ficheiro sobrescríbese sen problemas de cabeceiras.
 */
public class Exemplo18b_escribe_alumno_sobrescribe_cabeceira {
	public static void main(String[] args) {
		escrituraObxectos();
		lecturaObxectos();
	}

	private static void lecturaObxectos() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("Alumnos2.dat");
			ois = new ObjectInputStream(fis);
			while (true) {
				Alumno a = (Alumno) ois.readObject();
				System.out.println(a);
			}
		} catch (ClassNotFoundException cn) {
			System.out.println("Error en la clase alumnos");
		} catch (FileNotFoundException fn) {
			System.out.println("Error. Fichero no existe");
		} catch (EOFException eof) {
			System.out.println("Fin de la lectura");
		} catch (IOException io) {
			System.out.println("Error de lectura/escritura");
		}
	}

	private static void escrituraObxectos() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("Alumnos2.dat");
			oos = new ObjectOutputStream(fos);
			Alumno a1 = new Alumno("María", "Vigo", 25);
			Alumno a2 = new Alumno("Xan", "Redondela", 32);
			Alumno a3 = new Alumno("María", "Mos", 22);
			// escribe o ficheiro
			oos.writeObject(a1);
			oos.writeObject(a2);
			oos.writeObject(a3);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
