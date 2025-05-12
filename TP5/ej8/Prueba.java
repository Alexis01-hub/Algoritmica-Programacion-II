package ej8;

public class Prueba {
    public static void main(String[] args) {
        // Crear una cola circular con capacidad para 5 elementos
        ArrayCircularQueue<Integer> queue = new ArrayCircularQueue<>(5);

        // Agregar elementos a la cola
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
            System.out.println("Enqueued: " + i);
        }

        // Intentar agregar un elemento más (esto debería lanzar una excepción)
        try {
            queue.enqueue(6);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar el elemento al frente de la cola
        System.out.println("Front element: " + queue.front());

        // Eliminar elementos de la cola
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        // Intentar eliminar un elemento de una cola vacía (esto debería lanzar una excepción)
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
