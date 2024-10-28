package escribirEmpleados;

import java.io.Serializable;

public class Empleado implements Serializable
{
	private String nombre;
	private int edad;
	private float salario;
	public Empleado(String nombre,int edad,float salario) {
	this.nombre = nombre;
	this.edad = edad;
	this.salario= salario;
	}
	public Empleado() {
	this.nombre = null;
	}
	public void setNombre(String nombre){this.nombre = nombre;}
	public void setEdad(int edad){this.edad = edad;}
	public void setSalario(float salario){this.salario= salario;}
	public String getNombre(){return this.nombre;}//devuelve nombre
	public int getEdad(){return this.edad;} //devuelve edad
	public float getSalario(){return this.salario;}
}
