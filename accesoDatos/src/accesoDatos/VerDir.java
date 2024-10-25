package accesoDatos;
//Hacer un programa que dada una carpeta liste su contenido, pero por cada carpeta adentre y haga lo mismo
import java.io.File;
import java.util.Iterator;

public class VerDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dir = "C:\\Users";
		File f = new File(dir);
		//Para usar con consola:
//		if(!f.exists()) {
//			System.out.println("La carpeta no existe");
//			System.exit(1);
//		}else {
//			if(!f.isDirectory()) {
//				System.out.println("No es una carpeta");
//				System.exit(1);
//			}
//		}
		File[] archivos = f.listFiles();//f.list
		System.out.println("Ficheros en el directorio actual: " + archivos.length);
		for (int i = 0; i < archivos.length; i++) {
//			File f2 = new File(f, archivos[i]); Si descomentamos esta parte deberemos usar f2 en lugar de f en la siguiente linea. Porque lo que se hace aqui es convertir string a fichero lo cual no es necesario si usamos listFiles
			System.out.println(
					"Nombre: " + archivos[i] + " es fichero?:" + f.isFile() + " es directorio?:" + f.isDirectory());

		}
	}

}
