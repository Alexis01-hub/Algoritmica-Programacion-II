import java.util.EmptyStackException;

/**
 * Implementación de una pila (stack) utilizando una lista doblemente enlazada.
 *
 * @param <T> El tipo de elementos almacenados en la pila.
 */
public class DoublyLinkedStack<T> implements Stack<T> {
    private DoublyLinkedList<T> list; // Lista doblemente enlazada que almacena los elementos de la pila.

    /**
     * Constructor que inicializa la pila como una lista doblemente enlazada vacía.
     */
    public DoublyLinkedStack() {
        this.list = new DoublyLinkedList<>();
    }

    /**
     * Inserta un elemento en la parte superior de la pila.
     *
     * @param element El elemento a insertar.
     */
    @Override
    public void push(T element) {
        list.addFirst(element);
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return El elemento eliminado de la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    @Override
    public T pop() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.removeFirst();
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return El elemento en la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    @Override
    public T top() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.first();
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return {@code true} si la pila está vacía, de lo contrario {@code false}.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Devuelve el número de elementos en la pila.
     *
     * @return El tamaño de la pila.
     */
    @Override
    public int size() {
        return list.size();
    }
}
