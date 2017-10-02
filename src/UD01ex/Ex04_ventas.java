package UD01ex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex04_ventas {

	public static void main(String[] args) {
		int nart = 0;
		String Artigo = "";
		int pvp = 0;
		int stock = 0;
		int minimo = 0;

		int nart2 = 0;
		int ventas = 0;
		char tipo;

		File f = new File("Artigos.dat");
		File v = new File("Ventas.dat");
		FileWriter fw ;
		
		lerArtigos();
		
		escribirArtigos();
		
		
		
		
		try {
			fw = new FileWriter(f);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void escribirArtigos() {
		// TODO Auto-generated method stub
		
	}

	private static void lerArtigos() {
		// TODO Auto-generated method stub
		
	}
}
