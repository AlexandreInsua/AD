package unidade01;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exemplo13b_FileInputStream_DataInputStream_dobres {
	public static void main(final String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("Decimais.txt");
			dis = new DataInputStream(fis);

			// bucle infinito
			while (true)
				// Le enteiros
				System.out.print(dis.readDouble() + " ");
		} catch (EOFException e) {
			System.out.println("\n Oficheiro non ten máis información");
		} catch (FileNotFoundException e) {
			System.out.println("ERRO GRAVE: O ficheiro Enteiros.txt non está disponible");
		} catch (IOException ioe) {
			System.out.print("Erro non se puido ler de Enteros.txt");
		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				System.out.print("Erro no se puido pechar Enteiros.txt");
			}
		}
	}
}
