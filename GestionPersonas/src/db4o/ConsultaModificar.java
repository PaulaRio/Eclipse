package db4o;

import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class ConsultaModificar
{
	static String BDEmple = "DBEmpleadoDep.yap";

	public static void main(String[] args)
	{

		Scanner teclado = new Scanner(System.in);
		Integer numero = 0;
		
		System.out.println("Introduce numero de departamento");
		numero = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce nombre de departamento");
		String nomDept = teclado.nextLine();
		System.out.println("Introduce nombre de persona");
		String nomPers = teclado.nextLine();
//		nomDept = ("") ? nomDept=null;

		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmple);
		Empleado emple = new Empleado(nomPers, numero);
		Departamento dpt = new Departamento(nomDept, numero);
		ObjectSet<Empleado> resultEmple = db.queryByExample(emple);
		ObjectSet<Departamento> resultDept = db.queryByExample(dpt);

		if (resultEmple.size() == 0)
			System.out.println("No existen Registros de Empleados ");
		if (resultDept.size() == 0)
			System.out.println("No existen Registros de Departamento ");

		Departamento dptt = resultDept.getFirst();

		while (resultEmple.hasNext())
		{
			Empleado emp = resultEmple.next();
			System.out.printf("Nombre: %s, Numero departamento: %d, nombre departamento: %s %n", emp.getNombre(),
					emp.getnDep(), dptt.getNombreDep());
		}

		db.close(); // cerrar base de datos
	}

}
