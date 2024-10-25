package accesoDatos;

import java.io.File;

/*Hacer un programa que dada una carpeta liste su contenido, pero por cada carpeta adentre y haga lo mismo.
Además el programa debe detectar si la carpeta indicada mediante parámetro de la linea de comandos existe 
y si es una carpeta.En caso contrario dará un aviso por pantalla y finalizará el programa**/
public class VerDir2
{

	public static void main(String[] args)
	{

		String dir = "C:\\Users";
		File f = new File(dir);
		int cont = 0;

		File[] archivos = f.listFiles();// f.list
		System.out.println("Ficheros en el directorio actual: " + archivos.length);
		for (int i = 0; i < archivos.length; i++)
		{
			System.out.println(
					"Nombre: " + archivos[i] + " es fichero?:" + f.isFile() + " es directorio?:" + f.isDirectory());
			if (archivos[i].isDirectory())
			{
				listaDirectory(archivos[i]);
			}
			

		}

	}

	public static void listaDirectory(File f2)
	{
		File[] archivos2 = f2.listFiles();
		System.out.println(f2.getAbsolutePath());
		System.out.println(f2.length());


//		for (int i = 0; i < archivos2.length; i++)
//		{
//			System.out.println(
//					"Nombre: " + archivos2[i] + " es fichero?:" + f2.isFile() + " es directorio?:" + f2.isDirectory());
//		}

	}
}
