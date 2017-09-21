package UD01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExemploFileWriter02 {

	/*
	 * Escribe caracteres nun ficheiro de nome Caracteres.txt (se non existir,
	 * cr�ao). Os caracteres obt��ense dun String e escr�bense un a un.
	 * 
	 * 
	 */
	public class Ejemplo02FileWriter {
		public void main(String[] args) throws IOException {

			// String de orixe
			String cadena = "Esto es una prueba de FileWriter m�todo write";

			// Creo o ficheiro de sa�da
			File f = new File("Caracteres.txt");
			
			// Creo o fluxo de escritura
			FileWriter fw = new FileWriter(f);

			// Convirte un String nun arrya de caracteres
			char[] cad = cadena.toCharArray();

			// Para cada caracter obtido do paso anterior
			for (int i = 0; i < cad.length; i++)

				// Escr�bese un caracter (Ollo! isto forma parte da sentenza
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