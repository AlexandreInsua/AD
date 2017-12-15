package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntroducirDatos {

	public static String IntroducirDatos(final String cad) throws IOException {
		// Introducindo unha cadea de caracteres
		String cadena = null;
		// 1�. Crea un obxecto InputStreamReader
		InputStreamReader isr = new InputStreamReader(System.in);
		// 2�. Crea un obxecto BufferedReader
		BufferedReader br = new BufferedReader(isr);
		System.out.println(cad);
		return br.readLine();
	}
}
