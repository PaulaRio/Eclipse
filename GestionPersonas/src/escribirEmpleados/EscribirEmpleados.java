package escribirEmpleados;

import java.io.*;
import java.io.IOException;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;

public class EscribirEmpleados
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		File fichero = new File("NUEVODIR/FichEmpleado.dat");
		FileInputStream filein = new FileInputStream(fichero);
		ObjectInputStream dataIS = new ObjectInputStream(filein);
		System.out.println("Comienza el proceso...");
		// Creamos un objeto Lista de Personas
		ListaEmpleados listaemple = new ListaEmpleados();
		try
		{
			while (true)
			{ // lectura del fichero
				Empleado empleado = (Empleado) dataIS.readObject();
				listaemple.add(empleado); // añadir persona a la lista
			}
		} catch (EOFException eo) {}
		dataIS.close(); // cerrar stream de entrada
		try
		{
			XStream xstream = new XStream();
			// cambiar de nombre a las etiquetas XML
			xstream.alias("ListaPersonasMunicipio", ListaEmpleados.class);
			xstream.alias("DatosPersona", Empleado.class);
			xstream.aliasField("NombreEmpleado", Empleado.class, "nombre");
			xstream.aliasField("EdadEmpleado", Empleado.class, "edad");
			xstream.aliasField("SalarioEmpleado", Empleado.class, "salario");
			// quitar etiqueta lista (atributo de la clase ListaPersonas)
			xstream.addImplicitCollection(ListaEmpleados.class, "lista");
			// Insertar los objetos en el XML
			xstream.toXML(listaemple, new FileOutputStream("NUEVODIR/Empleado.xml"));
			System.out.println("Creado fichero XML....");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
