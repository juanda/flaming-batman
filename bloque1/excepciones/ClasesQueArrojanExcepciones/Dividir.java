/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.bloque1.excepciones.ClasesQueArrojanExcepciones;

import accesoadatos.bloque1.excepciones.Exception.DivisionPorCeroException;

/**
 *
 * @author juanda
 */
public class Dividir {
    
    private double numerador;
    private double denominador;
    
    public Dividir(double a,double b) throws DivisionPorCeroException{
        
        if( b==0 ){
            throw new DivisionPorCeroException("División por cero");
        }
        
        numerador   = a;
        denominador = b;
       
    }
    
    public double getResultado(){
        
        return numerador / denominador;
    }
}
