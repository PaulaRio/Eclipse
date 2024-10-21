package accesoDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTexto
{

	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		File fichero = new File("NUEVODIR/FICHERO1.TXT");

		FileReader fic = new FileReader(fichero);
		int i;
//		while ((i = fic.read()) != -1)
//		{
//			System.out.println((char) i + " ");
//
//		}
		// Leer de 5 en 5 caracteres
		char buffer[] = new char[20];
		while ((i = fic.read(buffer)) != -1)
		{
			System.out.print(buffer);
			
		}

		fic.close();
	}

}
