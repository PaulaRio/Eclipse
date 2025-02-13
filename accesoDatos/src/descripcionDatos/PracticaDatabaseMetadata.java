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

public class PracticaDatabaseMetadata
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
			ArrayList<String> tipos = new ArrayList<String>();
			ArrayList<String> tablas = new ArrayList<String>();
			while (resul.next())
			{
				String catalogo = resul.getString(1); // Columna 1
				String esquema = resul.getString(2); // Columna 2
				String tabla = resul.getString(3); // Columna 3
				String tipo = resul.getString(4); // Columna 4
				tipos.add(tipo);
				tablas.add(tabla);
				System.out.printf("%s - Catálogo: %s, Esquema: %s, Nombre: %s %n", tipo,
				catalogo, esquema, tabla);
				tipos.add(tipo);
				tablas.add(tabla);
				
			}
			System.out.println();
			for (int i = 0; i <tipos.size(); i++)
			{
				DescTable(tablas.get(i), tipos.get(i), dbmdp, conexion);
			}
			ResultSet procedures = dbmdp.getProcedures(null, null, null);
			System.out.println("Métodos:");
			System.out.println("========================");
			while (procedures.next())
			{

				String nomProc = procedures.getString("PROCEDURE_NAME");
				int tipoProc = procedures.getInt("PROCEDURE_TYPE");

				System.out.println("Nombre del Método: " + nomProc + " - Tipo: " + tipoProcedimiento(tipoProc));

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

	public static void DescTable(String table, String ttype, DatabaseMetaData dbmdp, Connection conex)
	{
		try
		{

			System.out.println("COLUMNAS " + ttype.toUpperCase() + " " + table.toUpperCase() + ":");
			System.out.println("========================");
			ResultSet columnas = null;
			columnas = dbmdp.getColumns(null, "ejemplo", table, null);
			ResultSet primaryKeys = dbmdp.getPrimaryKeys(null, ttype, table);
			ResultSet exportedKeys = dbmdp.getExportedKeys(null, ttype, table);
			ResultSet importedKeys = dbmdp.getImportedKeys(null, ttype, table);

			ArrayList<String> tipo = new ArrayList<String>();

			while (columnas.next())
			{
				String nombCol = columnas.getString("COLUMN_NAME"); // getString(4)
				String tipoCol = columnas.getString("TYPE_NAME"); // getString(6)
				String tamCol = columnas.getString("COLUMN_SIZE"); // getString(7)
				String nula = columnas.getString("IS_NULLABLE"); // getString(18)
				System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s,¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol,
						nula);
				tipo.add(tipoCol);
			}

			System.out.println();
			while (primaryKeys.next())
			{
				String pKey = primaryKeys.getString("COLUMN_NAME"); // getString(18)
				System.out.println("Clave Primaria: " + pKey);
			}
			System.out.println();
			if (ttype.equals("TABLE"))
			{
				// Se podría usar exportedKeys.beforeFirst, que te dice si hay o no resultados
				// mediante booleano
				System.out.print("Claves exportadas: ");
				if (!exportedKeys.next())
				{
					System.out.println("Ninguna");
				} else
				{
					do
					{
						String pk_tablename = exportedKeys.getString("PKTABLE_NAME");
						String fk_tablename = exportedKeys.getString("FKTABLE_NAME");
						String pk = exportedKeys.getString("PKCOLUMN_NAME");
						String fk = exportedKeys.getString("FKCOLUMN_NAME");
						System.out.println();
						System.out.printf("Tabla PK: %s, Clave Primaria: %s %n", pk_tablename, pk);
						System.out.printf("Tabla FK: %s, Clave Ajena: %s %n", fk_tablename, fk);
					} while (exportedKeys.next());
				}

				System.out.println();
				System.out.print("Claves importadas:");
				if (!importedKeys.next())
				{
					System.out.println("Ninguna");
				} else
				{
					do
					{

						String pk_tablename = importedKeys.getString("PKTABLE_NAME");
						String fk_tablename = importedKeys.getString("FKTABLE_NAME");
						String pk = importedKeys.getString("PKCOLUMN_NAME"); // getString(18)
						String fk = importedKeys.getString("FKCOLUMN_NAME"); // getString(18)
						System.out.println();
						System.out.printf("Tabla PK: %s, Clave Primaria: %s %n", pk_tablename, pk);
						System.out.printf("Tabla FK: %s, Clave Ajena: %s %n", fk_tablename, fk);
					} while (importedKeys.next());
				}
				System.out.println();
			}

			Statement sentencia = conex.createStatement();
			String sql = "SELECT * FROM " + table;
			ResultSet resul = sentencia.executeQuery(sql);
			System.out.println("Datos " + ttype.toLowerCase() + " " + table.toLowerCase() + ": ");
			System.out.println("========================");
			while (resul.next())
			{
				String cad = TypeData(resul, tipo);
				System.out.println(cad);
				cad = "";
			}
			System.out.println();

			resul.close();
			// Cerrar conexión
//			Statement sentence = conex.createStatement();
//			ResultSet rs = sentence.executeQuery("SELECT * FROM "+ table.toLowerCase());
//			ResultSetMetaData rsmd = rs.getMetaData();

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
