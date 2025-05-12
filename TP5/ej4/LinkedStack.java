package ej4;

/**
 * Clase que implementa una pila (stack) enlazada genérica.
 * 
 * @param <T> El tipo de elementos que se almacenarán en la pila.
 */
class LinkedStack<T> implements Cloneable {

    /**
     * Clase interna estática que representa un nodo de la pila.
     * 
     * @param <T> El tipo de elemento almacenado en el nodo.
     */
    private static class Node<T> {
        private T element; // Elemento almacenado en el nodo.
        private Node<T> next; // Referencia al siguiente nodo.

        /**
         * Constructor para crear un nodo.
         * 
         * @param element El elemento que se almacenará en el nodo.
         * @param next    El siguiente nodo en la pila.
         */
        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<T> top; // Nodo superior de la pila.
    private int size;    // Tamaño de la pila.

    /**
     * Constructor que inicializa una pila vacía.
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }

    /**
     * Agrega un elemento a la pila.
     * 
     * @param element El elemento que se agregará a la pila.
     */
    public void push(T element) {
        top = new Node<>(element, top);
        size++;
    }

    /**
     * Verifica si la pila está vacía.
     * 
     * @return {@code true} si la pila está vacía, {@code false} en caso contrario.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Elimina y devuelve el elemento superior de la pila.
     * 
     * @return El elemento superior de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = top.element;
        top = top.next;
        size--;
        return element;
    }

    /**
     * Crea una copia profunda de la pila.
     * 
     * @return Una nueva instancia de {@code LinkedStack} que contiene los mismos
     *         elementos que la pila original, en el mismo orden.
     */
    @Override
    public LinkedStack<T> clone() {
        LinkedStack<T> clonedStack = new LinkedStack<>(); // Creamos una nueva pila clonada
        if (top == null) {
            return clonedStack; // Si la pila está vacía, devolvemos una nueva pila vacía
        }

        // Usamos una pila auxiliar para invertir el orden de los nodos
        LinkedStack<T> tempStack = new LinkedStack<>();
        Node<T> current = top;

        // Empujamos los elementos de la pila original a la pila auxiliar
        while (current != null) {
            tempStack.push(current.element);
            current = current.next;
        }

        // Transferimos los elementos de la pila auxiliar a la pila clonada
        current = tempStack.top;
        while (current != null) {
            clonedStack.push(current.element);
            current = current.next;
        }

        return clonedStack;
    }
}