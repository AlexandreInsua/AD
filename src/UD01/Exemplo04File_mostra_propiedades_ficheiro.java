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
		
		System.out.println("Nome do ficheiro: \t" + f.getName());
		System.out.println("Ruta : \t" + f.getPath());
		System.out.println("Ruta absoluta : \t" + f.getAbsolutePath());
		System.out.println("Ruta anterior : \t" + f.getParent());
		System.out.println("Pódese escribir: \t" + f.canWrite());
		System.out.println("Pódese ler: \t" + f.canRead());
		System.out.println("Tamaño: \t" + f.length() + " bytes");
		System.out.println("É un directorio: \t" + f.isDirectory());
		System.out.println("É un ficheiro: \t" + f.isFile());
	}
}
