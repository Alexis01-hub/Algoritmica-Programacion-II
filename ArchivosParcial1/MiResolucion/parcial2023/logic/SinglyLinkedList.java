public class SinglyLinkedList<E> implements Cloneable {
	// ---------------- nested Node class ----------------
	/**
	 * Node of a singly linked list, which stores a reference to its element and to
	 * the subsequent node in the list (or null if this is the last node).
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
			other.tail = otherTail;
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
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
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
    * Crea una nueva lista y copia todos sus elementos 
    *  
    * @return lista nueva con una copia de la lista actual 
    *  
    */ 
    public SinglyLinkedList<E> duplicate(){
        SinglyLinkedList<E> duplicate = new SinglyLinkedList<>();
        Node<E> current = head;
        while(current != null){
            duplicate.addLast(current.getElement());
            current = current.getNext();
        }
        return duplicate;
    }
    /**
	 * Retorna la lista con todos los elementos de la lista l insertados a partir de
	 * la posici�n pos.
	 *
	 * Considere la opci�n de utilizar el m�todo duplicate() o clone()
	 *
	 * No utilizar m�todos que insertan de a un elemento como por ejemplo addPos(E,
	 * p)
	 *
	 * Por ejemplo:
	 * 
	 * Dada la lista: {A, B, C, D} y la lista l = {X, Y}
	 * 
	 * addPos(l, 2) => {A, B, X, Y, C, D}
	 * 
	 * addPos(l, 0) => {X, Y, A, B, C, D}
	 * 
	 * addPos(l, 4) => {A, B, C, D, X, y}
	 * 
	 * @param SinglyLinkedList<E> l : lista a insertar
	 * @param SinglyLinkedList<E> pos : posici�n a partir de donde se inserta
	 * 
	 * 
	 * @return lista original m�s todos los elementos de la lista l insertados a
	 *         partir de la posici�n pos
	 *
	 * @exception Si los �ndices est�n fuera de rango lanza la excepci�n
	 *               IndexOutOfBoundsException
	 * 
	 */
	public void addList(SinglyLinkedList<E> l, int pos) throws IndexOutOfBoundsException{
        if (pos < 0 || pos > size){
            throw new IndexOutOfBoundsException("posicion invalida");
        }
        if (l.isEmpty()){
            return;
        }
        SinglyLinkedList<E> otro = l.duplicate(); // duplicamos la lista l
        Node<E> current = head; // apuntamos al inicio de la lista original
        Node<E> prev = null; // apuntamos al nodo anterior
        int z = 0; // contador para la posicion
        while(z < pos){
            prev = current;
            current = current.getNext();
            z++;
        }
        if (prev == null){ // si la posicion es 0
            head = otro.head; // la cabeza de la lista original apunta a la cabeza de la lista l
        }else{
            prev.setNext(otro.head); // el nodo anterior apunta a la cabeza de la lista l
        }
        otro.tail.setNext(current); // el nodo final de la lista l apunta al nodo actual
        if(size == pos){ // si la posicion es igual al tamaño de la lista original
            tail = otro.tail; // si la posicion es igual al tamaño de la lista original, la cola de la lista original apunta a la cola de la lista l
        }
        size += otro.size; // sumamos el tamaño de la lista l al tamaño de la lista original
    }
}