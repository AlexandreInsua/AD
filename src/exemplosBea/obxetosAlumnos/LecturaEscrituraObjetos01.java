package exemplosBea.obxetosAlumnos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// ejemplo que nos permite escribir y leer objetos Alumnos
// el fichero se sobreescribe no hay problemas de cabeceras

public class LecturaEscrituraObjetos01 {

	public static void main(String[] args) {
		escrituraObjetos();
		lecturaObjetos();

	}
	
	static void escrituraObjetos(){
		FileOutputStream fo = null;
		ObjectOutputStream oo = null;
		
		try{
			fo = new FileOutputStream("Alumnos.dat", true);
			oo = new ObjectOutputStream(fo);
			
			//creo los objetos a escribir
			Alumnos alumno1 = new Alumnos("María", "Vigo", 25 );
			Alumnos alumno2 = new Alumnos("Juan", "Madrid", 32 );
			Alumnos alumno3 = new Alumnos("Marta", "Eibar", 22 );
			
			// escribimos en el fichero
			oo.writeObject(alumno1);
			oo.writeObject(alumno2);
			oo.writeObject(alumno3);
			
		
		}catch(FileNotFoundException fn){
			System.out.println("Error. Fichero no existe");
		}catch(IOException io){
			System.out.println("Error de escritura");
		}
	}// fin metodo escrituraObjetos
	
	static void lecturaObjetos(){
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		
		try{
			fi = new FileInputStream("Alumnos.dat");
			oi = new ObjectInputStream(fi);
			
			while(true){
				//creo el objeto donde voy a guardar los datos leidos del disco
				Alumnos alumno = (Alumnos) oi.readObject();
				System.out.println(alumno);
			}
			
		}catch(ClassNotFoundException cn){
			System.out.println("Error en la clase alumnos");
		}catch(FileNotFoundException fn){
			System.out.println("Error. Fichero no existe");
		}catch(EOFException eof){
			System.out.println("Fin de la lectura");
		}catch(IOException io){
			System.out.println("Error de lectura/escritura");
		}
	}// fin metod0 lecturaObjetos

}
