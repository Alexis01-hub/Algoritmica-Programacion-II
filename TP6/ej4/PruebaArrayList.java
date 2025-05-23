package ej4;

public class PruebaArrayList {
    public static void main(String[] args) {
        ArrayList lista = new ArrayList();

        // Simula agregar elementos incrementando el size manualmente
        // (o implementa y usa lista.add si lo tienes)
        for (int i = 0; i < 5; i++) {
            lista.add("Elemento " + i);
        }

        System.out.println("Capacidad antes de trimToSize: " + lista.capacidad());
        lista.trimToSize();
        System.out.println("Capacidad después de trimToSize: " + lista.capacidad());
    }
}