# Apunte: Pilas y Colas
## Tipos Abstractos de Datos (TAD/ADT)
**Definición:** Abstracción de una estructura de datos que especifica:

- Datos almacenados.

- Operaciones sobre esos datos.

- Condiciones de error asociadas.

Ejemplo: Sistema de gestión de stock con operaciones como buy, sell, y cancel.

## TAD Pila (Stack)
**Definición:** Colección de elementos donde el último elemento agregado es el primero en salir (LIFO: Last In First Out).

*Operaciones principales:*
- **push(x):** Agrega el elemento x a la pila.
- **pop():** Elimina y devuelve el elemento en la parte superior de la pila.
- **top():** Retorna el ultimo elemento agregado sin eliminarlo.
- **isEmpty():** Verifica si la pila está vacía.
- **size():** Devuelve el número de elementos en la pila.

**Interfaz en java:**
```java
public interface Stack<E> {
    int size();
    boolean isEmpty();
    E top();
    void push(E element);
    E pop();
}
```
### Ejemplo de uso:
```
| Method     | Return Value | Stack Contents  |
|------------|--------------|-----------------|
| push(5)    | –            | (5)             |
| push(3)    | –            | (5, 3)          |
| size()     | 2            | (5, 3)          |
| pop()      | 3            | (5)             |
| isEmpty()  | false        | (5)             |
| pop()      | 5            | ( )             |
| isEmpty()  | true         | ( )             |
| pop()      | null         | ( )             |
| push(7)    | –            | (7)             |
| push(9)    | –            | (7, 9)          |
| top()      | 9            | (7, 9)          |
| push(4)    | –            | (7, 9, 4)       |
| size()     | 3            | (7, 9, 4)       |
| pop()      | 4            | (7, 9)          |
| push(6)    | –            | (7, 9, 6)       |
| push(8)    | –            | (7, 9, 6, 8)    |
| pop()      | 8            | (7, 9, 6)       |
```

## TAD Cola (Queue)
**Definición:** Colección de elementos donde el primer elemento agregado es el primero en salir (FIFO: First In First Out).
*Operaciones principales:*
- **enqueue(x):** Agrega el elemento x al final de la cola.
- **dequeue():** Elimina y devuelve el primer elemento de la cola.
- **fisrt():** Retorna el primer elemento agregado sin eliminarlo.
- **isEmpty():** Verifica si la cola está vacía.
- **size():** Devuelve el número de elementos en la cola.

### Ejemplo de uso:
```
| Operation    | Output | Queue Contents      |
|--------------|--------|---------------------|
| enqueue(5)   | –      | (5)                 |
| enqueue(3)   | –      | (5, 3)              |
| dequeue()    | 5      | (3)                 |
| enqueue(7)   | –      | (3, 7)              |
| dequeue()    | 3      | (7)                 |
| first()      | 7      | (7)                 |
| dequeue()    | 7      | ()                  |
| dequeue()    | null   | ()                  |
| isEmpty()    | true   | ()                  |
| enqueue(9)   | –      | (9)                 |
| enqueue(7)   | –      | (9, 7)              |
| size()       | 2      | (9, 7)              |
| enqueue(3)   | –      | (9, 7, 3)           |
| enqueue(5)   | –      | (9, 7, 3, 5)        |
| dequeue()    | 9      | (7, 3, 5)           |
```
**Interfaz de java:**
```java
public interface Queue<E> {
    int size();
    boolean isEmpty();
    E first();
    void enqueue(E element);
    E dequeue();
}
```

### Colas Circulares (Circular Queue)
**Definición:** Cola implementada con arreglo circular para reutilizar espacios.

**Características:**

- Índices front y rear "dan la vuelta" usando aritmética modular (%).

- Evita desplazamientos costosos al llenarse.

**Ejemplo:**

```java
public class CircularQueue<E> {
    private E[] data;
    private int front = 0, size = 0;

    public void enqueue(E e) {
        int rear = (front + size) % data.length;
        data[rear] = e;
        size++;
    }

    public E dequeue() {
        E answer = data[front];
        front = (front + 1) % data.length;
        size--;
        return answer;
    }
}
```

