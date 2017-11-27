package unidade01;

public class Excepcions02_claseThrowable {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * Exemplo que captura 3 excepci�sn que se poden producir. Cando se
		 * encontra o primeiro erro, produce un salto ao bloque catcha que
		 * manexa o dito erro. Neste caso, ao encontrar a sentenza de asignaci�n
		 * arrynum[10] = 20 lanza a excepci�n ArrayIndexOutofBoundException (xa
		 * que o array est� definido para 4 elementos e d�selle valor ao
		 * elemento do �ndice 10.
		 */

		String cadea1 = "20", cadea2 = "0", mensaxe;
		int numerador, denominador, cociente;
		int[] arraynum = new int[4];

		try {
			// C�digo que pode producir o erro
			//arraynum[10] = 20; // sentenza que lanza a excepci�n
			numerador = Integer.parseInt(cadea1); // non se executa
			denominador = Integer.parseInt(cadea2); // non se executa
			cociente = numerador / denominador; // sentenza que lanza a excepci�n
			mensaxe = String.valueOf(cociente); // non se executa
		} catch (NumberFormatException nfe) {
			mensaxe = "Caracteres non num�ricos";
			// System.err -> m�todo usado convencionalmente para despregar mensaxes de erro 
			System.err.println("toString: " + nfe.toString()); // Devolve unha breve descrici�n do obxecto
			System.err.println("getMessage: " + nfe.getMessage()); // Devolve a cadea de erro do obxecto
			System.err.println("getLocalizeMessage: " + nfe.getLocalizedMessage()); // Crea unha descricion local deste obxecto
			nfe.printStackTrace(); //imprime o obxecto e a traza da pilla de chamadas lanzada

		} catch (ArithmeticException ae) {
			mensaxe = "Divisi�n por cero";
			System.err.println("toString: " + ae.toString()); // Devolve unha breve descrici�n do obxecto
			System.err.println("getMessage: " + ae.getMessage()); // Devolve a cadea de erro do obxecto
			System.err.println("getLocalizeMessage: " + ae.getLocalizedMessage()); // Crea unha descricion local deste obxecto
			ae.printStackTrace(); //imprime o obxecto e a traza da pilla de chamadas lanzada
			
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			mensaxe = "Array desborda o tama�o";
		} finally {
			System.out.println("'finally' exec�tase sempre");
		}
		System.out.println(mensaxe); // exec�tase
	} // fin maim
} // fin clase
