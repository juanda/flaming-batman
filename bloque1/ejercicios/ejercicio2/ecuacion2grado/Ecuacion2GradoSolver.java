/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.ejercicio2.ecuacion2grado;

/**
 *
 * @author juanda
 */
public class Ecuacion2GradoSolver {
    
    private double a,b,c;
    
    private double denominador;
    
    private double discriminante;
    
    public Ecuacion2GradoSolver(double a, double b, double c) throws DivisionPorCeroException, DiscriminanteNegativoException{
        
        this.a = a;
        this.b = b;
        this.c = c;
        
        this.denominador = 2*a;
        
        this.discriminante = b*b - 4*a*c;
        
        if(this.denominador == 0){
            throw new DivisionPorCeroException();
        }
        
        if(this.discriminante < 0){
            throw new DiscriminanteNegativoException();
        }                
    }
    
    public double[] dameResultado(){
        
        double result[] = new double[2];
        
        result[0] = (-this.b + Math.sqrt(this.discriminante))/2*a;
        result[1] = (-this.b - Math.sqrt(this.discriminante))/2*a;
        
        return result;                        
    }
    
}
