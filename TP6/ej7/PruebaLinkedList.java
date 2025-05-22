package ej7;

public class PruebaLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        // Agregar elementos
        for (int i = 0; i < 5; i++) {
            lista.add(i, i * 10);
        }
        System.out.println("Elementos de la lista usando for-each:");
        for (Integer elem : lista) {
            System.out.print(elem + " ");
        }
        System.out.println();
        // Prueba de métodos básicos
        System.out.println("Elemento en posición 2: " + lista.get(2));
        lista.set(2, 99);
        System.out.println("Elemento en posición 2 tras set: " + lista.get(2));
        lista.remove(1);
        System.out.println("Lista tras eliminar posición 1:");
        for (Integer elem : lista) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
