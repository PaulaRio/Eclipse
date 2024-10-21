package accesoDatos;

import java.io.Serializable;

public class Persona implements Serializable
{
	private String nombre;
	private int edad;

	// Constructores:
	public Persona(String nombre, int edad)
	{
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona(String nombre)
	{
		this.nombre = nombre;
	}

	// En java no se definen destructores como en C u otros lenguajes.
	public void setNombre(String nom)
	{
		nombre = nom;
	}

	public void setEdad(int ed)
	{
		edad = ed;
	}

	public String getNombre()
	{
		return nombre;
	}

	public int getEdad()
	{
		return edad;
	}

	@Override
	public String toString()
	{
		return "Persona [nombre=" + nombre + "]";
	}
	
}// fin Persona