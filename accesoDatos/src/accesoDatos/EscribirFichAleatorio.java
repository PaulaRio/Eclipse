package accesoDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFichAleatorio
{

	public static void main(String[] args)
	{
		File fich = new File("NUEVODIR/Empleados.txt");
		
		try
		{
			RandomAccessFile file = new RandomAccessFile(fich, "rw");

			String apellido[] =
			{ "FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY" };
			int dep[] =
			{ 10, 20, 10, 10, 30, 30, 20 };
			Double salario[] =
			{ 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0 };
//			String direccion[] =
//				{ "LA RIOJA", "GALICIA", "MADRID", "CATALUNIA", "ANDALUCIA", "CASTILLA Y LEON", "CANTABRIA" };
//			String localidad[] =
//				{ "LOGRONIO", "A CORUNIA", "MADRID", "BARCELONA", "SEVILLA", "VALLADOLID", "SANTANDER" };
//			String codigoPostal[] =
//				{ "", "GALICIA", "MADRID", "RAMOS", "ANDALUCIA", "CASTILLA Y LEON", "CANTABRIA" };
				
			StringBuffer buffer = null;
			int n = apellido.length;
			for (int i = 0; i < n; i++)
			{
				//file.write(i + 1);
				file.writeInt(i + 1);
				buffer = new StringBuffer(apellido[i]);
				buffer.setLength(10);
				
				file.writeChars(buffer.toString());
				file.writeInt(dep[i]);
				file.writeDouble(salario[i]);
				
					
				
			}
			file.close();

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
