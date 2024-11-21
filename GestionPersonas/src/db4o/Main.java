package db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Main 
{
	static String BDEmple = "DBEmpleadoDep.yap";
	
	public static void main(String[] args) 
	{
		ObjectContainer dbED = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmple);
		

		///*
		// Creamos empleados
		Empleado e1 = new Empleado("Juan", 1);
		Empleado e2 = new Empleado("Ana", 2);
		Empleado e3 = new Empleado("Luis", 1);
		Empleado e4 = new Empleado("Pedro", 3);
		//*/
		// Creamos departamentos
		Departamento d1 = new Departamento("Desarrollo Interfaces", 1);
		Departamento d2 = new Departamento("Acceso a Datos", 2);
		
		
		/*
		db.store(new Persona("Juan", "Guadalajara"));
		db.store(new Persona("Ana", "Madrid"));
		db.store(new Persona("Luis", "Granada"));
		db.store(new Persona("Pedro", "Asturias"));
		*/
		
		///*
		// Almacenar objetos Empleado y Departamento en la base de datos
		dbED.store(e1);
		dbED.store(e2);
		dbED.store(e3);
		dbED.store(e4);
		dbED.store(d1);
		dbED.store(d2);
		
		//*/
		
		dbED.close(); // cerrar base de datos
		

	}// fin de main
}// fin de la clase Main