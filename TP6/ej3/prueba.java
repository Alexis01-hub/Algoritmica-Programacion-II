package ej3;

public class prueba {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);

        System.out.println("Elemento en el frente: " + deque.peekFirst());
        System.out.println("Elemento en la parte trasera: " + deque.peekLast());
        System.out.println("Tamaño del deque: " + deque.size());

        while (!deque.isEmpty()) {
            System.out.println("Elemento eliminado del frente: " + deque.removeFirst());
            if (!deque.isEmpty()) {
                System.out.println("Elemento eliminado de la parte trasera: " + deque.removeLast());
            }
        }

        System.out.println("¿El deque está vacío? " + deque.isEmpty());
    }

}
