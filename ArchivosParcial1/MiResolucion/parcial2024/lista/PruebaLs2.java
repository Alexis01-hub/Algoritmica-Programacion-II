package ArchivosParcial1.MiResolucion.parcial2024.lista;

public class PruebaLs2 {
    public static void main(String[] args) {
        // Caso 1: {A, B, C, D} {W, X, Y, Z} => {W, A, X, B, Y, C, Z, D}
        SinglyLinkedList<String> lista1 = new SinglyLinkedList<>();
        SinglyLinkedList<String> lista2 = new SinglyLinkedList<>();
        lista1.addLast("A");
        lista1.addLast("B");
        lista1.addLast("C");
        lista1.addLast("D");
        lista2.addLast("W");
        lista2.addLast("X");
        lista2.addLast("Y");
        lista2.addLast("Z");
        lista1.addCombineBefore(lista2);
        System.out.println("Caso 1: " + lista1); // Debe imprimir: {W, A, X, B, Y, C, Z, D}
        System.out.println("Lista 2 vacía: " + lista2); // Debe estar vacía

        // Caso 2: {A, B, C, D} {W, X} => {W, A, X, B, C, D}
        lista1 = new SinglyLinkedList<>();
        lista2 = new SinglyLinkedList<>();
        lista1.addLast("A");
        lista1.addLast("B");
        lista1.addLast("C");
        lista1.addLast("D");
        lista2.addLast("W");
        lista2.addLast("X");
        lista1.addCombineBefore(lista2);
        System.out.println("Caso 2: " + lista1); // Debe imprimir: {W, A, X, B, C, D}
        System.out.println("Lista 2 vacía: " + lista2); // Debe estar vacía

        // Caso 3: {A, B} {W, X, Y, Z} => {W, A, X, B, Y, Z}
        lista1 = new SinglyLinkedList<>();
        lista2 = new SinglyLinkedList<>();
        lista1.addLast("A");
        lista1.addLast("B");
        lista2.addLast("W");
        lista2.addLast("X");
        lista2.addLast("Y");
        lista2.addLast("Z");
        lista1.addCombineBefore(lista2);
        System.out.println("Caso 3: " + lista1); // Debe imprimir: {W, A, X, B, Y, Z}
        System.out.println("Lista 2 vacía: " + lista2); // Debe estar vacía

        // Caso 4: {A, B, C, D} {} => {A, B, C, D}
        lista1 = new SinglyLinkedList<>();
        lista2 = new SinglyLinkedList<>();
        lista1.addLast("A");
        lista1.addLast("B");
        lista1.addLast("C");
        lista1.addLast("D");
        lista1.addCombineBefore(lista2);
        System.out.println("Caso 4: " + lista1); // Debe imprimir: {A, B, C, D}
        System.out.println("Lista 2 vacía: " + lista2); // Debe estar vacía

        // Caso 5: {} {W, X, Y, Z} => {W, X, Y, Z}
        lista1 = new SinglyLinkedList<>();
        lista2 = new SinglyLinkedList<>();
        lista2.addLast("W");
        lista2.addLast("X");
        lista2.addLast("Y");
        lista2.addLast("Z");
        lista1.addCombineBefore(lista2);
        System.out.println("Caso 5: " + lista1); // Debe imprimir: {W, X, Y, Z}
        System.out.println("Lista 2 vacía: " + lista2); // Debe estar vacía

        // Caso 6: {} {} => {}
        lista1 = new SinglyLinkedList<>();
        lista2 = new SinglyLinkedList<>();
        lista1.addCombineBefore(lista2);
        System.out.println("Caso 6: " + lista1); // Debe imprimir: {}
        System.out.println("Lista 2 vacía: " + lista2); // Debe estar vacía
    }
}
