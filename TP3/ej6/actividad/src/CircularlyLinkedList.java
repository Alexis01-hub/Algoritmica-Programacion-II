package actividad.src;
/**
 * Una implementación de una lista enlazada circular.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CircularlyLinkedList<E> {
  //---------------- clase anidada Node ----------------
  /**
   * Nodo de una lista enlazada simple, que almacena una referencia a su
   * elemento y al nodo siguiente en la lista.
   */
  private static class Node<E> {

    /** El elemento almacenado en este nodo */
    private E element;     // un elemento almacenado en este nodo

    /** Una referencia al nodo siguiente en la lista */
    private Node<E> next;  // una referencia al nodo siguiente en la lista

    /**
     * Crea un nodo con el elemento dado y el nodo siguiente.
     *
     * @param e  el elemento que se almacenará
     * @param n  referencia a un nodo que debe seguir al nuevo nodo
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Métodos de acceso
    /**
     * Devuelve el elemento almacenado en el nodo.
     * @return el elemento almacenado en el nodo
     */
    public E getElement() { return element; }

    /**
     * Devuelve el nodo que sigue a este (o null si no hay tal nodo).
     * @return el nodo siguiente
     */
    public Node<E> getNext() { return next; }

    // Métodos modificadores
    /**
     * Establece la referencia siguiente del nodo para que apunte al nodo n.
     * @param n    el nodo que debe seguir a este
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- fin de la clase anidada Node -----------

  // Variables de instancia de CircularlyLinkedList
  /** El cursor designado de la lista */
  private Node<E> tail = null;                  // almacenamos tail (pero no head)

  /** Número de nodos en la lista */
  private int size = 0;                         // número de nodos en la lista

  /** Construye una lista inicialmente vacía. */
  public CircularlyLinkedList() { }             // construye una lista inicialmente vacía

  // Métodos de acceso
  /**
   * Devuelve el número de elementos en la lista enlazada.
   * @return número de elementos en la lista enlazada
   */
  public int size() { return size; }

  /**
   * Verifica si la lista enlazada está vacía.
   * @return true si la lista enlazada está vacía, false en caso contrario
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Devuelve (pero no elimina) el primer elemento de la lista.
   * @return el elemento al frente de la lista (o null si está vacía)
   */
  public E first() {             // devuelve (pero no elimina) el primer elemento
    if (isEmpty()) return null;
    return tail.getNext().getElement();         // el head está *después* del tail
  }

  /**
   * Devuelve (pero no elimina) el último elemento de la lista.
   * @return el elemento al final de la lista (o null si está vacía)
   */
  public E last() {              // devuelve (pero no elimina) el último elemento
    if (isEmpty()) return null;
    return tail.getElement();
  }

  // Métodos de actualización
  /**
   * Rota el primer elemento al final de la lista.
   */
  public void rotate() {         // rota el primer elemento al final de la lista
    if (tail != null)                // si está vacía, no hace nada
      tail = tail.getNext();         // el antiguo head se convierte en el nuevo tail
  }

  /**
   * Agrega un elemento al frente de la lista.
   * @param e  el nuevo elemento a agregar
   */
  public void addFirst(E e) {                // agrega el elemento e al frente de la lista
    if (size == 0) {
      tail = new Node<>(e, null);
      tail.setNext(tail);                     // se enlaza a sí mismo circularmente
    } else {
      Node<E> newest = new Node<>(e, tail.getNext());
      tail.setNext(newest);
    }
    size++;
  }

  /**
   * Agrega un elemento al final de la lista.
   * @param e  el nuevo elemento a agregar
   */
  public void addLast(E e) {                 // agrega el elemento e al final de la lista
    addFirst(e);             // inserta el nuevo elemento al frente de la lista
    tail = tail.getNext();   // ahora el nuevo elemento se convierte en el tail
  }

  /**
   * Elimina y devuelve el primer elemento de la lista.
   * @return el elemento eliminado (o null si está vacía)
   */
  public E removeFirst() {                   // elimina y devuelve el primer elemento
    if (isEmpty()) return null;              // nada que eliminar
    Node<E> head = tail.getNext();
    if (head == tail) tail = null;           // debe ser el único nodo restante
    else tail.setNext(head.getNext());       // elimina "head" de la lista
    size--;
    return head.getElement();
  }
  //----------- métodos agregados ------------------

  /* Inserta el elemento e en la posición n de la lista */
  public void addPos(E e, int n) throws IndexOutOfBoundsException {
      // Verifica si la posición es válida dentro del rango de la lista
      if (n < 0 || n > size)
          throw new IndexOutOfBoundsException("Posición no válida: " + n);
       if (n == 0){
          addFirst(e); // Si la posición es 0, agrega al inicio
       }else if (n == size){
          addLast(e); // Si la posición es igual al tamaño, agrega al final
       }else{
          Node<E> current = tail.getNext(); // Comienza desde el primer nodo
          for (int i = 0; i < n - 1; i++) { // Recorre hasta la posición deseada
              current = current.getNext();
          }
          Node<E> newNode = new Node<>(e, current.getNext()); // Crea el nuevo nodo
          current.setNext(newNode); // Enlaza el nuevo nodo en la posición deseada
          size++;
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

      Node<E> current = tail.getNext(); // Comienza desde el primer nodo
      Node<E> previous = tail; // Nodo anterior al actual
      do {
          if (current.getElement().equals(e)) { // Si el elemento coincide
              if (current == tail) { // Si es el último nodo
                  if (current.getNext() == tail) { // Si es el único nodo restante
                      tail = null; // La lista queda vacía
                  } else {
                      previous.setNext(current.getNext()); // Enlaza el anterior con el siguiente
                      tail = previous; // Actualiza el tail
                  }
              } else {
                  previous.setNext(current.getNext()); // Enlaza el anterior con el siguiente
              }
              size--; // Disminuye el tamaño de la lista
              return current.getElement(); // Retorna el elemento eliminado
          }
          previous = current; // Avanza al siguiente nodo
          current = current.getNext();
      } while (current != tail.getNext()); // Recorre toda la lista
      return null; // Si no se encuentra el elemento, retorna null
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

      Node<E> current = tail.getNext();
      Node<E> previous = tail;
      for (int i = 0; i < n; i++) {
          previous = current;
          current = current.getNext();
      }
      previous.setNext(current.getNext()); // Enlaza el nodo anterior con el siguiente
      if (current == tail) { 
          tail = previous; // Actualiza el tail si se elimina el último nodo
      }
      size--;
      return current.getElement(); // Retorna el elemento eliminado
  }
  
    /**
     * Inserta todos los elementos de la Lista l al final de la lista
     * 
     * @param l Lista cuyos elementos se concatenaran al final de la lista actual
     */
    public void concatenate(CircularlyLinkedList<E> l) {
        if (l.isEmpty())
          return; // Si la lista es nula o vacia, no hace nada
        if (isEmpty()){
          tail = l.tail; // Si la lista actual es vacia, asigna el tail de l
          tail.setNext(tail); // Enlaza el tail con si mismo
          size = l.size; // Actualiza el tamaño de la lista actual
        }else {
          Node<E> current = tail.getNext(); // Comienza desde el primer nodo
          tail.setNext(l.tail.getNext()); // Enlaza el tail de la lista actual con el primer nodo de l
          l.tail.setNext(current); // Enlaza el tail de l con el primer nodo de la lista actual
          tail = l.tail; // Actualiza el tail de la lista actual
        }
        size += l.size; // Aumenta el tamaño de la lista actual
        l.tail = null; // Limpia la lista l para evitar referencias cruzadas
        l.size = 0; // Reinicia el tamaño de la lista l
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
        
      Node<E> current = tail.getNext();
      do {
          if (current.getElement().equals(e)) {
              return current.getElement();
          }
          current = current.getNext();
      } while (current != tail.getNext());

      return null; // Si no encuentra el elemento, retorna null
  }
  //------------
  /**
   * Produce una representación en formato de cadena del contenido de la lista.
   * Esto existe solo para propósitos de depuración.
   */
  public String toString() {
    if (tail == null) return "()";
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = tail;
    do {
      walk = walk.getNext();
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
    } while (walk != tail);
    sb.append(")");
    return sb.toString();
  }
  //------------------ métodos adicionales ------------------
  @SuppressWarnings({ "unchecked" })
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        CircularlyLinkedList other = (CircularlyLinkedList) o; // use nonparameterized type
        if (size != other.size)
            return false;
        Node<E> walkA = tail; // traverse the primary list
        Node<E> walkB = other.tail; // traverse the secondary list
        while (walkA != tail) {
            if (!walkA.getElement().equals(walkB.getElement()))
                return false; // mismatch
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true; // if we reach this, everything matched successfully
    }

    @SuppressWarnings({ "unchecked" })
    public CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
        // always use inherited Object.clone() to create the initial copy
        CircularlyLinkedList other = (CircularlyLinkedList) super.clone(); // safe cast
        if (size > 0) { // we need independent chain of nodes
            other.tail = new Node<>(tail.getElement(), null); 
            Node<E> walk = tail.getNext(); // walk through remainder of original list
            Node<E> otherTail = other.tail; // remember most recently created node
            while (walk != tail) { // make a new node storing same element
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest); // link previous node to this one
                otherTail = newest;
                walk = walk.getNext();
            }
            otherTail.setNext(other.tail); // link the last node to the tail
        }
        return other;
    }

    public int hashCode() {
        int h = 0;
        for (Node<E> walk = tail.getNext(); walk != tail; walk = walk.getNext()) {
            h ^= walk.getElement().hashCode(); // bitwise exclusive-or with element's code
            h = (h << 5) | (h >>> 27); // 5-bit cyclic shift of composite code
        }
        h ^= tail.getElement().hashCode(); // include the tail element in the hash code
        return h;
    }

}

