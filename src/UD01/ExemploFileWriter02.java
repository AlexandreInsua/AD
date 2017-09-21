package UD01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExemploFileWriter02 {

	/*
	 * Escribe caracteres nun ficheiro de nome Caracteres.txt (se non existir,
	 * créao). Os caracteres obtéñense dun String e escríbense un a un.
	 * 
	 * 
	 */
	public class Ejemplo02FileWriter {
		public void main(String[] args) throws IOException {

			// String de orixe
			String cadena = "Esto es una prueba de FileWriter método write";

			// Creo o ficheiro de saída
			File f = new File("Caracteres.txt");
			
			// Creo o fluxo de escritura
			FileWriter fw = new FileWriter(f);

			// Convirte un String nun arrya de caracteres
			char[] cad = cadena.toCharArray();

			// Para cada caracter obtido do paso anterior
			for (int i = 0; i < cad.length; i++)

				// Escríbese un caracter (Ollo! isto forma parte da sentenza
				// anterior
				fw.write(cad[i]);

			// Engade un * ao final
			fw.append('*');

			// porque non leva fw.flush(); ?????

			// Pechs o ficheiro
			fw.close();
		}
	}
}