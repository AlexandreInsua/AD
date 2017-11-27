package unidade01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Exemplo19_escrituraXML {
	private static final long tamanhoRegistro = 35;

	public static void main(final String[] args) throws IOException {
		File fichero = new File("NombresEdades.dat");
		RandomAccessFile raf = new RandomAccessFile(fichero, "r");
		int clave, edad;
		long posicion = 0; // para situarnos al principio del fichero
		@SuppressWarnings("unused")
		String nombre, aux;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			DOMImplementation implementacion = db.getDOMImplementation();
			Document documento = implementacion.createDocument(null, "Personas", null);// crea
																						// el
																						// documento
																						// con
																						// el
																						// nodo
																						// ra�z
																						// de
																						// nombre
																						// Personas
			documento.setXmlVersion("1.0"); // asignamos la versi�n de nuestro
											// XML
			for (;;) {
				raf.seek(posicion); // nos posicionamos al comienzo del fichero
				clave = raf.readInt(); // leemos los datos del fichero
				nombre = raf.readUTF();
				edad = raf.readInt();
				if (clave > 0) { // clave valida
					Element raiz = documento.createElement("persona"); // creamos
																		// el
																		// nodo
																		// persona
					documento.getDocumentElement().appendChild(raiz);// lo
																		// pegamos
																		// a la
																		// ra�z
																		// del
																		// documento
					CrearElemento("clave", Integer.toString(clave), raiz, documento); // a�adir
																						// clave
					CrearElemento("nombre", nombre.trim(), raiz, documento); // a�adir
																				// nombre
					CrearElemento("edad", Integer.toString(edad), raiz, documento);// a�adir
																					// edad
				} // fin if clave
				posicion = posicion + tamanhoRegistro; // se posiciona para el
														// siguiente registro
				if (raf.getFilePointer() == raf.length())
					break;
			} // fin del for que recorre el fichero
				// recorremos el fichero XML para ver su contenido
			Source fuente = new DOMSource(documento);
			Result resultado = new StreamResult(new java.io.File("Personas.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(fuente, resultado);
			// para mostrar el documento por pantalla, podemos especificar como
			// resultado el canal de salida System.out
			Result consola = new StreamResult(System.out);
			transformer.transform(fuente, consola);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		raf.close();
	}// fin del main
		// m�todo de inserci�n de los datos de la persona

	static void CrearElemento(final String datoPersona, final String valor, final Element raiz,
			final Document documento) {
		Element elemento = documento.createElement(datoPersona); // creamos hijo
		Text texto = documento.createTextNode(valor); // damos valor
		raiz.appendChild(elemento); // pegamos el elemento hijo a la raiz
		elemento.appendChild(texto); // pegamos el valor
	}// fin del m�todo
}// fin de la clase