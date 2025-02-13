package descripcionDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModificarSalario
{

	public static void main(String[] args)
	{
		try
		{
			/*ResultSet procedures = dbmdp.getProcedures(null, null, null);
			System.out.println();
			System.out.println("Métodos:");
			while (procedures.next())
			{
				
				String nomProc = procedures.getString("PROCEDURE_NAME");
				int tipoProc = procedures.getInt("PROCEDURE_TYPE");

				System.out.println("Nombre del Método: " + nomProc + " - Tipo: " + tipoProcedimiento(tipoProc));

			}*/
			Class.forName("com.mysql.jdbc.Driver");
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
			//recuperar parametros de main
			String dep = args[0]; // num. departamento
			String subida = args[1]; // subida
			//construir orden UPDATE
			String sql = String.format("UPDATE empleados SET salario = salario + %s WHERE deptno = %s",
			subida, dep);
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.printf("Empleados modificados: %d %n", filas);
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
