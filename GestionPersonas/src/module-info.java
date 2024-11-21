/**
 * 
 */
/**
 * 
 */
module GestionPersonas
{
	opens escribirPersonas to xstream;
	opens escribirEmpleados to xstream;
	requires xstream;
	requires java.xml;
	requires db4o;
	opens db4o to db4o; 
}