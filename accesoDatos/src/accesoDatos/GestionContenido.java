package accesoDatos;

import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler{
	

public void startDocument() {
	System.out.println("Comienzo del Documento XML");
}
public void endDocument() {
	System.out.println("Final del Documento XML");
}
public void startElement(String uri, String nombre, String nombreC) {
	System.out.printf("\tPrincipio Elemento : %s %n", nombre);
}
public void endElement(String uri, String nombre, String nombreC) {
	System.out.printf("\tfin Elemento : %s %n", nombre);
}
public void characters(char[] ch, int inicio, int longitud ) {
	String car = new String (ch,inicio,longitud);
	
	car=car.replaceAll("[\t\n]", "");
	System.out.printf("\tCaracteres : %s %n", car);
}

}
