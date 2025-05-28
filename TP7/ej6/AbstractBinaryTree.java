package ej6;

import java.util.List;
import java.util.ArrayList;

/**
 * An abstract base class providing some functionality of the BinaryTree
 * interface.
 *
 * The following five methods remain abstract, and must be implemented
 * by a concrete subclass: size, root, parent, left, right.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
    implements BinaryTree<E> {

  /**
   * Returns the Position of p's sibling (or null if no sibling exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the sibling (or null if no sibling exists)
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   */
  @Override
  public Position<E> sibling(Position<E> p) {
    Position<E> parent = parent(p);
    if (parent == null)
      return null; // p must be the root
    if (p == left(parent)) // p is a left child
      return right(parent); // (right child might be null)
    else // p is a right child
      return left(parent); // (left child might be null)
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
    if (left(p) != null)
      count++;
    if (right(p) != null)
      count++;
    return count;
  }

  /**
   * Returns an iterable collection of the Positions representing p's children.
   *
   * @param p A valid Position within the tree
   * @return iterable collection of the Positions of p's children
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  @Override
  public Iterable<Position<E>> children(Position<E> p) {
    List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
    if (left(p) != null)
      snapshot.add(left(p));
    if (right(p) != null)
      snapshot.add(right(p));
    return snapshot;
  }

  /**
   * Adds positions of the subtree rooted at Position p to the given
   * snapshot using an inorder traversal
   * 
   * @param p        Position serving as the root of a subtree
   * @param snapshot a list to which results are appended
   */
  private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
    if (left(p) != null)
      inorderSubtree(left(p), snapshot);
    snapshot.add(p);
    if (right(p) != null)
      inorderSubtree(right(p), snapshot);
  }

  /**
   * Returns an iterable collection of positions of the tree, reported in inorder.
   * 
   * @return iterable collection of the tree's positions reported in inorder
   */
  public Iterable<Position<E>> inorder() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty())
      inorderSubtree(root(), snapshot); // fill the snapshot recursively
    return snapshot;
  }

  /**
   * Returns an iterable collection of the positions of the tree using inorder
   * traversal
   * 
   * @return iterable collection of the tree's positions using inorder traversal
   */
  @Override
  public Iterable<Position<E>> positions() {
    return inorder();
  }
  //-------- implementacion del ejercicio 6 --------
  /**
  * Un árbol binario es lleno (full) si cada nodo interno tiene dos hijos o
  * ninguno
  * 
  * @return retorna "true" si es un árbol binario lleno o "false" en caso
  *         contrario
  */
  public boolean full(){
    if (isEmpty()){
      return false; // un arbol vacio es vacio
    }
    for (Position<E> p : positions()) {
      if (numChildren(p) == 1) {
        return false; // si hay un nodo interno con un hijo, no es lleno
      }
    }
    return true; // si no hay nodos internos con un hijo, es lleno
  }

  /**
  * Un árbol binario de expresiones contiene en sus nodos externos operandos y en 
  * sus nodos internos operadores
  * 
  * @param op lista de operadores válidos
  * @return retorna "true" si es árbol binario de expresiones o "false" en caso
  *         contrario
  */
  public boolean validExpressionTree(List<E> op){
    if (isEmpty()) return false; // un árbol vacío es un árbol de expresiones no es válido
    for (Position<E> p : positions()) {
      if (numChildren(p) == 0) { // si es un nodo externo
        if (op.contains(p.getElement())) {
          return false; // si es un nodo externo y es un operador, no es válido
        }
      } else if (numChildren(p) == 2) { // nodo interno
        if (!op.contains(p.getElement())) {
          return false; // si es un nodo interno y no es un operador, no es válido
        }
      } else {
        return false; // si tiene más de 2 hijos, no es válido
      }
    }
    return true; // si todos los nodos cumplen las condiciones, es un árbol de expresiones válido

  }
}