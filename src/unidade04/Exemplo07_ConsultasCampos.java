package unidade04;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/*
 * As consultas de selección de campo e as sentenzas de agrupacións usa interfaces diferentes que as anteriores.
 */
public class Exemplo07_ConsultasCampos {
	static String bd = "neodatis.test";
	static ODB odb = null;
	static IValuesQuery ivalues = null; // crea a consulta
	static Values resultado = null; // obter obxectos ou resultado da consulta

	static IQuery iquery = null;
	static Objects<Empleado> empleados = null;
	static ObjectValues objectValues;

	public static void main(String[] args) {

		// listadoEmpleados();
		// 1.- consutal01 .- SELECT nombre, sueldo, edad FROM Empleado;
		//listaNombreSueldoEdad();
		
		// 2. -calcular a idade media dos empregos
		// edadMediaEmpleados();
		
		// 3.- Calcular a suma total do soldo dos empregados
		// totalSueldos();
		
		// 4.- Contar empregados
		//		contarEmpleados();
				
				// 5.- Calcular soldo maior e soldo menor
			// 	sueldoMayorMenor();
		
				// 6.- Calcular total salarios por edad
				//totalSalarioGruposEdad();
		
		// 7.- total de empregados e grupos de salario por idadad
		totalEmpleadosSalarioGrupoEdad();
				
		// listadoEmpleados();
	}

	private static void totalEmpleadosSalarioGrupoEdad() {
		// SELECT SUM(sueldo) FROM Empleados GROUP BY edad
				odb = ODBFactory.open(bd);
				// Crear consulta - min() debe ir antes que max()
				ivalues = new ValuesCriteriaQuery(Empleado.class).field("edad").count("nombre").sum("sueldo").groupBy("edad");

				// obter resultados como podeser ser varios hai que metelos nun bucle
				resultado = odb.getValues(ivalues);
				
				while(resultado.hasNext()) {
					// recuperamos os resultados con objectValues e nextValues		
					objectValues = resultado.nextValues();
					// convertimos ás clases big
					BigInteger valueCount = (BigInteger)objectValues.getByAlias("nombre");
					BigDecimal valueSum = (BigDecimal)objectValues.getByAlias("sueldo");
					 
					// mostramos datos coa variable convertidos
					// vai mostrar os subtotais de empregados
					System.out.print("Edad: " + objectValues.getByAlias("edad")+" ");
						System.out.println("Número de empleados : " + valueCount.intValue());System.out.println("Total sueldo : " + valueSum.doubleValue());
						
				}
				
				
				odb.close();
		
	}

	private static void totalSalarioGruposEdad() {
		// SELECT SUM(sueldo) FROM Empleados GROUP BY edad
		odb = ODBFactory.open(bd);
		// Crear consulta - min() debe ir antes que max()
		ivalues = new ValuesCriteriaQuery(Empleado.class).sum("sueldo").groupBy("edad");

		// obter resultados como podeser ser varios hai que metelos nun bucle
		resultado = odb.getValues(ivalues);
		
		while(resultado.hasNext()) {
			// recuperamos os resultados con objectValues e nextValues		
			objectValues = resultado.nextValues();

			BigDecimal valueSum = (BigDecimal)objectValues.getByAlias("sueldo");
			 
			// mostramos datos coa variable convertidos
				System.out.println("Total sueldo : " + valueSum.doubleValue());
		}
		
		
		odb.close();
		

	}

	private static void sueldoMayorMenor() {
		// SELECT COUNT(nombre) FROM empleados
				odb = ODBFactory.open(bd);
				// Crear consulta - min() debe ir antes que max()
				ivalues = new ValuesCriteriaQuery(Empleado.class).min("sueldo", "mínimo").max("sueldo", "máximo");

				// obter resultados
				resultado = odb.getValues(ivalues);
				
				// recuperamos os resultados con objectValues e nextValues		
				objectValues = resultado.nextValues();

				BigDecimal valueCount = (BigDecimal)objectValues.getByAlias("");
				 
				// mostramos datos coa variable convertidos
					System.out.println("Número de empleados: " + valueCount.intValue());
				
				odb.close();
				
		
	}

