package escribirPersonas;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class convertidor 
{
 public static void main(String args[]) throws IOException
 {
  String datosAlumnos = "NUEVODIR/Personas.xml";		
  String hojaEstilo = "NUEVODIR/alumnosPlantilla.xsl";	
  
  File pagHTML = new File("NUEVODIR/mipagina.html");
  FileOutputStream os = new FileOutputStream(pagHTML); 
  
  Source estilos =new StreamSource(hojaEstilo); 
  Source datos =new StreamSource(datosAlumnos); 
  Result result = new StreamResult(os);         
  
  try
  {     
   Transformer transformer =  TransformerFactory.newInstance().newTransformer(estilos);   
   transformer.transform(datos, result);	
  }
  catch(Exception e){System.err.println("Error: "+e);}
  
  os.close();  
 }
}
