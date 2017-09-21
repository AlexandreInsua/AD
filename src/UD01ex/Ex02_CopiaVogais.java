package UD01ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex02_CopiaVogais {
	public static void main(String[] args) {

		File f = new File("orixinal.txt");
		if (f.exists()) {
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String letra;
				while ((letra = br.readLine()) != null) {
						if (letra == "a"){
							File f2 = new File("copia.txt");
							FileWriter fw = new FileWriter(f2);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(letra);
							bw.close();
							
						}
				}
			}
			catch (FileNotFoundException e) {
				System.out.println("O ficheiro non existe");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Erro de L/E");
				e.printStackTrace();
			}
		}
	}

}
