public class ArrayStack<T> implements Cloneable {
    private T[] stack;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        stack = (T[]) new Object[capacity];
        size = 0;
    }
    @SuppressWarnings("unchecked")
    @Override
    public ArrayStack<T> clone() {
        try {
            ArrayStack<T> cloned = (ArrayStack<T>) super.clone();
            cloned.stack = stack.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e); // Can't happen
        }
    }

    // Método para agregar un elemento a la pila
    public void push(T element) {
        if (size == stack.length) {
            throw new IllegalStateException("La pila está llena");
        }
        stack[size++] = element;
    }

    // Método para eliminar y devolver el elemento superior de la pila
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("La pila está vacía");
        }
        T element = stack[--size];
        stack[size] = null; // Evitar referencias obsoletas
        return element;
    }
}