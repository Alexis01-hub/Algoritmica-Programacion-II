package TP3.ej7.actividad.src;
/**
 * Una implementación básica de una lista doblemente enlazada.
 * 
 * @autor Michael T. Goodrich
 * @autor Roberto Tamassia
 * @autor Michael H. Goldwasser
 */
public class DoublyLinkedList<E> {

  //---------------- clase anidada Node ----------------
  /**
   * Nodo de una lista doblemente enlazada, que almacena una referencia a su
   * elemento y a los nodos anterior y siguiente en la lista.
   */
  private static class Node<E> {

    /** El elemento almacenado en este nodo */
    private E element;               // referencia al elemento almacenado en este nodo

    /** Una referencia al nodo anterior en la lista */
    private Node<E> prev;            // referencia al nodo anterior en la lista

    /** Una referencia al nodo siguiente en la lista */
    private Node<E> next;            // referencia al nodo siguiente en la lista

    /**
     * Crea un nodo con el elemento dado y los nodos anterior y siguiente.
     *
     * @param e  el elemento que se almacenará
     * @param p  referencia a un nodo que debe preceder al nuevo nodo
     * @param n  referencia a un nodo que debe seguir al nuevo nodo
     */
    public Node(E e, Node<E> p, Node<E> n) {
      element = e;
      prev = p;
      next = n;
    }

    // métodos de acceso públicos
    /**
     * Devuelve el elemento almacenado en el nodo.
     * @return el elemento almacenado en el nodo
     */
    public E getElement() { return element; }

    /**
     * Devuelve el nodo que precede a este (o null si no hay tal nodo).
     * @return el nodo anterior
     */
    public Node<E> getPrev() { return prev; }

    /**
     * Devuelve el nodo que sigue a este (o null si no hay tal nodo).
     * @return el nodo siguiente
     */
    public Node<E> getNext() { return next; }

    // métodos de actualización
    /**
     * Establece la referencia anterior del nodo para que apunte al nodo p.
     * @param p    el nodo que debe preceder a este
     */
    public void setPrev(Node<E> p) { prev = p; }

    /**
     * Establece la referencia siguiente del nodo para que apunte al nodo n.
     * @param n    el nodo que debe seguir a este
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- fin de la clase anidada Node -----------

  // variables de instancia de DoublyLinkedList
  /** Nodo centinela al inicio de la lista */
  private Node<E> header;                    // nodo centinela inicial

  /** Nodo centinela al final de la lista */
  private Node<E> trailer;                   // nodo centinela final

  /** Número de elementos en la lista (sin incluir los centinelas) */
  private int size = 0;                      // número de elementos en la lista

  /** Construye una nueva lista vacía. */
  public DoublyLinkedList() {
    header = new Node<>(null, null, null);      // crea el nodo centinela inicial
    trailer = new Node<>(null, header, null);   // el nodo centinela final es precedido por el inicial
    header.setNext(trailer);                    // el nodo centinela inicial es seguido por el final
  }

  // métodos de acceso públicos
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
  public E first() {
    if (isEmpty()) return null;
    return header.getNext().getElement();   // el primer elemento está después del nodo centinela inicial
  }

  /**
   * Devuelve (pero no elimina) el último elemento de la lista.
   * @return el elemento al final de la lista (o null si está vacía)
   */
  public E last() {
    if (isEmpty()) return null;
    return trailer.getPrev().getElement();    // el último elemento está antes del nodo centinela final
  }

  // métodos de actualización públicos
  /**
   * Agrega un elemento al frente de la lista.
   * @param e   el nuevo elemento a agregar
   */
  public void addFirst(E e) {
    addBetween(e, header, header.getNext());    // coloca justo después del nodo centinela inicial
  }

  /**
   * Agrega un elemento al final de la lista.
   * @param e   el nuevo elemento a agregar
   */
  public void addLast(E e) {
    addBetween(e, trailer.getPrev(), trailer);  // coloca justo antes del nodo centinela final
  }

  /**
   * Elimina y devuelve el primer elemento de la lista.
   * @return el elemento eliminado (o null si está vacía)
   */
  public E removeFirst() {
    if (isEmpty()) return null;                  // nada que eliminar
    return remove(header.getNext());             // el primer elemento está después del nodo centinela inicial
  }

  /**
   * Elimina y devuelve el último elemento de la lista.
   * @return el elemento eliminado (o null si está vacía)
   */
  public E removeLast() {
    if (isEmpty()) return null;                  // nada que eliminar
    return remove(trailer.getPrev());            // el último elemento está antes del nodo centinela final
  }

