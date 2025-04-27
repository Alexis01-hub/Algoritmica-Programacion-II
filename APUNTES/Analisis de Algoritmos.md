# Apunte: Analisis de Algolitmos

## Estudios Experimentales
**Objetivo:** Medir la eficiencia de un algoritmo implementándolo y registrando tiempos de ejecución en diferentes entradas.

**Herramientas en Java:**

- System.currentTimeMillis(): Mide tiempo en milisegundos.

- System.nanoTime(): Mide tiempo en nanosegundos para operaciones muy rápidas.

**Limitaciones:**

- Dependencia del hardware y software.

- Conjunto limitado de datos de prueba.

- Requiere implementación completa del algoritmo.

**EJEMPLO:**

```java
public class EjemploRapido {
    public static void main(String[] args) {
        int n = 1000000;  // Tamaño del problema
        
        // Iniciar medición
        long inicio = System.nanoTime();
        
        // Algoritmo a medir (bucle simple)
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += i;
        }
        
        // Finalizar medición
        long fin = System.nanoTime();
        long tiempo = fin - inicio;
        
        System.out.println("Suma: " + suma);
        System.out.println("Tiempo: " + tiempo + " nanosegundos");
    }
}
```
**Enfoque Teorico**
- No necesitas programar nada.
- Cuentas operaciones básicas que hace el algoritmo.
- Resultados son generales (no dependen de una computadora específica).

**Conteo de Operaciones Primitivas:**

***Definimos un conjunto de operaciones primitivas como las siguientes:***

- Asignación de un valor a una variable
- “Seguir” una referencia de objeto
- Realizar una operación aritmética (por ejemplo, sumar dos números)
- Comparación de dos números
- Acceso a un elemento de un arreglo con índice
- Llamar a un método
- Retorno de un método

En lugar de intentar determinar el tiempo de ejecución específico de cada operación primitiva, simplemente contaremos cuántas operaciones primitivas se ejecutarán y usaremos este número t como una medida del tiempo de ejecución del algoritmo.

El número t de operaciones primitivas que realiza un algoritmo será proporcional al tiempo real de ejecución de ese algoritmo.

**Medición de operaciones como una función del tamaño de entrada:**
Para capturar el orden de crecimiento del tiempo de ejecución de un algoritmo, asociaremos, con cada algoritmo, una función f (n) que caracteriza el número de operaciones primitivas que se realizan en función del tamaño de entrada n.

## 7 FUNCIONES
- Veremos las siete funciones más importantes utilizadas en el análisis de algoritmos. 
- Usaremos solamente estas siete funciones simples para casi todos los análisis que hacemos en este curso.

### 1. Funcion constante 
- Se representa como O(1).
- El tiempo de ejecución no depende del tamaño de la entrada.
- Ejemplo: Acceso a un elemento de un arreglo por índice.

```java
int getPrimerElemento(int[] arr) {
    return arr[0];  // Siempre 1 operación, sin importar el tamaño de `arr`
}
```
***¿Cuándo ocurre?***
Operaciones simples: asignaciones, comparaciones, operaciones aritméticas.



### 2. Funcion logaritmica
- Se representa como O(log n).
- El tiempo de ejecución crece logarítmicamente con el tamaño de la entrada.
- Ejemplo: Búsqueda binaria en un arreglo ordenado.

```java
int busquedaBinaria(int[] arr, int objetivo) {
    int izquierda = 0;
    int derecha = arr.length - 1;
    
    while (izquierda <= derecha) {
        int medio = (izquierda + derecha) / 2;
        if (arr[medio] == objetivo) {
            return medio;  // Encontrado
        } else if (arr[medio] < objetivo) {
            izquierda = medio + 1;  // Buscar en la mitad derecha
        } else {
            derecha = medio - 1;  // Buscar en la mitad izquierda
        }
    }
    return -1;  // No encontrado
}
```
***¿Cuándo ocurre?***
Algoritmos que dividen el problema en partes iguales (ej: árboles binarios).

### 3. Funcion lineal
- Se representa como O(n).
- El tiempo de ejecución crece linealmente con el tamaño de la entrada.
- Ejemplo: Recorrer un arreglo y sumar sus elementos.

```java
int sumaElementos(int[] arr) {
    int suma = 0;
    for (int i = 0; i < arr.length; i++) {
        suma += arr[i];  // Suma cada elemento
    }
    return suma;  // O(n) operaciones
}
```
***¿Cuándo ocurre?***
Bucles simples que procesan cada elemento una vez.


### 4. Funcion linealitmica
- Se representa como O(n log n).
- El tiempo de ejecución crece linealmente multiplicado por logaritmo del tamaño de la entrada.
- Ejemplo: Algoritmos de ordenamiento eficientes como Merge Sort o Quick Sort.

```java
void merge(int[] arr, int izquierda, int medio, int derecha) {
    // Crear arreglos temporales
    int n1 = medio - izquierda + 1;
    int n2 = derecha - medio;
    int[] L = new int[n1];
    int[] R = new int[n2];
    
    // Copiar datos a los arreglos temporales
    for (int i = 0; i < n1; i++) {
        L[i] = arr[izquierda + i];
    }
    for (int j = 0; j < n2; j++) {
        R[j] = arr[medio + 1 + j];
    }
    
    // Mezclar los arreglos temporales
    int i = 0, j = 0, k = izquierda;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    
    // Copiar los elementos restantes de L[] si hay alguno
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    
    // Copiar los elementos restantes de R[] si hay alguno
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
```
***¿Cuándo ocurre?***
Algoritmos que dividen y combinan soluciones (ej: QuickSort, HeapSort).

### 5. Funcion cuadratica
- Se representa como O(n^2).
- El tiempo de ejecución crece cuadráticamente con el tamaño de la entrada.
- Ejemplo: Algoritmo de ordenamiento por burbuja (Bubble Sort).

```java
void burbuja(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Intercambiar arr[j] y arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```
***¿Cuándo ocurre?***
Bucles anidados donde cada uno depende de n.

### 6. Funcion cubica
- Se representa como O(n^3).
- El tiempo de ejecución crece cúbicamente con el tamaño de la entrada.
- Ejemplo: Algoritmo de multiplicación de matrices (naive).

```java
void multiplicarMatrices(int[][] A, int[][] B, int[][] C) {
    int n = A.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            C[i][j] = 0;
            for (int k = 0; k < n; k++) {
                C[i][j] += A[i][k] * B[k][j];  // O(n^3) operaciones
            }
        }
    }
}
```
***¿Cuándo ocurre?***
Tres bucles anidados (ej: algunos algoritmos de grafos).

### 7. Funcion exponencial
- Se representa como O(2^n) o O(n!).
- El tiempo de ejecución crece exponencialmente con el tamaño de la entrada.
- Ejemplo: fibonnaci recursivo sin oprimización.

```java
int fibonacci(int n) {
    if (n <= 1) {
        return n;  // Caso base
    }
    return fibonacci(n - 1) + fibonacci(n - 2);  // O(2^n) operaciones
}
```
***¿Cuándo ocurre?***
Problemas con recursión no optimizada (ej: fuerza bruta en problemas NP).

### Conclusión:
Usa O(n log n) o mejor siempre que puedas.
O(2ⁿ) es catastrófico para n > 30.

## Notación Asintótica (Big-O, Ω, Θ)
- **Big-O (O)**: Máximo tiempo de ejecución. Describe el peor caso.
- **Omega (Ω)**: Mínimo tiempo de ejecución. Describe el mejor caso.
- **Theta (Θ)**: Tiempo de ejecución promedio. Describe el caso promedio.








