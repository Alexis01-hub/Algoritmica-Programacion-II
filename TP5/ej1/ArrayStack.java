import java.util.EmptyStackException;

/**
 * Implementación de una pila (stack) utilizando un arreglo estático.
 *
 * @param <T> El tipo de elementos almacenados en la pila.
 */
public class ArrayStack<T> implements Stack<T> {
    private Object[] array; // Arreglo que almacena los elementos de la pila.
    private int size; // Número de elementos actuales en la pila.

    /**
     * Constructor que inicializa la pila con un tamaño fijo.
     *
     * @param capacity La capacidad máxima de la pila.
     * @throws IllegalArgumentException Si la capacidad es menor o igual a 0.
     */
    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        array = new Object[capacity];
        size = 0;
    }

    /**
     * Inserta un elemento en la parte superior de la pila.
     *
     * @param element El elemento a insertar.
     * @throws IllegalStateException Si la pila está llena.
     */
    @Override
    public void push(T element) {
        if (size == array.length) {
            throw new IllegalStateException("La pila está llena.");
        }
        array[size++] = element;
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return El elemento eliminado de la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = (T) array[--size];
        array[size] = null; // Evitar referencias colgantes.
        return element;
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return El elemento en la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    @Override
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) array[size - 1];
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return {@code true} si la pila está vacía, de lo contrario {@code false}.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve el número de elementos en la pila.
     *
     * @return El tamaño de la pila.
     */
    @Override
    public int size() {
        return size;
    }
}
