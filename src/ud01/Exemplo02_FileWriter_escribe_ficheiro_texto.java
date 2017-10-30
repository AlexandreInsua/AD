package ud01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exemplo02_FileWriter_escribe_ficheiro_texto {

	/*
	 * Escribe caracteres nun ficheiro de nome Caracteres.txt (se non existir,
	 * créao). Os caracteres obtéñense dun String e escríbense un a un.
	 * 
	 */

	public static void main(String[] args) throws IOException {

		// String de orixe
		String cadea = "Isto é unha proba de FileWriter método write()";

		// Creo o ficheiro de saída
		File f = new File("Caracteres.txt");

		// Creo o fluxo de escritura
		FileWriter fw = new FileWriter(f);

		// Convirte un String nun array de caracteres
		char[] cad = cadea.toCharArray();

		// Para cada caracter obtido do paso anterior
		for (int i = 0; i < cad.length; i++)

			// Escríbese un caracter (Ollo! isto forma parte da sentenza
			// anterior
			fw.write(cad[i]);

		// Engade un * ao final
		fw.append('*');

		// porque non leva fw.flush(); ?????

		// Pecha o ficheiro
		fw.close();
	}
}
