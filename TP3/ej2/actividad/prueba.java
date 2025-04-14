package TP3.ej2.actividad;

/*
 * 2. Cargar un arreglo con elementos y probar los siguientes métodos de la clase java.util.Arrays 

    • equals(A, B)	
    • fill(A,x)	
    • copyOf(A, n)
    • copyOfRange(A, s, t)
    • toString(A) 
    • sort(A)
    • binarySearch(A, x)
 */
import java.util.Arrays;
public class prueba {
    public static void main(String[] args) {
        // Crear un arreglo de enteros
        int[] A = {5, 2, 8, 1, 3};
        int[] B = {5, 2, 8, 1, 3};
        
        // Probar equals(A, B)
        // Comparar los arreglos A y B
        System.out.println("equals(A, B): " + Arrays.equals(A, B)); // true
        
        // Probar fill(A,x)
        // Llenar el arreglo A con el valor 0
        Arrays.fill(A, 0);
        System.out.println("fill(A,x): " + Arrays.toString(A)); // [0, 0, 0, 0, 0]
        
        // Probar copyOf(A, n) 
        // Copiar el arreglo B en un nuevo arreglo C con la misma longitud
        int[] C = Arrays.copyOf(B, B.length);
        System.out.println("copyOf(A,n): " + Arrays.toString(C)); // [5, 2, 8, 1, 3]
        
        // Probar copyOfRange(A,s,t)
        // Copiar un rango del arreglo B en un nuevo arreglo D
        int[] D = Arrays.copyOfRange(B, 1, 4);
        System.out.println("copyOfRange(A,s,t): " + Arrays.toString(D)); // [2, 8, 1]
        
        // Probar toString(A)
        // Convertir el arreglo B a una cadena de texto
        System.out.println("toString(A): " + Arrays.toString(B)); // [5, 2, 8, 1, 3]
        
        // Probar sort(A)
        // Ordenar el arreglo B
        Arrays.sort(B);
        System.out.println("sort(A): " + Arrays.toString(B)); // [1, 2, 3, 5]
        
        // Probar binarySearch(A,x)
        // Buscar el índice del elemento '3' en el arreglo B
        int index = Arrays.binarySearch(B, 3);
        System.out.println("binarySearch(A,x): " + index); // index of element '3' in sorted array
    }
}