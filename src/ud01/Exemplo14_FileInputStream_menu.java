package ud01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Le ou escribe o código ou nome de usuario dun ficheiro
 */
public class Exemplo14_FileInputStream_menu {
	public static void main(final String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opcion = 0;

		/* MENU */
		do {
			try {
				System.out.println("1.- Escribir no fichero");
				System.out.println("2.- Leer do fichero");
				System.out.println("3.- Sair");
				System.out.println("Elexir opción: ");
				opcion = Integer.parseInt(br.readLine());
				switch (opcion) {
				case 1:
					EscrituraDisco();
					break;
				case 2:
					LecturaDisco();
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Erro ao introducir a opción");
			} catch (IOException ioe) {
				System.out.println("Erro ao introducir a opción");
			}

		} while (opcion != 3);
	}

	/* MÉTODO PARA A ESCRITURA EN DISCO */
	static void EscrituraDisco() {
		File archivo = null;
		DataOutputStream flujoescritura = null;
		String respuesta = "";
		System.out.println("Introduce o nome do ficheiro de claves desde o teclado");
		try {
			String nombrefich = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
			archivo = new File(nombrefich);
			if (archivo.exists()) {
				System.out.println("O fichero xa existe. Desexa sobreescribirlo (SI/NON)?");
				respuesta = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
			}
			if (respuesta.compareToIgnoreCase("si") == 0) {
				flujoescritura = new DataOutputStream(new FileOutputStream(nombrefich));
			} else {
				flujoescritura = new DataOutputStream(new FileOutputStream(nombrefich, true));
			}
			System.out.println("Introduce o nome de usuario: ");
			String nombre = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
			System.out.println("Introduce o código de usuario: ");
			int codigo = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());
			flujoescritura.writeInt(codigo);
			flujoescritura.writeUTF(nombre);
		} catch (IOException ioe) {
			System.out.println("Non se pudo escribir a información no fichero " + archivo.getName());
		} finally {
			try {
				if (flujoescritura != null) {
					flujoescritura.close();
				}
			} catch (IOException ioe) {
				System.out.println("No se pudo pechar correctamente o flujo do ficheiro" + archivo.getName());
			}
		}
	}

	/* MÉTODO PARA A LECTURA EN DISCO */
	static void LecturaDisco() {
		File archivo = null;
		DataInputStream flujolectura = null;

		System.out.println("Introduce o nome do ficheiro: ");
		try {
			archivo = new File(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());
			flujolectura = new DataInputStream(new FileInputStream(archivo));
			// OLLO !! a orde ao ler ten que ser o mesmo que ao escribir
			while (true) {
				System.out.println("Codigo de Usuario: " + flujolectura.readInt());
				System.out.println("Nombre de Usuario: " + flujolectura.readUTF());
			}
		} catch (FileNotFoundException fnf) {
			System.out.println("No se encontrou o ficheiro" + archivo.getName());
		} catch (EOFException eof) {
		} catch (IOException ioe) {
			System.out.println("No se puido ler a información do ficheiro " + archivo.getName());
		} finally {
			try {
				if (flujolectura != null) {
					flujolectura.close();
				}
			} catch (IOException ioe) {
				System.out.println("No se puido pechar o fluxo do ficheiro " + archivo.getName());
			}
		} // fin finally
	}// fin main
}// fin clase
