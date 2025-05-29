package ej2.prueba;

import java.io.*;
import java.util.Scanner;
import ej2.hash.*;

/**
 * Programa que cuenta la frecuencia de aparición de palabras reservadas de Java
 * en un archivo fuente dado. Utiliza una implementación de Map para almacenar
 * y contar las ocurrencias de cada palabra reservada.
 *
 * Uso:
 *   java prueba <ArchivoTest.java>
 *
 * Notas:
 * - El programa lee el archivo completo, incluyendo comentarios y cadenas,
 *   por lo que puede contar palabras reservadas que aparezcan fuera del código ejecutable.
 * - El delimitador utilizado separa cualquier secuencia de letras, por lo que puede
 *   contar palabras reservadas dentro de identificadores o cadenas.
 * - Para un análisis más preciso, se recomienda usar expresiones regulares o un parser léxico.
 *
 * @author Juanpi Torrico
 */
public class prueba {
    // Lista de palabras reservadas de Java a analizar
    private static final String[] PALABRAS_RESERVADAS = {
        "abstract", "assert", "boolean", "break", "byte",
        "case", "catch", "char", "class", "const", "else", "if"
    };

    /**
     * Método principal. Lee el archivo fuente y cuenta las ocurrencias de cada palabra reservada.
     * @param args Argumentos de línea de comandos. Debe recibir el nombre del archivo a analizar.
     * @throws FileNotFoundException si el archivo no existe.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Verifica que se haya pasado el nombre del archivo como argumento
        if (args.length < 1) {
            System.out.println("Uso: java prueba <ArchivoTest.java>");
            return;
        }

        // Crea el mapa para almacenar la frecuencia de cada palabra reservada
        Map<String, Integer> freq = new UnsortedTableMap<>();

        // Inicializa la frecuencia de cada palabra reservada a 0
        for (String palabra : PALABRAS_RESERVADAS) {
            freq.put(palabra, 0);
        }

        // Abre el archivo y configura el Scanner para separar por cualquier cosa que no sea letra
        Scanner doc = new Scanner(new File(args[0])).useDelimiter("[^a-zA-Z]+");

        // Lee palabra por palabra y cuenta si es una palabra reservada
        while (doc.hasNext()) {
            String word = doc.next().toLowerCase();
            if (freq.get(word) != null) {
                freq.put(word, freq.get(word) + 1);
            }
        }
        doc.close();

        // Muestra la frecuencia de cada palabra reservada encontrada
        System.out.println("Frecuencia de palabras reservadas:");
        for (Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
