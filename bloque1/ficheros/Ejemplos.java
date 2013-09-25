/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos.bloque1.ficheros;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author innovacion
 */
public class Ejemplos {

    public static void crearPath() {
        Path p1 = Paths.get("/Users/innovacion/tmp");
        Path p2 = Paths.get("C:\\Users\\innovacion\\tmp");
        Path p3 = Paths.get(URI.create("file:///Users/innovacion/FileTest.java"));

    }

    public static void leerPropiedadesDeUnPath(String ruta) throws IOException {

        Path path = Paths.get(ruta);

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0, 2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        System.out.println("Iterando ...");
        for (Path name : path) {
            System.out.println(name);
        }

        System.out.println(Files.isDirectory(path));
        System.out.println(Files.getOwner(path));
    }

    public static void jugandoConFiles() {
        Path p1 = Paths.get("/Users/innovacion/kuku");
        Path p2 = Paths.get("/Users/innovacion/hola.txt");
        Path p3 = Paths.get("C:\\Windows\\System32\\aaclient.dll");

        System.out.println(Files.exists(p1) + "\t" + Files.notExists(p1));
        System.out.println(Files.exists(p2) + "\t" + Files.notExists(p2));
        System.out.println(Files.exists(p3) + "\t" + Files.notExists(p3));
    }

    public static void accesoAleatorio() {
        String s = "Hola caracola\n";
        byte data[] = s.getBytes();

        // Este ByteBuffer se rellena con los datos del array de bytes `data`
        ByteBuffer out = ByteBuffer.wrap(data);

        // Este otro buffer tiene una reserva de memoria de 29 bytes
        ByteBuffer copy = ByteBuffer.allocate(29);

        // Definimos las opciones para abrir el canal
        StandardOpenOption[] options = new StandardOpenOption[]{StandardOpenOption.READ, StandardOpenOption.WRITE};
        
        // Creamos el path correspondiente al fichero con el que vamos a jugar
        Path p = Paths.get("./poesia.txt");

        // Creamo el FileChannel vinculandolo al fichero poesia.txt para lectura
        // y escritura
        try (FileChannel fc = (FileChannel.open(p, options))) {
            // Leemos los primeros 29 bytes del fichero y los colocamos en copy
            // la condición de parada es 
            // 1) que se haya alcanzado el final del fichero nread != -1
            // 2) que el ByteBuffer se haya acabado
            int nread;
            do {
                nread = fc.read(copy);
            } while (nread != -1 && copy.hasRemaining());

            // Ahora colocamos el cursor del FileChannel en la posición 0
            // es decir, al principio, y lo sobreescribimos con el contenido
            // del ByteBuffer `out` (que tenía la cadena `Hola caracola`)
                       
            fc.position(0);
            while (out.hasRemaining()) {
                fc.write(out);
            }
            
            // Rebovinamos el ByteBuffer para utilizarlo después otra vez
            out.rewind();

            // Movemos el cursor hasta el final del fichero y copiamos los 29
            // bytes que antes leímos   
            long length = fc.size();
            fc.position(length - 1);
            copy.flip();
            while (copy.hasRemaining()) {
                fc.write(copy);
            }
            
            // Volvemos a escribir al final del fichero el contenido del 
            // ByteBuffer out, que contiene "Hola caracola"
            while (out.hasRemaining()) {
                fc.write(out);
            }
        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }
    }
}
