//Ejercicio creado por Moises Sepulveda Segarra

package tema3;


import java.io.IOException;
import java.io.FileWriter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
public class Concesionarios2 {

	public static void main(String[] args) {
		crearXml();
	}

	private static void crearXml() {
		try {
            // Base
            Element concesionario = new Element("concesionario");
            Document doc = new Document(concesionario);
 
            Element coches = new Element("coches");
            concesionario.addContent(coches);
            
            //Audi
            Element coche = new Element("coche");
            coche.setAttribute("matricula", "1111AAA");
            Element marca = new Element("marca");
            marca.setText("AUDI");
            Element precio = new Element("precio");
            precio.setText("30000");

            coches.addContent(coche);
            coche.addContent(marca);
            coche.addContent(precio);
            
            //Seat
            coche = new Element("coche");
            coche.setAttribute("matricula", "2222BBB");
            marca = new Element("marca");
            marca.setText("SEAT");
            precio = new Element("precio");
            precio.setText("10000");
            
    
            coches.addContent(coche);
            coche.addContent(marca);
            coche.addContent(precio);
            
            //BMW
            coche = new Element("coche");
            coche.setAttribute("matricula", "3333CCC");
            marca = new Element("marca");
            marca.setText("BMW");
            precio = new Element("precio");
            precio.setText("20000");
            
    
            coches.addContent(coche);
            coche.addContent(marca);
            coche.addContent(precio);
            
            //Toyota
            coche = new Element("coche");
            coche.setAttribute("matricula", "4444DDD");
            marca = new Element("marca");
            marca.setText("TOYOTA");
            precio = new Element("precio");
            precio.setText("10000");
            
    
            coches.addContent(coche);
            coche.addContent(marca);
            coche.addContent(precio);
            
            XMLOutputter xml = new XMLOutputter();
            xml.setFormat(Format.getPrettyFormat());
            xml.output(doc, new FileWriter("/home/moiseg/leer/concesionario2.xml"));
 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
		
			System.out.println("Terminado");
	}

}


