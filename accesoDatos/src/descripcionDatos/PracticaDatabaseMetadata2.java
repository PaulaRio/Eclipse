package descripcionDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.derby.tools.sysinfo;

public class PracticaDatabaseMetadata2
{
	public static void main(String[] args)
	{
		// Cargar el driver
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
			DatabaseMetaData dbmd = conexion.getMetaData();
			// TableData();
			DatabaseMetaData dbmdp = conexion.getMetaData();
			ResultSet resul = null;

			String nombre = dbmdp.getDatabaseProductName();
			String driver = dbmdp.getDriverName();
			String url = dbmdp.getURL();
			String usuario = dbmdp.getUserName();
			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
			System.out.println("=============================");
			System.out.println();
			System.out.printf("Nombre: %s %n", nombre);
			System.out.printf("Driver: %s %n", driver);
			System.out.printf("URL: %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);
			// Obtener información de las tablas y vistas que hay
			resul = dbmdp.getTables(null, "ejemplo", null, null);
			while (resul.next())
			{
				String catalogo = resul.getString(1); // Columna 1
				String esquema = resul.getString(2); // Columna 2
				String tabla = resul.getString(3); // Columna 3
				String tipo = resul.getString(4); // Columna 4

				System.out.printf("%s - Catálogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
				System.out.println();
				TableData(tabla, tipo, dbmdp, conexion);
				System.out.println();
			}

			conexion.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void TableData(String table, String ttype, DatabaseMetaData dbmdp, Connection conex)
	{
		Statement sentencia = null;
		ResultSet rs = null;
		try
		{
			sentencia = conex.createStatement();
			rs = sentencia.executeQuery("SELECT * FROM " + table);

			ResultSetMetaData rsmd = rs.getMetaData();
			int nColumnas = rsmd.getColumnCount();
			String nula;

			System.out.printf("Número de columnas recuperadas: %d%n", nColumnas);

			for (int i = 1; i <= nColumnas; i++)
			{
//				System.out.println("Columna"+ i+ ", Nombre: "+rsmd.getColumnName(i)+" Tipo: "+rsmd.getColumnTypeName(i)+" ¿Puede ser nula?: ");
//				System.out.printf(" Nombre: %s %n", rsmd.getColumnName(i));
//				System.out.printf(" Tipo: %s %n", rsmd.getColumnTypeName(i));

				if (rsmd.isNullable(i) == ResultSetMetaData.columnNoNulls)
				{
					nula = "NO";
				} else
				{
					nula = "SI";
				}

//				System.out.printf("¿Puede ser nula?: %s %n", nula);
//				System.out.printf(" Máximo ancho de la columna: %d %n", rsmd.getColumnDisplaySize(i));
				System.out.println("Columna: "+ i+ ", Nombre: "+rsmd.getColumnName(i)+" Tipo: "+rsmd.getColumnTypeName(i)+", ¿Puede ser nula?: "+nula+ ", Máximo ancho de la columna: "+rsmd.getColumnDisplaySize(i));
			}

			sentencia.close();
			rs.close();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static String TypeData(ResultSet resul, ArrayList<String> tipo)
	{
		String cad = "";
		try
		{
			for (int i = 0; i < tipo.size(); i++)
			{
				if (tipo.get(i).toLowerCase().contains("int"))
				{

					cad = cad + resul.getInt(i + 1) + ", ";

				} else if (tipo.get(i).toLowerCase().equals("varchar"))
				{
					cad = cad + resul.getString(i + 1) + ", ";
				} else if (tipo.get(i).toLowerCase().equals("float"))
				{
					cad = cad + resul.getFloat(i + 1) + ", ";
				}

				if (i == (tipo.size() - 1))
				{
					cad = cad.substring(0, cad.length() - 2);
				}

			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cad;
	}

	public static String tipoProcedimiento(int tipoProc)
	{
		if (tipoProc == 2)
		{
			return "Función";
		} else
		{
			return "Procedimiento";
		}

	}

}
