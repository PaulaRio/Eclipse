package accesoDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class EscribirFichBytes
{

	public static void main(String[] args)
	{
		File fic1 = new File("C:\\Users\\Vespertino\\Downloads\\GRAFICOS 2D.old.mspaint\\mspaint.exe");
		File fic2 = new File("NUEVODIR/Copia.TXT");
		try
		{
			FileInputStream filein= new FileInputStream(fic1);
			FileOutputStream fileout = new FileOutputStream(fic2);
			
			
			int i;
			while((i=filein.read())!=-1) {
			
				fileout.write(i);
			}
			filein.close();
			fileout.close();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
