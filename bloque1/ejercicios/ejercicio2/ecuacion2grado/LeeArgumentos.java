/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.ejercicio2.ecuacion2grado;

/**
 *
 * @author juanda
 */
public class LeeArgumentos {
    
    private double[] args;
    
    public LeeArgumentos(String[] args) throws ArgumentosNumeroException {

        if (args.length != 3) {
            throw new ArgumentosNumeroException();
        }
        
        this.args = new double[3];
                              
        this.args[0] = Double.parseDouble(args[0]);
        this.args[1] = Double.parseDouble(args[1]);
        this.args[2] = Double.parseDouble(args[2]);         
    }
    
    public double dameA(){
        return this.args[0];
    }
    
    public double dameB(){
        return this.args[1];
    }
    
    public double dameC(){
        return this.args[2];
    }
}
