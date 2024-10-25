package accesoDatos;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class EscribirIFichData
{

	public static void main(String[] args)
	{
		
		try
		{
			File fichero = new File("NUEVODIR/Data.txt");
			DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichero));
			DataInputStream dataIS = new DataInputStream(new FileInputStream(fichero));
			String nombres[] =
			{ "Raquel", "Belen", "Lorena", "Alis", "Isa", "Pablo", "Juan" };
			int edades[] =
			{ 25, 23, 26, 23, 26, 25, 23 };
			int i;
			for (i = 0; i < edades.length; i++)
			{
				dataOS.writeUTF(nombres[i]);
				dataOS.writeInt(edades[i]);
			}
			dataOS.close();
			while (true)
			{
				String nombre = dataIS.readUTF();
				int edad = dataIS.readInt();// se lee en el mismo orden en el que se han escrito
				System.out.println(nombre + " " + edad);

			}
			
		} catch (IOException eo)
		{
			System.out.println("Fin de la lectura");
			

		}

	}

}
