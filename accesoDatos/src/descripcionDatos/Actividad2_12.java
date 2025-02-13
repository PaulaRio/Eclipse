package descripcionDatos;

/**Crea una función en Oracle, que reciba un número de departamento y devuelva el salario
medio de los empleados de ese departamento y como parámetro de salida el número de
empleados. Si el departamento no existe debe devolver como salario medio el valor -1 y el
número de empleados será O. Si existe y no tiene empleados debe devolver O.
 Realiza después un programa Java que use dicha función. El programa recorrerá la tabla departamentos y mostrará
los datos del departamento, incluyendo el número de empleados y el salario medio.
Realiza un procedimiento en MySQL que funcione de forma similar a la función en Oracle, es
decir, debe recibir un número de departamento y como parámetros de salida debe devolver el
número de empleados y el salario medio.
 Realiza después un programa Java para usar dicho procedimiento, igual que antes el programa recorrerá la tabla departamentos y mostrará los datos
del departamento, incluyendo el número de empleados y el salario medio.
La función y el procedimiento se crearán desde un programa Java**/
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Actividad2_12
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");

		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el numero de departamento");
		int num = teclado.nextInt();

		datosDep(num,conexion);
	}
	/*DELIMITER //
	CREATE FUNCTION numero_dep(d int) RETURNS float
	BEGIN
	DECLARE nom VARCHAR(15);
	SET nom = 'INEXISTENTE';
	SELECT COUNT(*) FROM empleados
	WHERE dept_no=d;
	RETURN nom;
	END;
	//*/
	public static void datosDep(int dep,Connection conexion) throws SQLException
	{
	Boolean ejecutar = true;
	float salario = 0;
	int contador = 0;
	String sql = "SELECT apellido,oficio,salario FROM empleados WHERE dept_no= ?  ";
	String sqlDep = String.format("SELECT COUNT(*) FROM departamentos WHERE dept_no=%s", dep);
	String sqlNomDep = String.format("SELECT dnombre FROM departamentos WHERE dept_no=%s", dep);
	String sqlNumEmple = String.format("SELECT COUNT(*) FROM empleados WHERE dept_no=%s", dep);
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

		sentencia.setInt(1, dep);
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
