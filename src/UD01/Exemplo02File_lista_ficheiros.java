package UD01;

import java.io.File;

/*
* Exemplo que mostra a lista de ficheiros do directorio actual
*/
public class Exemplo02File_lista_ficheiros {
	public static void main(final String[] args) {
		System.out.println("Listaxe de ficheiros do directorio actual:");

		// "." Representa o
		File f = new File(".");

		// list() lista os ficheiros do obxecto File e almacénaos nun array de
		// String
		String[] arquivos = f.list();
		for (int i = 0; i < arquivos.length; i++) {
			System.out.println(arquivos[i]);
		}
	}
}
