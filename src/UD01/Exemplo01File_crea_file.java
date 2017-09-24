package UD01;

import java.io.File;
import java.io.IOException;

/*
* Exemplo que crea un obxecto File cunha ruta e un ficheiro inexistentes
*/
public class Exemplo01File_crea_file {
	public static void main(final String[] args) throws IOException {
		File f = new File("Exemplo01.txt");
		f.createNewFile();
	}
}
