package ej9;

/**
 * Interfaz que define los métodos para una deque.
 * 
 * @param <T> El tipo de elementos que se almacenarán en la deque.
 */
public interface Deque<T> {

    /**
     * Agrega un elemento al frente de la deque.
     * 
     * @param element El elemento a agregar.
     */
    void addFirst(T element);

    /**
     * Agrega un elemento al final de la deque.
     * 
     * @param element El elemento a agregar.
     */
    void addLast(T element);

    /**
     * Elimina y devuelve el elemento al frente de la deque.
     * 
     * @return El elemento al frente de la deque.
     */
    T removeFirst();

    /**
     * Elimina y devuelve el elemento al final de la deque.
     * 
     * @return El elemento al final de la deque.
     */
    T removeLast();

    /**
     * Devuelve el elemento al frente de la deque sin eliminarlo.
     * 
     * @return El elemento al frente de la deque.
     */
    T getFirst();

    /**
     * Devuelve el elemento al final de la deque sin eliminarlo.
     * 
     * @return El elemento al final de la deque.
     */
    T getLast();

    /**
     * Verifica si la deque está vacía.
     * 
     * @return {@code true} si la deque está vacía, {@code false} en caso contrario.
     */
    boolean isEmpty();

    /**
     * Verifica si la deque está llena.
     * 
     * @return {@code true} si la deque está llena, {@code false} en caso contrario.
     */
    boolean isFull();

    /**
     * Devuelve el número de elementos en la deque.
     * 
     * @return El tamaño de la deque.
     */
    int size();
}
