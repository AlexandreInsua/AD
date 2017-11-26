package exemplosBea.obxetos01Persoa;
/*
 * este ejemplo escribe objetos del tipo Persona en un fichero en disco
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscrituraObjetoPersona {
	public static void main(final String[] args) {
		// creamos los objetos que nos permiten escribir
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		
		try{
			fs = new FileOutputStream("Personas.txt");
			os = new ObjectOutputStream(fs);
			//declaramos el objeto Persona usando un constructor y escribimos en el disco
			Persona p = new Persona("Marta peres", 32);
			os.writeObject(p);
			
			// escribimos pasando la creación del objeto
			os.writeObject(new Persona("Ana Sánchez", 27));
		//	p = new Persona();
			p.setEdad(44);
			p.setNombre("Pedro Martínez");
			os.writeObject(p);
			
			// cerramos el fichero
			os.close();
		}catch(FileNotFoundException fne){
			System.out.println("Error en el fichero");
		}catch(IOException ioe){
			System.out.println("Error E/L");
		}
	}
}
