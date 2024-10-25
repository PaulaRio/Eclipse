package accesoDatos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class EscribirFichTexto
{

	public static void main(String[] args) throws IOException
	{
		
	// con true añade contenido al final y con false crea un fichero nuevo:
	FileWriter fic = new FileWriter(new File("NUEVODIR/FICHERO3.TXT"),true); //crear el flujo de salida
	   
	// FileWriter fic = new FileWriter(new File("F:\\Ejercicios\\1-13-EscribirFichTexto.txt"),false);
	
	String cadena ="Esto es una prueba con FileWriter";
	char cad[] = cadena.toCharArray();//convierte un String en array de caracteres
	
	for(int i=0; i<cad.length; i++)
		fic.write(cad[i]);	// se va escribiendo un carácter
	
	fic.append('+');	// añado al final un +   
	fic.append('+');	// añado al final un +
	fic.append('+');	// añado al final un +
	
	fic.write(cad);				// escribir un array de caracteres   
	//fic.write(cadena);		// también funciona.
	   
	fic.write(System.getProperty( "line.separator" )); //Salto de línea
	//fic.write("\r\n"); //Salto de línea
	
	String c="*una línea más.";
	fic.write(c);//escribir un String
	
	fic.write(System.getProperty( "line.separator" )); //Salto de línea
	c= String.format("*esto es lo ultimo.%n");
	fic.write(c);//escribir un String
	   
	String prov[] = {"Albacete","Avila","Badajoz",
		   "Cáceres","Huelva","Jaén",
	       "Madrid","Segovia","Soria","Toledo",
	       "Valladolid","Zamora"};
	   
	String spc = String.format("%n");
	//String spc = "\r\n";
	
	for(int i=0; i<prov.length; i++) 
	{
		fic.write(prov[i]);
		fic.write(System.getProperty( "line.separator" ));	//Salto de línea 1
		fic.write(spc);										//Salto de línea 2
	}
	   
	fic.close();    //cerrar fichero		   

	}

}
