package ej8;

/**
 * Interfaz que define los métodos para una cola circular.
 * 
 * @param <T> El tipo de elementos que se almacenarán en la cola.
 */
public interface CircularQueue<T> {
    void enqueue(T element); // Agrega un elemento a la cola.
    T dequeue();             // Elimina y devuelve el elemento al frente de la cola.
    T front();               // Devuelve el elemento al frente sin eliminarlo.
    boolean isEmpty();       // Verifica si la cola está vacía.
    boolean isFull();        // Verifica si la cola está llena.
    int size();              // Devuelve el número de elementos en la cola.
}
