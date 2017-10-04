package UD01;

/*
* ejemplo de como leer un fichero XML DOM
*/

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Exemplo20_ler_XML_DOM {
	public static void main(final String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document documento = db.parse(new File("Personas.xml"));
			documento.getDocumentElement().normalize();
			System.out.println("Elemento raiz: " + documento.getDocumentElement().getNodeName());
			// crea una lista con todos los nodos de personas
			NodeList personas = documento.getElementsByTagName("persona");
			// recorre la lista
			for (int i = 0; i < personas.getLength(); i++) {
				Node persona = personas.item(i); // obtener un nodo
				if (persona.getNodeType() == Node.ELEMENT_NODE) { // tipo de
																	// nodo
					Element elemento = (Element) persona; // obtener los
															// elementos del
															// nodo
					System.out.println("Clave: " + getNodo("clave", elemento));
					System.out.println("Nombre: " + getNodo("nombre", elemento));
					System.out.println("Edad: " + getNodo("edad", elemento));
				} // fin if
			} // fin for
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fin main
		// obtener la información de un
		// nodo

	private static String getNodo(final String etiqueta, final Element elemento) {
		NodeList nodo = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valorNodo = nodo.item(0);
		return valorNodo.getNodeValue(); // devuelve el valor del nodo
	}
} // fin clase