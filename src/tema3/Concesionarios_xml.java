//Ejercicio creado por Moises Sepulveda Segarra aaa

package tema3;

import java.util.List;
import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Concesionarios_xml {

	public static void main(String[] args) {

		leer leida = new leer();
		leida.archivos();

	}
}

class leer {

	void archivos() {

		File archivo = new File("/home/moiseg/leer/concesionario.xml");

		SAXBuilder constructorSAX = new SAXBuilder();

		Document documento = null;

		Element nodoRaiz;

		try {
			documento = constructorSAX.build(archivo);
		} catch (JDOMException e) {
			System.err.println("No se puede acceder al archivo XML");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Fichero no valido");
			e.printStackTrace();
		}

		nodoRaiz = documento.getRootElement();
		Element coches = nodoRaiz.getChild("coches");
		List listacoches = coches.getChildren("coche");

		for (int i = 0; i < listacoches.size(); i++) {
			/* Obtenemoms el elemento de la lista */
			Element nodo = (Element) listacoches.get(i);
			String matricula = nodo.getAttributeValue("matricula");
			String marca = nodo.getChild("marca").getValue();
			String precio = nodo.getChild("precio").getValue();
			System.out.print("Con atricula:" + matricula + "\nMarca del vehiculo:" + marca + "\nPrecio del vehiculo:"
					+ precio + "\n\n");
		}

	}
}
