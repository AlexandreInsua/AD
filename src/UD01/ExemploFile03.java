package UD01;

import java.io.File;

/*
* No seguinte exemplo mostramos todos os ficheiros pdf que temos no directorio de Documentos.
* 
*/
public class ExemploFile03 {
	public static void main(final String[] args) {
		// separador almacena o tipo de separador utilizado na plataforma, en
		// windows "\"
		
		String separador = File.separator; // NB: separator é de clase

		// En carpeta almaceno o path do directorio cuxos elementos desexo ver
		File carpeta = new File("C:" + separador + "Users" + separador + "Alexandre" + separador + "Documents");
		System.out.println("Carpeta: " + carpeta);

		// En elementos almaceno a matriz con todos os nomes dos arquivos
		// e carpetas dentro da carpeta que lle indiquei

		String[] elementos = carpeta.list();
		// Mostramos o número de carpetas dentro da que lle pasei

		System.out.println("Os ficheiros .pdf son:\n");
		for (int i = 0; i < elementos.length; i++) {
			if (elementos[i].endsWith("pdf") || elementos[i].endsWith("PDF")) {
				System.out.println("\t" + carpeta.getAbsolutePath() + separador + elementos[i]);
			} // fin do if
		} // fin do for
	} // fin do main
} // fin da clase