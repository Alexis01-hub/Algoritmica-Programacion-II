import java.util.EmptyStackException;

/**
 * Implementación de una pila (stack) utilizando una lista enlazada.
 *
 * @param <T> El tipo de elementos almacenados en la pila.
 */
public class LinkedStack<T> implements Stack<T> {

    /**
     * Clase interna que representa un nodo en la lista enlazada.
     */
    private class Node {
        T data; // El dato almacenado en el nodo.
        Node next; // Referencia al siguiente nodo.

        /**
         * Constructor que inicializa el nodo con un dato.
         *
         * @param data El dato a almacenar en el nodo.
         */
        Node(T data) {
            this.data = data;
        }
    }

    private Node top; // Referencia al nodo superior de la pila.
    private int size; // Tamaño actual de la pila.

    /**
     * Inserta un elemento en la parte superior de la pila.
     *
     * @param element El elemento a insertar.
     */
    @Override
    public void push(T element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return El elemento eliminado de la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return El elemento en la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    @Override
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return {@code true} si la pila está vacía, de lo contrario {@code false}.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve el número de elementos en la pila.
     *
     * @return El tamaño de la pila.
     */
    @Override
    public int size() {
        return size;
    }
}
