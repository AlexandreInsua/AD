package ud01ex;

/*
 * Le o ficheiro de texto Nomes.txt e copia en vogaisNomes.txt unicamente a vogais
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex02_CopiaVogais {
	public static void main(String[] args) throws IOException {

		File f = new File("Nomes.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		File t = new File("vogaisNomes.txt");
		FileWriter fw = new FileWriter(t);
		BufferedWriter bw = new BufferedWriter(fw);

		if (f.exists()) {
			int character;

			while ((character = br.read()) != -1) {
				if (character == 'a' || character == 'A' || character == 'e' || character == 'E' || character == 'i'
						|| character == 'I' || character == 'o' || character == 'O' || character == 'u'
						|| character == 'U') {

					System.out.println("lendo caracter...: " + (char) character);
					bw.write((char) character);
					System.out.println("vogal escrita.");
				}
			}
		}
		br.close();
		bw.close();
	}
}