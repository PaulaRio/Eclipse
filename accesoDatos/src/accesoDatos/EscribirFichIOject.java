package accesoDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirFichIOject
{

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		Persona persona;

		File fichero = new File("NUEVODIR/FichPersona.dat");
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
		for (int i = 0; i < edades.length; i++)
		{
			persona = new Persona(nombres[i], edades[i]);
			dataOS.writeObject(persona);
			System.out.println();
		}

		dataOS.close();

	}

}
