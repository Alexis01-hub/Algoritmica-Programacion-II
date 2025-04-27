package factorial;

import java.util.Scanner;

public class PruebaFactorial {
    
    public static void main(String[] args) {
        int numero = 0;
        Scanner sc = new Scanner(System.in);

        try {
            //verifica si paso un argumento desde el programa
            if (args.length > 0) {
                numero = Integer.parseInt(args[0]);
            } else {
                System.out.println("Ingrese un número entero positivo: ");
                numero = sc.nextInt();
            }
            //verifica si el numero es positivo
            if (numero < 0) {
                System.out.println("El número debe ser positivo.");
            } else {
                long inicioI = System.nanoTime(); // Tiempo de inicio
                //llama a la funcion factorial iterativa
                System.out.println("El factorial iterativo de " + numero + " es: " + FactorialIterativa.factorialI(numero));
                long finI = System.nanoTime(); // Tiempo de fin
                long tiempoI = finI - inicioI; // Tiempo total
                System.out.println("Tiempo de ejecución iterativo: " + tiempoI + " nanosegundos.");


                long inicioR = System.nanoTime(); // Tiempo de inicio
                //llama a la funcion factorial recursiva
                System.out.println("El factorial recursivo de " + numero + " es: " + FactorialRecursiva.factorialR(numero));
                long finR = System.nanoTime(); // Tiempo de fin
                long tiempoR = finR - inicioR; // Tiempo total
                System.out.println("Tiempo de ejecución recursivo: " + tiempoR + " nanosegundos.");
                // Traza del algoritmo recursivo
                if (numero <= 5) { // Mostramos traza solo para valores pequeños
                    System.out.println("\nTraza recursiva para n = " + numero);
                    System.out.println("----------------------------------");
                    mostrarTrazaRecursiva(numero);
                }
            }            
        } catch (NumberFormatException e) {
            System.out.println(" Error: El argumento debe ser un número entero.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: "+ e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: "+ e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Método auxiliar para mostrar la traza recursiva
    private static void mostrarTrazaRecursiva(int n) {
        System.out.println("Calculando factorial(" + n + ")");
        
        if (n == 0 || n == 1) {
            System.out.println("Caso base alcanzado: factorial(" + n + ") = 1");
            return;
        }
        
        System.out.println("Llamada recursiva a factorial(" + (n - 1) + ")");
        mostrarTrazaRecursiva(n - 1);
        
        int resultado = n * FactorialRecursiva.factorialR(n - 1);
        System.out.println("Retornando factorial(" + n + ") = " + n + " * factorial(" + (n - 1) + ") = " + resultado);
    }
}
