/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.bloque1.excepciones;

import accesoadatos.bloque1.excepciones.ClasesQueArrojanExcepciones.Dividir;
import accesoadatos.bloque1.excepciones.ClasesQueArrojanExcepciones.RangoPositivo;
import accesoadatos.bloque1.excepciones.Exception.FueraDeRangoException;
import accesoadatos.bloque1.excepciones.Exception.RangoMalFormadoException;
import accesoadatos.bloque1.excepciones.Exception.DivisionPorCeroException;

/**
 *
 * @author juanda
 */
public class Ejemplos {

    public static void divideEnteros() {
        try {
            Dividir d1 = new Dividir(10.0, 20.0);

            Dividir d2 = new Dividir(1.0, 0.0);

            System.out.print(d1.getResultado());
            System.out.print(d2.getResultado());

        } catch (DivisionPorCeroException ex) {
            System.err.println(DivisionPorCeroException.class.getName() + " " + ex.getMessage());
        }
    }

    public static void divideEnterosConStackTrace() {
        try {
            Dividir d1 = new Dividir(10, 20);

            Dividir d2 = new Dividir(1, 0);

            System.out.print(d1.getResultado());
            System.out.print(d2.getResultado());

        } catch (DivisionPorCeroException ex) {
            System.err.println(DivisionPorCeroException.class.getName() + " " + ex.getMessage());
            StackTraceElement elements[] = ex.getStackTrace();
            for (int i = 0, n = elements.length; i < n; i++) {
                System.err.println(elements[i].getFileName()
                        + ":" + elements[i].getLineNumber()
                        + ">> "
                        + elements[i].getMethodName() + "()");
            };
        }
    }

    public static void discriminaEntreExcepciones() {

        try {
            Dividir d1 = new Dividir(10, 20);

            RangoPositivo r = new RangoPositivo(1, 2);

            RangoPositivo r2 = new RangoPositivo(-1, 2);

        } catch (DivisionPorCeroException ex) {
            System.err.println(ex);
        } catch (FueraDeRangoException ex) {
            System.err.println(ex);
        } catch (RangoMalFormadoException ex) {
            System.err.println(ex);
        }
    }
    
    public static void especificaExcepcion() throws DivisionPorCeroException{
        Dividir d1 = new Dividir(10, 20);
    }
}
