package ud01;

public class Excepcions01_captura {
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
		int numerador, denominador, cociente = 0;
		int[] arraynum = new int[4];

		try {
			// C�digo que pode producir o erro
			arraynum[10] = 20; // sentenza que lanza a excepci�n
			numerador = Integer.parseInt(cadea1); // non se executa
			denominador = Integer.parseInt(cadea2); // non se executa
			mensaxe = String.valueOf(cociente); // non se executa
		} catch (NumberFormatException nfe) {
			mensaxe = "Caracteres non num�ricos";
		} catch (ArithmeticException ae) {
			mensaxe = "Divisi�n por cero";
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			mensaxe = "Array desborda o tama�o";
		} finally {
			System.out.println("'finally' exec�tase sempre");
		}
		System.out.println(mensaxe); // exec�tase
	} // fin maim
} // fin clase