	private static void contarEmpleados() {
		// SELECT COUNT(nombre) FROM empleados
		odb = ODBFactory.open(bd);
		// Crear consula
		ivalues = new ValuesCriteriaQuery(Empleado.class).count("nombre");

		// obter resultados
		resultado = odb.getValues(ivalues);
		
		// recuperamos os resultados con objectValues e nextValues		
		objectValues = resultado.nextValues();

		BigInteger valueCount = (BigInteger)objectValues.getByAlias("nombre");
		 
		// mostramos datos coa variable convertidos
			System.out.println("Número de empleados: " + valueCount.intValue());
		
		odb.close();
		
	}

	private static void totalSueldos() {
		// SELECT SUM(sueldo) FROM Empleados
		
		odb = ODBFactory.open(bd);
		// Crear consula
		ivalues = new ValuesCriteriaQuery(Empleado.class).sum("sueldo");

		// obter resultados
		resultado = odb.getValues(ivalues);
		
		// recuperamos os resultados con objectValues e nextValues		
		objectValues = resultado.nextValues();

		BigDecimal valueSum = (BigDecimal)objectValues.getByAlias("sueldo");
		 
		// mostramos datos
			System.out.println("Total Sueldos: " + valueSum.doubleValue());
		
		odb.close();
	}

	private static void edadMediaEmpleados() {
		odb = ODBFactory.open(bd);
		// Crear consula
		ivalues = new ValuesCriteriaQuery(Empleado.class).avg("edad");

		// obter resultados
		resultado = odb.getValues(ivalues);
		
		// recuperamos os resultados con objectValues e nextValues		
		objectValues = resultado.nextValues();

		// devolve valores de tipo big e gardamos o resultado nunha variable apropiada
		BigDecimal valueMedia = (BigDecimal) objectValues.getByAlias("edad");
		
		//valueMedia = valuesMedia
		// mostramos datos
			System.out.println("Media de idade empregados: " + valueMedia.doubleValue());
		
		odb.close();
	} 

	private static void listaNombreSueldoEdad() {
		// SELECT nombre, sueldo, edad FROM Empleado;
		odb = ODBFactory.open(bd);
		// crear consulta coa clase ValuesCriteaQuery e o método .field() que recupera
		// un campo e se poden encadear consecutivamente
		// tamén se lle poden dar alias ao campo field("now() - dataNac", "idade")
		ivalues = new ValuesCriteriaQuery(Empleado.class).field("nombre").field("sueldo").field("edad");
		// recuperamos os datos co método getValues() 
		Values resultado = odb.getValues(ivalues);
		// visualizamos un resultado coa clase ObjectValues() - que recolle unha parte
		// dos atributos da clase
		// potencialmente devolve varios
		while (resultado.hasNext()) {
			objectValues = (ObjectValues) resultado.next();
			// objecValues ten os métodos getByAlias() e getByIndex() - comeza en 0
			System.out.println(objectValues. getByAlias("nombre") + "\t" + objectValues.getByAlias("sueldo") + "\t"
					+ objectValues.getByIndex(2));
			
		}
		odb.close(); 
	}

	private static void listadoEmpleados() {
		// SELECT * FROM Empleados
		// Abrimos a base de datos
		ODB odb = ODBFactory.open("neodatis.test");
		// crea a consulta
		IQuery query = new CriteriaQuery(Empleado.class);
		// Obtén o resultado da consulta
		Objects empleados = odb.getObjects(query);
		// Devolve o número de Empleados
		System.out.println(empleados.size() + " Empleados");
		//
		int i = 1;
		// VISUALIZA OS EMPLEADOS
		// visua
		System.out.println("LISTADO EMPLEADOS");
		System.out.println("=================");
		while (empleados.hasNext()) {
			Empleado empleado = (Empleado) empleados.next();
			// Método parecido a un toString
			visualizarResultados(empleado);
		}
		// cierra la base de datos
		odb.close();
	}

	private static void visualizarResultados(Empleado empleado) {
		System.out.println(("Empleado: " + "\t" + empleado.getNombre() + "\t" + empleado.getDireccion() + "\t"
				+ empleado.getCiudad() + "\t" + empleado.getSueldo() + "\t" + empleado.getEdad()));
	}
}