package unidade01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/*
 * Creao un ficheiro de acceo directo 
 * Cada rexistro está composto de:
 * clave (int), nome (String de 25 caracteres), idade (int)
 * A clave é a posición do rexistro dentro do ficheiro
 */
public class Exemplo20_acceso_aleatorio {
	// Nun ficheiro ramdom hai que establecer o tamaño do rexsitro
	// Un carácter son dous bytes no ficheiro
	private static final long tamanhoRexistro = 35;

	public static void main(String[] args) {
		File file = new File("NomesIdades.dat");
		String option;

		do {
			System.out.println("1.- Introducir novo rexistro");
			System.out.println("2.- Listado completo");
			System.out.println("3.- Buscar rexistro");
			System.out.println("4.- Modificar rexistro");
			System.out.println("5.- Sair");

			option = enterData("Introduce unah opción: ");

			try {
				switch (Integer.parseInt(option)) {
				case 1:
					insertNewRegister(file);
					break;
				case 2:
					if (file.exists()) {
						fullList(file);
					} else {
						System.out.println("O ficheiro non existe. Ten que inserir datos.");
					}
					break;
				case 3:
					searchRegister(file);
					break;
				case 4:
					modifyRegister(file);
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Opción incorrecta.");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("A opción ten que ser un número");
			}
		} while (!option.equals("5"));
	} // fin do main

	/* MÉTODOS PÚBLICOS E MÉTODDDO STATIC */

	/* MÉTODO PARA INTRODUCIR DATOS DESDE O TECLADO */
	private static String enterData(final String string) {
		try {
			System.out.println("-------------------------");
			System.out.println(string);
			return (new BufferedReader(new InputStreamReader(System.in))).readLine();
		} catch (IOException ioe) {
			System.out.println("Erro interno no sistema I/O");
		}
		return "";
	}

	/* MÉTODO PARA MODIFICAR REXISTROS */
	private static void modifyRegister(File file) {
		RandomAccessFile punteiro = null; // punteiro
		String resposta = null;
		// atributos
		int clave = 0;
		String nome = "";
		int idade = 0;

		try {
			// abrir ficheiro, capturando datos
			punteiro = new RandomAccessFile(file, "rw");
			clave = Integer.parseInt(enterData("Introducir a clave do rexistro (0 para finalizar): "));
			while (clave != 0) {
				// coloca o punteiro segundo a clave para ler o rexistro
				punteiro.seek((clave - 1) * tamanhoRexistro);
				// lemos os campos do rexistro
				// lemos os campos do rexistro
				clave = punteiro.readInt();
				nome = punteiro.readUTF();
				idade = punteiro.readInt();
				// visualizamos os datos
				System.out.println(clave + " " + nome + " " + idade);
				resposta = enterData("Desexa modificar o rexistro? (S/N)");
				// modifica o rexistro
				if (resposta.compareToIgnoreCase("s") == 0) {
					// introduce o nome
					nome = enterData("Introduce o nome: ");
					// valida o nome introducido
					if (nome.length() > 25) {
						for (int i = nome.length(); i < 25; i++) {
							nome = nome + " ";
						}
					} else {
						nome = nome.substring(0, 25);
					}
					// introduce a idade
					idade = Integer.parseInt(enterData("Introduce a idade: "));
					if (punteiro.length() != 0) {
						punteiro.seek(punteiro.length());
					}
					// recoloca o punteiro segundo a clave para escribir
					punteiro.seek((clave - 1) * tamanhoRexistro);
					punteiro.writeInt(clave);
					punteiro.writeUTF(nome);
					punteiro.writeInt(idade);
				}
				// volve a mostrar a mensaxe
				clave = Integer.parseInt(enterData("Introducir a clave do rexistro (0 para finalizar): "));
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Erro ao introducir os datos");
		} catch (FileNotFoundException nfe) {
			System.out.println("Ficheiro inexistente.");
		} catch (Exception e) {
			System.out.println("Erro non especificado");
		} finally {
			try {
				punteiro.close();
			} catch (IOException e2) {
				System.out.println("Erro ao pechar o ficheiro");
			}
		}
	}

	/* MÉTODO PARA BUSCAR REXISTROS */
	private static void searchRegister(File file) {
		RandomAccessFile punteiro = null; // punteiro
		// atributos
		int clave = 0;
		String nome = "";
		int idade = 0;
		try {
			// abre o ficheiro, capturando datos
			punteiro = new RandomAccessFile(file, "r"); /// modo lectura
			// fóra do while
			clave = Integer.parseInt(enterData("Introducir a clave  0  para finalizar): "));
			while (clave != 0) {
				// colocamos o punteiro segundo a clave
				punteiro.seek((clave - 1) * tamanhoRexistro);
				// lemos os campos do rexistro
				clave = punteiro.readInt();
				nome = punteiro.readUTF();
				idade = punteiro.readInt();
				// visualizamos os datos
				System.out.println(clave + " " + nome + " " + idade);
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Erro ao introducir os datos");
		} catch (FileNotFoundException nfe) {
			System.out.println("Ficheiro inexistente.");
		} catch (Exception e) {
			System.out.println("Erro non especificado");
		} finally {
			try {
				punteiro.close();
			} catch (IOException e2) {
				System.out.println("Erro ao pechar o ficheiro");
			}
		}
	}

	/* MÉTODO PARA MOSTRAR A LISTA COMPLETA */
	private static void fullList(File file) {
		RandomAccessFile punteiro = null; // punteiro
		long contadorRexistros = 0; // vai server para contar os rexistros
		// atributos
		int clave = 0;
		String nome = "";
		int idade = 0;
		try {
			punteiro = new RandomAccessFile(file, "r"); // modo lectura

			// conta o número de rexistros
			contadorRexistros = punteiro.length() / tamanhoRexistro;
			System.out.println(
					"Nº de rexistros " + contadorRexistros + " Tamaño do ficheiro: " + punteiro.length() + "\n\n");
			for (int r = 0; r < contadorRexistros; r++) { // r de read
				punteiro.seek(r * tamanhoRexistro);

				clave = punteiro.readInt();
				nome = punteiro.readUTF();
				idade = punteiro.readInt();
				if (clave != 0) {
					System.out.println(clave + " " + nome + " " + idade);
				}
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Erro ao introducir os datos");
		} catch (FileNotFoundException nfe) {
			System.out.println("Ficheiro inexistente.");
		} catch (Exception e) {
			System.out.println("Erro non especificado");
		} finally {
			try {
				punteiro.close();
			} catch (IOException e2) {
				System.out.println("Erro ao pechar o ficheiro");
			}
		}
	}

	/* MÉTODO PARA INSERIR NOVOS REXISTROS */
	private static void insertNewRegister(File file) {
		RandomAccessFile punteiro = null; // punteiros
		// atributos
		int clave = 0;
		String nome = "";
		int idade = 0;
		try {
			punteiro = new RandomAccessFile(file, "rw"); // modo
															// lectura/escritura
			String resposta = null;
			do {
				// teclea os datos
				clave = Integer.parseInt(enterData("Introduce a clave"));
				// comproba a lonxitude do nome tecleado, se é menor de 25,
				// éncheo, senón acúrtao
				nome = enterData("Introduce o nome");
				if (nome.length() < 25) {
					for (int i = nome.length(); i < 25; i++) {
						nome = nome + "";
					} // fin for
				} else {
					nome = nome.substring(0, 25);
				} // fin if
				idade = Integer.parseInt(enterData("Introduce a idade: "));
				// graba o rexistro no archivo
				// colocamos o punteiro segundo a clave
				punteiro.seek((clave - 1) * tamanhoRexistro);
				punteiro.writeInt(clave);
				punteiro.writeUTF(nome);
				punteiro.writeInt(idade);
				resposta = enterData("Desexa continuar S/N");

			} while (resposta.equalsIgnoreCase("s"));

		} catch (NumberFormatException nfe) {
			System.out.println("Erro ao introducir os datos");
		} catch (FileNotFoundException nfe) {
			System.out.println("Ficheiro inexistente.");
		} catch (Exception e) {
			System.out.println("Erro non especificado");
		} finally {
			try {
				punteiro.close();
			} catch (IOException e2) {
				System.out.println("Erro ao pechar o ficheiro");
			}
		}
	}
}
