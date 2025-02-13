package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSqlite
{

	public static void main(String[] args)
	{
		try {
			//Cargar el driver
			Class.forName("org.sqlite.JDBC");
			//Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection
			("jdbc:sqlite:D:/DB/SQLITE/ejemplo.db");
			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sql1 = "SELECT * FROM departamentos";
			String sql2 = "SELECT * FROM empleados";
			ResultSet resul1 = sentencia.executeQuery(sql1);
			
			//Recorremos el resultado para visualizar cada fila
			//Se hace un bucle mientras haya registros y se van mostrando
			System.out.println("Tabla departamentos: ");
			while (resul1.next()) {
			System.out.printf("%d, %s, %s %n",
			resul1.getInt(1),
			resul1.getString(2),
			resul1.getString(3));
			}
			resul1.close();
			System.out.println("\n"+"Tabla empleados: ");
			ResultSet resul2 = sentencia.executeQuery(sql2);
			while (resul2.next()) {
				System.out.printf("%d, %s, %s,%d,%s,%s,%s,%d %n",
				resul2.getInt(1),
				resul2.getString(2),
				resul2.getString(3),
				resul2.getInt(4),
				resul2.getString(5),
				resul2.getString(6),
				resul2.getString(7),
				resul2.getInt(8)
				);
				}
			
			resul2.close();// Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexión
		    }catch (ClassNotFoundException cn) {
			cn.printStackTrace();
			}catch (SQLException e) {
			e.printStackTrace();
			}
			
	}

}
	
