package ej8;

/**
 * Clase que implementa una cola circular utilizando un arreglo.
 * 
 * @param <T> El tipo de elementos que se almacenarán en la cola.
 */
public class ArrayCircularQueue<T> implements CircularQueue<T> {
    private T[] queue; // Arreglo que almacena los elementos de la cola.
    private int front; // Índice del primer elemento de la cola.
    private int rear;  // Índice del último elemento de la cola.
    private int size;  // Número de elementos en la cola.
    private int capacity; // Capacidad máxima de la cola.

    /**
     * Constructor que inicializa la cola con una capacidad específica.
     * 
     * @param capacity La capacidad máxima de la cola.
     */
    @SuppressWarnings("unchecked")
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    /**
     * Agrega un elemento al final de la cola.
     * 
     * @param element El elemento a agregar.
     * @throws IllegalStateException Si la cola está llena.
     */
    @Override
    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalStateException("La cola está llena.");
        }
        rear = (rear + 1) % capacity; // Mueve el índice al siguiente espacio circularmente.
        queue[rear] = element; // Agrega el elemento al final de la cola.
        size++;
    }

    /**
     * Elimina y devuelve el elemento al frente de la cola.
     * 
     * @return El elemento al frente de la cola.
     * @throws IllegalStateException Si la cola está vacía.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        T element = queue[front]; // Obtiene el elemento al frente de la cola.
        queue[front] = null; // Limpia la referencia para evitar fugas de memoria.
        front = (front + 1) % capacity; // Mueve el índice al siguiente espacio circularmente.
        size--;
        return element;
    }

    /**
     * Devuelve el elemento al frente de la cola sin eliminarlo.
     * 
     * @return El elemento al frente de la cola.
     * @throws IllegalStateException Si la cola está vacía.
     */
    @Override
    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return queue[front]; // Devuelve el elemento al frente sin eliminarlo.
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * @return {@code true} si la cola está vacía, {@code false} en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Verifica si la cola está llena.
     * 
     * @return {@code true} si la cola está llena, {@code false} en caso contrario.
     */
    @Override
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Devuelve el número de elementos en la cola.
     * 
     * @return El tamaño de la cola.
     */
    @Override
    public int size() {
        return size;
    }
}
