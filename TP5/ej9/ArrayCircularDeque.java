package ej9;

/**
 * Clase que implementa una deque (cola doble) circular utilizando un arreglo.
 * 
 * @param <T> El tipo de elementos que se almacenarán en la deque.
 */
public class ArrayCircularDeque<T> implements Deque<T> {
    private T[] deque; // Arreglo que almacena los elementos del deque.
    private int front; // Índice del primer elemento del deque.
    private int rear;  // Índice del último elemento del deque.
    private int size;  // Número de elementos en el deque.
    private int capacity; // Capacidad máxima del deque.

    /**
     * Constructor que inicializa el deque con una capacidad específica.
     * 
     * @param capacity La capacidad máxima del deque.
     */
    @SuppressWarnings("unchecked")
    public ArrayCircularDeque(int capacity) {
        this.capacity = capacity;
        this.deque = (T[]) new Object[capacity];
        this.front = 0; 
        this.rear = -1; // Inicializa el índice del último elemento en -1.
        this.size = 0;
    }

    /**
     * Agrega un elemento al frente del deque.
     * 
     * @param element El elemento a agregar.
     * @throws IllegalStateException Si el deque está lleno.
     */
    @Override
    public void addFirst(T element) {
        if (isFull()) {
            throw new IllegalStateException("El deque está lleno.");
        }
        front = (front - 1 + capacity) % capacity; // Mueve el índice al espacio anterior circularmente.
        deque[front] = element; // Agrega el elemento al frente del deque.
        size++;
    }

    /**
     * Agrega un elemento al final del deque.
     * 
     * @param element El elemento a agregar.
     * @throws IllegalStateException Si el deque está lleno.
     */
    @Override
    public void addLast(T element) {
        if (isFull()) {
            throw new IllegalStateException("El deque está lleno.");
        }
        rear = (rear + 1) % capacity; // Mueve el índice al siguiente espacio circularmente.
        deque[rear] = element; // Agrega el elemento al final del deque.
        size++;
    }

    /**
     * Elimina y devuelve el elemento al frente del deque.
     * 
     * @return El elemento al frente del deque.
     * @throws IllegalStateException Si el deque está vacío.
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío.");
        }
        T element = deque[front]; // Guarda el elemento que se va a eliminar.
        front = (front + 1) % capacity; // Mueve el índice al siguiente espacio circularmente.
        size--;
        return element; // Devuelve el elemento eliminado.
    }

    /**
     * Elimina y devuelve el elemento al final del deque.
     * 
     * @return El elemento al final del deque.
     * @throws IllegalStateException Si el deque está vacío.
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío.");
        }
        T element = deque[rear]; // Guarda el elemento que se va a eliminar.
        rear = (rear - 1 + capacity) % capacity; // Mueve el índice al espacio anterior circularmente.
        size--;
        return element; // Devuelve el elemento eliminado.
    }

    /**
     * Devuelve el elemento al frente del deque sin eliminarlo.
     * 
     * @return El elemento al frente del deque.
     * @throws IllegalStateException Si el deque está vacío.
     */
    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío.");
        }
        return deque[front]; // Devuelve el primer elemento del deque.
    }

    /**
     * Devuelve el elemento al final del deque sin eliminarlo.
     * 
     * @return El elemento al final del deque.
     * @throws IllegalStateException Si el deque está vacío.
     */
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío.");
        }
        return deque[rear]; // Devuelve el último elemento del deque.
    }

    /**
     * Verifica si el deque está vacío.
     * 
     * @return {@code true} si el deque está vacío, {@code false} en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return size == 0; // Devuelve verdadero si el deque está vacío.
    }

    /**
     * Devuelve el número de elementos en el deque.
     * 
     * @return El tamaño del deque.
     */
    @Override
    public int size() {
        return size; // Devuelve el número de elementos en el deque.
    }

    /**
     * Verifica si el deque está lleno.
     * 
     * @return {@code true} si el deque está lleno, {@code false} en caso contrario.
     */
    @Override
    public boolean isFull() {
        return size == capacity; // Devuelve verdadero si el deque está lleno.
    }
}
