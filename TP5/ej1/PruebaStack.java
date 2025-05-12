/**
 * Clase que prueba el rendimiento de diferentes implementaciones de pilas
 * utilizando implementaciones personalizadas.
 * Se mide el tiempo de ejecución de las operaciones de inserción (push) y
 * eliminación (pop) para diferentes tamaños de pilas.
 */
public class PruebaStack {

    /**
     * Método principal que ejecuta las pruebas de rendimiento para diferentes
     * implementaciones de pilas.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        int n = 1000; // Número de elementos a insertar y eliminar.

        // Pila implementada con un arreglo estático
        ArrayStack<Integer> arrayStack = new ArrayStack<>(n);
        long arrayStackTime = tiempoStack(arrayStack, n);
        System.out.println("Tiempo de la pila implementada con arreglo estático: " + arrayStackTime + " nanosegundos");

        // Pila implementada con lista enlazada
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        long linkedStackTime = tiempoStack(linkedStack, n);
        System.out.println("Tiempo de la pila implementada con lista enlazada: " + linkedStackTime + " nanosegundos");

        // Pila implementada con lista doblemente enlazada
        DoublyLinkedStack<Integer> doublyLinkedStack = new DoublyLinkedStack<>();
        long doublyLinkedStackTime = tiempoStack(doublyLinkedStack, n);
        System.out.println("Tiempo de la pila implementada con lista doblemente enlazada: " + doublyLinkedStackTime + " nanosegundos");
    }

    /**
     * Calcula el tiempo que toma realizar las operaciones de inserción (push) y
     * eliminación (pop) en una pila.
     *
     * @param stack La pila sobre la cual se realizarán las operaciones.
     * @param n     El número de elementos a insertar y eliminar.
     * @return El tiempo total en nanosegundos que tomó realizar las operaciones.
     */
    private static long tiempoStack(Stack<Integer> stack, int n) {
        long startTime = System.nanoTime();

        // Operación push
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Operación pop
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}