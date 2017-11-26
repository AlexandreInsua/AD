package exemplosBea.obxetos01Persoa;

/*
 * Ejemplo que lee el primer objeto de un fichero en disco
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class LecturaObjetoPersona01 {
	public static void main(final String[] args) {
		System.out.println("Nombre \t Edad" );
		try{
			// abrimos el fichero para lectura
			FileInputStream fs = new FileInputStream("Personas.txt");
			ObjectInputStream os = new ObjectInputStream(fs);
			
			// solo recupera un objeto
			// os debe realizar un casting al tipo original
			Persona p = (Persona)os.readObject();
			System.out.println(p.getNombre() +"\t" +p.getEdad());
			
			os.close();
		}catch(ClassNotFoundException cnf){
			System.out.println("Error la clase");
		}catch(FileNotFoundException fnfe){
			System.out.println("Error en el fichero");
		}catch(IOException ioe){
			System.out.println("Error E/L");
		}
	}

}