  // métodos de actualización privados
  /**
   * Agrega un elemento a la lista enlazada entre los nodos dados.
   * Los nodos predecesor y sucesor deben ser vecinos antes de la llamada.
   *
   * @param predecessor   nodo justo antes de la ubicación donde se inserta el nuevo elemento
   * @param successor     nodo justo después de la ubicación donde se inserta el nuevo elemento
   */
  private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
    // crea y enlaza un nuevo nodo
    Node<E> newest = new Node<>(e, predecessor, successor);
    predecessor.setNext(newest);
    successor.setPrev(newest);
    size++;
  }

  /**
   * Elimina el nodo dado de la lista y devuelve su elemento.
   * @param node    el nodo que se eliminará (no debe ser un centinela)
   */
  private E remove(Node<E> node) {
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    size--;
    return node.getElement();
  }

  //----------------metodos agregados-----------------
  /* Insertar el elemento e en la posicion n de la lista */
  public void addPos(E e, int n) throws IndexOutOfBoundsException{
    if (n < 0 || n > size){
      throw new IndexOutOfBoundsException("posicion no valida");
    }
    if (n == 0){
      addFirst(e);
    }if(n == size){
      addLast(e);
    }else {
        Node<E> current = header.getNext();
        for(int i = 0; i < n-1; i++){
          current = current.getNext();
        }
        addBetween(e, current, current.getNext());
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
     Node<E> current = header.getNext();
      while (current != trailer) {
          if (current.getElement().equals(e)) {
            remove(current);
            return current.getElement();
          }
          current = current.getNext();
      }
      return null; // Elemento no encontrado
  }  

  /* Elimina elemento que se encuentra en la posicion n de la lista */
  /* Retorna NULL si no es una posición valida */
  public E removePos(int n) throws IndexOutOfBoundsException{
    if (n < 0 || n >= size){
      throw new IndexOutOfBoundsException("posicion no valida");}
    if (n == 0){ // si es el primer elemento
      return removeFirst(); 
    } 
    if (n == size-1){ // si es el último elemento
      return removeLast();
    }
    Node<E> current = header.getNext();
    for(int i = 0; i < n; i++){
      current = current.getNext();
    }
    E element = current.getElement(); // almacena el elemento a eliminar
    remove(current); // elimina el nodo
    return element;
  }

  /* Inserta todos los elementos de la Lista l al final de la lista */
  public void concatenate(DoublyLinkedList<E> l){
    if(l.isEmpty()){ return; } // si la lista está vacía, no hay nada que concatenar
    Node<E> current = l.header.getNext(); // nodo que apunta al primer elemento de la lista l
    while (current != l.trailer) { // mientras no se llegue al final de la lista l
      addLast(current.getElement()); // agrega el elemento al final de la lista actual
      current = current.getNext(); // avanza al siguiente nodo en la lista l
    }
    l.header.setNext(l.trailer); // actualiza el nodo centinela inicial de la lista l
    l.trailer.setPrev(l.header); // actualiza el nodo centinela final de la lista l
    l.size = 0; // establece el tamaño de la lista l a 0
  }

  /* Busca el elemento e dentro de la lista */
/* Retorna el elemento si lo encuentra o Null si no está en la lista */
  public E search(E e){
    Node<E> current = header.getNext(); 
    while (current != trailer) {
      if(current.getElement().equals(e)){
        return current.getElement();
      }
    } 
    return null; // Elemento no encontrado
  }
  /**
  * Compara esta lista con otra lista para verificar si son iguales.
  * Dos listas son iguales si tienen el mismo tamaño y los mismos elementos
  * en el mismo orden.
  * 
  * @param o El objeto a comparar con esta lista.
  * @return true si las listas son iguales, false en caso contrario.
  */
  @SuppressWarnings("unchecked")
  @Override
  public boolean equals(Object o) {
    if (o == null) return false; // Si el objeto es null, no son iguales.
    if (getClass() != o.getClass()) return false; // Si no son del mismo tipo, no son iguales.
    DoublyLinkedList<E> other = (DoublyLinkedList<E>) o; // Realiza un cast seguro.
    if (size != other.size) return false; // Si los tamaños son diferentes, no son iguales.

    // Compara elemento por elemento.
    Node<E> walkA = this.header.getNext(); // Nodo actual de esta lista.
    Node<E> walkB = other.header.getNext(); // Nodo actual de la otra lista.
    while (walkA != this.trailer) { // Recorre hasta el nodo centinela final.
        if (!walkA.getElement().equals(walkB.getElement())) {
            return false; // Si algún elemento no coincide, las listas no son iguales.
        }
        walkA = walkA.getNext(); // Avanza al siguiente nodo en esta lista.
        walkB = walkB.getNext(); // Avanza al siguiente nodo en la otra lista.
    }
    return true; // Si todos los elementos coinciden, las listas son iguales.
  }
  
  /**
   * Produce una representación en formato de cadena del contenido de la lista.
   * Esto existe solo para propósitos de depuración.
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
} //----------- fin de la clase DoublyLinkedList -----------
