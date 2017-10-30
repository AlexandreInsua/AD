package ud01ex;

/*
 *  Xestiona o ficheiro artigos.dat 
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
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
		try {
			runMenu(sc, f);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	private static void runMenu(Scanner sc, File f) {
		System.out.println(
				"Introduza a opción:\n1.- Inserir datos\n2.- Listar datos\n3.- Listar productos por debaixo de stock\n4.- Saír");
		int option = Integer.parseInt(sc.nextLine());
		while (option != 4) {

			switch (option) {
			case 1:
				try {
					if (f.exists()) {
						insertData(sc, f);
					} else {
						insertDataNewFile(sc, f);
					}

				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

				break;

			case 2:
				readFile(f);
				break;
			case 3:
				readCriticalStock(f);
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Insirar unha ocpión válida.");
				break;
			}
			System.out.println(
					"Introduza a opción:\n1.- Inserir datos\n2.- Listar datos\n3.- Listar productos por debaixo de stock\n4.- Saír");
			option = Integer.parseInt(sc.nextLine());
		}
	}

	private static void readCriticalStock(File f) {
		System.out.println("Artigos por debaixo de stock");

	}

	private static Article askForObject(Scanner sc) {
		Article a = null;
		System.out.println("Introduza os datos do Obxecto: ");
		System.out.println("Código: ");
		int code = 0;
		try {
			code = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}
		if (validateCode(code)) {
			System.out.println("Código: ");
			code = Integer.parseInt(sc.nextLine());
			System.out.println("Descripción: ");
			String desc = sc.nextLine();
			System.out.println("PVP: ");
			double pvp = Double.parseDouble(sc.nextLine());
			System.out.println("Existencias: ");
			int stck = Integer.parseInt(sc.nextLine());
			System.out.println("Existencias mínimas: ");
			int minStck = Integer.parseInt(sc.nextLine());

			a = new Article(code, desc, pvp, stck, minStck);

		}
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
			try {
				moos.writeObject(askForObject(sc));
			} catch (NumberFormatException e) {

				e.printStackTrace();
			}
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
			System.out.println("Código\tDescrp.\tPrezo\tExists.\t\tExists. míns.\tTotal");
			while (true) {
				Article a = (Article) ois.readObject();
				double pvp = a.getPVP();
				int stock = a.getStock();
				double total = pvp * stock;
				System.out.println(a.getCODIGO() + "\t " + a.getDescription() + "\t " + a.getPVP() + "\t "
						+ a.getStock() + "\t\t " + a.getMinStock() + "\t\t" + total + "€");

			}

		} catch (EOFException eof) {
		} catch (ClassNotFoundException cnf) {
			System.out.println("Error: fallo na clase");
		} catch (NullPointerException npe) {
			System.out.println("Error: ficheiro non encontrado.");
		} catch (FileNotFoundException fnf) {
			System.out.println("Error: ficheiro non encontrado.");
		} catch (IOException ioe) {
			System.out.println("Error: fallo na lectura/escritura");
		} finally {
			try {
				ois.close();
			} catch (NullPointerException npe) {
				System.out.println("Error: ficheiro non encontrado.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean validateCode(int code) {
		boolean codeValidated = false;
		File codesFile = (new File("articlesCodes.dat"));
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		int newCode = code;

		if (codesFile.exists()) {
			try {
				fis = new FileInputStream(codesFile);
				fos = new FileOutputStream(codesFile);
				dis = new DataInputStream(fis);
				dos = new DataOutputStream(fos);

				while (true) {
					try {
						int oldCode = dis.read();
						if (newCode == oldCode) {
							System.out.println("Codigo repetido");
							break;
						} else {
							dos.writeInt(newCode);
							codeValidated = true;
						}
					} catch (NumberFormatException e) {
						System.out.println("Introduza un número como código.");
					}
				}
			} catch (IOException ioe) {
				System.out.println("Error: fallo na lectura/escritura");
			} finally {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			try {
				codesFile.createNewFile();
				fos = new FileOutputStream(codesFile);
				dos = new DataOutputStream(fos);
				System.out.println("Creando rexistro de código");
				dos.writeInt(code);
				codeValidated = true;
			} catch (IOException e) {

				e.printStackTrace();
			} finally {
				try {
					dos.close();
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return codeValidated;
	}
}

@SuppressWarnings("serial")
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
