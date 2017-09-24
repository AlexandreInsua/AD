package UD01;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Exemplo de escritura nun ficheiro dun array de enteiros.
 */

public class Exemplo11_FileOutputStream_le_array_DataOutputStream {

	public static void main(final String[] args) {
		FileOutputStream fos;
		DataOutputStream dos = null;
		try {
			// array de enteiros
			int[] array = { 5, 18, 23, 12, 10, 1, 47 };

			// Úsase o obxecto de tipo FileOutputStream con dous parámetros:
			// String e append false
			// Logo un DataOutputStream para usar un método writeXxx()
			fos = new FileOutputStream("Enteiros.txt", false);
			dos = new DataOutputStream(fos);

			// Mentrens o array tiver elementos, escríbimolos no ficheiro cun
			// bucle foreach
			for (int i : array) {
				dos.writeInt(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Non se puido abrir o ficheiro 'Enteiros.txt'");
		} catch (IOException e) {
			System.out.println("Non se puido escribir o ficheiro 'Enteiros.txt'");
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				System.out.println("No se pudo cerrar el fichero Enteros.txt");
			}
		}
	}
}
