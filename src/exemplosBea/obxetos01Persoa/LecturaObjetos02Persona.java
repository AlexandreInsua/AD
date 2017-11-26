package exemplosBea.obxetos01Persoa;
/*
 * Ejemplo que lee todos los objeto de un fichero en disco
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LecturaObjetos02Persona {
	public static void main(final String[] args) throws IOException {
		
		//abrimos el fichero de lectura 
		FileInputStream fs = null;
		ObjectInputStream os = null;
		
		System.out.println("Nombre \t Edad" );
		try{
			fs = new FileInputStream("Personas.txt");
			os = new ObjectInputStream(fs);
			while(true){ // lectura del fichero mientras haya objetos
				// os debe realizar un castingal tipo original
				Persona p = (Persona)os.readObject();
				System.out.println(p.getNombre() +"\t" +p.getEdad());
			}
		}catch(ClassNotFoundException cnf){
			System.out.println("Error la clase");
		}catch(FileNotFoundException fnfe){
			System.out.println("Error en el fichero");
		}catch(EOFException eo){
			System.out.println("Fin del fichero");
		}
		catch(IOException ioe){
			System.out.println("Error");
		}
		os.close();
	}

}
