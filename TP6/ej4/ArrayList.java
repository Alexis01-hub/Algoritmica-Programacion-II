package ej4;

public class ArrayList {
    private Object[] elementos;
    private int size;

    public ArrayList() {
        elementos = new Object[10]; // capacidad inicial
        size = 0;
    }

    // ...otros métodos...
    public int capacidad() {
        return elementos.length;
    }
    /**
     * Reduce la capacidad del array interno al número de elementos actuales.
     */
    public void trimToSize() {
        if (elementos.length > size) {
            Object[] nuevo = new Object[size];
            for (int i = 0; i < size; i++) {
                nuevo[i] = elementos[i];
            }
            elementos = nuevo;
        }
    }
}
