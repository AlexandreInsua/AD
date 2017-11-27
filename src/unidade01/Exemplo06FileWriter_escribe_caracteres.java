package unidade01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* Escribe cadeas de caracteres que se obte�en dun array de String. As cadeas gr�banse unha a continuaci�n doutra sen saltos de li�a */

public class Exemplo06FileWriter_escribe_caracteres {

	public static void main(final String[] args) {

		String provincias[] = { "A Coru�a", "Lugo", "Ourense", "Pontevedra", "Guip�zcoa", "Vizcaya", "Alava" };

		// En File almaceno os elementos do array
		try {
			// Crea ficheiro
			File f = new File("Provincias.txt");

			// Crea fluxo
			FileWriter fw = new FileWriter(f);

			// Percorre o array
			for (int i = 0; i < provincias.length; i++)

				// Escribe cada elemento. forma parte do for
				fw.write(provincias[i]);

			// Pecha o fluxo
			fw.close();

		} catch (IOException ioe) {
			System.out.println("Disco cheo ou protexido");
		}
	}

}
