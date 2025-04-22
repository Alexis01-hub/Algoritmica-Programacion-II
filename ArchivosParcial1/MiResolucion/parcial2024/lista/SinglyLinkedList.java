package ArchivosParcial1.MiResolucion.parcial2024.lista;

/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> implements Cloneable {
  //---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element;            // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next;         // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- end of nested Node class -----------

  // instance variables of the SinglyLinkedList
  /** The head node of the list */
  private Node<E> head = null;               // head node of the list (or null if empty)

  /** The last node of the list */
  private Node<E> tail = null;               // last node of the list (or null if empty)

  /** Number of nodes in the list */
  private int size = 0;                      // number of nodes in the list

  /** Constructs an initially empty list. */
  public SinglyLinkedList() { }              // constructs an initially empty list

  // access methods
  /**
   * Returns the number of elements in the linked list.
   * @return number of elements in the linked list
   */
  public int size() { return size; }

  /**
   * Tests whether the linked list is empty.
   * @return true if the linked list is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the list
   * @return element at the front of the list (or null if empty)
   */
  public E first() {             // returns (but does not remove) the first element
    if (isEmpty()) return null;
    return head.getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * @return element at the end of the list (or null if empty)
   */
  public E last() {              // returns (but does not remove) the last element
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Adds an element to the front of the list.
   * @param e  the new element to add
   */
  public void addFirst(E e) {                // adds element e to the front of the list
    head = new Node<>(e, head);              // create and link a new node
    if (size == 0)
      tail = head;                           // special case: new node becomes tail also
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * @param e  the new element to add
   */
  public void addLast(E e) {                 // adds element e to the end of the list
    Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
    if (isEmpty())
      head = newest;                         // special case: previously empty list
    else
      tail.setNext(newest);                  // new node after existing tail
    tail = newest;                           // new node becomes the tail
    size++;
  }

  /**
   * Removes and returns the first element of the list.
   * @return the removed element (or null if empty)
   */
  public E removeFirst() {                   // removes and returns the first element
    if (isEmpty()) return null;              // nothing to remove
    E answer = head.getElement();
    head = head.getNext();                   // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null;                           // special case as list is now empty
    return answer;
  }

  @SuppressWarnings({"unchecked"})
  public boolean equals(Object o) {
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;
    SinglyLinkedList other = (SinglyLinkedList) o;   // use nonparameterized type
    if (size != other.size) return false;
    Node walkA = head;                               // traverse the primary list
    Node walkB = other.head;                         // traverse the secondary list
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;   // if we reach this, everything matched successfully
  }

  @SuppressWarnings({"unchecked"})
  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    // always use inherited Object.clone() to create the initial copy
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
    if (size > 0) {                    // we need independent chain of nodes
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext();      // walk through remainder of original list
      Node<E> otherTail = other.head;     // remember most recently created node
      while (walk != null) {              // make a new node storing same element
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest);     // link previous node to this one
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }

  public int hashCode() {
    int h = 0;
    for (Node walk=head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
      h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
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

  /**
   * Retorna la lista con todos los elementos de la lista pasada combinados después del
   * primer elemento de la lista.
   *
   * Por ejemplo:
   * 
   * {A, B, C, D} {W, X, Y, Z} => {A, W, B, X, C, Y, D, Z}
   * 
   * {A, B, C, D} {W, X} => {A, W, B, X, C, D}
   * 
   * {A, B} {W, X, Y, Z} => {A, W, B, X, Y, Z}
   * 
   * {A, B, C, D} {} => {A, B, C, D}
   * 
   * {} {W, X, Y, Z} => {W, X, Y, Z}
   * 
   * {} {} => {}
   * 
   * @param SinglyLinkedList<E> l : lista con los elementos a combinar
   * 
   * @return lista original con todos los elementos de la lista l combinados
   *         después del primer elemento de la lista original
   * 
   */
  public void addCombineAfter(SinglyLinkedList<E> l) {
    if (l.isEmpty()) return; // Si la lista l está vacía, no se hace nada
    if (isEmpty()) { // Si la lista original está vacía, se asigna la lista l
      head = l.head;
      tail = l.tail;
      size = l.size;
      l.head = l.tail = null; // Se vacía la lista l
      l.size = 0;
      return;
    }

    Node<E> walk = head; // Nodo actual de la lista original
    Node<E> next = walk.getNext(); // Nodo siguiente de la lista original
    Node<E> lCurrent = l.head; // Nodo actual de la lista l

    while (lCurrent != null) {
      walk.setNext(lCurrent); // Conecta el nodo actual de la lista original con el de la lista l
      walk = lCurrent; // Avanza al nodo actual de la lista l
      lCurrent = lCurrent.getNext(); // Avanza al siguiente nodo de la lista l

      if (next != null) { // Si hay un siguiente nodo en la lista original
        walk.setNext(next); // Conecta el nodo actual de la lista l con el siguiente de la lista original
        walk = next; // Avanza al siguiente nodo de la lista original
        next = next.getNext(); // Avanza al siguiente nodo de la lista original
      }
    }

    if (next == null) { // Si no quedan más nodos en la lista original
      tail = walk; // El último nodo de la lista combinada es el nuevo tail
    }

    size += l.size; // Actualiza el tamaño de la lista original
    l.head = l.tail = null; // Vacía la lista l
    l.size = 0;
  }

  public void addCombineBefore(SinglyLinkedList<E> l) {
    if (l.isEmpty()) return; // Si la lista l está vacía, no se hace nada
    if (isEmpty()) { // Si la lista original está vacía, se asigna la lista l
        head = l.head;
        tail = l.tail;
        size = l.size;
        l.head = l.tail = null; // Se vacía la lista l
        l.size = 0;
        return;
    }

    Node<E> lCurrent = l.head; // Nodo actual de la lista l
    Node<E> originalCurrent = head; // Primer nodo de la lista original
    Node<E> newHead = null; // Nueva cabeza de la lista combinada
    Node<E> newTail = null; // Nuevo tail de la lista combinada

    while (lCurrent != null || originalCurrent != null) {
        if (lCurrent != null) { // Agregar nodo de la lista l
            if (newHead == null) {
                newHead = lCurrent; // Establecer nueva cabeza
                newTail = lCurrent; // Establecer nuevo tail
            } else {
                newTail.setNext(lCurrent); // Conectar al nuevo tail
                newTail = lCurrent; // Avanzar el tail
            }
            lCurrent = lCurrent.getNext(); // Avanzar en la lista l
        }

        if (originalCurrent != null) { // Agregar nodo de la lista original
            if (newHead == null) {
                newHead = originalCurrent; // Establecer nueva cabeza
                newTail = originalCurrent; // Establecer nuevo tail
            } else {
                newTail.setNext(originalCurrent); // Conectar al nuevo tail
                newTail = originalCurrent; // Avanzar el tail
            }
            originalCurrent = originalCurrent.getNext(); // Avanzar en la lista original
        }
    }

    head = newHead; // Actualizar la cabeza de la lista original
    tail = newTail; // Actualizar el tail de la lista original
    size += l.size; // Actualizar el tamaño de la lista original
    l.head = l.tail = null; // Vaciar la lista l
    l.size = 0;
  }
}
