package UD01ex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Scanner;

public class Ex03_Artigos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f = new File("Artigos.dat");
		File ids = new File("articlesCodes.dat");
		FileOutputStream oos = null;

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
				readArticles(f);
			}
			System.out.println("Introduza a opción:\n1.- Inserir datos\n2.- Listar datos\n3.- Saír");
			option = Integer.parseInt(sc.nextLine());
		}
	}

	private static void insertDataNewFile(Scanner sc, File f) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);

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

			oos.writeObject(a);
			oos.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error: ficheir non encontrado.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void insertData(Scanner sc, File f) {
		System.out.println("inserindo datos en ficheiro existente");

	}

	private static void readArticles(File f) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			Article a = (Article) ois.readObject();
			System.out.println(a.getCODIGO() + "\t " + a.getDescription() + "\t " + a.getPVP() + "\t " + a.getStock()
					+ "\t " + a.getMinStock());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
