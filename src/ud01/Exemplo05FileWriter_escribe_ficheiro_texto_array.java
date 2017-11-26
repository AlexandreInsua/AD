package ud01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* Escribe unha array de nomes nun ficheiro de texto */

public class Exemplo05FileWriter_escribe_ficheiro_texto_array {
	public static void main(String[] args) throws IOException {

		// array de nomes
		String[] nomes = { "María", "Ana", "Santiago", "Jorge", "Iciar", "Isabel" };

		// Creamos ficheiro (en rigor, creamos o espazo en memoria que
		// representa o ficheiro en disco)
		File f = new File("Nomes.txt");

		// Abrimos o fluxo de escritura
		FileWriter fw = new FileWriter(f);
		
		// con FileWriter fw = new FileWriter(f, true); actívase o modo append

		// As dúas sentenzas anteriores son equivalentes á seguinte:
		// FileWriter fw = new FileWriter("Nombres.txt");

		// Creamos un obxecto que representa o medio de saída
		// (recibe como parámetro un fluxo)
		PrintWriter saida = new PrintWriter(fw);

		// As dúas sentenzas anteriores son equivalentes á seguinte
		// PrintWriter salida = new PrintWriter("Nombres.txt");
		
		// Para cada nome
		for (int i = 0; i < nomes.length; i++) {
			// Escríbeo no ficheiro
			saida.println(nomes[i]);
		}

		// Garante que os datos enviados a través do buffer foron escritos
		saida.flush();
		
		// Pecha a conexión co ficheiro e libera os recursos que se empregaron
		saida.close();
	}
}
