package ej9;

public class PruebaPositionalList {
    public static void main(String[] args) {
        PositionalList<String> lista = new LinkedPositionalList<>();

        // Prueba de addFirst y addLast (usando solo métodos permitidos)
        lista.addFirst("B"); // Lista: B
        lista.addLast("C");  // Lista: B, C
        lista.addFirst("A"); // Lista: A, B, C

        // Prueba de addBefore y addAfter
        Position<String> posB = lista.after(lista.first()); // posición de "B"
        lista.addBefore(posB, "X"); // Lista: A, X, B, C
        lista.addAfter(posB, "Y");  // Lista: A, X, B, Y, C

        // Mostrar la lista usando iterator()
        System.out.println("Elementos de la lista:");
        for (String s : lista) {
            System.out.println(s);
        }

        // Prueba de first, last, before, after
        System.out.println("Primero: " + lista.first().getElement());
        System.out.println("Último: " + lista.last().getElement());
        System.out.println("Antes de B: " + lista.before(posB).getElement());
        System.out.println("Después de B: " + lista.after(posB).getElement());
    }
}
