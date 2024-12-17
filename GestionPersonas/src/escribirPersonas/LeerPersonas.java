package escribirPersonas;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class LeerPersonas
{

	public static void main(String[] args)
	{
		try
		{
		XStream xstream = new XStream();
		xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
		xstream.alias("DatosPersona", Persona.class);
		xstream.addImplicitCollection(ListaPersonas.class, "lista");
		
		xstream.aliasField("NombreAlumno", Persona.class, "nombre");
		xstream.aliasField("EdadAlumno", Persona.class, "edad");
		
		ListaPersonas listadoTodas= (ListaPersonas)xstream.fromXML(new FileInputStream("NUEVODIR/Personas2.xml"));
		
		System.out.println("Numero de Personas: " + listadoTodas.getListaPersonas().size());
		List<Persona> listaPersonas = new ArrayList<Persona>();
		listaPersonas = listadoTodas.getListaPersonas();
		Iterator iterador = listaPersonas.listIterator();
		while (iterador.hasNext())
		{
			Persona p = (Persona) iterador.next();
			System.out.printf("Nombre: %s, edad: %d %n", p.getNombre(), p.getEdad());
		}
		//Se puede hacer así en lugar de un iterator
//		for (Persona persona : listaPersonas)
//		{
//			
//			System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(), persona.getEdad());
//		}
		System.out.println("Fin de listado ");
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
