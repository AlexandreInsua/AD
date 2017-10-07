package UD01ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * Escribe nun ficheiro o nome e tres notas dun alumno. Le o ficheiro e devolve a información, a nota media do alumno e a do grupo.
 */
public class Ex_Alumno {

	public static void main(String[] args) throws IOException {

		File f = new File("Alumno.txt");
		FileOutputStream fos = new FileOutputStream(f,true);
		DataOutputStream dos = new DataOutputStream(fos);

		Scanner sc = new Scanner(System.in);
		String opcion = "";
		
		while (!opcion.equalsIgnoreCase("n")) {
			System.out.println("Por favor introduza o alumno: ");
			String alumn = sc.nextLine();
			dos.writeUTF(alumn);
			System.out.println("Desexa introducir outro alumno (S/N)");
			opcion = sc.next();
		}

		
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
	
		
		String dato = dis.readUTF();
		String [] data = dato.split(" ");
		String nome = data[0];
		int n1 = Integer.parseInt(data[1]);
		int n2 = Integer.parseInt(data[2]);
		int n3 = Integer.parseInt(data[3]);
		float mediaAlumno = (n1+n2+n3)/3;
		
		System.out.println("Nome: "+ nome + ", nota 1: "+ n1+", nota 2: "+ n2+", nota 3: "+ n3+ " nota media: "+ mediaAlumno);
		
		dos.close();
		dis.close();
		sc.close();
	}
}
