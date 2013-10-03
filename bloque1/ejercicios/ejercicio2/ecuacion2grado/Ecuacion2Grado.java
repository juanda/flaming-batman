/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.ejercicio2.ecuacion2grado;

/**
 *
 * @author juanda
 */
public class Ecuacion2Grado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        double a, b, c;
//
//        a = 1;
//        b = 0;
//        c = -9;

        try {
            LeeArgumentos la = new LeeArgumentos(args);
            
            Ecuacion2GradoSolver solver = new Ecuacion2GradoSolver(la.dameA(), la.dameB(), la.dameC());

            double[] resultado = solver.dameResultado();

            System.out.println("Soluciones");
            System.out.println("==========");
            System.out.println("x=" + resultado[0]);
            System.out.println("x=" + resultado[1]);

        } catch (DivisionPorCeroException ex) {
            System.err.println(ex);
        } catch (DiscriminanteNegativoException ex) {
            System.err.println(ex);
        } catch (ArgumentosNumeroException ex) {
            System.err.println(ex);
        } catch (NumberFormatException ex) {
            System.err.println(ex);
        }

    }
}
