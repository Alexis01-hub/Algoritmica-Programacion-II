package ArchivosParcial1.MiResolucion.parcial2021.lista;

public class PruebaSinglyLinkedList {
    /*
     * realizar un programa que 
    pruebe los diferentes casos que se pueden presentar (lista vacía, lista sin elementos repetidos, lista con 
    todos los elementos repetidos, etc.) 
     */
    public static void main(String[] args) {
        
        SinglyLinkedList<String> lista1 = new SinglyLinkedList<>();
        // Agregar elementos a la lista
        lista1.addLast("Juan");
        lista1.addLast("Pedro");
        lista1.addLast("Juan");
        lista1.addLast("Ana");
        lista1.addLast("Juan");
        lista1.addLast("Pedro");
        // Mostrar la lista original
        System.out.println("Lista original: " + lista1.toString());
        // Crear una nueva lista sin duplicados
        SinglyLinkedList<String> a1 = lista1.noDuplicate();
        // Mostrar la lista sin duplicados
        System.out.println("Lista sin duplicados: " + a1.toString());

        //-------------------- vacia
        SinglyLinkedList<String> lista2 = new SinglyLinkedList<>();
        // Mostrar la lista vacía
        System.out.println("Lista vacía: " + lista2);
        // Mostrar la lista sin duplicados
        System.out.println("Lista vacía sin duplicados: " + lista2.noDuplicate());

        //-------------------- sin duplicados
        SinglyLinkedList<String> lista3 = new SinglyLinkedList<>();
        // Agregar elementos a la lista
        lista3.addLast("Juan");
        lista3.addLast("Pedro");
        lista3.addLast("Ana");
        // Mostrar la lista original
        System.out.println("Lista original: " + lista3);
        // Mostrar la lista sin duplicados
        System.out.println("Lista sin duplicados: " + lista3.noDuplicate());

        //-------------------- todos duplicados
        SinglyLinkedList<String> lista4 = new SinglyLinkedList<>();
        // Agregar elementos a la lista
        lista4.addLast("Juan");
        lista4.addLast("Juan");
        lista4.addLast("Juan");
        lista4.addLast("Juan");
        // Mostrar la lista original
        System.out.println("Lista original: " + lista4);
        // Mostrar la lista sin duplicados
        System.out.println("Lista sin duplicados: " + lista4.noDuplicate());


    }
}
