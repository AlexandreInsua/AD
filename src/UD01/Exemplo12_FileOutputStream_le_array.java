package UD01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exemplo12_FileOutputStream_le_array {

	public static void main(final String[] args) {
		FileOutputStream fos = null;
		try {
			// Array de enteiros
			int[] array = { 55, 185, 237, 142, 150, 21, 487 };
			fos = new FileOutputStream("Enteiros02.txt", false);

			// Mentrens o array tiver elementos, escríbimolos no ficheiro cun
			// bucle foreach
			for (int i : array) {
				fos.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Non se puido abrir o ficheiro 'Enteiros.txt'");
		} catch (IOException e) {
			System.out.println("Non se puido escribir o ficheiro 'Enteiros.txt'");
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("No se pudo cerrar el fichero Enteros.txt");
			}
		}
	}
}
