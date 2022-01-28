package tema3;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import com.opencsv.*;

public class LeerFichero {

	public static void main(String[] args) throws IOException {
		
		
		//Primera parte del ejercicio
		System.out.print("1.- Indica la ruta de un fichero: ");
		Scanner leer = new Scanner(System.in);
		String ruta = leer.next();
		File f_ruta = new File (ruta);
		
		if (f_ruta.exists()) {
			String permisos="";
			
			if (f_ruta.canRead() == true) {
				permisos=permisos+"r";
			}
			else {
				permisos=permisos+"-";
			}
			
			if (f_ruta.canWrite() == true) {
				permisos=permisos+"w";
			}
			else {
				permisos=permisos+"-";
			}
			
			if (f_ruta.canExecute() == true) {
				permisos=permisos+"x";
			}
			else {
				permisos=permisos+"-";
			}
			

			if (f_ruta.isDirectory() == false) {
				System.out.println( f_ruta.getName()+"\t"+f_ruta.length()+"\t"+permisos+" <Fitxer>");
			}
		}
		else {
			System.out.println("La ruta indicada no existe");
		}
		
		//Segunda parte del ejercicio
		
		System.out.println("2.- Restaurantes cuyo c�digo postal que empiece por 6");
		File fitxer = null;
		FileReader reader = null;
		BufferedReader buffer = null;
		
		try {
			System.out.println("Resultat amb el Split + Matcher");
			System.out.println();
			fitxer = new File("Restaurants.csv");
			reader = new FileReader(fitxer);
			buffer= new BufferedReader(reader);
			
			String lin;
			while((lin = buffer.readLine()) != null) {
				
				String[] separat = lin.split(",");
				
				for (int i=0;i<separat.length;i++) {
					if (i == (separat.length-1)) {
						Pattern pat = Pattern.compile("^6.*");
						Matcher mat = pat.matcher(separat[i]);
						if (mat.matches()) {
							System.out.println(lin);
						}
					}
				}
			}
		}
		catch(Exception ex){}
		
		//Segunda parte con el CSVreader
		
		
		System.out.println();
		System.out.println("Segunda parte con el CSVReader");
		System.out.println();
		
		CSVReader csvReader = null;
		String[] lineas = null;
		
		try {
		
			csvReader = new CSVReader(new FileReader("Restaurants.csv"));
		
			while ((lineas = csvReader.readNext()) != null) {
				// Filtro los que empiezan por 6
				Pattern pat = Pattern.compile("^6.*");
				Matcher mat = pat.matcher(lineas[4]);
				if (mat.matches()) {
					System.out.print(lineas[0] + " - ");
					System.out.print(lineas[1] + " - ");
					System.out.print(lineas[2] + " - ");
					System.out.print(lineas[3] + " - ");
					System.out.println(lineas[4] + "");
				}
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error en la lectura del archivo con la clase csvReader");
		}
		
		
		
		//Tercera parte del ejercicio
		
		System.out.println("A�adir nuevos datos al fichero csv");
		String nombreR;
		String ciudad;
		String estado;
		String cpostal;
		
		
		FileWriter filewriter = new FileWriter(fitxer, true);
		
		System.out.println("Indica nombre del restaurante: ");
		nombreR = leer.nextLine();
		System.out.println("Indica la direcci�n: ");
		ciudad = leer.nextLine();
		System.out.println("Indica la ciudad: ");
		estado = leer.nextLine();
		System.out.println("Indica codigo postal: ");
		cpostal = leer.nextLine();
		
		try {
			filewriter.write(nombreR+","+ciudad+","+estado+","+cpostal);
			filewriter.close();
		}
		catch(Exception ex) {}
		
		
		//Ejercicio 4
		
		/**/
		
		
		
	}
	

}
