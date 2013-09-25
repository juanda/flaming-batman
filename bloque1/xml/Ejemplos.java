/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.bloque1.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author innovacion
 */
public class Ejemplos {

    public static void buscaElementoEnXMLConDOM(String filename, String ele) throws ParserConfigurationException, IOException, SAXException {

        // Primero instanciamos la factoria de DOMs
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // Ahora, si fuese necesario, podemos configurar la factoría para
        // que los documentos que construya tengan en cuenta los espacios
        // de nombre y reglas de validación procedentes de un fichero 
        // DTD o Schema. 

        // El siguiente código se ha incluido en este ejemplo para que veas
        // como se realizaría dicha configuración. No obstante para el ejemplo
        // que vamos a mostrar no es necesario. De hecho las siguientes 6 líneas
        // de código, tal y como están definidas son inócuas.

        boolean dtdValidate = false;
        boolean xsdValidate = false;
        String schemaSource = null;

        dbf.setNamespaceAware(false);
        dbf.setValidating(dtdValidate || xsdValidate);

        // Ahora creamos a través de la factoría un constructor de documentos
        // y con este creamos el DOM mediante parseo del fichero XML El objeto
        // `doc` representa el árbol XML completo.
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(filename));

        NodeList list = doc.getElementsByTagName(ele);

        if (list.getLength() == 0) {
            System.out.println("No hay ningún elemento llamado " + ele);
        } else {
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i).getFirstChild();
                System.out.println(node.getNodeName()
                        + " "
                        + node.getNodeType()
                        + " "
                        + node.getNodeValue());
            }
        }
    }

    public static void crearXMLConDOM() {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder parser = factory.newDocumentBuilder();

            // Creamos un documento nuevo
            Document doc = parser.newDocument();

            // Creamos el elemento raíz
            Element root = doc.createElement("rollings");

            // Lo añadimos como hijo al documento
            doc.appendChild(root);

            // Creamos el elemento `rolling`, es decir un miembro de los 
            // rollings stones
            Element miembro = doc.createElement("rolling");

            // A ese elmento le añadimos un atributo llamado `link`
            miembro.setAttribute("link", "http://mickjagger.com");

            // Creamos un elemento `name`
            Element name = doc.createElement("name");

            // Creamos un elemento `firstname`
            Element firstname = doc.createElement("firstname");

            // Creamos un nodo de Texto con el nombre de uno de los miembros
            Text fn = doc.createTextNode("Mick");

            // Se lo añadimos como hijo al elemento `firstname`
            firstname.appendChild(fn);

            // Creamos el elemento `lastname`
            Element lastname = doc.createElement("lastname");

            // Creamos un nodo de Texto con el apellido de uno de los miembros
            Text ln = doc.createTextNode("Jagger");

            // Se lo añadimos como hijo al elemento `lastname`
            lastname.appendChild(ln);

            // Vamos construyendo todo el árbol

            // Añadimos `firstname`como hijo de `name`
            name.appendChild(firstname);

            // Añadimos `lastname`como hijo de `name`
            name.appendChild(lastname);

            // Añadimos `name`como hijo de `rolling`
            miembro.appendChild(name);

            // Añadimos `rolling`como hijo de `rollings` (el elemento raíz)
            root.appendChild(miembro);

            // Ya está construido el árbol DOM, ahora vamos a guardarlo en
            // un fichero XML.

            Source source = new DOMSource(doc);

            // Preparamos el fichero de salida
            File file = new File("rolling.xml");
            Result result = new StreamResult(file);

            // Escribimos el DOM al fichero de salida
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void nombresElementosTablaPeriodica() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("tabla_periodica.xml"));

            // Obtenemos los nombres de todos los elementos de la tabla periodica

            ArrayList<String> nombresDeElementos = new ArrayList<>();

            NodeList atomos = doc.getElementsByTagName("ATOM");

            for (int i = 0; i < atomos.getLength(); i++) {

                NodeList propiedades = atomos.item(i).getChildNodes();

                for (int j = 0; j < propiedades.getLength(); j++) {

                    if (propiedades.item(j).getNodeName() == "NAME") {

                        nombresDeElementos.add(propiedades.item(j).getFirstChild().getNodeValue());

                    }
                }
            }

            // Pintamos los nombres de los elementos

            for (Iterator<String> iter = nombresDeElementos.iterator(); iter.hasNext();) {
                System.out.println(iter.next());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void radioAtomicoAtomo(String nombreAtomo) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("tabla_periodica.xml"));

            NodeList atomos = doc.getElementsByTagName("ATOM");

            boolean encontrado = false;
            Element atomo = null;
            
            for (int i = 0; i < atomos.getLength(); i++) {
                
                atomo = (Element) atomos.item(i);
                
                if(nombreAtomo.equals(getPropiedadAtomo(atomo, "NAME"))){
                    encontrado = true;
                    break;
                }
            }
            
            
//            for (int i = 0; i < atomos.getLength(); i++) {
//
//                NodeList propiedades = atomos.item(i).getChildNodes();
//
//                for (int j = 0; j < propiedades.getLength(); j++) {
//
//                    if (propiedades.item(j).getNodeName() == "NAME") {
////System.out.println(propiedades.item(j).getFirstChild().getNodeValue());
//                        if (propiedades.item(j).getFirstChild().getNodeValue().equals(nombreAtomo)) {
//
//                            encontrado = true;
//                            atomo = (Element) atomos.item(i);
//                            break; // Cuando encontremos el átomo deja de buscar
//                        }
//                    }
//                }
//                if (encontrado) {
//                    break;
//                }
//            }
            if (!encontrado) {
                System.out.println("No se ha encontrado el elemento");
            } else {
                System.out.println("El radio atómico del " + nombreAtomo + " es: " + getPropiedadAtomo(atomo, "ATOMIC_RADIUS"));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected static String getPropiedadAtomo(Element atomo, String nombrePropiedad) {

        NodeList propiedades = atomo.getChildNodes();

        for (int i = 0; i < propiedades.getLength(); i++) {

            if (propiedades.item(i).getNodeName().equals(nombrePropiedad)) {

                return propiedades.item(i).getFirstChild().getNodeValue();
            }
        }

        return "";
    }
}
