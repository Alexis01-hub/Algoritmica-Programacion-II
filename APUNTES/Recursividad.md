**patron de la recursividad:**
- condicion para tirar una exepcion
- caso base
- caso de recursion

en el caso final , despues del caso base. libera los recursos que se han utilizado en la recursion de l pila.

(comparar metodos recursivos y no recursivos, y ver los tiempos de ejecucion)

**Busqueda binaria:**

```java
public static boolean binarySearch(int[] data, int target, int low, int high) {
    if (low > high)
        return false;    // interval empty; no match
    else {
        int mid = (low + high) / 2;
        if (target == data[mid])
            return true;    // found a match
        else if (target < data[mid])
            return binarySearch(data, target, low, mid - 1);   // recur left of the middle
        else
            return binarySearch(data, target, mid + 1, high);   // recur right of the middle
    }
}
```

si solo hay una sola llamada al metodo recursivo. entonces es una recursividad lineal.
y si hay dos entonces es recursividad binaria. y si es tres o mas veces es recursividad multiple.

**Recursividad de cola:**

La recursión de cola se produce cuando un método linealmente
recursivo hace su llamada recursiva como su último paso.

**recursion multiple:**

