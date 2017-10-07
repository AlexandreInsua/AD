package UD01ex;

import java.io.File;
import java.util.Scanner;
/*
 * Mostra os ficheiros dun directorio que se lle pasa por teclado.
 * Mostra a información dun ficheiro que se lle pasa por teclado.
 */
public class Ex01_mostrarDirectorioFicheiro {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor, introduza a ruta do directorio: ");

		String path = sc.nextLine();

		File f = new File(path);
		if (f.exists()) {
			try {
				System.out.println("Listaxe de ficheiros do directorio: ");
				String[] files = f.list();
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i]);
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
				System.out.println("Pódese escribir : " + f.canWrite());
				System.out.println("Pódese ler : " + f.canRead());
				System.out.println("Tamaño : " + f.length() + " bytes");
				System.out.println("É un directorio : " + f.isDirectory());
				System.out.println("É un ficheiro : " + f.isFile());
			} catch (Exception e) {
				System.out.println("O ficheiro non existe");
			}

		}
		sc.close();
	}
}