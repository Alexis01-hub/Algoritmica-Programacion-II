package TP3.ej7.actividad.test;

import TP3.ej7.actividad.src.DoublyLinkedList;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        // Crear una nueva lista doblemente enlazada
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Prueba: Verificar si la lista está vacía
        System.out.println("¿La lista está vacía? " + list.isEmpty()); // true

        // Prueba: Agregar elementos al inicio y al final
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println("Lista después de agregar elementos: " + list); // (10, 20, 30)

        // Prueba: Obtener el primer y último elemento
        System.out.println("Primer elemento: " + list.first()); // 10
        System.out.println("Último elemento: " + list.last()); // 30

        // Prueba: Eliminar el primer elemento
        System.out.println("Elemento eliminado (primero): " + list.removeFirst()); // 10
        System.out.println("Lista después de eliminar el primer elemento: " + list); // (20, 30)

        // Prueba: Eliminar el último elemento
        System.out.println("Elemento eliminado (último): " + list.removeLast()); // 30
        System.out.println("Lista después de eliminar el último elemento: " + list); // (20)

        // Prueba: Insertar en una posición específica
        list.addFirst(10);
        list.addLast(30);
        list.addPos(25, 2); // Insertar 25 en la posición 2
        System.out.println("Lista después de insertar 25 en la posición 2: " + list); // (10, 20, 25, 30)
        // Prueba: Eliminar un elemento en una posición específica
        System.out.println("Elemento eliminado en la posición 2: " + list.removePos(2)); // 25
        System.out.println("Lista después de eliminar el elemento en la posición 2: " + list); // (10, 20, 30)
    }
}