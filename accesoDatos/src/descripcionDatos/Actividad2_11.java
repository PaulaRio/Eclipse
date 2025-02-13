package descripcionDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Actividad2_11
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{

		Class.forName("com.mysql.jdbc.Driver");

		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
		Boolean ejecutar = true;
		float salario = 0;
		int contador = 0;
		String dept_no = args[0];
		// dept_no=%s", dept_no
		String sql = "SELECT apellido,oficio,salario FROM empleados WHERE dept_no= ?  ";
		String sqlDep = String.format("SELECT COUNT(*) FROM departamentos WHERE dept_no=%s", dept_no);
		String sqlNomDep = String.format("SELECT dnombre FROM departamentos WHERE dept_no=%s", dept_no);
		String sqlNumEmple = String.format("SELECT COUNT(*) FROM empleados WHERE dept_no=%s", dept_no);
		DecimalFormat formato = new DecimalFormat("##,##0.00€");
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		ResultSet rsDep = sentencia.executeQuery(sqlDep);
		rsDep.next();
		contador = rsDep.getInt(1);
	
		if (contador == 0)
		{
			System.out.println("No existe el dpto");
			ejecutar = false;
		}
		if (ejecutar)
		{
			ResultSet rsNumEmple = sentencia.executeQuery(sqlNumEmple);
			rsNumEmple.next();
			int numEmple = rsNumEmple.getInt(1);
			ResultSet rsNomDep = sentencia.executeQuery(sqlNomDep);
			rsNomDep.next();
			String nombreDep = rsNomDep.getString(1);

			sentencia.setInt(1, Integer.parseInt(dept_no));
			ResultSet rs = sentencia.executeQuery();
			while (rs.next())
			{
				System.out.printf("'%s','%s',%s %n", rs.getString("apellido"), rs.getString("oficio"),
						formato.format(rs.getFloat("salario")));
				salario += rs.getFloat("salario");
			}

			System.out.println("Salario medio: " + salario / contador + " Numero de empleados : " + numEmple
					+ " Del departamento: " + nombreDep);

			rs.close();

			sentencia.close();
			conexion.close();
		}

	}

}
