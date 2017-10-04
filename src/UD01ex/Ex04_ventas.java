package UD01ex;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*4º) Codificar un programa que nos permita actualizar el fichero de artículos. Para ello tenemos un fichero
de movimientos VENTAS.DAT que contiene toda la información de las compras y las ventas realizadas, otro
fichero maestro ARTICULOS.DAT, con la información de todos los artículos de la empresa, que es el que hay
que actualizar.
La estructura del fichero directo ARTICULOS.DAT es:
NART Autoincrementable ,ARTICULO Alfanumérico (20) ,PVP Numérico , STOCK Numérico ,MINIMO Numérico donde MINIMO es el stock mínimo de ese artículo

En el fichero secuencial, VENTAS.DAT, están almacenadas las modificaciones de los productos durante el día,
cuyos campos son: NART2 Numérico (5) VENTAS Numérico TIPO Carácter
el campo TIPO puede tomar los valores:  Cero: es una venta  Uno: es una compra del producto.

Puede haber más de un registro para un mismo artículo.
Se desea hacer un programa que realice la actualización del fichero ARTICULOS.DAT, y un listado de las
compras y otro de las ventas de los artículos.*/

public class Ex04_ventas {
	static int tamanhoRexistro = 40;

	public static void main(String[] args) {
		File f = new File("Artigos.dat");
		String option;

		do {
			System.out.println("1.- Crear Ficheiro de ventas");
			System.out.println("2.- Crear ficheiros de artigos");
			System.out.println("3.- Actualizar artigos");
			System.out.println("4.- Listar artigos");
			System.out.println("5.- Listar compras");
			System.out.println("6.- Listar ventas");
			System.out.println("7.- Saír");

			option = introducionDatos("Introduza unha opción: ");
			try {
				switch (Integer.parseInt(option)) {
				case 1:
					crearVentas();
					listarFicheiroVentas();
					break;
				case 2:
					crearFicheiroArtigos();
					break;
				case 3:
					actualizarArtigod();
					break;
				case 4:
					listarArtigos();
					break;
				case 5:
					listarCompras();
					break;
				case 6:
					listarVentas();
					break;
				case 7:
					System.exit(0);
				default:
					System.out.println("Opción errónea");
				}
			} catch (NumberFormatException e) {
				System.out.println("A opción ten que ser un número");
			}
		} while (!option.equals("7"));
	}

	private static void listarCompras() {
		FileInputStream fLectura = null;
		DataInputStream ds = null;
		int numArt = 0;
		int ventas = 0;
		int tipo = 0;
		
		String articulo = "";
		try{
			fLectura = new FileInputStream("Ventas.dat");
			ds = new DataInputStream(fLectura);
			System.out.println("Listado de Compras");
			System.out.println("N. Artículo \t Cantidad comprada");
			//bucle infinito
			while(true){
				numArt = ds.readInt();
				ventas = ds.readInt();
				tipo = ds.readInt();
				if(tipo == 1){
					articulo = recuperarArticulo(numArt);
					System.out.println(numArt +"\t " +articulo+"\t " +ventas );
				}
					
				
			}
		}catch (FileNotFoundException e){
			System.out.println("ERROR GRAVE: El fichero Ventas.DAT no está disponible");
			return;
		}catch (EOFException e){
				System.out.println("Fin del fichero");
		}catch(IOException ioe){
			System.out.print("Error no se ha podido leer de Enteros.txt");
		}
		finally{
			try{
				ds.close();
			}
			catch(IOException e){
				System.out.print("Error no se ha podido cerrar Ventas.DAT");
			}
		}
		
	}

	private static void crearFicheiroArtigos() {
		File f = new File("Articulos.DAT");
		RandomAccessFile puntero = null;

		int numArt = 0;
		String articulo = "";
		float precio = 0;
		int stock = 0;
		int minimo = 0;

		try {
			// abriendo archivo, capturando y grabando datos
			puntero = new RandomAccessFile(f, "rw");

			String respuesta = null;

			do {
				// teclea los datos
				numArt = Integer.parseInt(introducionDatos("Introduce la clave: "));

				// comprueba la longitud del articulo tecleado si es menor que
				// 20 lo rellena
				// si es mayor lo acorta
				articulo = introducionDatos("Introduce el artículo: ");
				if (articulo.length() < 20) {
					for (int i = articulo.length(); i < 20; i++)
						articulo = articulo + " ";
				} else {
					articulo = articulo.substring(0, 20);
				}

				precio = Float.parseFloat(introducionDatos("Introduce el precio: "));
				stock = Integer.parseInt(introducionDatos("Introduce el stock: "));
				minimo = Integer.parseInt(introducionDatos("Introduce el stock mínimo: "));
				// grabando el registro en el archivo

				// colocamos el puntero según la clave
				puntero.seek((numArt - 1) * tamanhoRexistro);
				puntero.writeInt(numArt);
				puntero.writeUTF(articulo);
				puntero.writeFloat(precio);
				puntero.writeInt(stock);
				puntero.writeInt(minimo);

				respuesta = introducionDatos("Desea continuar S/N");
			} while (respuesta.equalsIgnoreCase("s"));
		} catch (NumberFormatException nfe) {
			System.out.println("Error al introducir los datos");
		} catch (FileNotFoundException fnf) {
			System.out.println("Fichero inexistente");
		} catch (IOException ioe) {
			System.out.println(" Error al escribir en el fichero");
		} finally {
			try {
				puntero.close();
			} catch (IOException e) {
				System.out.println(" Error al cerrar el fichero ");
			}
		}
	}

