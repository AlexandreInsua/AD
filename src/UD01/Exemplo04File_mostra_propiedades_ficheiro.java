package UD01;

import java.io.File;

/* Exemplo que mostra informaci�n dun ficheiro de Documentos favicon.jpg 
  */
public class Exemplo04File_mostra_propiedades_ficheiro {
	
	public static void main(final String[] args) {
		System.out.println("Informaci�n sobre o ficheiro\n");
		String separador = File.separator;
		
		// En carpeta almaceno o path da carpeta cuxos elementos quero ver
		File f = new File("C:" + separador + "Users" + separador + "Alexandre" + separador + "Documents" + separador
				+ "favicon.jpg");
		
		System.out.println("Nome do ficheiro: \t" + f.getName());
		System.out.println("Ruta : \t" + f.getPath());
		System.out.println("Ruta absoluta : \t" + f.getAbsolutePath());
		System.out.println("Ruta anterior : \t" + f.getParent());
		System.out.println("P�dese escribir: \t" + f.canWrite());
		System.out.println("P�dese ler: \t" + f.canRead());
		System.out.println("Tama�o: \t" + f.length() + " bytes");
		System.out.println("� un directorio: \t" + f.isDirectory());
		System.out.println("� un ficheiro: \t" + f.isFile());
	}
}
