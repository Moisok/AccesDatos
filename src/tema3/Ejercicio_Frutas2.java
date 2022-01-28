package tema3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class Ejercicio_Frutas2 {

	public static void main(String[] args) {
		
		leerycopiar();
	}
	
	//FUncion
	private static void leerycopiar() {
		String[] lineas;
	
		try {
				System.out.println("Copiando archivo....");
				
				File rutaArchivo = new File("/home/moiseg/leer/frutas2.csv");
				
	            File destino = new File("/home/moiseg/leer/frutas3.csv");
	            
	            FileReader leer = new FileReader(rutaArchivo);
	            
	            CSVReader csvReader = new CSVReader(leer);
	            
	            FileWriter escribir = new FileWriter(destino);
	            
	            try {
					while ((lineas = csvReader.readNext()) != null) {	
						
						Pattern pat = Pattern.compile("No");
						Matcher mat = pat.matcher(lineas[3]);
						if (mat.matches() == false) {
							for (int i=0;i<lineas.length;i++) {
								escribir.write(lineas[i]+",");
							}
							escribir.write("\n");
						}
					}
				} catch (CsvValidationException e) {
	
					e.printStackTrace();
				}
	            
	            escribir.close();
	            
	            leer.close();
	            
	            System.out.println("Archivo copiado");
	            
			}catch(IOException ex) {
				
				System.out.println("No se ha podido copiar el archivo");
				
			}
	}
	
}




