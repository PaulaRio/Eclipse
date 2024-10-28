package escribirEmpleados;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class LeerEmpleados
{

	public static void main(String[] args)
	{
		try
		{
		XStream xstream = new XStream();
		xstream.alias("ListaPersonasMunicipio", ListaEmpleados.class);
		xstream.alias("DatosPersona", Empleado.class);
		xstream.addImplicitCollection(ListaEmpleados.class, "lista");
		
		xstream.aliasField("NombreEmpleado", Empleado.class, "nombre");
		xstream.aliasField("EdadEmpleado", Empleado.class, "edad");
		xstream.aliasField("SalarioEmpleado", Empleado.class, "salario");
		
		ListaEmpleados listadoTodas= (ListaEmpleados)xstream.fromXML(new FileInputStream("NUEVODIR/Empleado.xml"));
		
		System.out.println("Numero de Empleados: " + listadoTodas.getListaEmpleados().size());
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		listaEmpleados = listadoTodas.getListaEmpleados();
		Iterator iterador = listaEmpleados.listIterator();

		while (iterador.hasNext())
		{
			Empleado emp = (Empleado) iterador.next();
			System.out.printf("Nombre: %s, edad: %d, salario: %.2f %n", emp.getNombre(), emp.getEdad(),emp.getSalario());
		}
		System.out.println("Fin de listado ");
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
