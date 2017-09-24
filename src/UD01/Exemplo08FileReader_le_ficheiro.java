package UD01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exemplo08FileReader_le_ficheiro {

	/*
	 * Vai mostrar por pantalla o contenido do fichero Nomes.txt
	 */

	public static void main(final String[] args) {
		try {
			File f = new File("Nomes.txt");
			if (f.exists()) {
				FileReader fr = new FileReader(f);

				BufferedReader br = new BufferedReader(fr);

				String nome; // variable donde se recupera la informacion

				while ((nome = br.readLine()) != null) {
					System.out.println(nome);
				}
				br.close();
			}
		} catch (FileNotFoundException fn) {
			System.out.println("Non se atopa o ficheiro");
		} catch (IOException ioe) {
			System.out.println("Erro de L/E");
		}
	}
}
