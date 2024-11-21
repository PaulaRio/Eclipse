package db4o;

public class Departamento
{
	private String nombreDep;
	private Integer numero;
	public Departamento(String nombreDep, int numero)
	{
		this.nombreDep = nombreDep;
		this.numero = numero;
	}
	public Departamento( int numero)
	{
		this.numero = numero;
	}
	public String getNombreDep()
	{
		return nombreDep;
	}
	public void setNombreDep(String nombreDep)
	{
		this.nombreDep = nombreDep;
	}
	public int getNumero()
	{
		return numero;
	}
	public void setNumero(int numero)
	{
		this.numero = numero;
	}
	
	

}
