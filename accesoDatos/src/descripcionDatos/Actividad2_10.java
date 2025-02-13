package descripcionDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Actividad2_10
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
			String emp_no = args[0];
			String apellido = args[1];
			String oficio = args[2];
			String dir = args[3];
			Date fecha = new Date();
			String salario = args[4];
			String comision = args[5];
			String dept_no = args[6];
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			String fechaFormateada = formateador.format(fecha);
			
			Boolean ejecutar=true;

			String sql = String.format("INSERT INTO empleados VALUES (%s,'%s','%s',%s,'%s',%s,%s,%s)", emp_no, apellido,
					oficio, dir, fechaFormateada, salario, comision, dept_no);
			String sqlDep = String.format("SELECT COUNT(*) FROM departamentos WHERE dept_no=%s", dept_no);
			String sqlEmp = String.format("SELECT COUNT(*) FROM empleados WHERE emp_no=%s", emp_no);
			String sqlDir = String.format("SELECT COUNT(*) FROM empleados WHERE emp_no=%s", dir);

			Statement sentencia = conexion.createStatement();
			ResultSet rsDep = sentencia.executeQuery(sqlDep);
			rsDep.next();
			if (rsDep.getInt(1)== 0)
			{
				System.out.println("No existe el dpto");
				ejecutar=false;
			}

			ResultSet rsEmp = sentencia.executeQuery(sqlEmp);
			rsEmp.next();
			if (rsEmp.getInt(1)!= 0)
			{
				System.out.println("Existe el empleado");
				ejecutar=false;
			}

			
			if (Double.valueOf(salario)<= 0)
			{
				System.out.println("El salario es menor que 0");
				ejecutar=false;
			}
		
			ResultSet rsDir = sentencia.executeQuery(sqlDir);
			rsDir.next();
			if (rsDir.getInt(1)== 0)
			{
				System.out.println("No existe el director");
				ejecutar=false;
			}
			if (apellido.trim().isEmpty())
			{
				System.out.println("No se ha introducido apellido");
				ejecutar=false;
			}
			if (oficio.trim().isEmpty())
			{
			    System.out.println("No se ha introducido oficio");
			    ejecutar=false;
			}
			
			if(ejecutar) {
			System.out.println(sql);
			int filas = sentencia.executeUpdate(sql);
			System.out.printf("Filas afectadas: %d %n", filas);
			}

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
