/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.bloque1.excepciones.ClasesQueArrojanExcepciones;

import accesoadatos.bloque1.excepciones.Exception.FueraDeRangoException;
import accesoadatos.bloque1.excepciones.Exception.RangoMalFormadoException;

/**
 *
 * @author juanda
 */
public class RangoPositivo {
    
    private double a;
    private double b;
    
    public RangoPositivo(double a, double b) throws FueraDeRangoException, RangoMalFormadoException{
        
        if(a <= 0){
            throw new FueraDeRangoException("El extremo izquierdo es menor o igual que cero");
        }
        
        if(a > b){
            
            throw new RangoMalFormadoException("El extremo izquierdo es mayor que el derecho");
        }
        
        this.a = a;
        this.b = b;
    }
}
