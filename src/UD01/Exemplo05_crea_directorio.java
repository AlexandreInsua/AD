package UD01;

import java.io.File;
import java.io.IOException;

/*
 * Creao un novo directorio no directorio actual, tres ficheiros valeiros e renomea un deles.
 */
public class Exemplo05_crea_directorio {

	public static void main(String[] args) {
		// Directorios e ficheiros
		File d = new File("NovoDirectorio");
		File f1 = new File(d, "Ficheiro01.txt");
		File f2 = new File(d, "Ficheiro02.txt");

		// Crea o directorio
		d.mkdir();

		// Crea o ficheiros
		try {
			if (f1.createNewFile()) {
				System.out.println("Ficheiro 1 creado correctamente.");
			} else {
				System.out.println("Non se puido crear Ficheiro 1 correctamente.");
			}
			if (f2.createNewFile()) {
				System.out.println("Ficheiro 2 creado correctamente.");
			} else {
				System.out.println("Non se puido crear Ficheiro 2 correctamente.");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// Renomeamos o ficheiro
		f1.renameTo(new File(d, "novoFicheiro.txt"));

		// Creamos un ficheiro máis en novo directorio
		try {
			File f3 = new File("NovoDirectorio\\Ficheiro3.txt");
			f3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// EXTRA
		// Mostro os ficheiros creados
		String[] ficheiros = d.list();
		System.out.println("Ficheiros creados");
		for (int i = 0; i < ficheiros.length; i++) {
			System.out.println(ficheiros[i]);
		}
	}
}
