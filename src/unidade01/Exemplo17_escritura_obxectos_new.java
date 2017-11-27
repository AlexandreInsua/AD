package unidade01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class Exemplo17_escritura_obxectos_new {
	public static void main(final String[] args) {
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			fs = new FileOutputStream("Persoas01.txt");
			os = new ObjectOutputStream(fs);
			// Persoa p = new Persoa();
			for (int i = 0; i < 5; i++) {
				Persoa p = new Persoa(); // Dentro do bucle créase un novo
											// obxecto
				System.out.println("Introduce o nome do empregado: ");
				p.setNombre(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());
				System.out.println("Introduce a idade do empregado: ");
				p.setEdad(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine().trim()));
				os.writeObject(p);
			}
			System.out.println("Fin");
			os.close();
		} catch (FileNotFoundException fne) {
			System.out.println("Erro no ficheiro");
		} catch (IOException ioe) {
			System.out.println("Erro E/L");
		}
	}

}
