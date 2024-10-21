package accesoDatos;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class PruebaSax
{

	public static void main(String[] args) 
	{
		
		try
		{
			XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
			GestionContenido gestor = new GestionContenido();
			procesadorXML.setContentHandler(gestor);
			InputSource fileXMl= new InputSource("NUEVODIR/Empleados.xml");
			procesadorXML.parse(fileXMl);
		} catch (SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
