package escribirPersonas;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class convertidor2 
{
 public static void main(String argv[]) throws IOException
 {
  String datosAlumnos = "NUEVODIR/alumnos2.xml";		// fichero de datos
  String hojaEstilo = "NUEVODIR/alumnosPlantilla2.xsl";	// plantilla de presentaci�n
  
  File pagHTML = new File("NUEVODIR/mipagina2.html");
  FileOutputStream os = new FileOutputStream(pagHTML); //crear fichero HTML
  
  Source estilos =new StreamSource(hojaEstilo); //fuente XSL
  Source datos =new StreamSource(datosAlumnos); //fuente XML
  Result result = new StreamResult(os);         //resultado de la transformaci�n
  
  try
  {     
   Transformer transformer =  TransformerFactory.newInstance().newTransformer(estilos);   
   transformer.transform(datos, result);	//obtiene el HTML
  }
  catch(Exception e){System.err.println("Error: "+e);}
  
  os.close();  //cerrar fichero 	
 }//de main
}//de la clase
