package ArchivosParcial1.MiResolucion.parcial2024.lista;

public class PruebaLs {
    public static void main(String[] args) {
        // Crear dos listas enlazadas
        SinglyLinkedList<Integer> lista1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> lista2 = new SinglyLinkedList<>();

        // Agregar elementos a la primera lista
        lista1.addLast(1);
        lista1.addLast(2);
        lista1.addLast(3);

        // Agregar elementos a la segunda lista
        lista2.addLast(4);
        lista2.addLast(5);
        lista2.addLast(6);

        // Combinar la segunda lista después de la primera
        lista1.addCombineAfter(lista2);

        // Imprimir la lista combinada
        System.out.println("Lista combinada con addCombineAfter:");
        System.out.println(lista1);

        // Verificar que la lista2 esté vacía después de la combinación
        System.out.println("Lista 2 después de addCombineAfter (debe estar vacía):");
        System.out.println(lista2);

        // Crear una nueva lista para probar addCombineBefore
        SinglyLinkedList<Integer> lista3 = new SinglyLinkedList<>();
        lista3.addLast(7);
        lista3.addLast(8);
        lista3.addLast(9);

        // Combinar la nueva lista antes de la primera
        lista1.addCombineBefore(lista3);

        // Imprimir la lista combinada
        System.out.println("Lista combinada con addCombineBefore:");
        System.out.println(lista1);

        // Verificar que la lista3 esté vacía después de la combinación
        System.out.println("Lista 3 después de addCombineBefore (debe estar vacía):");
        System.out.println(lista3);

        // Caso 1: {A, B, C, D} {W, X, Y, Z} => {A, W, B, X, C, Y, D, Z}
        SinglyLinkedList<String> listaA = new SinglyLinkedList<>();
        SinglyLinkedList<String> listaB = new SinglyLinkedList<>();
        listaA.addLast("A");
        listaA.addLast("B");
        listaA.addLast("C");
        listaA.addLast("D");
        listaB.addLast("W");
        listaB.addLast("X");
        listaB.addLast("Y");
        listaB.addLast("Z");
        listaA.addCombineAfter(listaB);
        System.out.println("Caso 1: " + listaA);

        // Caso 2: {A, B, C, D} {W, X} => {A, W, B, X, C, D}
        listaA = new SinglyLinkedList<>();
        listaB = new SinglyLinkedList<>();
        listaA.addLast("A");
        listaA.addLast("B");
        listaA.addLast("C");
        listaA.addLast("D");
        listaB.addLast("W");
        listaB.addLast("X");
        listaA.addCombineAfter(listaB);
        System.out.println("Caso 2: " + listaA);

        // Caso 3: {A, B} {W, X, Y, Z} => {A, W, B, X, Y, Z}
        listaA = new SinglyLinkedList<>();
        listaB = new SinglyLinkedList<>();
        listaA.addLast("A");
        listaA.addLast("B");
        listaB.addLast("W");
        listaB.addLast("X");
        listaB.addLast("Y");
        listaB.addLast("Z");
        listaA.addCombineAfter(listaB);
        System.out.println("Caso 3: " + listaA);

        // Caso 4: {A, B, C, D} {} => {A, B, C, D}
        listaA = new SinglyLinkedList<>();
        listaB = new SinglyLinkedList<>();
        listaA.addLast("A");
        listaA.addLast("B");
        listaA.addLast("C");
        listaA.addLast("D");
        listaA.addCombineAfter(listaB);
        System.out.println("Caso 4: " + listaA);

        // Caso 5: {} {W, X, Y, Z} => {W, X, Y, Z}
        listaA = new SinglyLinkedList<>();
        listaB = new SinglyLinkedList<>();
        listaB.addLast("W");
        listaB.addLast("X");
        listaB.addLast("Y");
        listaB.addLast("Z");
        listaA.addCombineAfter(listaB);
        System.out.println("Caso 5: " + listaA);

        // Caso 6: {} {} => {}
        listaA = new SinglyLinkedList<>();
        listaB = new SinglyLinkedList<>();
        listaA.addCombineAfter(listaB);
        System.out.println("Caso 6: " + listaA);

        
    }
}
