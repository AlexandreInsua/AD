package UD01ex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Ex03_Articles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f = new File("Artigos.dat");
		new File("articlesCodes.dat");
		runMenu(sc, f);
	}

	private static void runMenu(Scanner sc, File f) {
		System.out.println("Introduza a opción:\n1.- Inserir datos\n2.- Listar datos\n3.- Saír");
		int option = Integer.parseInt(sc.nextLine());
		while (option != 3) {
			if (option == 1) {
				if (f.exists()) {
					insertData(sc, f);

				} else {
					insertDataNewFile(sc, f);
				}
			}
			if (option == 2) {
				readFile(f);
			}
			System.out.println("Introduza a opción:\n1.- Inserir datos\n2.- Listar datos\n3.- Saír");
			option = Integer.parseInt(sc.nextLine());
		}
	}

	private static Article askForObject(Scanner sc) {
		System.out.println("Introduza os datos do Obxecto: ");
		System.out.println("Código: ");
		int code = Integer.parseInt(sc.nextLine());
		// TODO implementar validación código
		System.out.println("Descripción: ");
		String desc = sc.nextLine();
		System.out.println("PVP: ");
		double pvp = Double.parseDouble(sc.nextLine());
		System.out.println("Existencias: ");
		int stck = Integer.parseInt(sc.nextLine());
		System.out.println("Existencias mínimas: ");
		int minStck = Integer.parseInt(sc.nextLine());

		Article a = new Article(code, desc, pvp, stck, minStck);
		return a;

	}

	private static void insertDataNewFile(Scanner sc, File f) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(askForObject(sc));
			oos.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: ficheiro non encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: fallo de lectura/escritura no ficheiro");
		}
	}

	private static void insertData(Scanner sc, File f) {
		FileOutputStream fos = null;
		MyObjectOutputStream moos = null;
		try {
			fos = new FileOutputStream(f, true);
			moos = new MyObjectOutputStream(fos);
			moos.writeObject(askForObject(sc));
			moos.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: ficheiro non encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: fallo de lectura/escritura no ficheiro");
		}

	}

	private static void readFile(File f) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			System.out.println("Código\tDescripción\tPrezo\tExistencias\tExistencias mínimas");
			while (true) {
				Article a = (Article) ois.readObject();
				System.out.println(a.getCODIGO() + "\t " + a.getDescription() + "\t " + a.getPVP() + "\t "
						+ a.getStock() + "\t " + a.getMinStock());

			}

		} catch (ClassNotFoundException cnf) {
			System.out.println("Error: fallo na clase");
		} catch (FileNotFoundException fnf) {
			System.out.println("Error: ficheiro non encontrado.");
		} catch (IOException ioe) {
			System.out.println("Error: fallo na lectura/escritura");
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Article implements Serializable {
	private int CODIGO;
	private String description;
	private double PVP;
	private int stock;
	private int minStock;

	public Article(int Codigo, String description, double pVP, int stock, int minStock) {
		CODIGO = Codigo;
		this.description = description;
		PVP = pVP;
		this.stock = stock;
		this.minStock = minStock;
	}

	public int getCODIGO() {
		return CODIGO;
	}

	public void setCODIGO(int cODIGO) {
		CODIGO = cODIGO;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPVP() {
		return PVP;
	}

	public void setPVP(double pVP) {
		PVP = pVP;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	boolean seekArticle(int code) {
		boolean thereIs = false;
		if (code == this.CODIGO)
			thereIs = true;
		return thereIs;
	}

	void minArticle() {
		if (this.stock <= this.minStock)
			System.out.println("Realizar pedido de " + description);
	}
}
