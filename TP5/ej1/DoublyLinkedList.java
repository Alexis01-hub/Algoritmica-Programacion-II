/**
 * Clase que implementa una lista doblemente enlazada.
 *
 * @param <E> El tipo de elementos almacenados en la lista.
 */
public class DoublyLinkedList<E> {

  //---------------- Clase interna Node ----------------
  /**
   * Nodo de una lista doblemente enlazada, que almacena una referencia
   * a su elemento y a los nodos anterior y siguiente en la lista.
   */
  private static class Node<E> {

    /** El elemento almacenado en este nodo */
    private E element;

    /** Referencia al nodo anterior en la lista */
    private Node<E> prev;

    /** Referencia al nodo siguiente en la lista */
    private Node<E> next;

    /**
     * Crea un nodo con el elemento dado y referencias a los nodos anterior y siguiente.
     *
     * @param e El elemento a almacenar.
     * @param p Referencia al nodo que precede al nuevo nodo.
     * @param n Referencia al nodo que sigue al nuevo nodo.
     */
    public Node(E e, Node<E> p, Node<E> n) {
      element = e;
      prev = p;
      next = n;
    }

    // Métodos de acceso públicos
    /**
     * Devuelve el elemento almacenado en el nodo.
     * @return El elemento almacenado en el nodo.
     */
    public E getElement() { return element; }

    /**
     * Devuelve el nodo que precede a este (o null si no hay ninguno).
     * @return El nodo anterior.
     */
    public Node<E> getPrev() { return prev; }

    /**
     * Devuelve el nodo que sigue a este (o null si no hay ninguno).
     * @return El nodo siguiente.
     */
    public Node<E> getNext() { return next; }

    // Métodos de actualización
    /**
     * Establece la referencia al nodo anterior.
     * @param p El nodo que debe preceder a este.
     */
    public void setPrev(Node<E> p) { prev = p; }

    /**
     * Establece la referencia al nodo siguiente.
     * @param n El nodo que debe seguir a este.
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- Fin de la clase interna Node -----------

  // Variables de instancia de DoublyLinkedList
  /** Nodo centinela al inicio de la lista */
  private Node<E> header;

  /** Nodo centinela al final de la lista */
  private Node<E> trailer;

  /** Número de elementos en la lista (sin incluir los nodos centinela) */
  private int size = 0;

  /** Construye una nueva lista vacía. */
  public DoublyLinkedList() {
    header = new Node<>(null, null, null);      // Crear el nodo header
    trailer = new Node<>(null, header, null);   // El nodo trailer es precedido por header
    header.setNext(trailer);                    // Header es seguido por trailer
  }

  // Métodos de acceso públicos
  /**
   * Devuelve el número de elementos en la lista enlazada.
   * @return El número de elementos en la lista.
   */
  public int size() { return size; }

  /**
   * Verifica si la lista enlazada está vacía.
   * @return {@code true} si la lista está vacía, de lo contrario {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Devuelve (pero no elimina) el primer elemento de la lista.
   * @return El elemento al frente de la lista (o null si está vacía).
   */
  public E first() {
    if (isEmpty()) return null;
    return header.getNext().getElement();   // El primer elemento está después de header
  }

  /**
   * Devuelve (pero no elimina) el último elemento de la lista.
   * @return El elemento al final de la lista (o null si está vacía).
   */
  public E last() {
    if (isEmpty()) return null;
    return trailer.getPrev().getElement();    // El último elemento está antes de trailer
  }

  // Métodos de actualización públicos
  /**
   * Agrega un elemento al frente de la lista.
   * @param e El nuevo elemento a agregar.
   */
  public void addFirst(E e) {
    addBetween(e, header, header.getNext());    // Colocar justo después de header
  }

  /**
   * Agrega un elemento al final de la lista.
   * @param e El nuevo elemento a agregar.
   */
  public void addLast(E e) {
    addBetween(e, trailer.getPrev(), trailer);  // Colocar justo antes de trailer
  }

  /**
   * Elimina y devuelve el primer elemento de la lista.
   * @return El elemento eliminado (o null si está vacía).
   */
  public E removeFirst() {
    if (isEmpty()) return null;                  // Nada que eliminar
    return remove(header.getNext());             // El primer elemento está después de header
  }

  /**
   * Elimina y devuelve el último elemento de la lista.
   * @return El elemento eliminado (o null si está vacía).
   */
  public E removeLast() {
    if (isEmpty()) return null;                  // Nada que eliminar
    return remove(trailer.getPrev());            // El último elemento está antes de trailer
  }

  // Métodos de actualización privados
  /**
   * Agrega un elemento a la lista enlazada entre los nodos dados.
   * Los nodos predecesor y sucesor deben ser vecinos antes de la llamada.
   *
   * @param e El elemento a agregar.
   * @param predecessor Nodo justo antes de la ubicación donde se inserta el nuevo elemento.
   * @param successor Nodo justo después de la ubicación donde se inserta el nuevo elemento.
   */
  private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
    // Crear y enlazar un nuevo nodo
    Node<E> newest = new Node<>(e, predecessor, successor);
    predecessor.setNext(newest);
    successor.setPrev(newest);
    size++;
  }

  /**
   * Elimina el nodo dado de la lista y devuelve su elemento.
   * @param node El nodo a eliminar (no debe ser un nodo centinela).
   * @return El elemento almacenado en el nodo eliminado.
   */
  private E remove(Node<E> node) {
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    size--;
    return node.getElement();
  }

  /**
   * Produce una representación en forma de cadena del contenido de la lista.
   * Esto existe solo con fines de depuración.
   * @return Una representación en cadena de la lista.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = header.getNext();
    while (walk != trailer) {
      sb.append(walk.getElement());
      walk = walk.getNext();
      if (walk != trailer)
        sb.append(", ");
    }
    sb.append(")");
    return sb.toString();
  }
} //----------- Fin de la clase DoublyLinkedList -----------
