/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import accesoadatos.bloque1.xml.Ejemplos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author juanda
 */
public class AccesoADatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            //Ejemplos.divideEnteros();
            //Ejemplos.divideEnterosConStackTrace();
            //Ejemplos.discriminaEntreExcepciones();
            //Ejemplos.especificaExcepcion();       

            //Ejemplos.copiarBytesFichero(args[0], args[1]);
            //Ejemplos.verBytesFichero(args[0]);
            //Ejemplos.copiarCaracteresFichero(args[0], args[1]);
            //Ejemplos.verCaracteresFichero(args[0]);
            //Ejemplos.copiaFicheroPorLineas(args[0], args[1]);
            //Ejemplos.verFicheroPorLinea(args[0]);
            //Ejemplos.scanFile(args[0]);

            //Ejemplos.leerPropiedadesDeUnPath("C:\\Users\\innovacion");
            //Ejemplos.jugandoConFiles();

            //Ejemplos.accesoAleatorio();

            //Ejemplos.buscaElementoEnXMLConDOM("beatles.xml", "firstname");            
            //Ejemplos.crearXMLConDOM();
            //Ejemplos.nombresElementosTablaPeriodica();
            
            Ejemplos.radioAtomicoAtomo("Antimony");
        } catch (Exception ex) {
            System.err.println(ex);
        }

    }
}
