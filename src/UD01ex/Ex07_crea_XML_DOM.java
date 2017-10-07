package UD01ex;

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

/*
 * Visualiza o ficheiro Alumnos.DAT en xml
 */
public class Ex07_crea_XML_DOM {

	private static final long tamanhoRexistro = 40;

	public static void main(String[] args) {
		File f = new File("Articulos.DAT");
		RandomAccessFile raf;
		int codigo, stock, minimo;
		float prezo;
		String artigo;
		int posicion = 0;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			raf = new RandomAccessFile(f, "r");
			DocumentBuilder db = dbf.newDocumentBuilder();
			DOMImplementation implementation = db.getDOMImplementation();
			Document document = implementation.createDocument(null, "Artigos", null);
			document.setXmlVersion("1.0");

			for (;;) {
				raf.seek(posicion);
				codigo = raf.readInt();
				artigo = raf.readUTF();
				prezo = raf.readFloat();
				stock = raf.readInt();
				minimo = raf.readInt();
				if (codigo > 0) {
					Element raiz = document.createElement("Artigo");
					document.getDocumentElement().appendChild(raiz);
					crearElemento("codigo", Integer.toString(codigo), raiz, document);
					crearElemento("artigo", artigo, raiz, document);
					crearElemento("prezo", Float.toString(prezo), raiz, document);
					crearElemento("stock", Integer.toString(stock), raiz, document);
					crearElemento("minimo", Integer.toString(minimo), raiz, document);
					
				}
				posicion += tamanhoRexistro;
				
				if (raf.getFilePointer() == raf.length())
					
					break;
			}

			Source fonte = new DOMSource(document);
			Result resultado = new StreamResult(new java.io.File("Artigos.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(fonte, resultado);
			Result consola = new StreamResult(System.out);
			transformer.transform(fonte, consola);
		} catch (IOException ioe) {System.out.println("Erro: "+ ioe);} catch (Exception e) {
			System.out.println("Erro: " + e);

		}
	}

	// Metodo para inserir datos do artigo
	static void crearElemento(String dato, String valor, Element raiz, Document document) {
		Element elemento = document.createElement(dato);
		Text texto = document.createTextNode(valor);
		raiz.appendChild(elemento);
		elemento.appendChild(texto);
	}

}
