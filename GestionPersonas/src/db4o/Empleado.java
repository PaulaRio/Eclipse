package db4o;

public class Empleado
{
	private String nombre;
	private Integer nDep;
	public Empleado(String nombre, int nDep)
	{
		this.nombre = nombre;
		this.nDep = nDep;
	}
	public Empleado()
	{
		this.nombre = null;
		this.nDep = null;
		
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public int getnDep()
	{
		return nDep;
	}
	public void setnDep(int nDep)
	{
		this.nDep = nDep;
	}
	

	
}
