package ud01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import ud01.Persoa;

public class Excepcions04_especificarExcepcions {

	public static void main(String[] args) {
		FileInputStream fs = null;
		ObjectInputStream os = null;
		System.out.println("Nome\t idade");
		try {
			fs = new FileInputStream("Persoas.txt");
			os = new ObjectInputStream(fs);
			while (true) { // le o ficheiro
				// os debe realizar un casteo ao tipo orixinasl
				// le o obxecto
				Persoa p = (Persoa) os.readObject();
				System.out.println(p.getNombre() + "\t" + p.getEdad());
			}
		} catch (NoClassDefFoundError ncdfe) {
			System.out.println("Erro de clase");
		} catch (ClassNotFoundException cnf) {
			System.out.println("Erro da clase");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Erro no ficheiro");
		} catch (IOException ioe) {
			System.out.println("Erro de E/L");
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				System.out.println("Erro de E/L");
			}
		}
	}
}
