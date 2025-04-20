package ArchivosParcial1.MiResolucion.parcial2021.lista;

public class PruebaDoublyLinkedList {
    public static void main(String[] args) {
        
        DoublyLinkedList<String> lista1 = new DoublyLinkedList<>();
        // Agregar elementos a la lista
        lista1.addLast("n");
        lista1.addLast("e");
        lista1.addLast("u");
        lista1.addLast("q");
        lista1.addLast("u");
        lista1.addLast("e");
        lista1.addLast("n");
        System.out.println(lista1); // [n, e, u, q, u, e, n]
        System.out.println(lista1.palindrome()); // true


        DoublyLinkedList<String> lista2 = new DoublyLinkedList<>();
        System.out.println(lista2); // []
        System.out.println(lista2.palindrome()); // true

        DoublyLinkedList<String> lista3 = new DoublyLinkedList<>();
        // Agregar elementos a la lista
        lista3.addLast("a");
        lista3.addLast("b");
        lista3.addLast("b");
        lista3.addLast("a");
        System.out.println(lista3); // [a, b, b, a]
        System.out.println(lista3.palindrome()); // true

        DoublyLinkedList<String> lista4 = new DoublyLinkedList<>();
        // Agregar elementos a la lista
        lista4.addLast("a");
        lista4.addLast("b");
        lista4.addLast("c");
        lista4.addLast("a");
        System.out.println(lista4); // [a, b, c, a]
        System.out.println(lista4.palindrome()); // false

        DoublyLinkedList<String> lista5 = new DoublyLinkedList<>();
        // Agregar elementos a la lista
        lista5.addLast("a");
        lista5.addLast("b");
        lista5.addLast("b");
        lista5.addLast("c");
        lista5.addLast("a");
        System.out.println(lista5); // [a, b, b, c, a]
        System.out.println(lista5.palindrome()); // false

    }
    
}
