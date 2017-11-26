package ud01;

import java.io.IOException;

import org.xml.sax.helpers.XMLReaderFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Exemplo21_ler_XML_SAX {
	public static void main(final String[] args) throws SAXException, IOException {
		/* ANALIZADOR de XML 
		 * Act�a como un cursor  indo cara adiante no fluxo do documento
		 * e det�ndose en cada nodo do cami�o. 
		*/
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		
		/* XESTOR DE CONTIDO
		 * Instancia da clase que estende  de DefaultHandler
		 * 
		 */
		GestionContenido gestor = new GestionContenido();
		
		// Ao procesador pas�nselle os eventos do arquivo
		procesadorXML.setContentHandler(gestor);
		
		// Pas�selle o arquivo
		InputSource ficheroXML = new InputSource("Personas.xml");
		
		// Parseador
		procesadorXML.parse(ficheroXML);
		
	}// fin main
}// fin clase EjemploFicheroXMLSAX01


// Clase que herda de DefaulHandler que ten definidos os m�todos que imos usar
// Obrigatoria para usar SML SAX
// Creou a clase para sobre escribir os m�todos e poder inserir os print
class GestionContenido extends DefaultHandler {
	// simple construtor
	public GestionContenido() {
		super();
	}

	@Override
	public void startDocument() {
		System.out.println("*** Comezo do documento XML ***\n");
	}

	@Override
	public void endDocument() {
		System.out.println("\n*** Final do documento XML ***");
	}

	public void startElement(final String uri, final String nombre, final String nombreC) {
		System.out.println("Principio Elemento: " + nombre);

	}

	@Override
	public void endElement(final String uri, final String nombre, final String nombreC) {
		System.out.println("Fin Elemento: " + nombre);
	}

	@Override
	public void characters(final char[] ch, final int inicio, final int longitud) {
		String car = new String(ch, inicio, longitud);
		car = car.replaceAll("[\t\n]", ""); // quitar saltos de linea
		System.out.println("\tCaracteres: " + car);
	}
}