	private static void actualizarArtigod() {
		// para leer el fichero VENTAS.DAT secuencialmente
		FileInputStream fLectura = null;
		DataInputStream ds = null;

		// para acceder de manera aleatoria al fichero ARTICULOS.DAT
		File f = new File("Articulos.DAT");
		RandomAccessFile puntero = null;

		// variables donde guardamos los datos del fichero Ventas.dat
		int numArtV = 0;
		int ventas = 0;
		int tipo = 0;

		// variables donde guardamos los datos del fichero Articulos.dat
		int numArtA = 0;
		String articulo = "";
		float precio = 0;
		int stock = 0;
		int minimo = 0;

		try {
			fLectura = new FileInputStream("Ventas.dat");
			puntero = new RandomAccessFile(f, "rw");
			ds = new DataInputStream(fLectura);
			System.out.println("Actualizando el FICHERO Articulos.DAT espere......");

			// bucle infinito para leer el fichero VENTAS.DAT
			while (true) {
				// leemos los datos de Ventas.dat
				numArtV = ds.readInt();
				ventas = ds.readInt();
				tipo = ds.readInt();

				// nos colocamos en el registro
				puntero.seek((numArtV - 1) * tamanhoRexistro);
				// leemos los datos de Articulos.dat
				numArtA = puntero.readInt();
				articulo = puntero.readUTF();
				precio = puntero.readFloat();
				stock = puntero.readInt();
				minimo = puntero.readInt();

				// compruebo si existe el articulo
				if (numArtA != 0) {// existe
					// actualizamos el stock segun el tipo de operación
					if (tipo == 0) // es una venta
						stock -= ventas;
					else // es una compra
						stock += ventas;
				} else {
					stock = ventas;
				}

				// recolocamos el punteroy escribimos en el fichero
				// Articulos.DAT
				puntero.seek((numArtV - 1) * tamanhoRexistro);

				puntero.writeInt(numArtV);
				puntero.writeUTF(articulo);
				puntero.writeFloat(precio);
				puntero.writeInt(stock);
				puntero.writeInt(minimo);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR GRAVE: El fichero Ventas.DAT no está disponible");
			return;
		} catch (EOFException e) {
			System.out.println("Fin del fichero");
		} catch (IOException ioe) {
			System.out.print("Error no se ha podido leer de Enteros.txt");
		} finally {
			try {
				ds.close();
			} catch (IOException e) {
				System.out.print("Error no se ha podido cerrar Ventas.DAT");
			}
		}
	}

	private static void listarVentas() {
		FileInputStream fLectura = null;
		DataInputStream ds = null;
		int numArt = 0;
		int ventas = 0;
		int tipo = 0;

		String articulo = "";
		try {
			fLectura = new FileInputStream("Ventas.dat");
			ds = new DataInputStream(fLectura);
			System.out.println("Listado de Ventas");
			System.out.println("N. Artículo \t Cantidad vendida");
			// bucle infinito
			while (true) {
				numArt = ds.readInt();
				ventas = ds.readInt();
				tipo = ds.readInt();
				if (tipo == 0) {
					articulo = recuperarArticulo(numArt);
					System.out.println(numArt + "\t " + articulo + "\t " + ventas);
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR GRAVE: El fichero Ventas.DAT no está disponible");
			return;
		} catch (EOFException e) {
			System.out.println("Fin del fichero");
		} catch (IOException ioe) {
			System.out.print("Error no se ha podido leer de Enteros.txt");
		} finally {
			try {
				ds.close();
			} catch (IOException e) {
				System.out.print("Error no se ha podido cerrar Ventas.DAT");
			}
		}

	}

	private static String recuperarArticulo(int numArt) {
		// para acceder de manera aleatoria al fichero ARTICULOS.DAT
		File f = new File("Articulos.DAT");
		RandomAccessFile puntero = null;

		// variables donde guardamos los datos del fichero Articulos.dat
		int numArtA = 0;
		String articulo = "";
		float precio = 0;
		int stock = 0;
		int minimo = 0;

		try {
			puntero = new RandomAccessFile(f, "r");
			// nos colocamos en el registro
			puntero.seek((numArt - 1) * tamanhoRexistro);
			// leemos los datos de Articulos.dat
			numArtA = puntero.readInt();
			articulo = puntero.readUTF();
			precio = puntero.readFloat();
			stock = puntero.readInt();
			minimo = puntero.readInt();

		} catch (FileNotFoundException e) {
			System.out.println("ERROR GRAVE: El fichero Ventas.DAT no está disponible");

		} catch (EOFException e) {
			System.out.println("Fin del fichero");
		} catch (IOException ioe) {
			System.out.print("Error no se ha podido leer de Enteros.txt");
		} finally {
			try {
				puntero.close();

			} catch (IOException e) {
				System.out.print("Error no se ha podido cerrar Ventas.DAT");
			}
		}
		return articulo;
	}

	private static void listarArtigos() {
		int numArt = 0;
		String articulo = "";
		float precio = 0;
		int stock = 0;
		int minimo = 0;

		RandomAccessFile puntero = null;
		long contadorRegistros = 0;
		try {
			// abriendo archivo, capturando datos
			puntero = new RandomAccessFile("Articulos.DAT", "r");

			// calculando el numero de registros
			contadorRegistros = puntero.length() / tamanhoRexistro;
			System.out.println(contadorRegistros);

			for (int r = 0; r <= contadorRegistros; r++) {
				puntero.seek(r * tamanhoRexistro);
				numArt = puntero.readInt();
				articulo = puntero.readUTF();
				precio = puntero.readFloat();
				stock = puntero.readInt();
				minimo = puntero.readInt();
				if (numArt != 0)
					System.out.println(numArt + " " + articulo + " " + stock);

			}

		} catch (EOFException eof) {
			System.out.println("Final del fichero ");
		} catch (FileNotFoundException fnf) {
			System.out.println("Fichero inexistente");
		} catch (IOException ioe) {
			System.out.println("Error al leer el fichero ");
		} finally {
			try {
				puntero.close();
			} catch (IOException e) {
				System.out.println(" Error al cerrar el fichero ");
			}
		}
	}

	private static void listarFicheiroVentas() {
		FileInputStream fLectura = null;
		DataInputStream ds = null;
		try {
			fLectura = new FileInputStream("Ventas.dat");
			ds = new DataInputStream(fLectura);
			System.out.println("FICHERO VENTAS.DAT");
			// bucle infinito
			while (true) {
				System.out.print(ds.readInt() + " ");
				System.out.println(ds.readInt() + " " + ds.readInt());
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR GRAVE: El fichero Ventas.DAT no está disponible");
			return;
		} catch (EOFException e) {
			System.out.println("Fin del fichero");
		} catch (IOException ioe) {
			System.out.print("Error no se ha podido leer de Ventas.DAT");
		} finally {
			try {
				ds.close();
			} catch (IOException e) {
				System.out.print("Error no se ha podido cerrar Ventas.DAT");
			}
		}

	}

	private static void crearVentas() {
		FileOutputStream fEscritura = null;
		DataOutputStream ds = null;
		int numArt;
		int ventas;
		int tipo; // 0: es una venta 1: es una compra
		try {
			fEscritura = new FileOutputStream("Ventas.dat", false);
			ds = new DataOutputStream(fEscritura);

			while ((numArt = Integer
					.parseInt(introducionDatos("Introduce el código del artículo. " + "<0 Para finalizar: "))) != 0) {
				ventas = Integer
						.parseInt(introducionDatos("Introduce la cantidad vendida o " + "comprada del artículo: "));
				do {
					tipo = Integer.parseInt(introducionDatos("Introduce 0.- Venta  1.- Compra:"));
				} while (tipo < 0 || tipo > 1);

				ds.writeInt(numArt);
				ds.writeInt(ventas);
				ds.writeInt(tipo);

			} // fin while

		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el fichero Enteros.txt");
		} catch (IOException e) {
			System.out.println("No se pudo escribir en el fichero Enteros.txt");
		} finally {
			try {
				fEscritura.close();
			} catch (IOException e) {
				System.out.println("No se pudo cerrar el fichero Enteros.txt");
			}
		}
	}

	public static String introducionDatos(final String s) {
		try {
			System.out.println("--------------------------------------------------------");
			System.out.print(s);
			return (new BufferedReader(new InputStreamReader(System.in))).readLine();
		} catch (IOException ioe) {
			System.out.println("\nError interno en sistema de entrada/salida\n");
		}
		return "";
	}// fin metodo introduccionDatos()
}
