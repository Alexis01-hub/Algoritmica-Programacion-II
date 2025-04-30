import java.util.Scanner;
import java.io.File;
/**
 * Soporta el cálculo del uso total de espacio en disco dentro de un sistema de archivos.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class DiskSpace {

  /**
   * Calcula el uso total de espacio en disco (en bytes) de la parte del sistema de archivos
   * enraizada en la ruta dada, mientras imprime un resumen similar a la herramienta 'du' de Unix.
   * @param root designa una ubicación en el sistema de archivos
   * @return número total de bytes utilizados por la parte designada del sistema de archivos
   */
  public static long diskUsage(File root) {
    long total = root.length();                          // comienza con el uso directo del disco
    if (root.isDirectory()) {                            // y si esto es un directorio,
      for (String childname : root.list()) {             // entonces para cada hijo
        File child = new File(root, childname);          // compone la ruta completa al hijo
        total += diskUsage(child);                       // agrega el uso del hijo al total
      }
    }
    System.out.println(total + "\t" + root);             // salida descriptiva
    return total;                                        // devuelve el total general
  }

  /**
   * Calcula el uso de disco de la ruta dada como un argumento de línea de comandos.
   * Ejemplo de uso:  java DiskSpace C:\Users\Michael
   */
  public static void main(String[] args) {
    String start;
    if (args.length > 0) {
      start = args[0];
    } else {
      System.out.print("Introduce la ubicación inicial: ");
      start = new Scanner(System.in).next();
    }
    diskUsage(new File(start));
  }

}
