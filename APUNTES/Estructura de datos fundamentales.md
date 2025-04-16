# Apunte: Estructura de datos fundamentales

## 1. Arreglos
### Definición
Los arreglos son estructuras de datos que almacenan secuencias de elementos del mismo tipo. Son ideales para aplicaciones donde se necesita guardar una colección ordenada de datos.
- sintaxis basica:
```java
// Crear un arreglo vacío:
elementType[] arrayName = new elementType[length];  

// Inicializar con valores:
elementType[] arrayName = {valor0, valor1, ..., valorN};  
```
- Ejemplo:
```java
int[] scores = {750, 1105, 720, 660}; // Almacena puntajes.
String[] players = {"Rob", "Mike", "Anna"}; // Almacena nombres.
```
- Ordenamiento

Este es uno de tantos metodos de ordenamientos de un arreglo.
```java
public class OrdenamientoBurbuja {
    public static void main(String[] args) {
        int[] arreglo = {5, 2, 9, 1, 5, 6};

        // Ordenamiento burbuja
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambiar
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        // Mostrar arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
    }
}
```
### Métodos de `java.util` para **Arreglos** y números **Random**

### 📗 Métodos para Arreglos (`Arrays`)
- `equals(A, B)`
- `fill(A, x)`
- `copyOf(A, n)`
- `copyOfRange(A, s, t)`
- `toString(A)`
- `sort(A)`
- `binarySearch(A, x)`

### 🔵 Métodos para números Random (`Random`)
- `nextBoolean()`
- `nextDouble()`: entre 0.0 y 1.0
- `nextInt()`
- `nextInt(n)`: entre 0 y n
- `setSeed(s)`: long `s`

### Ejemplo de su uso:
```java
import java.util.Arrays;
import java.util.Random;

public class EjemploJavaUtil {
    public static void main(String[] args) {
        // Creamos un arreglo de tamaño 5 y lo llenamos con el número 3
        int[] arreglo = new int[5];
        Arrays.fill(arreglo, 3);
        System.out.println("Arreglo con fill: " + Arrays.toString(arreglo));

        // Reemplazamos el arreglo con números aleatorios entre 0 y 9
        Random rand = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = rand.nextInt(10); // números entre 0 y 9
        }
        System.out.println("Arreglo con números aleatorios: " + Arrays.toString(arreglo));

        // Copiamos el arreglo
        int[] copia = Arrays.copyOf(arreglo, arreglo.length);
        System.out.println("Copia del arreglo: " + Arrays.toString(copia));

        // Comparamos los dos arreglos
        System.out.println("¿Son iguales? " + Arrays.equals(arreglo, copia));

        // Ordenamos el arreglo
        Arrays.sort(arreglo);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));

        // Búsqueda binaria de un número (por ejemplo, 5)
        int posicion = Arrays.binarySearch(arreglo, 5);
        if (posicion >= 0) {
            System.out.println("El número 5 se encuentra en la posición: " + posicion);
        } else {
            System.out.println("El número 5 no se encuentra en el arreglo.");
        }

        // Ejemplos adicionales con Random
        System.out.println("Random boolean: " + rand.nextBoolean());
        System.out.println("Random double: " + rand.nextDouble()); // entre 0.0 y 1.0
    }
}
```
## 2. Listas 
