package UD01;

import java.io.File;
import java.io.IOException;

/*
* Exemplo que crea un obxecto File cunha ruta e un ficheiro inexistentes
*/
public class ExemploFile01 {
	public static void main(final String[] args) throws IOException {
		File f = new File("exemplo01.txt");
		f.createNewFile();
	}
}
