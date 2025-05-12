package ej10;

/**
 * Clase que implementa una deque (cola doble) utilizando una lista doblemente enlazada.
 * 
 * @param <T> El tipo de elementos que se almacenarán en la deque.
 */
public class DoublyLinkedDeque<T> implements Deque<T> {
    private DoublyLinkedList<T> list; // Lista doblemente enlazada para almacenar los elementos.
    private int capacity;            // Capacidad máxima del deque.

    /**
     * Constructor que inicializa una deque vacía con una capacidad específica.
     * 
     * @param capacity La capacidad máxima del deque.
     */
    public DoublyLinkedDeque(int capacity) {
        list = new DoublyLinkedList<>();
        this.capacity = capacity;
    }

    /**
     * Agrega un elemento al frente de la deque.
     * 
     * @param element El elemento a agregar.
     * @throws IllegalStateException Si el deque está lleno.
     */
    @Override
    public void addFirst(T element) {
        if (isFull()) {
            throw new IllegalStateException("El deque está lleno.");
        }
        list.addFirst(element); // Agrega el elemento al inicio de la lista.
    }

    /**
     * Agrega un elemento al final de la deque.
     * 
     * @param element El elemento a agregar.
     * @throws IllegalStateException Si el deque está lleno.
     */
    @Override
    public void addLast(T element) {
        if (isFull()) {
            throw new IllegalStateException("El deque está lleno.");
        }
        list.addLast(element); // Agrega el elemento al final de la lista.
    }

    /**
     * Elimina y devuelve el elemento al frente de la deque.
     * 
     * @return El elemento al frente de la deque.
     * @throws IllegalStateException Si el deque está vacío.
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío.");
        }
        return list.removeFirst(); // Elimina y devuelve el primer elemento de la lista.
    }

    /**
     * Elimina y devuelve el elemento al final de la deque.
     * 
     * @return El elemento al final de la deque.
     * @throws IllegalStateException Si el deque está vacío.
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío.");
        }
        return list.removeLast(); // Elimina y devuelve el último elemento de la lista.
    }

    /**
     * Devuelve el elemento al frente de la deque sin eliminarlo.
     * 
     * @return El elemento al frente de la deque.
     * @throws IllegalStateException Si el deque está vacío.
     */
    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío.");
        }
        return list.getFirst(); // Devuelve el primer elemento de la lista sin eliminarlo.
    }

    /**
     * Devuelve el elemento al final de la deque sin eliminarlo.
     * 
     * @return El elemento al final de la deque.
     * @throws IllegalStateException Si el deque está vacío.
     */
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío.");
        }
        return list.getLast(); // Devuelve el último elemento de la lista sin eliminarlo.
    }

    /**
     * Verifica si el deque está vacío.
     * 
     * @return {@code true} si el deque está vacío, {@code false} en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty(); // Verifica si la lista está vacía.
    }

    /**
     * Verifica si el deque está lleno.
     * 
     * @return {@code true} si el deque está lleno, {@code false} en caso contrario.
     */
    @Override
    public boolean isFull() {
        return list.size() >= capacity; // Verifica si el tamaño actual alcanza la capacidad máxima.
    }

    /**
     * Devuelve el número de elementos en el deque.
     * 
     * @return El tamaño del deque.
     */
    @Override
    public int size() {
        return list.size(); // Devuelve el número de elementos en la lista.
    }
}
