package accesoDatos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class LeerFichObject
{

	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Persona persona;
		File fichero = new File("NUEVODIR/FichPersona.dat");
		//FileInputStream filein = ;
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
		int i = 1;// Me faltaba esto
		try
		{
			while (true)
			{
				persona = (Persona) dataIS.readObject();
				System.out.println(i+"-> Nombre " + persona.getNombre() + ", edad: " + persona.getEdad());
			i++;
			}

		} catch (EOFException eo)
		{
			System.out.println("Fin de la lectura");
		} catch (StreamCorruptedException x)
		{
			System.out.println("HUBO ERRORES EN LA LECTURA");
		}

		dataIS.close();

	}

}
