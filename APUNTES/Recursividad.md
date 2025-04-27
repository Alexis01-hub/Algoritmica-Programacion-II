# Apunte: Recursividad
## Concepto Básico
**Recursividad:** Un método que se llama a sí mismo.

- Ejemplo clásico: Factorial de un número.

Definición recursiva:
```java
public static int factorial(int n) {
    if (n == 0) return 1;          // Caso base
    else return n * factorial(n-1); // Caso recursivo
}
```

**Partes de un Método Recursivo**
1. Caso Base: Condición que detiene la recursión (sin llamadas recursivas).

2. Llamada Recursiva: Invocación al mismo método, progresando hacia el caso base.

En el caso final, despues del caso base. libera los recursos que se han utilizado en la recursion de la pila.

### Tipos de Recursividad

- Lineal: Una sola llamada recursiva por caso (ejemplo: suma de elementos de un arreglo).
```java
public static int linearSum(int[] A, int n) {
    if (n == 0) return 0;
    else return linearSum(A, n-1) + A[n-1];
}
```
- Binaria: dos llamados a recurción (Ejemplo: Búsqueda binaria).
```java
public static int binarySearch(int[] arr, int target, int left, int right) {
    if (left > right) return -1; // Caso base: no encontrado
    int mid = (left + right) / 2;
    if (arr[mid] == target) return mid; // Caso base: encontrado
    else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, right); // Llamada recursiva derecha
    else return binarySearch(arr, target, left, mid - 1); // Llamada recursiva izquierda
}
```
- Multiple: más de dos llamadas recursivas.

### Recursividad de cola:
- Definición: La llamada recursiva es la última operación del método.

- Ejemplo: Factorial de cola.
```java
public static int factorialCola(int n, int acumulador) {
    if (n == 0) return acumulador; // Caso base
    else return factorialCola(n - 1, n * acumulador); // Llamada recursiva en cola
}
```

### Videos recomendados:

- [Recursividad | FÁCIL de entender y visualizar | Recursión](https://www.youtube.com/watch?v=YwRjEOFxvO0)

- [Recursividad pero Optimizada!!! Recursión de Cola](https://www.youtube.com/watch?v=SIgfSYyWVjo)