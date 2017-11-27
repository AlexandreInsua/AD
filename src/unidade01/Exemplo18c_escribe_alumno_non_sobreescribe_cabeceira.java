package unidade01;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Exemplo que non permite escriber e ler obxectos Alumno.
 * O ficheiro non se sobreescribe e engades obxectos ao final.
 * Utiliza a calse MiObjectOutputStream para que non escriba a cabeceira cada vez que se chama ao programa.
 * 
 */
public class Exemplo18c_escribe_alumno_non_sobreescribe_cabeceira {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// O ficheiro é unha constante que se crea no main e pásaselle como argumento aos métodos.
		File f = new File("Alumnos.dat");
		int opcion;
		// Usa a clase BufferedReader en lugar dun Scanner 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("1.- Insertar Registros.");
			System.out.println("2.- Leer Registros.");
			System.out.println("3.- Salir.");
			System.out.println("Elegir opcion: ");
			opcion = Integer.parseInt(br.readLine());
			switch (opcion) {
			case 1:
				if (f.exists()) {
					System.out.println("Alumnos.dat existe");
					escrituraObjetosExisteFichero(f);
				} else {
					System.out.println("Alumnos.dat no existe");
					escrituraObjetosNuevoFichero(f);
				}
				break;
			case 2:
				lecturaObjetos(f);
				break;
			default:
				System.out.println("Error en la opcion.");
			}// fin switch
		} while (opcion != 3);
	} // fin main

	/* ESCRITURA DE OBXECTOS EN FICHEIRO NOVO */
	/* Usa a clase ObjectOutputStream */
	static void escrituraObjetosNuevoFichero(File f) {
		FileOutputStream fo = null;
		ObjectOutputStream oo = null;
		try {
			fo = new FileOutputStream(f);
			oo = new ObjectOutputStream(fo);
			// creo los objetos a escribir
			Alumno alumno1 = new Alumno("Luis", "Vigo", 25);
			Alumno alumno2 = new Alumno("Carmen", "Madrid", 32);
			Alumno alumno3 = new Alumno("Iciar", "Eibar", 22);
			System.out.println("Escribiendo registros. Espere");
			// escribimos en el fichero
			oo.writeObject(alumno1);
			oo.writeObject(alumno2);
			oo.writeObject(alumno3);
		} catch (FileNotFoundException fn) {
			System.out.println("Error. Fichero no existe");
		} catch (IOException io) {
			System.out.println("Error de escritura");
		} finally {
			try {
				if (fo != null) {
					fo.close();
					oo.close();
				}
			} catch (IOException io) {
				System.out.println("Error al cerrar el fichero");
			}
		}
	}// fin metodo escrituraObjetosNuevo

	/* ESCRITURA DE OBXECTOS EN FICHEIRO QUE XA EXISTE */
	/* Usa a clase modificada MyObjectOutputStream */
	static void escrituraObjetosExisteFichero(File f) {
		FileOutputStream fo = null;
		MyObjectOutputStream mo = null;
		try {
			fo = new FileOutputStream(f, true);
			mo = new MyObjectOutputStream(fo);
			// creo los objetos a escribir
			Alumno alumno1 = new Alumno("Bea", "Vigo", 25);
			Alumno alumno2 = new Alumno("Pedro", "Madrid", 32);
			Alumno alumno3 = new Alumno("Iñigo", "Eibar", 28);
			System.out.println("Añadiendo registros. Espere");
			// escribimos en el fichero
			mo.writeObject(alumno1);
			mo.writeObject(alumno2);
			mo.writeObject(alumno3);
		} catch (FileNotFoundException fn) {
			System.out.println("Error. Fichero no existe");
		} catch (IOException io) {
			System.out.println("Error de escritura");
		} finally {
			try {
				if (fo != null) {
					fo.close();
					mo.close();
				}
			} catch (IOException io) {
				System.out.println("Error al cerrar el fichero");
			}
		}
	}// fin metodo escrituraObjetosExiste

	/* LECTURA DE OBXECTOS */
	static void lecturaObjetos(File f) {
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		try {
			fi = new FileInputStream(f);
			oi = new ObjectInputStream(fi);
			while (true) {
				// creo el objeto donde voy a guardar los datos leidos del disco
				Alumno alumno = (Alumno) oi.readObject();
				System.out.println(alumno);
			}
		} catch (ClassNotFoundException cn) {
			System.out.println("Error en la clase alumnos");
		} catch (FileNotFoundException fn) {
			System.out.println("Error. Fichero no existe");
		} catch (EOFException eof) {
			System.out.println("Fin del la lectura");
		} catch (IOException io) {
			System.out.println("Error de lectura");
		} finally {
			try {
				if (fi != null) {
					fi.close();
					oi.close();
				}
			} catch (IOException io) {
				System.out.println("Error al cerrar el fichero");
			}
		} // fin metod0 lecturaObjetos

	}
}
