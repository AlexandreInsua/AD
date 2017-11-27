package unidade01;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Exemplo07_BufferedWriter_escribe_saltos_de_li�a {

	/*
	 * Escribe 10 fileiras de caracteres nun ficheiro de texto e despois de cada
	 * fila salta unha li�a co m�todo newLine().
	 */

	public static void main(final String[] args) {
		try {
			// Crea o fluxo e o ficheiro
			BufferedWriter bw = new BufferedWriter(new FileWriter("Filas.txt"));

			// Escribe 10 li�os
			for (int i = 0; i < 11; i++) {
				bw.write("Fileira n�mero: " + i);
				bw.newLine();
			}
			bw.close();
			System.out.println("Sucesso!");
		} catch (FileNotFoundException fne) {
			System.out.println("Non se encontra o ficheiro.");
		} catch (IOException ioe) {
			System.out.println("Erro de L/E");
		}
	}
}
