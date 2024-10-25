package accesoDatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirFichTextoPrint
{

	public static void main(String[] args)
	{
			try
			{
				PrintWriter fichero = new PrintWriter(new FileWriter(new File("NUEVODIR/FichPrint.txt"),false));
				
				
				for (int i = 01; i < 11; i++)
				{
					fichero.print("Fila numero:"+i );
					fichero.println();
					System.out.println("File numero: "+i);
					System.out.println();
					
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
