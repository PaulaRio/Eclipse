package accesoDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EjercicioParte2
{
	public static void main(String[] args) throws IOException
	{
		int opcion = 0;
		File fichero = new File("NUEVODIR/Aleatorio3.txt");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		if (file.length() == 0)
		{
			crearZonaExcedente(fichero);
			 crearFichero(fichero);
		}
		  
		System.out.println(file.length());

		while (opcion != 7)
		{
			mostrarMenu();
			Scanner teclado = new Scanner(System.in);
			opcion = teclado.nextInt();

			switch (opcion)
			{
			case 1:
				System.out.println("Introduce el número del empleado a buscar");
				teclado = new Scanner(System.in);
				int n = teclado.nextInt();
				mostrarEmpleado(fichero, n);
				break;
			case 2:
				borrarEmpleado(fichero);
				break;
			case 3:
				aniadirEmpleado(fichero);
				break;
			case 4:
				listarEmpleados(fichero);
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Por favor, introduce una opción válida.");
				break;
			}
		}

	}

	public static void mostrarMenu()
	{
		System.out.println("Elige un número de las siguientes opciones para realizar una función");
		System.out.println("\n--- Menú ---");
		System.out.println("1 - Leer empleado");
		System.out.println("2 - Borrar empleado");
		System.out.println("3 - Agregar empleado");
		System.out.println("4 - Listar todos los empleados");
		System.out.println("5 - Salir");
		System.out.print("Elige una opción: ");
	}

	public static void crearFichero(File fich)
	{

		try
		{
			RandomAccessFile file = new RandomAccessFile(fich, "rw");
			int dni[] =
			{ 16510439, 88406429, 40159015, 59376221, 52203925, 54362039, 31182460, 58656695 };
			String apellido[] =
			{ "FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY" };
			int dep[] =
			{ 10, 20, 10, 10, 30, 30, 20 };
			Double salario[] =
			{ 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0 };
			StringBuffer buffer = null;
			int n = apellido.length;
			for (int i = 0; i < n; i++)
			{
				
				file.writeInt(dni[i]);
				buffer = new StringBuffer(apellido[i]);
				buffer.setLength(15);

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

	public static void crearZonaExcedente(File fichero)
	{
		try
		{

			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			Scanner teclado = new Scanner(System.in);
			int tamanio = (int) file.length();
			file.seek(tamanio);
			for (int i = 0; i < 285; i++)
			{
				file.writeInt(-1);

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

	public static void mostrarEmpleado(File fichero, int n)
	{

		try
		{
			RandomAccessFile file = new RandomAccessFile(fichero, "r");

			int dni, dep, posicion;
			Double salario;
			char apellido[] = new char[15], aux;
			posicion = buscarPosicionDni(fichero, n) * 114;
			file.seek(posicion);
			if (posicion < 0)
			{
				System.out.println("Este empleado no existe");
			}

			dni = file.readInt();
			if (dni < 0)
			{
				System.out.println("No hay registros");
			}

			for (int i = 0; i < apellido.length; i++)
			{
				aux = file.readChar();
				apellido[i] = aux;
			}
			String apellidos = new String(apellido);
			dep = file.readInt();
			salario = file.readDouble();
				if (dni > 0)
				{

					System.out.println("ID: " + dni + ", Apellido: " + apellidos.trim() + ", Departamento: " + dep);

				}
				

				

			file.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("No se encuentra el fichero");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Error de E/S o no existe el empleado");
		}
	}

	public static void borrarEmpleado(File fichero)
	{
		System.out.println("Introduce el número de empleado que quieras eliminar");
		Scanner teclado = new Scanner(System.in);
		int n = teclado.nextInt();
		if (asegurarse(fichero, n))
		{

			try
			{

				RandomAccessFile file = new RandomAccessFile(fichero, "rw");
				int posicion = (n - 1) * 36;

				file.seek(posicion);
				file.writeInt(-1);
				file.seek(posicion);
				int nuevoId = file.readInt();

				file.close();
				System.out.println("El número de este empleado ahora es :" + nuevoId);

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

	public static long ultimoEmpleado(File fichero)
	{
		long nUltimoEmple = 0;
		try
		{
			RandomAccessFile file = new RandomAccessFile(fichero, "r");
			nUltimoEmple = file.length();

			file.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("No se encuentra el fichero");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Error de E/S");
		}
		return nUltimoEmple / 36;
	}

	public static void aniadirEmpleado(File fichero)
	{
		try
		{
			int posicionLibre = -1;
			long numEmpleados = ultimoEmpleado(fichero);
			int nNuevo = (int) ultimoEmpleado(fichero) + 1;
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			Scanner teclado = new Scanner(System.in);

			System.out.println("Introduce el dni");
			int dni = teclado.nextInt();
			System.out.println("Introduce el apellido");
			String apellido = teclado.nextLine();
			System.out.println("Introduce el departamento");
			int dep = teclado.nextInt();
			System.out.println("Introduce el salario");
			Double salario = teclado.nextDouble();

			for (int i = 0; i < numEmpleados; i++)
			{
				file.seek(i * 114);
				int id = file.readInt();
				if (id == -1)
				{
					posicionLibre = i;
					nNuevo = i + 1;
					break;
				}
			}

			if (posicionLibre == -1)
			{
				posicionLibre = (int) numEmpleados;
			}
			file.seek(posicionLibre * 36);

			file.writeInt(nNuevo);
			StringBuffer buffer = new StringBuffer(apellido);
			buffer.setLength(10);
			file.writeChars(buffer.toString());
			file.writeInt(dep);
			file.writeDouble(salario);

			file.close();
			System.out.println("El número de este empleado será :" + (int) ultimoEmpleado(fichero));

			mostrarEmpleado(fichero, nNuevo);

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

	public static void listarEmpleados(File fichero)
	{
		try
		{
			RandomAccessFile file = new RandomAccessFile(fichero, "r");

			int id, dep, posicion;
			Double salario;
			char apellido[] = new char[15], aux;
			posicion = 0;
			for (;;)
			{

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

	public static boolean asegurarse(File fichero, int n)
	{
		System.out.println("El empleado que has seleccionado es: ");
		mostrarEmpleado(fichero, n);
		System.out.println("Estás seguro?Escribe s o n");
		Scanner teclado = new Scanner(System.in);
		String respuesta = teclado.nextLine();
		while (respuesta == "s" || respuesta == "n")
		{
			System.out.println("Estás seguro?Escribe s o n");
			respuesta = teclado.nextLine();

		}
		if (respuesta.toLowerCase().equals("s"))
		{
			return true;
		}
		return false;
	}

	public static int buscarPosicionDni(File fichero, int n)
	{ 
		int  num=0;
		try
		{
			RandomAccessFile file = new RandomAccessFile(fichero, "r");

			int dni, posicion;
			num=0;
			posicion = 0;
			for (;;)
			{
				dni = file.readInt();
				if (dni == n)
				{
					num=posicion;
					break;
				}

				posicion = posicion + 114;

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
		return num/114;

	}

}
