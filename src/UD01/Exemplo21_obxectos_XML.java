package UD01;


	/*
	 * Ejemplo que recorre el fichero Alumnos.Dat para crear una lista de alumnos
	 * que despu�s se insertar�n en el fichero Alumnos.xml
	 */

	import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;

	public class Exemplo21_obxectos_XML {
		public static void main(final String[] args) throws IOException, ClassNotFoundException {
			File fichero = new File("Alumnos.DAT");
			// flujo de entrada
			FileInputStream lectura = new FileInputStream(fichero); 
			// conecta el flujo de bytes al flujo de datos
			ObjectInputStream datos = new ObjectInputStream(lectura);
			System.out.println("Comienza el proceso de creaci�n del fichero XML....");

			// Creamos un objeto Lista de alumnos
			ListaAlumnos listaalu = new ListaAlumnos();
			try{
				while(true){ // lectura del fichero
					Alumno alumno = (Alumno)datos.readObject();// leer un alumno
					listaalu.add(alumno); //a�adir un alumno a la lista
				}// fin while
			}catch(EOFException eo){}
			datos.close();
			try{
				XStream xstream = new XStream();
				//cambiar de nombre a las etiquetas XML
				xstream.alias("ListadoAlumnos", ListaAlumnos.class);
				xstream.alias("DatosAlumno", Alumno.class);
				//quitar etiqueta lista (atributo de la clase ListaAlumno
				xstream.addImplicitCollection(ListaAlumnos.class, "lista");
				//Insertar los objetos en el XML
				xstream.toXML(listaalu, new FileOutputStream("Alumnos.xml"));
				System.out.println("Creado el fichero xml");
			}catch(Exception e){
				e.printStackTrace();
			}
		}// fin main
	}// fin clase


