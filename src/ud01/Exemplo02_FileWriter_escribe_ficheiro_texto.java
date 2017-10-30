package ud01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exemplo02_FileWriter_escribe_ficheiro_texto {

	/*
	 * Escribe caracteres nun ficheiro de nome Caracteres.txt (se non existir,
	 * cr�ao). Os caracteres obt��ense dun String e escr�bense un a un.
	 * 
	 */

	public static void main(String[] args) throws IOException {

		// String de orixe
		String cadea = "Isto � unha proba de FileWriter m�todo write()";

		// Creo o ficheiro de sa�da
		File f = new File("Caracteres.txt");

		// Creo o fluxo de escritura
		FileWriter fw = new FileWriter(f);

		// Convirte un String nun array de caracteres
		char[] cad = cadea.toCharArray();

		// Para cada caracter obtido do paso anterior
		for (int i = 0; i < cad.length; i++)

			// Escr�bese un caracter (Ollo! isto forma parte da sentenza
			// anterior
			fw.write(cad[i]);

		// Engade un * ao final
		fw.append('*');

		// porque non leva fw.flush(); ?????

		// Pecha o ficheiro
		fw.close();
	}
}
