//Moises Sepulveda Segarra
package tema3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio_2 {

	public static void main(String[] args) {
		
		//Variables tipo File
		File archivo;
		
		FileReader entrada = null;
		
		BufferedReader buffer = null;
		
		
		//ArrayList
		ArrayList <String> lista = new ArrayList <String>();
		
		//Creamos excepciones ya que al trabajar con la clase File se nos pide implementarlas
		try {
			
			archivo = new File("/home/moiseg/leer/ejercicio2.txt");
			
			entrada = new FileReader (archivo);
			
			buffer = new BufferedReader (entrada);
			
			String lineas;
			
			//Bucle donde recorreremos el archivo con el buffer
			
			while ( (lineas=buffer.readLine()) != null) {
				
					String [] elementos = lineas.split(" ");
					
					for (int i=0;i<elementos.length;i++) {
						Pattern pat = Pattern.compile("[a-zA-Z]+");
						Matcher mat = pat.matcher(elementos[i]);
						
						//Ponemos las condiciones
						if(mat.matches()) {
							System.out.println("Palabras: " + elementos[i]);
						}
						else {
							System.out.println("Numeros: " + elementos[i]);
						}
						
						
					}
				
				}
				
			}catch(IOException ex) {
			
			System.err.println("Error al leer el archivo");
			
			System.err.println(ex.getMessage());
			
		}
		
		//Creamos un for each donde leera los elementos de la lista
		
		
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