package ej3;
import java.util.ArrayList;

public class Deque<T> {
    private ArrayList<T> elementos;

    public Deque() {
        elementos = new ArrayList<>();
    }

    public void addFirst(T elemento) {
        elementos.add(0, elemento);
    }

    public void addLast(T elemento) {
        elementos.add(elemento);
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elementos.remove(0);
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elementos.remove(elementos.size() - 1);
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elementos.get(0);
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elementos.get(elementos.size() - 1);
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }
}