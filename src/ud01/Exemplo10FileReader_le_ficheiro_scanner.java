package ud01;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Le o ficheiro e imprímeo cun Scanner
 */

public class Exemplo10FileReader_le_ficheiro_scanner {

	public static void main(final String[] args) throws IOException {
		File f = new File("Nomes.txt");
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			Scanner sc = new Scanner(fr);
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
			sc.close();
		} else
			System.out.println("El fichero no existe");
	}
}
