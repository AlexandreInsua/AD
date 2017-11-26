package ud01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Le o ficheiro e imprímeo cun Scanner
 */

public class Exemplo10FileReader_le_ficheiro_scanner {

	@SuppressWarnings("hiding")
	public static void main(final String[] args) throws IOException {
		File f = new File("Nomes.txt");
		FileReader fr = null;
		Scanner sc = null;
		try {
			if (f.exists()) {
				fr = new FileReader(f);
				sc = new Scanner(fr);
				// mentres non encontre o final segue a ler
				while (sc.hasNext()) {
					System.out.println(sc.next());
				}
			} else
				System.out.println("El fichero no existe");
		} catch (FileNotFoundException fne) {
			System.out.println("Non se encontra o ficheiro");
		} catch (IOException ioe) {
			System.out.println("Erro de L/E");
		} catch (Exception e) {
			System.out.println("Erro");
		} finally {
			try {
				sc.close();
				fr.close();
			} catch (Exception e2) {
				System.out.println("Erro ao pechar o ficheiro");
			}
		}
	}
}
