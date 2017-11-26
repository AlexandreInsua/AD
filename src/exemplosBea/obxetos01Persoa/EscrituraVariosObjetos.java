package exemplosBea.obxetos01Persoa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscrituraVariosObjetos {
	public static void main(final String[] args) {
		// creamos los objetos que nos permiten escribir
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		
		try{
			fs = new FileOutputStream("Personas.txt");
			os = new ObjectOutputStream(fs);
			//declaramos el objeto Persona usando un constructor y escribimos en el disco
			Persona p=new Persona();; 				
				
			
			for(int i=0; i<3;i++){
			//	p =
				p.setEdad(25+i);
				p.setNombre("Ana");
				os.writeObject(p);
			}
			
			
			// escribimos pasando la creación del objeto
			os.writeObject(new Persona("Ana Sánchez", 27));
		//	p = new Persona();
		
			
			// cerramos el fichero
			os.close();
		}catch(FileNotFoundException fne){
			System.out.println("Error en el fichero");
		}catch(IOException ioe){
			System.out.println("Error E/L");
		}
	}
}
