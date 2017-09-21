package UD01ex;

import java.io.File;
import java.util.Scanner;

public class Ex01_mostrarDirectorioFicheiro {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, introduza a ruta do directorio: ");

		String path = sc.nextLine();

		File f = new File(path);
		if (f.exists()) {
			try {
				System.out.println("Listaxe de ficheiros do directorio: ");
				String[] arquivos = f.list();
				for (int i = 0; i < arquivos.length; i++) {
					System.out.println(arquivos[i]);
				}
			} catch (Exception e) {
				System.out.println("O directorio non existe");
			}
		}

		System.out.println("Por favor, introduza a ruta do ficheiro: ");
		path = sc.nextLine();
		f = new File(path);
		if (f.exists()) {
			try {
				System.out.println("Nome do ficheiro: " + f.getName());
				System.out.println("Ruta : " + f.getPath());
				System.out.println("Ruta absoluta : " + f.getAbsolutePath());
				System.out.println("Ruta anterior : " + f.getParent());
				System.out.println("P�dese escribir : " + f.canWrite());
				System.out.println("P�dese ler : " + f.canRead());
				System.out.println("Tama�o : " + f.length() + " bytes");
				System.out.println("� un directorio : " + f.isDirectory());
				System.out.println("� un ficheiro : " + f.isFile());
			} catch (Exception e) {
				System.out.println("O ficheiro non existe");
			}

		}
		sc.close();
	}
}