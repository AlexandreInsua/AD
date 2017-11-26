package ud01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exemplo08FileReader_le_ficheiro_linea {

	/*
	 * Vai mostrar por pantalla o contenido do fichero Nomes.txt liña a liña
	 */

	public static void main(final String[] args) {
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			f = new File("Nomes.txt");
			if (f.exists()) {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				String nome; // variable donde se recupera la informacion
				// readLine() apunta á seguinte liña despois de recuperar a liña
				// actual
				// Mentres a nova liña non sexa nula
				while ((nome = br.readLine()) != null) {
					System.out.println(nome);
				}
			} else {
				System.out.println("O ficheiro non existe");
			}
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
