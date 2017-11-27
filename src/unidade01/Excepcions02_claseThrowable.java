package unidade01;

public class Excepcions02_claseThrowable {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * Exemplo que captura 3 excepciósn que se poden producir. Cando se
		 * encontra o primeiro erro, produce un salto ao bloque catcha que
		 * manexa o dito erro. Neste caso, ao encontrar a sentenza de asignación
		 * arrynum[10] = 20 lanza a excepción ArrayIndexOutofBoundException (xa
		 * que o array está definido para 4 elementos e dáselle valor ao
		 * elemento do índice 10.
		 */

		String cadea1 = "20", cadea2 = "0", mensaxe;
		int numerador, denominador, cociente;
		int[] arraynum = new int[4];

		try {
			// Código que pode producir o erro
			//arraynum[10] = 20; // sentenza que lanza a excepción
			numerador = Integer.parseInt(cadea1); // non se executa
			denominador = Integer.parseInt(cadea2); // non se executa
			cociente = numerador / denominador; // sentenza que lanza a excepción
			mensaxe = String.valueOf(cociente); // non se executa
		} catch (NumberFormatException nfe) {
			mensaxe = "Caracteres non numéricos";
			// System.err -> método usado convencionalmente para despregar mensaxes de erro 
			System.err.println("toString: " + nfe.toString()); // Devolve unha breve descrición do obxecto
			System.err.println("getMessage: " + nfe.getMessage()); // Devolve a cadea de erro do obxecto
			System.err.println("getLocalizeMessage: " + nfe.getLocalizedMessage()); // Crea unha descricion local deste obxecto
			nfe.printStackTrace(); //imprime o obxecto e a traza da pilla de chamadas lanzada

		} catch (ArithmeticException ae) {
			mensaxe = "División por cero";
			System.err.println("toString: " + ae.toString()); // Devolve unha breve descrición do obxecto
			System.err.println("getMessage: " + ae.getMessage()); // Devolve a cadea de erro do obxecto
			System.err.println("getLocalizeMessage: " + ae.getLocalizedMessage()); // Crea unha descricion local deste obxecto
			ae.printStackTrace(); //imprime o obxecto e a traza da pilla de chamadas lanzada
			
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			mensaxe = "Array desborda o tamaño";
		} finally {
			System.out.println("'finally' execútase sempre");
		}
		System.out.println(mensaxe); // execútase
	} // fin maim
} // fin clase
