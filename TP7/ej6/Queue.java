package ej6;

/**
 * Interface for a queue: a collection of elements that are inserted
 * and removed according to the first-in first-out principle. Although
 * similar in purpose, this interface differs from java.util.Queue.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Queue<E> {
  /**
   * Returns the number of elements in the queue.
   * 
   * @return number of elements in the queue
   */
  int size();

  /**
   * Tests whether the queue is empty.
   * 
   * @return true if the queue is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Inserts an element at the rear of the queue.
   * 
   * @param e the element to be inserted
   */
  void enqueue(E e);

  /**
   * Returns, but does not remove, the first element of the queue.
   * 
   * @return the first element of the queue (or null if empty)
   */
  E first();

  /**
   * Removes and returns the first element of the queue.
   * 
   * @return element removed (or null if empty)
   */
  E dequeue();
}