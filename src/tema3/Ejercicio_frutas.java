package tema3;

//C:\Users\Moises\Desktop\Frutas


import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Ejercicio_frutas {
	
	public static void main (String [] args) {
		//Leer
		Leer();
		System.out.println("\nCopiando en archivo csv....\n");
		//Escribir
		Escribir();
		System.out.println("Archivo copiado a formato CSV");
	}
	
//Metodo para escribir	
private static void Escribir() {
		FileReader leer;
		BufferedReader leyendo;
		String lineas;
		FileWriter escribir;
		try {
			leer = new FileReader("/home/moiseg/leer/frutas.txt");
			leyendo = new BufferedReader(leer);
			escribir = new FileWriter ("/home/moiseg/leer/frutas2.csv");
			escribir.write("ID,NOMBRE,PRECIO,TEMPORADA\n");
			lineas = leyendo.readLine();
			String palabras [] = null;
			
			while (lineas != null) {
				palabras = lineas.split(" ");
				escribir.write(palabras[0]+","+palabras[1]+","+palabras[2]+","+palabras[3]+"\n");
				lineas = leyendo.readLine();
			}
			
			leer.close();
			leyendo.close();
			escribir.close();
				
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se ha podido leer el archivo");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

//Metodo para leer	
private static void Leer() {
		FileReader leer;
		BufferedReader leyendo;
		String lineas;
		try {
			leer = new FileReader("/home/moiseg/leer/frutas.txt");
			leyendo = new BufferedReader(leer);
			lineas = leyendo.readLine();
			while (lineas != null) {
				System.out.println(lineas);
				lineas = leyendo.readLine();
			}
			
			leer.close();
			leyendo.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se ha podido leer el archivo");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
