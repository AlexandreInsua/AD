package UD01;

import java.io.File;
import java.io.IOException;

/*
* Exemplo que crea un obxecto File cunha ruta e un ficheiro inexistentes
*/
public class Exemplo01_crea_file {
	public static void main(final String[] args) throws IOException {
		// Declara un ficheiro
		File f = new File("Exemplo01.txt");
		// Crea o ficheiro esplicitamente
		f.createNewFile();
	}
}
