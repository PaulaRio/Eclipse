package accesoDatos;

import java.io.*;

public class PruebaLeer 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		Persona persona; // defino la variable persona
		File fichero = new File("NUEVODIR/FichPersona.txt");
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

		int i = 1;
		try 
		{
			while (true) 
			{ // lectura del fichero
				persona = (Persona) dataIS.readObject(); // leer una Persona
				System.out.print(i + "=>");
				i++;
				System.out.printf("Nombre: %s, edad: %d %n",
						persona.getNombre(),persona.getEdad());
			}
		} 
		catch (EOFException eo) 
		{
			System.out.println("FIN DE LA LECTURA.");
		} 
		catch (StreamCorruptedException x) 
		{
			System.out.println("HUBO ERRORES DE LECTURA.");
		}

		dataIS.close(); // cerrar stream de entrada
	}
}