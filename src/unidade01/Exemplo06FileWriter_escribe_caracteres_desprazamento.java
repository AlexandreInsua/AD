package unidade01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exemplo06FileWriter_escribe_caracteres_desprazamento {

	/*
	 * Escribe cadeas de caracteres que se obte�en dun array de String, as
	 * cadeas gr�banse desde un deprazamento de 10
	 */

	public static void main(final String[] args) {
		String cadea = "Probando o desprazamento e o n�mero de caracteres que se van escribir";

		try {
			File f = new File("TextoDesprazamento.txt");
			FileWriter fw = new FileWriter(f);

			// write() con 3 par�metros son a cadea, o inicio do desprazamento e
			// a lonxitude
			fw.write(cadea, 3, 10);

			fw.close();
		} catch (IOException ioe) {
			System.out.println("Disco cheo ou protexido");
		}
	}
}
