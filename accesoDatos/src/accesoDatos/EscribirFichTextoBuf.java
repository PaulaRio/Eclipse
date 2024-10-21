package accesoDatos;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichTextoBuf
{

	public static void main(String[] args)
	{
		try
		{
			File fic = new File("NUEVODIR/FICHERONUEVO.TXT");
			BufferedWriter fichero = new BufferedWriter(new FileWriter(fic,true));
			for (int i = 01; i < 5; i++)
			{
				fichero.write("Fila numero:"+i );
				fichero.newLine();
				
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
