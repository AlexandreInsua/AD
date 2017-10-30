package ud01ex;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/*
 * Utiliza SAX para visualizar o contido do ficheiro XML artigos xml
 */
public class Ex08_le_XML_SAX {
	public static void main(String[] args) {

		try {
			XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
			XestorContido xestor = new XestorContido();
			procesadorXML.setContentHandler(xestor);
			InputSource ficheiroXML = new InputSource("artigos.xml");
			procesadorXML.parse(ficheiroXML);
		} catch (SAXException saxe) {
			System.out.println("Erro: " + saxe);
		} catch (IOException e) {
			System.out.println("Erro: "+ e);
		}
	}

	
}


class XestorContido extends DefaultHandler{
		public XestorContido(){
			super();
		}
		
		@Override
		public void startDocument() throws SAXException {
		System.out.println("Comezo do documento XML");
		}
		
		@Override
		public void endDocument() throws SAXException {
		System.out.println("Fin do documento XML");
		}
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(localName);
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String valor = new String(ch, start, length);
			System.out.println("\t"+ valor);
		}
	}