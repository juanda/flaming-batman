/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.bloque1.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author juanda
 */
public class Ejemplos {

    public static void copiarBytesFichero(String fin, String fout) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            // Estos dos métodos constructores pueden arrojar una FileNotFoundException
            in = new FileInputStream(fin);
            out = new FileOutputStream(fout);
            int c;

            // read() es un método de los objetos `FileInputStream` y puede arrojar
            // una IOException

            // Este método lee y devuelve un byte y pasa la "cabeza lectora" al
            // próximo byte, de forma que la próxima vez que se utilice lee y 
            // devuelve el proximo byte. Cuando ya no hay más bytes que leer, es
            // decir, cuando se alcanza el final del fichero, devuelve un `-1`.
            while ((c = in.read()) != -1) {

                // write() es un método de `FileOutputStream` y puede arrojar una
                // IOException.

                // Este método escribe al final del fichero el byte especificado
                // en su argumento.
                out.write(c);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {

            // Los FileInputStream y  FileOutputStream disponen de un método close()
            // para cerrar los ficheros abiertos. Es importante cerrar los recursos,
            // en este caso lo sficheros, una vez que lo hemos utilizado.
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void verBytesFichero(String fin) throws IOException {
        FileInputStream in = null;

        try {
            in = new FileInputStream(fin);
            int c;

            while ((c = in.read()) != -1) {

                char ch = (char) c;
                System.out.println(c
                        + "\t"
                        + Integer.toHexString(c)
                        + "\t"
                        + ch);
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void copiarCaracteresFichero(String fin, String fout) throws IOException {

        FileReader in = null;
        FileWriter out = null;

        try {
            // Estos dos métodos constructores pueden arrojar una FileNotFoundException
            in = new FileReader(fin);
            out = new FileWriter(fout);
            int c;

            // read() es un método de los objetos `FileReader` y puede arrojar
            // una IOException

            // Este método lee y devuelve un byte y pasa la "cabeza lectora" al
            // próximo byte, de forma que la próxima vez que se utilice lee y 
            // devuelve el proximo byte. Cuando ya no hay más bytes que leer, es
            // decir, cuando se alcanza el final del fichero, devuelve un `-1`.
            while ((c = in.read()) != -1) {

                // write() es un método de `FileWriter` y puede arrojar una
                // IOException.

                // Este método escribe al final del fichero el byte especificado
                // en su argumento.
                out.write(c);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {

            // Los FileInputStream y  FileOutputStream disponen de un método close()
            // para cerrar los ficheros abiertos. Es importante cerrar los recursos,
            // en este caso lo sficheros, una vez que lo hemos utilizado.
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void verCaracteresFichero(String fin) throws IOException {
        FileReader in = null;

        try {
            in = new FileReader(fin);

            //System.out.println(in.getEncoding());
            int c;

            while ((c = in.read()) != -1) {

                char ch = (char) c;
                System.out.println(c
                        + "\t"
                        + Integer.toHexString(c)
                        + "\t"
                        + ch);
            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void copiaFicheroPorLineas(String fin, String fout) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            // Encadenamiento de streams. En el caso del inputStream se ha
            // creado en primer lugar un objeto FileReader a partir del
            // fichero de entrada cuyo nombre se especifica en la cadena `fin`,
            // a continuación ese stream se utiliza como entrada para el 
            // ``BufferedReader``, obteniendo de esta manera un nuevo stream con
            // nuevas propiedades. Este último stream implementa el método
            // `readLine()` que nos facilita la lectura línea a línea de un 
            // fichero de texto.
            //
            // En el caso del outputStream se procede de la misma manera. El
            // ouputStreamm que es del tipo ``PrintWriter``, implemente el 
            // método `println()` con el que podemos escribir líneas terminadas
            // con el carácter que marca el fin de línea.

            inputStream = new BufferedReader(new FileReader(fin));
            outputStream = new PrintWriter(new FileWriter(fout));

            String l;

            // `readLine()` lee y devuelve una cadena con la siguiente línea del 
            // fichero de texto. Cuando no hay más líneas que leer devuelve un
            // `null`.
            while ((l = inputStream.readLine()) != null) {
                // `println()` escribe en el stream la cadena que se le pasa
                // en su argumento seguida de un carácter fin de línea
                outputStream.println(l);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void verFicheroPorLinea(String fin) throws IOException {

        BufferedReader inputStream = null;

        try {

            inputStream = new BufferedReader(new FileReader(fin));

            String l;

            while ((l = inputStream.readLine()) != null) {
                System.out.println(l);
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void scanFile(String fin) {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader(fin)));
            
            // También podemos utilizar un stream sin buffer, pero es menos
            // eficiente:
            // s = new Scanner(new FileReader(fin));
            
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
    
//    public static void escribeFicha(String fin, int index, float ){
//        
//        DataOutputStream d = null;
//        
//        try {
//            d = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fin)));
//            
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Ejemplos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
}
