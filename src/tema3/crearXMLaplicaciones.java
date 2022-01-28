package tema3;

import java.io.FileWriter;
import java.io.IOException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
 
public class crearXMLaplicaciones {
 
    public static void main(String[] args) {
 
        try {
            // Creamos el elemento base
            Element aplicaciones= new Element("aplicaciones");
            Document doc = new Document(aplicaciones);
 
            // Creamos aplicacion 1 
            Element aplicacion = new Element("aplicacion");
            aplicacion.setAttribute("categoria", "programacion");
            
            Element nombre = new Element("nombre");
            nombre.setText("NetBeans");
            Element compania = new Element("compania");
            compania.setText("Oracle");
 
            //Añadimos nombre y compañia al elemento padre aplicacion
            aplicacion.addContent(nombre);
            aplicacion.addContent(compania);
            
            // (También podría añadir directamente una colección de objetos "Element")
            
            
            //añadimos la aplicación al elemento padre aplicaciones
            aplicaciones.addContent(aplicacion);
            
          //Mismo codigo para resto de aplicaciones
 
            aplicacion = new Element("aplicacion");
            aplicacion.setAttribute("categoria", "programacion");
            
            nombre = new Element("nombre");
            nombre.setText("Eclipse");
            compania = new Element("compania");
            compania.setText("Eclipse foundation");
            
            aplicacion.addContent(nombre);
            aplicacion.addContent(compania);
            
            aplicaciones.addContent(aplicacion);

 
            // Creamos el fichero XML  con la clase XMLOutputter de JDOM
            XMLOutputter xml = new XMLOutputter();
            xml.setFormat(Format.getPrettyFormat());
            //Recuerda que necesitaras el elemento raíz que hemos creado al inicio (objeto Document).


            xml.output(doc, new FileWriter("aplicacionesprueba.xml"));
 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
 
    }
 
}
