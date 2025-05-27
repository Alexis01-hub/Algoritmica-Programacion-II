package ej5;

import java.util.Iterator;
import java.util.List; // for use as snapshot iterator
import java.util.ArrayList; // for use as snapshot iterator

/**
 * An abstract base class providing some functionality of the Tree interface.
 *
 * The following three methods remain abstract, and must be
 * implemented by a concrete subclass: root, parent, children. Other
 * methods implemented in this class may be overridden to provide a
 * more direct and efficient implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public abstract class AbstractTree<E> implements Tree<E> {

  /**
   * Returns true if Position p has one or more children.
   *
   * @param p A valid Position within the tree
   * @return true if p has at least one child, false otherwise
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  @Override
  public boolean isInternal(Position<E> p) {
    return numChildren(p) > 0;
  }

  /**
   * Returns true if Position p does not have any children.
   *
   * @param p A valid Position within the tree
   * @return true if p has zero children, false otherwise
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  @Override
  public boolean isExternal(Position<E> p) {
    return numChildren(p) == 0;
  }

  /**
   * Returns true if Position p represents the root of the tree.
   *
   * @param p A valid Position within the tree
   * @return true if p is the root of the tree, false otherwise
   */
  @Override
  public boolean isRoot(Position<E> p) {
    return p == root();
  }

  /**
   * Returns the number of children of Position p.
   *
   * @param p A valid Position within the tree
   * @return number of children of Position p
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  @Override
  public int numChildren(Position<E> p) {
    int count = 0;
    for (Position child : children(p))
      count++;
    return count;
  }

  /**
   * Returns the number of nodes in the tree.
   * 
   * @return number of nodes in the tree
   */
  @Override
  public int size() {
    int count = 0;
    for (Position p : positions())
      count++;
    return count;
  }

  /**
   * Tests whether the tree is empty.
   * 
   * @return true if the tree is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  // ---------- support for computing depth of nodes and height of (sub)trees
  // ----------

  /**
   * Returns the number of levels separating Position p from the root.
   *
   * @param p A valid Position within the tree
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  public int depth(Position<E> p) throws IllegalArgumentException {
    if (isRoot(p))
      return 0;
    else
      return 1 + depth(parent(p));
  }

  /**
   * Returns the height of the tree.
   *
   * Note: This implementation works, but runs in O(n^2) worst-case time.
   */
  private int heightBad() { // works, but quadratic worst-case time
    int h = 0;
    for (Position<E> p : positions())
      if (isExternal(p)) // only consider leaf positions
        h = Math.max(h, depth(p));
    return h;
  }

  /**
   * Returns the height of the subtree rooted at Position p.
   *
   * @param p A valid Position within the tree
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  public int height(Position<E> p) throws IllegalArgumentException {
    int h = 0; // base case if p is external
    for (Position<E> c : children(p))
      h = Math.max(h, 1 + height(c));
    return h;
  }

  //-------- agregacion de metodos de la actividad 5 --------

  /**
  * Retorna una colección iterable con las posiciones de los ancestros hasta la
  * raíz
  * 
  * @param p posición del primer nodo
  * @return colección iterable con las posiciones de los ancestros hasta la raíz
  */
  public Iterable<Position<E>> ancestor (Position<E> p){
    if (p == null) {
      throw new IllegalArgumentException("Position cannot be null");
    }
    List<Position<E>> list = new ArrayList<Position<E>>();
    while (!isRoot(p)){ // Mientras no sea la raíz
      list.add(p); // Agrega la posición actual a la lista
      p = parent(p); // Mueve a la posición del padre
    }
    list.add(p); // Agrega la raíz al final
    return list; // Retorna la lista de ancestros
  }  

  /**
   * Busca un elemento dentro del árbol y retorna su posición o null si no se 
   * encuentra
   * 
   * @param e elemento a buscar
   * @return la posición donde se encuentra el elemento "e" o null si no se
   *         encuentra
   */
  public Position<E> search(E e){
    for (Position<E> p : positions()){
      if (p.getElement().equals(e)){
        return p;
      }
    }
    return null;
  }

  /**
   * Retorna una lista con todas las posiciones de los elementos encontrados
   * 
   * @param e elemento a buscar
   * @return lista con las posiciones donde se encuentra el elemento "e"
   */
  public java.util.List<Position<E>> searchAll(E e){
    List<Position<E>> list = new ArrayList<Position<E>>();
    for (Position<E> p : positions()){
      if (p.getElement().equals(e)){
        list.add(p);
      }
    }
    return list;
  }
  /**
  * Indica si un árbol tienen elementos duplicados
  * 
  * @return "true" si tiene elementos duplicados o "false" caso contrario
  */
  public boolean duplicate() {
    List<E> list = new ArrayList<E>();
    for (Position<E> p : positions()) {
        if (list.contains(p.getElement())) {
            return true; // Si ya existe el elemento, hay duplicados
        }
        list.add(p.getElement()); // Agrega el elemento a la lista
    }
    return false; // Si no se encontró duplicados, retorna false
  }


  /**
  * Retorna un iterable con todas las posiciones de los nodos externos (hijos)
  * 
  * @return iterable de las posiciones de los nodos externos
  */
  public Iterable<Position<E>> listChildren() {
    List<Position<E>> hojas = new ArrayList<>(); // Lista para almacenar las posiciones de las hojas
    if (isEmpty()) {
        return hojas; // Retorna una lista vacía si el árbol está vacío
    }
    for (Position<E> p : positions()) {
        if (isExternal(p)) { // Es hoja si no tiene hijos
            hojas.add(p); // Agrega la posición de la hoja a la lista
        }
    }
    return hojas;
  }

  /**
  * Retorna un iterable con todas las posiciones de la rama más larga de un árbol
  * comenzando desde un nodo externo hasta llegar a la raíz
  * 
  * Si hay más de una rama con la misma profundidad, retorna una de las ramas que
  * cumpla con la condición dada
  * 
  * @return iterable de las posiciones de rama más larga de un árbol
  */
  public Iterable<Position<E>> listGreaterAncestor() {
    List<Position<E>> longestBranch = new ArrayList<>(); // Lista para almacenar la rama más larga
    for (Position<E> leaf : listChildren()) { // listChildren() retorna las hojas
        List<Position<E>> currentBranch = new ArrayList<>(); // Lista para almacenar la rama actual
        Position<E> current = leaf; // Comienza desde la hoja actual
        // Recorre desde la hoja hasta la raíz
        while (current != null) {
            currentBranch.add(current); // Agrega la posición actual a la rama
            if (isRoot(current)) break; // Si es la raíz, termina el recorrido
            current = parent(current); // Mueve a la posición del padre
        }
        // Si la rama actual es más larga, la guardamos
        if (currentBranch.size() > longestBranch.size()) { // Compara tamaños de ramas
            longestBranch = currentBranch; // Actualiza la rama más larga
        }
    }
    return longestBranch;
  }

  /**
  * Retorna un iterable con los valores de todos los nodos que tienen la
  * profundidad depth
  * 
  * @param depth profundidad
  * 
  * @return iterable con los valores de los nodos que tienen la profundidad depth
  */
  public Iterable<E> listDepth(int depth) {
    List<E> result = new ArrayList<>(); 
    for (Position<E> p : positions()) { // Itera sobre todas las posiciones del árbol
        if (depth(p) == depth) { // Verifica si la profundidad del nodo es igual a la buscada
            result.add(p.getElement()); // Agrega el elemento del nodo a la lista de resultados
        }
    }
    return result; 
  }

  //---------------- fin de agregación de métodos de la actividad 5 ----------------


  // ---------- support for various iterations of a tree ----------

  // ---------------- nested ElementIterator class ----------------
  /*
   * This class adapts the iteration produced by positions() to return elements.
   */
  private class ElementIterator implements Iterator<E> {
    Iterator<Position<E>> posIterator = positions().iterator();

    public boolean hasNext() {
      return posIterator.hasNext();
    }

    public E next() {
      return posIterator.next().getElement();
    } // return element!

    public void remove() {
      posIterator.remove();
    }
  }

  /**
   * Returns an iterator of the elements stored in the tree.
   * 
   * @return iterator of the tree's elements
   */
  @Override
  public Iterator<E> iterator() {
    return new ElementIterator();
  }

  /**
   * Returns an iterable collection of the positions of the tree.
   * 
   * @return iterable collection of the tree's positions
   */
  @Override
  public Iterable<Position<E>> positions() {
    return preorder();
  }

  /**
   * Adds positions of the subtree rooted at Position p to the given
   * snapshot using a preorder traversal
   * 
   * @param p        Position serving as the root of a subtree
   * @param snapshot a list to which results are appended
   */
  private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
    snapshot.add(p); // for preorder, we add position p before exploring subtrees
    for (Position<E> c : children(p))
      preorderSubtree(c, snapshot);
  }

  /**
   * Returns an iterable collection of positions of the tree, reported in
   * preorder.
   * 
   * @return iterable collection of the tree's positions in preorder
   */
  public Iterable<Position<E>> preorder() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty())
      preorderSubtree(root(), snapshot); // fill the snapshot recursively
    return snapshot;
  }

  /**
   * Adds positions of the subtree rooted at Position p to the given
   * snapshot using a postorder traversal
   * 
   * @param p        Position serving as the root of a subtree
   * @param snapshot a list to which results are appended
   */
  private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
    for (Position<E> c : children(p))
      postorderSubtree(c, snapshot);
    snapshot.add(p); // for postorder, we add position p after exploring subtrees
  }

  /**
   * Returns an iterable collection of positions of the tree, reported in
   * postorder.
   * 
   * @return iterable collection of the tree's positions in postorder
   */
  public Iterable<Position<E>> postorder() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty())
      postorderSubtree(root(), snapshot); // fill the snapshot recursively
    return snapshot;
  }

  /**
   * Returns an iterable collection of positions of the tree in breadth-first
   * order.
   * 
   * @return iterable collection of the tree's positions in breadth-first order
   */
  public Iterable<Position<E>> breadthfirst() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty()) {
      Queue<Position<E>> fringe = new LinkedQueue<>();
      fringe.enqueue(root()); // start with the root
      while (!fringe.isEmpty()) {
        Position<E> p = fringe.dequeue(); // remove from front of the queue
        snapshot.add(p); // report this position
        for (Position<E> c : children(p))
          fringe.enqueue(c); // add children to back of queue
      }
    }
    return snapshot;
  }
}