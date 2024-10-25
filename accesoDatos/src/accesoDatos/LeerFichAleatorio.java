package accesoDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio
{

	public static void main(String[] args)
	{
		File fichero = new File("NUEVODIR/Aleatorio2.txt");
		try
		{
		RandomAccessFile file= new RandomAccessFile(fichero, "r");

			int id, dep, posicion;
			Double salario;
			char apellido[] = new char[10], aux;
			posicion = 0;
			for (;;)
			{

				//file.seek(posicion);

				id = file.readInt();

				for (int i = 0; i < apellido.length; i++)
				{
					aux = file.readChar();
					apellido[i] = aux;
				}
				String apellidos = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();
				if (id > 0)
				{

					System.out.println("ID: " + id + ", Apellido: " + apellidos.trim() + ", Departamento: " + dep);

				}
				posicion = posicion + 36;

				if (file.getFilePointer() == file.length())
				
					break;
				
			}
			file.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("No se encuentra el fichero");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Error de E/S");
		}

	}

}
