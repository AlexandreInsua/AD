package unidade01;

import java.io.File;

/*
* Exemplo que mostra a lista de ficheiros do directorio actual
*/
public class Exemplo02_File_lista_ficheiros {
	public static void main(final String[] args) {
		System.out.println("Listaxe de ficheiros do directorio actual:");

		// list() lista os ficheiros do obxecto File e almacénaos nun array de String
		// "." Representa o ficheiro actual
		File f = new File(".");

		// Instancio a lista de arquivos 
		String[] arquivos = f.list();
		
		// Mostra a array de arquivos
		for (int i = 0; i < arquivos.length; i++) {
			System.out.println(arquivos[i]);
		}
	}
}
