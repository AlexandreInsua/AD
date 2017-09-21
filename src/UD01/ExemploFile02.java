package UD01;

import java.io.File;

/*
* Exemplo que mostra a lista de ficheiros do directorio actual
*/
public class ExemploFile02 {
	public static void main(final String[] args) {
		System.out.println("Listaxe de ficheiros do directorio actual:");
		File f = new File(".");
		String[] arquivos = f.list();
		for (int i = 0; i < arquivos.length; i++) {
			System.out.println(arquivos[i]);
		}
	}

}
