package accesoDatos;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaEmpleadoXml
{
	public static void main(String[] args)
	{

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("NUEVODIR/Empleados.xml"));
			document.getDocumentElement().normalize();

			System.out.printf("Elemento raíz : %s %n", document.getDocumentElement().getNodeName());

			NodeList empleados = document.getElementsByTagName("empleado");
			System.out.printf("Nodos empleado a recorrer : %d %n", empleados.getLength());

			for (int i = 0; i < empleados.getLength(); i++)
			{
				Node emple = empleados.item(i);
				if (emple.getNodeType() == Node.ELEMENT_NODE)
				{
					Element elemento = (Element) emple;
					System.out.printf("ID: %s %n", elemento.getElementsByTagName("id").item(0).getTextContent());
					System.out.printf("*Apellido: %s %n",
							elemento.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.printf("*Departamento : %s %n",
							elemento.getElementsByTagName("dep").item(0).getTextContent());
					System.out.printf("*Salario : %s %n",
							elemento.getElementsByTagName("salario").item(0).getTextContent());
//					System.out.printf("*Extra: : %s %n",
//							elemento.getElementsByTagName("extra").item(0).getNodeName());
					NodeList extra = document.getElementsByTagName("extra");
					
						Node ext = extra.item(i);
						if (ext.getNodeType() == Node.ELEMENT_NODE)
						{
							Element subElemento = (Element) ext;
							System.out.println("*Extra: ");
							System.out.printf("**SubExtra1: %s %n", subElemento.getElementsByTagName("subExtra1").item(0).getTextContent());
							System.out.printf("**SubExtra2: %s %n", subElemento.getElementsByTagName("subExtra2").item(0).getTextContent());
						}

					
					{

					}

				}

			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
