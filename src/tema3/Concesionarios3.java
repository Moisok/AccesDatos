package tema3;

//Ejercicio creado por Moises Sepulveda Segarra

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
public class Concesionarios3 {

	public static void main(String[] args) {
		crearXml();
	}

	private static void crearXml() {
		
		int opcion = 0;
		String dato;
		
		Scanner keyboard = new Scanner (System.in);
		
		try {
          // Base
          Element concesionario = new Element("concesionario");
          Document doc = new Document(concesionario);

          Element coches = new Element("coches");
          concesionario.addContent(coches);
          
          while (opcion != 2) {
  			System.out.println("INTRODUCE: 1 PARA INTRODUCIR DATOS\nINTRODUCE: 2 PARA SALIR DEL PROGRAMA");
  			opcion = keyboard.nextInt();
  			
  			if (opcion == 1) {
  				Element coche = new Element("coche");
  				System.out.println("Introduce matricula");
  				dato = keyboard.next();
  				System.out.println("Matricula introducida: ["+dato+"]");
  	            coche.setAttribute("matricula", dato);
  	            Element marca = new Element("marca");
  	            System.out.println("Introduce marca");
  	            dato = keyboard.next();
  	            System.out.println("Marca introducida: ["+dato+"]");
  	            marca.setText(dato);
  	            Element precio = new Element("precio");
  	            System.out.println("Introduce precio");
	            dato = keyboard.next();
	            System.out.println("Precio introducido: ["+dato+"]\n");
  	            precio.setText(dato);

  	            coches.addContent(coche);
  	            coche.addContent(marca);
  	            coche.addContent(precio);
  			}
  			
  			if (opcion > 2 || opcion < 1) {
  				System.out.println("No se reconoce el comando");
  			}
  		}
          XMLOutputter xml = new XMLOutputter();
          xml.setFormat(Format.getPrettyFormat());
          xml.output(doc, new FileWriter("/home/moiseg/leer/concesionario3.xml"));
      } catch (IOException ex) {
          System.out.println(ex.getMessage());
      }
			keyboard.close();
			System.out.println("Terminado");
	}

}
