package ud01;

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

public class Exemplo21_ler_XML_DOM {
	public static void main(final String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			// o método parse() devolve o documento DOM que se vai crear para o ficheiro XML
			Document documento = db.parse(new File("Personas.xml"));
			// o método normaliza() transforma o texto Unicode que se lle pase en texto normalizado
			// ou na estandarización de normalización Unicode 
			documento.getDocumentElement().normalize();
			// getNodeName() imprime o nome da raiz
			System.out.println("Elemento raiz: " + documento.getDocumentElement().getNodeName());
			// créase unha lista con todos os nodos de personas
			NodeList personas = documento.getElementsByTagName("persona");
			// recorre la lista
			for (int i = 0; i < personas.getLength(); i++) {
				// obtener un nodo 
				Node persona = personas.item(i); 
				if (persona.getNodeType() == Node.ELEMENT_NODE) { 
					// obtener los elementos del nodo
					Element elemento = (Element) persona; 
					System.out.println("Clave: " + getNodo("clave", elemento));
					System.out.println("Nombre: " + getNodo("nombre", elemento));
					System.out.println("Edad: " + getNodo("edad", elemento));
				} // fin if
			} // fin for
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fin main

	// obtener la información de un nodo
	private static String getNodo(final String etiqueta, final Element elemento) {
		NodeList nodo = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valorNodo = nodo.item(0);
		return valorNodo.getNodeValue(); // devuelve el valor del nodo
	}
} // fin clase