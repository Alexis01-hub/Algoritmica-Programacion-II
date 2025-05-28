package ej6;

import java.util.Iterator;
import java.util.List;

/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Tree<E> extends Iterable<E> {

  /**
   * Returns the root Position of the tree (or null if tree is empty).
   * 
   * @return root Position of the tree (or null if tree is empty)
   */
  Position<E> root();

  /**
   * Returns the Position of p's parent (or null if p is root).
   *
   * @param p A valid Position within the tree
   * @return Position of p's parent (or null if p is root)
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  Position<E> parent(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns an iterable collection of the Positions representing p's children.
   *
   * @param p A valid Position within the tree
   * @return iterable collection of the Positions of p's children
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  Iterable<Position<E>> children(Position<E> p)
      throws IllegalArgumentException;

  /**
   * Returns the number of children of Position p.
   *
   * @param p A valid Position within the tree
   * @return number of children of Position p
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  int numChildren(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns true if Position p has one or more children.
   *
   * @param p A valid Position within the tree
   * @return true if p has at least one child, false otherwise
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  boolean isInternal(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns true if Position p does not have any children.
   *
   * @param p A valid Position within the tree
   * @return true if p has zero children, false otherwise
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  boolean isExternal(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns true if Position p represents the root of the tree.
   *
   * @param p A valid Position within the tree
   * @return true if p is the root of the tree, false otherwise
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  boolean isRoot(Position<E> p) throws IllegalArgumentException;

  /**
   * Returns the number of nodes in the tree.
   * 
   * @return number of nodes in the tree
   */
  int size();

  /**
   * Tests whether the tree is empty.
   * 
   * @return true if the tree is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Returns an iterator of the elements stored in the tree.
   * 
   * @return iterator of the tree's elements
   */
  Iterator<E> iterator();

  /**
   * Returns an iterable collection of the positions of the tree.
   * 
   * @return iterable collection of the tree's positions
   */
  Iterable<Position<E>> positions();

  /**
   * Retorna una colección iterable con las posiciones de los ancestros hasta la
   * raíz
   * 
   * @param p posición del primer nodo
   * @return colección iterable con las posiciones de los ancestros hasta la raíz
   */
  public Iterable<Position<E>> ancestor(Position<E> p);

  /**
   * Busca un elemento dentro del árbol y retorna su posición o null si no se 
   * encuentra
   * 
   * @param e elemento a buscar
   * @return la posición donde se encuentra el elemento "e" o null si no se
   *         encuentra
   */
  public Position<E> search(E e);

  /**
   * Retorna una lista con todas las posiciones de los elementos encontrados
   * 
   * @param e elemento a buscar
   * @return lista con las posiciones donde se encuentra el elemento "e"
   */
  public java.util.List<Position<E>> searchAll(E e);

  /**
   * Indica si un árbol tienen elementos duplicados
   * @return "true" si tiene elementos duplicados o "false" caso contrario
   */
  public boolean duplicate();

  /**
   * Retorna un iterable con todas las posiciones de los nodos externos (hijos)
   * 
   * @return iterable de las posiciones de los nodos externos
   */
  public Iterable<Position<E>> listChildren();

  /**
   * Retorna un iterable con todas las posiciones de la rama más larga de un árbol
   * comenzando desde un nodo externo hasta llegar a la raíz
   * 
   * Si hay más de una rama con la misma profundidad, retorna una de las ramas que
   * cumpla con la condición dada
   * 
   * @return iterable de las posiciones de rama más larga de un árbol
   */
  public Iterable<Position<E>> listGreaterAncestor();

  /**
   * Retorna un iterable con los valores de todos los nodos que tienen la
   * profundidad depth
   * 
   * @param depth profundidad
   * 
   * @return iterable con los valores de los nodos que tienen la profundidad depth
   */
  public Iterable<E> listDepth(int depth);

}