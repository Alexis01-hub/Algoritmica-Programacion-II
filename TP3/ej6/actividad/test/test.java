package actividad.test;

import actividad.src.CircularlyLinkedList;

public class test {
    public static void main(String[] args) {
        
        // Crear una lista circular
        CircularlyLinkedList<String> list = new CircularlyLinkedList<String>();
        
        // Test: Añadir elementos al final
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        System.out.println("Lista después de añadir elementos: " + list); // A B C D
        
        // Test: Buscar elementos
        System.out.println("Buscar 'A': " + list.search("A")); // A
        System.out.println("Buscar 'D': " + list.search("D")); // D
        System.out.println("Buscar 'Z': " + list.search("Z")); // null
        
        // Test: Concatenar dos listas
        CircularlyLinkedList<String> list2 = new CircularlyLinkedList<String>(); 
        list2.addLast("E");
        list2.addLast("F");
        list.concatenate(list2);
        System.out.println("Lista después de concatenar: " + list); // A B C D E F
        
        // Test: Añadir en una posición específica
        list.addPos("Z", 0);
        System.out.println("Lista después de añadir 'Z' en posición 0: " + list); // Z A B C D E F
        list.addPos("Y", 3);
        System.out.println("Lista después de añadir 'Y' en posición 3: " + list); // Z A B Y C D E F
        
        // Test: Eliminar el primer elemento
        list.removeFirst();
        System.out.println("Lista después de eliminar el primer elemento: " + list); // A B Y C D E F
        
        // Test: Eliminar un elemento en una posición específica
        list.removePos(2);
        System.out.println("Lista después de eliminar el elemento en posición 2: " + list); // A B C D E
        
        // Test: Verificar si la lista está vacía
        System.out.println("¿La lista está vacía?: " + list.isEmpty()); // false
        
        // Test: Operaciones en una lista vacía
        System.out.println("Buscar en lista vacía: " + list.search("A")); // null
        list.removeFirst(); // No debería causar error
        System.out.println("Lista después de intentar eliminar en lista vacía: " + list); // (vacía)
    }
}
