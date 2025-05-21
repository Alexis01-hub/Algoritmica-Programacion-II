package ej4;

import java.util.Arrays;

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
     * Agrega un elemento al final de la lista, redimensionando si es necesario.
     */
    public void add(Object elemento) {
        if (size == elementos.length) {
            // Duplicar la capacidad
            Object[] nuevo = new Object[elementos.length * 2];
            for (int i = 0; i < elementos.length; i++) {
                nuevo[i] = elementos[i];
            }
            elementos = nuevo;
        }
        elementos[size] = elemento;
        size++;
    }
    /**
     * Reduce la capacidad del array interno al número de elementos actuales.
     */
    public void trimToSize() {
        if (elementos.length > size) { // Si la capacidad del array es mayor que la cantidad de elementos, redimensiona el array para que su tamaño coincida con la cantidad de elementos
            elementos = Arrays.copyOf(elementos, size); // redimensiona el array
        }
    }

}
