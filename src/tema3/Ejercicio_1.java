
//Moises Sepulveda Segarra
package tema3;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Ejercicio_1 {

	public static void main(String[] args) {
		//Variables tipo File
		
		File archivo;
		
		FileReader entrada = null;
		
		BufferedReader buffer = null;
		
		
		//Creamos excepciones ya que al trabajar con la clase File se nos pide implementarlas
		try {
			
			archivo = new File("/home/moiseg/leer/ejercicio1.txt");
			
			entrada = new FileReader (archivo);
			
			buffer = new BufferedReader (entrada);
			
			String lineas;
			
			//Bucle donde recorreremos el archivo con el buffer
			
			while ( (lineas=buffer.readLine()) != null) {
				
				//Creamos las expresiones regulares para comprobar si empieza por una letra y filtrarlo
				
				Pattern pat = Pattern.compile("[a-zA-Z]+");
				Matcher mat = pat.matcher(lineas);
				
				//Ponemos las condiciones
				if(mat.matches()) {
					System.out.println("Palabra: " + lineas);
				}
				else {
					System.out.println("Numero: " + lineas);
				}
				
				
				}
				
			}catch(IOException ex) {
			
			System.err.println("Error al leer el archivo");
			
			System.err.println(ex.getMessage());
			
		}
		
	
		
		//Por ultimo cerramos
			try {
				entrada.close();
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
}