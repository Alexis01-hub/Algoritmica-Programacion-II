package ej10;

/**
 * Clase que implementa una lista doblemente enlazada.
 * 
 * @param <T> El tipo de elementos que se almacenarán en la lista.
 */
public class DoublyLinkedList<T> {
    /**
     * Clase interna que representa un nodo de la lista doblemente enlazada.
     * 
     * @param <T> El tipo de elemento almacenado en el nodo.
     */
    private static class Node<T> {
        T element; // Elemento almacenado en el nodo.
        Node<T> next; // Referencia al siguiente nodo.
        Node<T> prev; // Referencia al nodo anterior.

        /**
         * Constructor que inicializa un nodo con un elemento y referencias a los nodos
         * adyacentes.
         * 
         * @param element El elemento a almacenar en el nodo.
         * @param next    Referencia al siguiente nodo.
         * @param prev    Referencia al nodo anterior.
         */
        Node(T element, Node<T> next, Node<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head; // Nodo inicial de la lista.
    private Node<T> tail; // Nodo final de la lista.
    private int size;     // Número de elementos en la lista.

    /**
     * Constructor que inicializa una lista vacía.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Agrega un elemento al inicio de la lista.
     * 
     * @param element El elemento a agregar.
     */
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element, head, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param element El elemento a agregar.
     */
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element, null, tail);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Elimina y devuelve el primer elemento de la lista.
     * 
     * @return El primer elemento de la lista.
     * @throws IllegalStateException Si la lista está vacía.
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        T element = head.element;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return element;
    }

    /**
     * Elimina y devuelve el último elemento de la lista.
     * 
     * @return El último elemento de la lista.
     * @throws IllegalStateException Si la lista está vacía.
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        T element = tail.element;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return element;
    }

    /**
     * Devuelve el primer elemento de la lista sin eliminarlo.
     * 
     * @return El primer elemento de la lista.
     * @throws IllegalStateException Si la lista está vacía.
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        return head.element;
    }

    /**
     * Devuelve el último elemento de la lista sin eliminarlo.
     * 
     * @return El último elemento de la lista.
     * @throws IllegalStateException Si la lista está vacía.
     */
    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        }
        return tail.element;
    }

    /**
     * Verifica si la lista está vacía.
     * 
     * @return {@code true} si la lista está vacía, {@code false} en caso contrario.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve el número de elementos en la lista.
     * 
     * @return El tamaño de la lista.
     */
    public int size() {
        return size;
    }
}
