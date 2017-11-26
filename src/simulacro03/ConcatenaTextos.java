package simulacro03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import jdk.jfr.events.FileWriteEvent;

public class ConcatenaTextos {

	public static void main(String[] args) {
		String resultado;
		File ficheiro1 = new File("Texto01.txt");
		File ficheiro2 = new File("Texto02.txt");
		File ficheiro3 = new File("Texto03.txt");

		
		resultado = lerFicheiro(ficheiro1) + (lerFicheiro(ficheiro2));
		
		escribirFicheiro(ficheiro3, resultado);

		lerFicheiro(ficheiro3);

	}

	private static void escribirFicheiro(File ficheiro, String resultado) {
		FileWriter fw = null;
		PrintWriter saida = null;
		try {
			fw = new FileWriter(ficheiro);
			saida = new PrintWriter(fw);
			saida.println(resultado);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String lerFicheiro(File file) {
		String texto = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
		
			if (file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				// String texto; // variable donde se recupera la informacion
				// readLine() apunta á seguinte liña despois de recuperar a liña
				// actual
				// Mentres a nova liña non sexa nula
				while ((texto = br.readLine()) != null) {
					System.out.println(texto);
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
		return texto;
	}
}
