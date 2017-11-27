package unidade01;



import java.util.ArrayList;
public class Exemplo21_z_ListaAlumnos {

}
class ListaAlumnos {
	private ArrayList<Alumno> lista = new ArrayList<Alumno>();

	public ListaAlumnos() {
		super();
	}
	
	public void add(Alumno alumno2){
		lista.add(alumno2);
	}
	public ArrayList<Alumno> getListaAlumno(){
		return lista;
	}
	

}
