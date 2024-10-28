package escribirEmpleados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirFichIOject
{

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Empleado empleado;

		File fichero = new File("NUEVODIR/FichEmpleado.dat");
		FileOutputStream fileout;
		ObjectOutputStream dataOS;

		if (!fichero.exists())
		{

			fileout = new FileOutputStream(fichero, true);
			dataOS = new ObjectOutputStream(fileout);
			System.out.println("NO existe");
		} else
		{
			fileout = new FileOutputStream(fichero, true);
			dataOS = new MiObjectOutputStream(fileout);
			System.out.println("Existe");
		}
		String nombres[] =
		{ "Raquel", "Belen", "Lorena", "Alis", "Isa", "Pablo", "Juan" };
		int edades[] =
		{ 25, 23, 26, 23, 26, 25, 23 };
		float salario[] =
			{ 2000, 1500, 1800, 2000, 1700, 1500, 1300 };
		for (int i = 0; i < edades.length; i++)
		{
			empleado = new Empleado(nombres[i], edades[i],salario[i]);
			dataOS.writeObject(empleado);
			
		}

		dataOS.close();

	}

}
