package UD01;

import java.io.File;

/* Exemplo que mostra información dun ficheiro de Documentos favicon.jpg 
  */
public class Exemplo04File_mostra_propiedades_ficheiro {
	
	public static void main(final String[] args) {
		System.out.println("Información sobre o ficheiro\n");
		String separador = File.separator;
		
		// En carpeta almaceno o path da carpeta cuxos elementos quero ver
		File f = new File("C:" + separador + "Users" + separador + "Alexandre" + separador + "Documents" + separador
				+ "favicon.jpg");
		
		System.out.println("Nome do ficheiro: " + f.getName());
		System.out.println("Ruta : " + f.getPath());
		System.out.println("Ruta absoluta : " + f.getAbsolutePath());
		System.out.println("Ruta anterior : " + f.getParent());
		System.out.println("Pódese escribir : " + f.canWrite());
		System.out.println("Pódese ler : " + f.canRead());
		System.out.println("Tamaño : " + f.length() + " bytes");
		System.out.println("É un directorio : " + f.isDirectory());
		System.out.println("É un ficheiro : " + f.isFile());
	}
}
