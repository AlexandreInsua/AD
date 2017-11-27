package unidade01;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exemplo12b_DataOutputStream_escribe_doubles {

	/*
	 * Exemplo que escribe números doubres nun ficheiro todos os números son
	 * reais.
	 */
	public static void main(String[] args) {
		// Declaramos os obxectos FileOutputStream e DataOutputStream
		File f = null;
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			double[] array = { 5.25, 145.18, 2.37, 143.12, 147.10, 169.19, 47.65 };
			f = new File("Decimais.txt");
			f.createNewFile();
			fos = new FileOutputStream(f, false);
			dos = new DataOutputStream(fos);
			// Mentres o array teñe elementos escríbeos no ficheiro.
			for (double i : array) {
				dos.writeDouble(i);
			}
		} catch (FileNotFoundException fne) {
			System.out.println("Non se puido abrir o ficheiro");
		} catch (IOException ioe) {
			System.out.println("Non se puido escribir no ficheiro 'Decimais.txt'.");
		} finally {
			try {
				dos.close();
			} catch (IOException ioe) {
				System.out.println("Non se puido pechar o ficheiro 'Decimais.txt'.");
			}
		}
	}
}
