package UD01ex;

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
			int caracter;

			while ((caracter = br.read()) != -1) {

				if ((caracter == 'a') || (caracter == 'A') || (caracter == 'e') || (caracter == 'E')
						|| (caracter == 'i') || (caracter == 'I') || (caracter == 'o') || (caracter == 'O')
						|| (caracter == 'u') || (caracter == 'U')) {

					bw.write((char)caracter);
				}
			}
		}
		br.close();
		bw.close();
	}

}