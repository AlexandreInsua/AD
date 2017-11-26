package ud01;

public class Excepcions01_captura {
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
		int numerador, denominador, cociente = 0;
		int[] arraynum = new int[4];

		try {
			// Código que pode producir o erro
			arraynum[10] = 20; // sentenza que lanza a excepción
			numerador = Integer.parseInt(cadea1); // non se executa
			denominador = Integer.parseInt(cadea2); // non se executa
			mensaxe = String.valueOf(cociente); // non se executa
		} catch (NumberFormatException nfe) {
			mensaxe = "Caracteres non numéricos";
		} catch (ArithmeticException ae) {
			mensaxe = "División por cero";
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			mensaxe = "Array desborda o tamaño";
		} finally {
			System.out.println("'finally' execútase sempre");
		}
		System.out.println(mensaxe); // execútase
	} // fin maim
} // fin clase
