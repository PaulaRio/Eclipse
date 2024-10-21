package accesoDatos;

import java.io.File;
import java.io.IOException;

public class CrearDir
{

	public static void main(String[] args)
	{
		double r=8%10;
		System.out.println(r);
		File d = new File("NUEVODIR");
		File f1 = new File(d, "FICHERO1.TXT");
		File f2 = new File(d, "FICHERO2.TXT");
		d.mkdir();
		System.out.println(d.getAbsolutePath());

		try
		{
			if (f1.createNewFile())
			{
				System.out.println("FICHERO1.TXT creado correctamemte");
			} else
			{
				System.out.println("No se ha podido crear FICHERO1.TXT ");
			}
			if (f2.createNewFile())
			{
				System.out.println("FICHERO2.TXT creado correctamemte");
			} else
			{
				System.out.println("No se ha podido crear FICHERO2.TXT ");
			}

		} catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		f1.renameTo(new File(d, "FICHERONUEVO"));
		try
		{
			File f3 = new File("NUEVODIR/FICHERO3.TXT");
			f3.createNewFile();
		} catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

	}

}
