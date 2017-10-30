package ud01;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exemplo13_FileInputStream_DataInputSteam {
	public static void main(final String[] args) {
		FileInputStream fis;
		DataInputStream dis;
		try {
			fis = new FileInputStream("Enteiros.txt");
			dis = new DataInputStream(fis);
		} catch (FileNotFoundException e) {
			System.out.println("ERRO GRAVE: O ficheiro Enteiros.txt non está disponible");
			return;
		}
		try {
			// bucle infinito
			while (true)
				// Le enteiros
				System.out.print(dis.readInt() + " ");
		} catch (EOFException e) {
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
