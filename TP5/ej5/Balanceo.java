package ej5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 * Clase que verifica el balanceo de paréntesis, corchetes y llaves en un archivo.
 * La aplicación lee el nombre del archivo desde la línea de comando y analiza
 * línea por línea para detectar errores de balanceo.
 */
public class Balanceo {

    /**
     * Método principal que ejecuta la verificación de balanceo.
     * 
     * @param args Argumentos de la línea de comando. Se espera un único argumento
     *             que sea el nombre del archivo a analizar.
     */
    public static void main(String[] args) {
        // Verificar que se haya proporcionado un argumento
        if (args.length != 1) {
            System.out.println("Uso: java Balanceo <nombre_archivo>");
            return;
        }

        String fileName = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Stack<Character> stack = new Stack<>();
            String line;
            int lineNumber = 0;

            // Leer el archivo línea por línea
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    // Abrir paréntesis, corchetes o llaves
                    if (ch == '(' || ch == '[' || ch == '{') {
                        stack.push(ch);
                    }
                    // Cerrar paréntesis, corchetes o llaves
                    else if (ch == ')' || ch == ']' || ch == '}') {
                        if (stack.isEmpty()) {
                            System.out.println("Error de balanceo en la línea " + lineNumber + ": " + ch);
                            return;
                        }

                        char top = stack.pop();
                        if (!esParBalanceado(top, ch)) {
                            System.out.println("Error de balanceo en la línea " + lineNumber + ": " + ch);
                            return;
                        }
                    }
                }
            }

            // Verificar si quedan elementos en la pila
            if (!stack.isEmpty()) {
                System.out.println("Error de balanceo: faltan cerrar algunos símbolos.");
            } else {
                System.out.println("El archivo está correctamente balanceado.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Verifica si un par de caracteres es balanceado.
     * 
     * @param open  El carácter de apertura (por ejemplo, '(', '[', '{').
     * @param close El carácter de cierre (por ejemplo, ')', ']', '}').
     * @return {@code true} si el par es balanceado, {@code false} en caso contrario.
     */
    private static boolean esParBalanceado(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
