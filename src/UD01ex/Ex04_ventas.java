package UD01ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
	static int tamanhoRexistro = 46;
	static int nart = 0, stock = 0, minimo = 0;
	float pvp = 0;
	static String descricion = "";
	static final int DESC_MAX = 20;

	static int nart2 = 0, ventas = 0, tipo;

	public static void main(String[] args) {
		int option;
		Scanner sc = new Scanner(System.in);
		File f = new File("Artigos.dat");
		File v = new File("Ventas.dat");

		System.out.println("Introduza unha opción: ");
		
		option = sc.nextInt();
		do {
switch (option) {
case 1:
	
	break;

default:
	break;
}
			
		} while (option != 5);

		escribirArtigos(sc, f);
		escribirVentas(sc, v);
		lerArtigos();
		lerVentas();
		actualizarArtigos(f, v);

	}

	private static void escribirArtigos(Scanner sc, File f) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		System.out.println("O número de artigo: ");
		nart = sc.nextInt();
		System.out.println("Descrición: ");
		descricion = sc.next();

		if (descricion.length() > DESC_MAX) {
			descricion = descricion.substring(0, DESC_MAX);
		} else if (descricion.length() < DESC_MAX) {
			for (int i = descricion.length(); i <= DESC_MAX; i++) {
				descricion = descricion + " ";
			}
		}

		System.out.println("pvp: ");
		pvp = sc.nextInt();
		System.out.println("stock: ");
		stock = sc.nextInt();
		System.out.println("minimo: ");
		minimo = sc.nextInt();

		try {
			fos = new FileOutputStream(f);
			dos = new DataOutputStream(fos);
			dos.writeInt(nart);
			dos.writeUTF(descricion);
			dos.writeInt(pvp);
			dos.writeInt(stock);
			dos.writeInt(minimo);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void escribirVentas(Scanner sc, File v) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		System.out.println("O número de artigo: ");
		nart = sc.nextInt();
		System.out.println("Descrición: ");
		descricion = sc.next();

		if (descricion.length() > DESC_MAX) {
			descricion = descricion.substring(0, DESC_MAX);
		} else if (descricion.length() < DESC_MAX) {
			for (int i = descricion.length(); i <= DESC_MAX; i++) {
				descricion = descricion + " ";
			}
		}

		System.out.println("pvp: ");
		pvp = sc.nextInt();
		System.out.println("stock: ");
		stock = sc.nextInt();
		System.out.println("minimo: ");
		minimo = sc.nextInt();

		try {
			fos = new FileOutputStream(v);
			dos = new DataOutputStream(fos);
			dos.writeInt(nart);
			dos.writeUTF(descricion);
			dos.writeInt(pvp);
			dos.writeInt(stock);
			dos.writeInt(minimo);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void lerArtigos() {
		// TODO Auto-generated method stub

	}

	private static void lerVentas() {
		// TODO Auto-generated method stub

	}

	private static void actualizarArtigos(File f, File v) {
		// ler en ventasdat
		FileInputStream fis = null;
		DataInputStream dis = null;

		// para accderr aleatoriamentaen a artigos .can
		RandomAccessFile punteiro = null;

		// variables para gardar os datos de ficheiro ventas.dat
		int numV = 0;
		int ventas = 0;
		int tipo = 0;

		// variables para gardar os datos do ficheiro artigos.dat
		int numA = 0;
		String artigo = "";
		float prezo = 0;
		int minimo = 0;

		try {
			fis = new FileInputStream(v);
			punteiro = new RandomAccessFile(f, "r/w");

			// TODO por facer.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}
}
