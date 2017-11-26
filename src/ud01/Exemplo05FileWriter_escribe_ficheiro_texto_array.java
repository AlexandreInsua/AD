package ud01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* Escribe unha array de nomes nun ficheiro de texto */

public class Exemplo05FileWriter_escribe_ficheiro_texto_array {
	public static void main(String[] args) throws IOException {

		// array de nomes
		String[] nomes = { "Mar�a", "Ana", "Santiago", "Jorge", "Iciar", "Isabel" };

		// Creamos ficheiro (en rigor, creamos o espazo en memoria que
		// representa o ficheiro en disco)
		File f = new File("Nomes.txt");

		// Abrimos o fluxo de escritura
		FileWriter fw = new FileWriter(f);
		
		// con FileWriter fw = new FileWriter(f, true); act�vase o modo append

		// As d�as sentenzas anteriores son equivalentes � seguinte:
		// FileWriter fw = new FileWriter("Nombres.txt");

		// Creamos un obxecto que representa o medio de sa�da
		// (recibe como par�metro un fluxo)
		PrintWriter saida = new PrintWriter(fw);

		// As d�as sentenzas anteriores son equivalentes � seguinte
		// PrintWriter salida = new PrintWriter("Nombres.txt");
		
		// Para cada nome
		for (int i = 0; i < nomes.length; i++) {
			// Escr�beo no ficheiro
			saida.println(nomes[i]);
		}

		// Garante que os datos enviados a trav�s do buffer foron escritos
		saida.flush();
		
		// Pecha a conexi�n co ficheiro e libera os recursos que se empregaron
		saida.close();
	}
}
