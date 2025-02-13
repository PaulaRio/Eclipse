package descripcionDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploDatabaseMetadata
{ public static void main(String[] args)
{
	try {
		//Cargar el driver
		Class.forName("com.mysql.jdbc.Driver");
		//Establecemos la conexion con la BD
		Connection conexion = DriverManager.getConnection
		("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
		
		DatabaseMetaData dbmd = conexion.getMetaData();
		ResultSet resul = null;
		String nombre = dbmd.getDatabaseProductName();
		String driver = dbmd.getDriverName();
		String url = dbmd.getURL();
		String usuario = dbmd.getUserName() ;
		System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
        System.out.println("=============================");
        System.out.printf("Nombre: %s %n", nombre);
        System.out.printf("Driver: %s %n", driver);
        System.out.printf("URL: %s %n", url);
        System.out.printf("Usuario: %s %n", usuario);
     // Obtener información de las tablas y vistas que hay
        resul = dbmd.getTables(null, "ejemplo", null, null);
        while (resul.next()) {
            String catalogo = resul.getString(1); // Columna 1
            String esquema = resul.getString(2);  // Columna 2
            String tabla = resul.getString(3);    // Columna 3
            String tipo = resul.getString(4);     // Columna 4

            System.out.printf("%s - Catálogo: %s, Esquema: %s, Nombre: %s %n", 
                              tipo, catalogo, esquema, tabla);
        }
        System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
        System.out.println("========================");
        // columnas=null;
        ResultSet columnas = dbmd.getColumns(null, "ejemplo", "departamentos", null);
        while (columnas.next()) {
        String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
        String tipoCol = columnas.getString("TYPE_NAME"); //getString(6)
        String tamCol = columnas.getString("COLUMN_SIZE"); //getString(7)
        String nula = columnas.getString("IS_NULLABLE"); //getString(18)
        System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s,¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
        

        }
		conexion.close(); // Cerrar conexión
	    }catch (ClassNotFoundException cn) {
		cn.printStackTrace();
		}catch (SQLException e) {
		e.printStackTrace();
		}

}

}
