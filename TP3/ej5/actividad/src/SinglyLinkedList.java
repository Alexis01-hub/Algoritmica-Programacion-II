package src;

/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> implements Cloneable {
    // ---------------- nested Node class ----------------
    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */
    private static class Node<E> {

        /** The element stored at this node */
        private E element; // reference to the element stored at this node

        /** A reference to the subsequent node in the list */
        private Node<E> next; // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // Accessor methods
        /**
         * Returns the element stored at the node.
         * 
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         * 
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Modifier methods
        /**
         * Sets the node's next reference to point to Node n.
         * 
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } // ----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    /** The head node of the list */
    private Node<E> head = null; // head node of the list (or null if empty)

    /** The last node of the list */
    private Node<E> tail = null; // last node of the list (or null if empty)

    /** Number of nodes in the list */
    private int size = 0; // number of nodes in the list

    /** Constructs an initially empty list. */
    public SinglyLinkedList() {
    } // constructs an initially empty list

    // access methods
    /**
     * Returns the number of elements in the linked list.
     * 
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     * 
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list
     * 
     * @return element at the front of the list (or null if empty)
     */
    public E first() { // returns (but does not remove) the first element
        if (isEmpty())
            return null;
        return head.getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * 
     * @return element at the end of the list (or null if empty)
     */
    public E last() { // returns (but does not remove) the last element
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // update methods
    /**
     * Adds an element to the front of the list.
     * 
     * @param e the new element to add
     */
    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0)
            tail = head; // special case: new node becomes tail also
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * 
     * @param e the new element to add
     */
    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty())
            head = newest; // special case: previously empty list
        else
            tail.setNext(newest); // new node after existing tail
        tail = newest; // new node becomes the tail
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     * 
     * @return the removed element (or null if empty)
     */
    public E removeFirst() { // removes and returns the first element
        if (isEmpty())
            return null; // nothing to remove
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null; // special case as list is now empty
        return answer;
    }

    // ---- Agregar logica a metodos ----

    /* Insertar el elemento e en la posicion n de la lista */
    public void addPos(E e, int n) throws IndexOutOfBoundsException {
        // Verifica si la posicion es valida dentro del rango de la lista
        if (n < 0 || n > size)
            throw new IndexOutOfBoundsException("Posicion no valida: " + n);

        // Si la posicion es 0, se agrega al inicio
        if (n == 0) {
            addFirst(e);
        } else if (n == size) { // Si la posicion es igual al tamaño, se agrega al final
            addLast(e);
        } else { // Si la posicion es valida, se agrega en el medio
            Node<E> current = head; // Se inicia desde el primer nodo
            for (int i = 0; i < n - 1; i++) { // Se recorre hasta la posicion anterior
                current = current.getNext();
            }
            Node<E> newest = new Node<>(e, current.getNext()); // Se crea el nuevo nodo
            current.setNext(newest); // Inserta el nuevo nodo en la posicion
            size++; // Incrementa el tamaño de la lista
        }
    }

    /**
     * Elemina el primer nodo que contiene el elemento especificado 'e' y lo
     * devuelve
     * Si el elemento no se encuentra, retorna 'null'
     * 
     * @param e Elemento a eliminar de la lista
     * @return Elemento eliminado si se encuentra, o 'null' si no esta lista
     */
    public E removeElement(E e) {
        if (isEmpty())
            return null; // Si la lista esta vacia, retorna null

        // Caso especial: el elemento esta en el primer nodo
        if (head.getElement().equals(e)) {
            return removeFirst(); // Llama al metodo removeFirst, para eliminar el primer nodo
        }

        Node<E> current = head; // Nodo actual para recorrer la lista
        Node<E> previous = null; // Nodo anterior al actual

        // Recorre la lista buscando el nodo que contiene el elemento 'e'
        while (current != null) {
            if (current.getElement().equals(e)) { // Si encuentra el elemento
                // Si el elemento se encuentra en el nodo actual, lo elimina
                if (previous == null) {
                    head = head.getNext();
                } else {
                    // Salta el nodo actual ajustando la referencia del nodo anterior
                    previous.setNext(current.getNext());
                }
                if (current == tail) {
                    // Si el nodo eleminado es el tail(cola/ultimo), actualiza el tail al nodo
                    // anterior
                    tail = previous;
                }
                size--; // Decrementa el tamaño de la lista
                return current.getElement(); // Retorna el elemento eliminado
            }
            // Si no lo encuentra, avanza al siguiente nodo
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    /**
     * Elemina elemento que se encuentra en la posicion 'n' de la lista
     * Si la posicion no es valida, lanza una excepcion
     * 
     * @param n Posicion del elemento a eliminar
     * @return Elemento eliminado de la lista si la posicion es valida, o lanza una
     *         excepcion si no lo es
     * @throws IndexOutOfBoundsException Si la posicion esta fuera de rango de la
     *                                   lista
     */
    public E removePos(int n) throws IndexOutOfBoundsException {
        // Verifica si la posicion es valida dentro del rango de la lista
        if (n < 0 || n >= size)
            throw new IndexOutOfBoundsException("Posicion no valida: " + n);

        if (n == 0)
            return removeFirst(); // Caso especial: eliminar el primer nodo

        Node<E> current = head; // Nodo actual para recorrer la lista
        for (int i = 0; i < n - 1; i++) { // Recorre hasta el nodo anterior al que se va a eliminar
            // Guarda el nodo actual en la variable 'current'
            current = current.getNext();

        }

        Node<E> nodeToRemove = current.getNext(); // Nodo a eliminar
        E removedElement = nodeToRemove.getElement(); // Elemento a eliminar

        // Ajusta las referencias para eliminar el nodo
        current.setNext(nodeToRemove.getNext()); // Salta el nodo a eliminar

        // Si el nodo a eliminar es el tail, actualiza el tail
        if (nodeToRemove == tail) {
            tail = current; // Actualiza el tail al nodo anterior
        }
        size--; // Decrementa el tamaño de la lista
        return removedElement; // Retorna el elemento eliminado
    }

    /**
     * Inserta todos los elementos de la Lista l al final de la lista
     * 
     * @param l Lista cuyos elementos se concatenaran al final de la lista actual
     */
    public void concatenate(SinglyLinkedList<E> l) {
        if (l.isEmpty())
            return; // Si la lista es nula o vacia, no hace nada

        if (this.isEmpty()) {
            // Si lista actual es vacia, simplemente copia los nodos de 'l'
            this.head = l.head;
            this.tail = l.tail;
            this.size = l.size;
        } else {
            // Si la lista actual no es vacia, enlaza el tail de la lista actual con el head
            // de 'l'
            this.tail.setNext(l.head);
            this.tail = l.tail; // Actualiza el tail de la lista actual
            this.size += l.size; // Aumenta el tamaño de la lista actual
        }
    }

    /**
     * Busca el elemento 'e' dentro de la lista
     * Retorna el elemento si se encuentra, o NULL si no esta en la lista
     * 
     * @param e Elemento a buscar en la lista
     * @return El elemento si se encuentra, o NULL si no esta en la lista
     */
    public E search(E e) {
        if (isEmpty())
            return null; // Si la lista esta vacia, retorna null
        // Caso especial: el elemento esta en el primer nodo
        if (head.getElement().equals(e)) {
            // Si el elemento es igual al primer nodo, retorna el elemento
            return head.getElement();
        }
        Node<E> current = head; // Nodo actual para recorrer la lista
        while (current != null) { // Recorre la lista hasta el final
            if (current.getElement().equals(e)) { // Si encuentra el elemento
                return current.getElement(); // Retorna el elemento encontrado
            }
            current = current.getNext(); // Avanza al siguiente nodo
        }
        return null; // Si no encuentra el elemento, retorna null
    }

    @SuppressWarnings({ "unchecked" })
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        SinglyLinkedList other = (SinglyLinkedList) o; // use nonparameterized type
        if (size != other.size)
            return false;
        Node walkA = head; // traverse the primary list
        Node walkB = other.head; // traverse the secondary list
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement()))
                return false; // mismatch
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true; // if we reach this, everything matched successfully
    }

    @SuppressWarnings({ "unchecked" })
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // always use inherited Object.clone() to create the initial copy
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
        if (size > 0) { // we need independent chain of nodes
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext(); // walk through remainder of original list
            Node<E> otherTail = other.head; // remember most recently created node
            while (walk != null) { // make a new node storing same element
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest); // link previous node to this one
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }

    public int hashCode() {
        int h = 0;
        for (Node walk = head; walk != null; walk = walk.getNext()) {
            h ^= walk.getElement().hashCode(); // bitwise exclusive-or with element's code
            h = (h << 5) | (h >>> 27); // 5-bit cyclic shift of composite code
        }
        return h;
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }
}