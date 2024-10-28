package escribirEmpleados;


import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados
{

	private List <Empleado> lista = new ArrayList<Empleado>();
	public ListaEmpleados(){ }
	public void add(Empleado emple) {
	lista.add(emple);
	}
	public List<Empleado> getListaEmpleados() {
	return lista;
	}
	}

