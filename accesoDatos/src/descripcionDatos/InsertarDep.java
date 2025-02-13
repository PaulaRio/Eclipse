package descripcionDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDep
{

	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
			String dep = args[0]; // num. departamento
			String dnombre = args[1]; // nombre
			String loc = args[2]; // localidad

			String sql = String.format("INSERT INTO departamentos VALUES (%s,'%s', '%s')", dep, dnombre, loc);

			System.out.println(sql);
			
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.printf("Filas afectadas: %d %n", filas);
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexión

		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
