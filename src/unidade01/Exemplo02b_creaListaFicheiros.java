package unidade01;

import java.io.File;
import java.io.IOException;

/*
* Exemplo que crea un directorio, un ficheiro e o lista
*/
public class Exemplo02b_creaListaFicheiros {
	public static void main(final String[] args) throws IOException {
		System.out.println("Listaxe de ficheiros do directorio creado:");

		// crea o directorio co nome listado como argumento
		File f = new File("directorioCreado");
		f.mkdir();

		// crea o ficheiro
		File f2 = new File("directorioCreado\\ficheiroCreado");
		f2.createNewFile();
		
		// Instancia a lista de arquivos
		String[] arquivos = f.list();

		// Mostra a array de arquivos
		for (int i = 0; i < arquivos.length; i++) {
			System.out.println(arquivos[i]);
		}
	}
}
