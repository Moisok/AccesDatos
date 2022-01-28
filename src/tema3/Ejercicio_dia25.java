//Moises Sepulveda Segarra
package tema3;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.util.regex.Matcher;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//Importasmos para leer archivos CSV

public class Ejercicio_dia25 {

	public static void main(String[] args) throws CsvValidationException {
		// Variables tipo File
		Scanner keyboard = new Scanner(System.in);
		// Variables para introducir datos
		File archivo;
		CSVReader csvReader = null;
		String[] lineas = null;
		String ruta = "/home/moiseg/leer/Restaurants.csv";
		archivo = new File("/home/moiseg/leer/Restaurants.csv");
		csvReader = LeerDatos(archivo, csvReader, ruta);
		IntroducirDatos(keyboard, ruta);
		CopiarDatos(csvReader);
		borrararchivos(keyboard);
		
		
		// Por ultimo cerramos
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void borrararchivos(Scanner keyboard) {
		String rutaborrar;	
		System.out.println("Introduce ruta a borrar");
		rutaborrar = keyboard.nextLine();
		File rutaborrado = new File(rutaborrar);
		if (rutaborrado.exists()) {
			rutaborrado.delete();
			System.out.println("Se hga eliminado el archivo");
		}
		else {
			System.out.println("No existe el archivo");
		}
	}

//Funcion de copiar datos
	private static void CopiarDatos(CSVReader csvReader) throws CsvValidationException {
		String[] lineas;
		//Copia del fichero
		try {
			
				System.out.println("Copiando archivo....");
				
				File rutaArchivo = new File("/home/moiseg/leer/Restaurants.csv");
				
				
	            File destino = new File("/home/moiseg/leer/Restaurants2.csv");
	            
	            FileReader leer = new FileReader(rutaArchivo);
	            
	            csvReader = new CSVReader(leer);
	            
	            FileWriter escribir = new FileWriter(destino);
	            
	            
	            while ((lineas = csvReader.readNext()) != null) {	
					// Filtramos solo los que empiezan por 6
	            	
					Pattern pat = Pattern.compile("^6.*");
					Matcher mat = pat.matcher(lineas[4]);
					// Ponemos las condiciones
					if (mat.matches() == false) {
						for (int i=0;i<lineas.length;i++) {
							escribir.write(lineas[i]+",");
							
						}
						escribir.write("\n");
					}
				}
	            
	            escribir.close();
	            
	            leer.close();
	            
	            System.out.println("Archivo copiado");
	            
			}catch(IOException ex) {
				
				System.out.println("No se ha podido copiar el archivo");
				
			}
	}

	
//Funcion de Introducir datos	
	private static void IntroducirDatos(Scanner keyboard, String ruta) {
		String nombre;
		String calle;
		String ciudad;
		String estado;
		String cpostal;
		try {
			// Aqui introducimos datos nuevos
						CSVWriter write = new CSVWriter(new FileWriter(ruta,true));
						System.out.println("Introduce nombre de restaurante");
						nombre = keyboard.nextLine();
						System.out.println("Introduce calle");
						calle = keyboard.nextLine();
						System.out.println("Introduce ciudad");
						ciudad = keyboard.nextLine();
						System.out.println("Introduce estado");
						estado = keyboard.nextLine();
						System.out.println("Introduce codigo postal");
						cpostal = keyboard.nextLine();
						String [] aniadir = {nombre,calle,ciudad,estado,cpostal};
						write.writeNext(aniadir);
						write.close();
			
		}catch(IOException ex) {
			System.out.println("No se ha podido introducir datos");
		}
	}

//Funcion de Leer datos	
	private static CSVReader LeerDatos(File archivo, CSVReader csvReader, String ruta) throws CsvValidationException {
		String[] lineas;
		// implementarlas
		try {
			csvReader = new CSVReader(new FileReader(ruta));
			// Primera comprobacion
			if (archivo.exists()) {
				System.out.println("La ruta existe");
			} else {
				System.out.println("No existe la ruta");
			}
			// Segunda comprobacion
			if (archivo.isFile()) {
				System.out.println("Es un archivo");
				// Tercera comprobacion
				System.out.println("Nombre: " + archivo.getName());
				System.out.println("¿Cuanto pesa el archivo?: " + archivo.length() + "kb");
				System.out.println("¿Puedes escribir?: " + archivo.canWrite());
				System.out.println("¿Puedes leerlo?: " + archivo.canRead());
				System.out.println(" ");
			}
			// Bucle donde recorreremos el archivo con el buffer
			while ((lineas = csvReader.readNext()) != null) {
				// Filtramos solo los que empiezan por 6
				Pattern pat = Pattern.compile("^6.*");
				Matcher mat = pat.matcher(lineas[4]);
				// Ponemos las condiciones
				if (mat.matches()) {
					System.out.print(lineas[0] + " | ");
					System.out.print(lineas[1] + " | ");
					System.out.print(lineas[2] + " | ");
					System.out.print(lineas[3] + " | ");
					System.out.print(lineas[4] + " |");
					System.out.println(" ");
					System.out.println(" ");
				}
			}
			//Excepciones    
					} catch (IOException ex) {
						System.err.println("Error al leer el archivo");
						System.err.println(ex.getMessage());
					}
		return csvReader;
	}
}