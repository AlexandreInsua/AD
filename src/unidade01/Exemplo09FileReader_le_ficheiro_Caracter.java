package unidade01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
 * Le o ficheiro de devolve os caracteres en ascii e texto
 */

public class Exemplo09FileReader_le_ficheiro_Caracter {

	public static void main(final String[] args) throws IOException {
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			f = new File("Nomes.txt");
			fr = new FileReader(f);
			// Clase para ler os caracteres
			br = new BufferedReader(fr);

			if (f.exists()) {

				// Variable coa que se recupera a información
				int caracter;

				// Le mentres haxa caracteres que recuperar
				while ((caracter = br.read()) != -1) {
					// Imprime por consola o ascci e o texto
					System.out.println(caracter + "\t" + (char) caracter);
				}
			} else
				System.out.println("O ficheiro non existe");
		} catch (FileNotFoundException fn) {
			System.out.println("Non se atopa o ficheiro");
		} catch (IOException ioe) {
			System.out.println("Erro de L/E");
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				System.out.println("Erro ao pechar o ficheiro");
			}
		}
	}
}