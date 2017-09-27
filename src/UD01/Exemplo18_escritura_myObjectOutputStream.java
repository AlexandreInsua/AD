package UD01;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Xestiona un ficheiro de clientes.
 * Non hai problema de cabeceiras porque non está activo o parámetro main.
 */

public class Exemplo18_escritura_myObjectOutputStream {
	public static void main(final String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opcion;
		do {
			System.out.println("1.- Inserir rexistros.");
			System.out.println("2.- Ler rexistros.");
			System.out.println("3.- Sair.");
			System.out.println("Elegir opcion: ");
			opcion = Integer.parseInt(br.readLine());
			switch (opcion) {
			case 1:
				Escritura();
				break;
			case 2:
				Lectura();
				break;
			}// fin switch
		} while (opcion != 3);
	}// fin main

	public static void Escritura() {
		ObjectOutputStream flujoescritura = null;
		File archivo, carpeta;
		carpeta = new File("Clientes");
		if (!carpeta.exists()) {
			carpeta.mkdir();
		}
		archivo = new File(carpeta, "Correos.txt");
		try {
			flujoescritura = new ObjectOutputStream(new FileOutputStream(archivo));
			flujoescritura.writeObject(new Persoa("Pepe Salas Pérez", 45));
			flujoescritura.writeObject(new Persoa("Maria Martín Sierra", 23));
			System.out.println("ESCRIBIUSE NO FICHEIRO " + archivo);
		} catch (IOException e) {
			System.out.println("NON SE PUIDO ESCRIBIR A INFORMACIÓN NO FICHEIRO " + archivo);
		} finally {
			try {
				if (flujoescritura != null) {
					flujoescritura.close();
				}
			} catch (IOException e) {
				System.out.println("NON SE PUIDO PECHAR CORRECTAMENTE O FLUXO ASOCIADO AO FICHEIRO " + archivo);
			}
		}
	}

	private static void Lectura() {
		ObjectInputStream flujolectura = null;
		File archivo;
		archivo = new File("Clientes", "Correos.txt");
		try {
			flujolectura = new ObjectInputStream(new FileInputStream(archivo));
			System.out.println("NOME\t IDADE ");
			while (true) {
				Persoa obj = (Persoa) flujolectura.readObject();
				System.out.println(obj.getNombre() + "\t " + obj.getEdad());
			}

		} catch (ClassNotFoundException e) {
			System.out.println("NON SE PUIDO CONVERTIR A INFORMACIÓN");
		} catch (EOFException eof) {
			System.out.println("Finalizouse a lectura do ficheiro ");
		} catch (IOException e) {
			System.out.println("NON SE PUIDO LER A INFORMACIÓN DO FICHEIRO");
		} finally {
			try {
				if (flujolectura != null) {
					flujolectura.close();
				}
			} catch (IOException e) {
				System.out.println("NON SE PUIDO PECHAR CORRECTAMENTE O FLUXO ASOCIADO AO FICHEIRO ");
			}
		} // fin finally
	}// fin metodo lectura
}// fin clase
