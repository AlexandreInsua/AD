package exemplosBea.obxetos02Persoa;

/*
 * Ejemplo que añade una segunda cabecera en el fichero de objetos
 * si el fichero lo creamos en el modo añadir
 */

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exemplosBea.obxetos01Persoa.Persona;



public class EscrituraObjetosPersonaError02 {
	public static void main(final String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opcion;
		do{
			System.out.println("1.- Insertar Registros.");
			System.out.println("2.- Leer Registros.");
			System.out.println("3.- Salir.");
			System.out.println("Elegir opcion: ");
			opcion = Integer.parseInt(br.readLine());
			switch(opcion){
				case 1:
					Escritura();
					break;
				case 2:
					Lectura();
					break;
				default:
					System.out.println("Error en la opcion.");
				
			}// fin switch
		}while(opcion != 3);
	}// fin main
	
	public static void Escritura(){
		
		ObjectOutputStream flujoescritura = null;
		File archivo, carpeta;
		carpeta= new File ("Clientes");
		// comprueba si existe una carpeta llamada Clientes, en el caso de que no exista la crea
		if (!carpeta.exists()){
			carpeta.mkdir();
		}
		// abre el fichero correos
		archivo = new File (carpeta, "Correos01.txt");
		try{
			/*flujoescritura = new ObjectOutputStream ( new FileOutputStream (archivo));
			flujoescritura.writeObject( new Persona ("Pepe Salas Pérez", 45));
			flujoescritura.writeObject( new Persona ("Maria Martín Sierra", 23));*/
			
			flujoescritura = new ObjectOutputStream ( new FileOutputStream (archivo, true));
			flujoescritura.writeObject( new Persona ("Andres Sanchez Salinas", 38));
			flujoescritura.writeObject( new Persona ("Marian Martinez Gonzalez", 53));
			System.out.println("SE HA ESCRITO EN EL FICHERO "+ archivo);
		}catch (IOException e){
			System.out.println("NO SE HA PODIDO ESCRIBIR LA INFORMACION EN EL FICHERO "+ archivo);
		}finally{
			try {
				if (flujoescritura!=null){
					flujoescritura.close();
					System.out.println("Fin de la inserción de registros");
				}
			}catch(IOException e){
				System.out.println("NO SE HA PODIDO CERRAR CORRECTAMENTE EL FLUJO ASOCIADO AL FICHERO "+ archivo);
			}
		}
	} // fin metodo Escritura
	
		private static void Lectura() {
			
		ObjectInputStream flujolectura = null;
		File archivo;
		archivo = new File ("Clientes","Correos01.txt");
		try{
			flujolectura = new ObjectInputStream (new FileInputStream (archivo));
			System.out.println("NOMBRE\t EDAD");
			while(true){
				Persona obj = (Persona) flujolectura.readObject();
				System.out.println(obj.getNombre() +"\t" +obj.getEdad());
			}
		}catch(ClassNotFoundException e){
			System.out.println("NO SE HA PODIDO CONVERTIR LA INFORMACION");
		}catch (EOFException eof){
			System.out.println("Ha finalizado la lectura del fichero");
		}catch(IOException e){
			System.out.println("NO SE HA PODIDO LEER LA INFORMACION DEL FICHERO");
		}finally{
			try{
				if(flujolectura!=null){
					flujolectura.close();
				}
			}catch(IOException e){
				System.out.println("NO SE HA PODIDO CERRAR CORECTAMENTE EL FLUJO ASOCIADO AL FICHERO");
			}
		}// fin finally
	}// fin metodo lectura
}// fin clase

