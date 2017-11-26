package ud01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class Exemplo22_crea_ficheiro_XML_DOM {
	private static final long tamanhoRexistro = 35;

	public static void main(String[] args) throws IOException {
		File file = new File("NombresEdades.dat");
		// vou ler un ficheiro de acceso aleatorio
		RandomAccessFile punteiro = new RandomAccessFile(file, "r"); // punteiro
		long posicion = 0; // situamos a posición no principio do documento
		int clave = 0;
		String nome = "";
		int idade = 0;

		String aux = null;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			DOMImplementation implementacion = db.getDOMImplementation();
			// crea o elemento raiz
			Document documento = implementacion.createDocument(null, "persoas", null);
			// asignamos a versión
			documento.setXmlVersion("1.0");
			// lemos o ficheiro de orixe
			for (;;) {
				// posicionámonos na posición inicial
				punteiro.seek(posicion);
				// lemos os datos do ficheiro
				clave = punteiro.readInt();
				nome = punteiro.readUTF();
				idade = punteiro.readInt();
				// a clave debe ser válida
				if (clave > 0) {

					// creamos o nodo persoa
					Element raiz = documento.createElement("persona");
					// pegámolo no documento
					documento.getDocumentElement().appendChild(raiz);
					// engadimos a clave
					crearElemento("clave", Integer.toString(clave), raiz, documento);
					// engadimos o nome
					// trim() elimina os espazos en branco ao principio e ao
					// final da cadea

					crearElemento("nome", nome.trim(), raiz, documento);
					// engadimos a idade
					crearElemento("idade", Integer.toString(idade), raiz, documento);
				} // fin if clave
				// posiciónase para o seguinte rexistro
				posicion = posicion + tamanhoRexistro;
				if (punteiro.getFilePointer() == punteiro.length())
					break;
			} // fin do for que recorre o ficheiro

			// recorremos o fichero XML para ver o seu contido
			Source fonte = new DOMSource(documento);
			Result resultado = new StreamResult(new java.io.File("Persoas.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(fonte, resultado);
			// para mostrar el documento por pantalla,podemos especificar como
			// resultado el canal de salida System.out
			Result consola = new StreamResult(System.out);
			transformer.transform(fonte, consola);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		punteiro.close();
	}// fin del main

	// MÉTODO PARA INSERIR OS DATOS DE PERSOA
	static void crearElemento(final String datoPersona, final String valor, final Element raiz,
			final Document documento) {
		// crear fillo
		Element elemento = documento.createElement(datoPersona);
		// damos valor
		Text texto = documento.createTextNode(valor);
		// pegamos o elemento fillo na súa raiz
		raiz.appendChild(elemento);
		// pegamos o valor
		elemento.appendChild(texto); // pegamos el valor
	}// fin del metodo
}// fin de la clase