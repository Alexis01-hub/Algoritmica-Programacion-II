package ej10;

public class Prueba {
    public static void main(String[] args) {
        // Crear un deque con una capacidad de 5
        DoublyLinkedDeque<Integer> deque = new DoublyLinkedDeque<>(5);

        // Agregar elementos al deque
        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);
        deque.addFirst(-1);

        // Intentar agregar un elemento al deque lleno
        try {
            deque.addLast(6); // Esto debería lanzar una excepción
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Mostrar los elementos del deque
        System.out.println("Elementos del deque:");
        while (!deque.isEmpty()) { // Mientras el deque no esté vacío
            System.out.print(deque.removeFirst() + " "); // Eliminar y mostrar el primer elemento
        }
        System.out.println();
    }
}
