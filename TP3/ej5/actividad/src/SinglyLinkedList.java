package src;

import org.junit.platform.engine.support.hierarchical.Node;

/*
 *  Implementar los métodos: addPos, removeElement, removePos, concatenate y search
 */

/**
 * Una implementación básica de una lista enlazada simple.
 *
 */
public class SinglyLinkedList<E> implements Cloneable {
  //---------------- clase anidada Node ----------------
  /**
   * Nodo de una lista enlazada simple, que almacena una referencia a su
   * elemento y al nodo siguiente en la lista (o null si este
   * es el último nodo).
   */
  private static class Node<E> {

    /** El elemento almacenado en este nodo */
    private E element;            // referencia al elemento almacenado en este nodo

    /** Una referencia al nodo siguiente en la lista */
    private Node<E> next;         // referencia al nodo siguiente en la lista

    /**
     * Constructor de nodo con el elemento dado.
     * Crea un nodo con el elemento y el nodo siguiente dados.
     *
     * @param e  el elemento a almacenar
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
     * 
     * Establece la referencia del nodo siguiente para que apunte al nodo n.
     * @param n    el nodo que debe seguir a este
     */
    public void setNext(Node<E> n) { next = n; }
  } //----------- fin de la clase anidada Node -----------

  // Variables de instancia de SinglyLinkedList
  /** El nodo inicial de la lista */
  private Node<E> head = null;               // nodo inicial de la lista (o null si está vacía)

  /** El último nodo de la lista */
  private Node<E> tail = null;               // último nodo de la lista (o null si está vacía)

  /** Número de nodos en la lista */
  private int size = 0;                      // número de nodos en la lista

  /** Construye una lista inicialmente vacía. */
  public SinglyLinkedList() { }              // construye una lista inicialmente vacía

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
    return head.getElement();
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
   * Agrega un elemento al frente de la lista.
   * @param e  el nuevo elemento a agregar
   */
  public void addFirst(E e) {                // agrega el elemento e al frente de la lista
    head = new Node<>(e, head);              // crea y enlaza un nuevo nodo
    if (size == 0)
      tail = head;                           // caso especial: el nuevo nodo también se convierte en el último
    size++;
  }

  /**
   * Agrega un elemento al final de la lista.
   * @param e  el nuevo elemento a agregar
   */
  public void addLast(E e) {                 // agrega el elemento e al final de la lista
    Node<E> newest = new Node<>(e, null);    // el nodo eventualmente será el último
    if (isEmpty())
      head = newest;                         // caso especial: lista previamente vacía
    else
      tail.setNext(newest);                  // nuevo nodo después del último existente
    tail = newest;                           // el nuevo nodo se convierte en el último
    size++;
  }

