package unidade04_exemplo03_variasClases;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import unidade04_exemplo03_variasClases.clasesVO.Empleado;

public class Ej01Consultas02EmpleadosCampos {
	static ODB odb = null;

	static IValuesQuery iValues = null;
	static Values values = null;
	static ObjectValues objectValues = null;

	static Ej01MantenimientoEmpleados manEmpleado = new Ej01MantenimientoEmpleados();

	public void consulta01() {
		// Obtener nombre y salario de los empleados
		// SELECT nombre, salario FROM Empleado;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{

			//creamos la consulta
			iValues = new ValuesCriteriaQuery(Empleado.class).field("nombre").field("salario");

			//recuperamos los valores
			values = odb.getValues(iValues);

			//visualizar resultados
			System.out.println("Nombre\t\t\tSalario");
			System.out.println("=======\t\t\t======");
			while(values.hasNext()){
				objectValues = (ObjectValues)values.next();
				System.out.println(objectValues.getByAlias("nombre") +"\t\t\t" +objectValues.getByIndex(1));
			}

		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}

		//cerramos la base de datos
		odb.close();
	}// fin consulta01

	public void consulta02() {
		// Obtener la suma de los salarios y de las comisiones
		// SELECT SUM(Salario), SUM(comision) FROM Empleado;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{

			//creamos la consulta
			iValues = new ValuesCriteriaQuery(Empleado.class).sum("salario").sum("comision");

			//recuperamos los valores
			values = odb.getValues(iValues);
			objectValues = values.nextValues();

			//convertimos el resultado en BigDecimal
			BigDecimal totalSalario = (BigDecimal) objectValues.getByAlias("salario");
			BigDecimal totalComision = (BigDecimal) objectValues.getByAlias("comision");


			//visualizar resultados
			System.out.println("=======================");
			System.out.println("Total salarios: " +totalSalario);
			System.out.println("Total comisiones: " +totalComision);
			System.out.println("=======================");

		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay resultados");
		}

		//cerramos la base de datos
		odb.close();
	}// fin consulta02

	public void consulta03() {
		// Obtener el número de empleados de la empresa
		// SELECT COUNT(codEmpleado) FROM Empleado;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{

			//creamos la consulta
			iValues = new ValuesCriteriaQuery(Empleado.class).count("codEmpleado");

			//recuperamos los valores
			values = odb.getValues(iValues);
			objectValues = values.nextValues();

			//convertimos el resultado en BigInteger
			BigInteger numeroEmpleados = (BigInteger) objectValues.getByAlias("codEmpleado");

			//visualizar resultados
			System.out.println("=======================");
			System.out.println("Número empleados: " +numeroEmpleados);
			System.out.println("=======================");

		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay resultados");
		}

		//cerramos la base de datos
		odb.close();
	}// fin consulta03

	public void consulta04() {
		// Obtener el mayor y el menor salario
		// SELECT MAX(salario), MIN(salario) FROM Empleado;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{

			//creamos la consulta
			iValues = ((ValuesCriteriaQuery) new ValuesCriteriaQuery(Empleado.class).max("salario", "Mayor")).min("salario", "Menor");

			//recuperamos los valores
			values = odb.getValues(iValues);
			objectValues = values.nextValues();

			//convertimos el resultado en BigDecimal
			BigDecimal mayorSalario = (BigDecimal) objectValues.getByAlias("Mayor");
			BigDecimal menorSalario = (BigDecimal) objectValues.getByAlias("Menor");

			//visualizar resultados
			System.out.println("=======================");
			System.out.println("Mayor Salario: " +mayorSalario);
			System.out.println("Menor Salario: " +menorSalario);
			System.out.println("=======================");

		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay resultados");
		}

		//cerramos la base de datos
		odb.close();
	}// fin consulta04

	public void consulta05() {
		// Obtener el salario medio
		
		// SELECT AVG(salario) FROM Empleado;

				//Abrimos la base de datos, si no existe la crea
				odb = ODBFactory.open("Empleados.neodatis");

				try{

					//creamos la consulta
					iValues = ((ValuesCriteriaQuery) new ValuesCriteriaQuery(Empleado.class).avg("salario", "Media"));

					//recuperamos los valores
					values = odb.getValues(iValues);
					objectValues = values.nextValues();

					//convertimos el resultado en BigDecimal
					BigDecimal mediaSalario = (BigDecimal) objectValues.getByAlias("Media");
					
					//visualizar resultados
					System.out.println("=======================");
					System.out.println("Media Salario: " +mediaSalario);
					System.out.println("=======================");

				}catch(IndexOutOfBoundsException io){
					System.out.println("No hay resultados");
				}catch(ArithmeticException ae){
					System.out.println("Error al redondear");
				}

				//cerramos la base de datos
				odb.close();
	}// fin consulta05

	public void consulta06() {
		// Obtener totales por puesto
		
		// SELECT Puesto, COUNT(codEmpleado), SUM(Salario), SUM(Comision)
		// FROM Empleado GROUP BY Puesto;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{

			//creamos la consulta
			iValues =  new ValuesCriteriaQuery(Empleado.class).field("puesto").count("codEmpleado")
					.sum("salario").sum("comision").groupBy("puesto");

			//recuperamos los valores
			values = odb.getValues(iValues);
			
			//visualizar resultados
			System.out.println("==================================================================================================");
			System.out.println("Puesto\t\tNúmero empleados\tTotal Salario\tTotal comisión");
			System.out.println("==================================================================================================");
			
			while(values.hasNext()){
				objectValues = values.nextValues();

				//convertimos los resultados
				BigInteger numeroEmpleados = (BigInteger) objectValues.getByAlias("codEmpleado");
				BigDecimal totalSalario = (BigDecimal) objectValues.getByAlias("salario");
				BigDecimal totalComision = (BigDecimal) objectValues.getByAlias("comision");
								
				System.out.println(objectValues.getByAlias("puesto") +"\t" +numeroEmpleados +"\t" 
				 +totalSalario +"\t" +totalComision);
			}
			
			System.out.println("=======================");

		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay resultados");
		}

		//cerramos la base de datos
		odb.close();
}// fin consulta06

	
	public void consulta07() {
		// Obtener totales por puesto para los salarios mayores que 3000
		
		// SELECT Puesto, COUNT(codEmpleado), SUM(Salario), SUM(Comision)
		// FROM Empleado 
		// WHERE Salario > 3000 GROUP BY Puesto;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{

			//creamos la consulta
			iValues =  new ValuesCriteriaQuery(Empleado.class, Where.gt("salario",  3000)).field("puesto").count("codEmpleado")
					.sum("salario").sum("comision").groupBy("puesto");

			//recuperamos los valores
			values = odb.getValues(iValues);
			
			//visualizar resultados
			System.out.println("==================================================================================================");
			System.out.println("Puesto\t\tNúmero empleados\tTotal Salario\tTotal comisión");
			System.out.println("==================================================================================================");
			
			while(values.hasNext()){
				objectValues = values.nextValues();

				//convertimos los resultados
				BigInteger numeroEmpleados = (BigInteger) objectValues.getByAlias("codEmpleado");
				BigDecimal totalSalario = (BigDecimal) objectValues.getByAlias("salario");
				BigDecimal totalComision = (BigDecimal) objectValues.getByAlias("comision");
								
				System.out.println(objectValues.getByAlias("puesto") +"\t" +numeroEmpleados +"\t" 
				 +totalSalario +"\t" +totalComision);
			}
			
			System.out.println("=======================");

		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay resultados");
		}

		//cerramos la base de datos
		odb.close();
}// fin consulta06

}
