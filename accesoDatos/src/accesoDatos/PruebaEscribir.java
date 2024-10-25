package accesoDatos;

import java.io.*;

public class PruebaEscribir 
{
  public static void main(String[] args) throws IOException
  {  
   
   Persona persona; //define el objeto/variable persona
   
   File fichero = new File("NUEVODIR/FichPersona.txt");//declara el fichero

   //*
   //FileOutputStream fileout = new FileOutputStream(fichero,true); //crea el flujo de salida
   FileOutputStream fileout;
   //FileOutputStream fileout = new FileOutputStream("F:\\Ejercicios\\1-19-EscribirFichObject-FichPersona.txt",true);

   /*
   //conecta el flujo de bytes al flujo de datos
   ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
   */

   ObjectOutputStream dataOS;
   
   ///* Nuevo bloque
   {
	   if (!fichero.exists())
	   {
		   fileout = new FileOutputStream(fichero,true); //crea el flujo de salida
		   dataOS = new ObjectOutputStream(fileout);
		   System.out.println("NO Existe");
	   }
	   else
	   {
		   fileout = new FileOutputStream(fichero,true); //crea el flujo de salida
		   dataOS = new MiObjectOutputStream(fileout);
		   System.out.println("Existe");
	   }
   }
   //*/
   
   String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andres",
                       "Julio","Antonio","Maria Jesus"};
					   
   int edades[] = {14,15,13,15,16,12,16,14,13};
   
   System.out.println("COMIENZA A GRABAR LOS DATOS DE LAS PERSONAS.");      
   
   for (int i=0;i<edades.length; i++)
   { //recorre los arrays para asignar los datos al array de personas.
      persona = new Persona(nombres[i],edades[i]); //creo la persona	  
	  dataOS.writeObject(persona); //escribo la persona en el fichero
	  System.out.println("GRABA LOS DATOS DE PERSONA "+(i+1));  
   }
   dataOS.close();  //cerrar stream de salida    
  }
}