  /**
   * Elimina y devuelve el primer elemento de la lista.
   * @return el elemento eliminado (o null si está vacía)
   */
  public E removeFirst() {                   // elimina y devuelve el primer elemento
    if (isEmpty()) return null;              // nada que eliminar
    E answer = head.getElement();
    head = head.getNext();                   // se convertirá en null si la lista tenía solo un nodo
    size--;
    if (size == 0)
      tail = null;                           // caso especial ya que la lista ahora está vacía
    return answer;
  }
  //----- Metodos agregados -----
  /**
   * Agrega un elemento en una posición específica de la lista.
   * @param e  el nuevo elemento a agregar
   * @param pos  la posición donde se debe agregar el nuevo elemento
   */
  public void addPos(E e, int pos) throws IndexOutOfBoundsException {
      // Verifica si la posicion es válida
      if (pos < 0 || pos > size) {
          throw new IndexOutOfBoundsException("Posicion no valida ");
      }
      // Si la posicion es 0, agrega al inicio
      if (pos == 0) {
          addFirst(e);
      // Si la posicion es igual al tamaño, agrega al final
      }else if (pos == size) {
          addLast(e);
      // Si la posicion es mayor que 0 y menor que el tamaño, agrega en medio
      }else{
          Node<E> walk = head; // Inicializa el nodo para recorrer la lista
          
          for(int i = 0; i < pos - 1; i++){
              walk = walk.getNext(); // Recorre la lista hasta la posicion deseada
          }

          Node<E> newest = new Node<>(e, walk.getNext()); // Crea un nuevo nodo
          walk.setNext(newest); // Enlaza el nodo anterior con el nuevo 
          size++; // Incrementa el tamaño de la lista
      }
  }
  /**
   * Remueve un elemento de la lista Enlazada.
   * @param e  el elemento a eliminar
   * @return el elemento eliminado (o null si no se encuentra)
   */
  public E removeElement (E e){
      if (head == null) return null; // Si la lista está vacía, retorna null
      
      Node<E> walk = head; // Inicializa el nodo para recorrer la lista
      Node<E> prev = null; // Inicializa el nodo anterior
      while (walk != null) { // Recorre la lista
          if (walk.getElement().equals(e)) { // Si el elemento es igual al que se busca
              if (prev == null) { // Si es el primer elemento
                  head = walk.getNext(); // Cambia la cabeza de la lista
              }else{
                  prev.setNext(walk.getNext()); // Enlaza el nodo anterior con el siguiente
              }
              size--; // Decrementa el tamaño de la lista
              return walk.getElement(); // Retorna el elemento eliminado
          }
          prev = walk; // Cambia el nodo anterior
          walk = walk.getNext(); // Cambia el nodo actual
      }
      return null; // Si no se encuentra el elemento, retorna null
    

  }
  /**
   * Remueve un elemento de una posición específica de la lista.
   * @param pos  la posición del elemento a eliminar
   * @return el elemento eliminado (o null si no se encuentra)
   */
   public E removePos(int pos) throws IndexOutOfBoundsException{
      //verifica si la posicion es valida
      if (pos < 0 || pos >= size){
          throw new IndexOutOfBoundsException("Posicion no valida ");
      }
      // Si la posicion es 0, elimina el primer elemento
      if (pos == 0){
          return removeFirst();
      }else{
        Node<E> current = head; // Inicializa el nodo para recorrer la lista
        for (int i = 0; i < pos - 1; i++) { // Recorre la lista hasta la posicion deseada
            current = current.getNext();
        }
        Node<E> nodeToRemove = current.getNext(); // Nodo a eliminar
        E removedElement = nodeToRemove.getElement(); // Guarda el elemento a eliminar

        current.setNext(nodeToRemove.getNext()); // Enlaza el nodo anterior con el siguiente
        if (nodeToRemove == tail) { // Si es el último nodo
            tail = current; // Cambia la cola de la lista
        }
        size--; // Decrementa el tamaño de la lista
        
        return removedElement; // Retorna el elemento eliminado
      }
   }
   /**
    * Concatena dos listas enlazadas.
    * @return la lista concatenada
    */
   public void concatenate(SinglyLinkedList<E> otro){
      if (otro == null || otro.isEmpty()) return; // Verifica si la lista es nula o está vacía
      if (isEmpty()) { // Si la lista actual está vacía, simplemente asigna la otra lista
          this.head = otro.head;
          this.tail = otro.tail;
      }else{
        // Si la lista actual no está vacía, enlaza el último nodo de la lista actual con el primero de la otra
          this.tail.setNext(otro.head); // Enlaza el último nodo de la lista actual con el primero de la otra
          this.tail = otro.tail; // Cambia la cola de la lista actual
      }
      this.size += otro.size; // Incrementa el tamaño de la lista actual 
   }

   /**
    * Busca elemento e en la lista enlazada.
    * @param e  el elemento a buscar
    * @return el elemento encontrado (o null si no se encuentra)
    */
    public E search(E e){
        if (isEmpty()) return null; // Si la lista está vacía, retorna null
        Node<E> current = head; // Inicializa el nodo para recorrer la lista
        while (current != null) { // Recorre la lista
            if (current.getElement().equals(e)) { // Si el elemento es igual al que se busca
                return current.getElement(); // Retorna el elemento encontrado
            }
            current = current.getNext(); // Avanza al siguiente nodo
        }
        return null; // Si no se encuentra el elemento, retorna null
    }
    //----- Fin de los métodos agregados -----
    
  @SuppressWarnings({"unchecked"})
  public boolean equals(Object o) {
    if (o == null) return false;
    if (getClass() != o.getClass()) return false;
    SinglyLinkedList other = (SinglyLinkedList) o;   // usa tipo no parametrizado
    if (size != other.size) return false;
    Node walkA = head;                               // recorre la lista principal
    Node walkB = other.head;                         // recorre la lista secundaria
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement())) return false; // no coinciden
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;   // si llegamos aquí, todo coincidió exitosamente
  }

  @SuppressWarnings({"unchecked"})
  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    // siempre usa Object.clone() heredado para crear la copia inicial
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // conversión segura
    if (size > 0) {                    // necesitamos una cadena independiente de nodos
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext();      // recorre el resto de la lista original
      Node<E> otherTail = other.head;     // recuerda el nodo más recientemente creado
      while (walk != null) {              // crea un nuevo nodo almacenando el mismo elemento
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest);     // enlaza el nodo anterior con este
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }

  public int hashCode() {
    int h = 0;
    for (Node walk=head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();      // operación XOR bit a bit con el código del elemento
      h = (h << 5) | (h >>> 27);              // desplazamiento cíclico de 5 bits del código compuesto
    }
    return h;
  }

  /**
   * Produce una representación en cadena del contenido de la lista.
   * Esto existe solo para propósitos de depuración.
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
