package unidade01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Exemplo15_escritura_obxectos_append {

	public static void main(final String[] args) throws IOException {
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			fs = new FileOutputStream("Personas.txt",true);
			os = new ObjectOutputStream(fs);
			Persoa p = new Persoa("Marta", 32);
			os.writeObject(p);
			os.writeObject(new Persoa("Ana", 27));
						
		} catch (FileNotFoundException fne) {
			System.out.println("Error en el fichero");
		} catch (IOException ioe) {
			System.out.println("Error E/L");
		}
	os.close();}
}
