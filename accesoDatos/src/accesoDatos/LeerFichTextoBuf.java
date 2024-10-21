package accesoDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTextoBuf
{

	public static void main(String[] args)
	{
		
			
			try
			{
				BufferedReader fichero = new BufferedReader(new FileReader("NUEVODIR/FICHERO1.TXT"));
				String linea;
				while ((linea = fichero.readLine())!=null)
				{
					System.out.println(linea);

				}
				fichero.close();
			} catch (FileNotFoundException fn)
			{
				// TODO Auto-generated catch block
				System.out.println("No se encuentra el fichero");
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Error de E/S");
			}
			
		

	}

}
