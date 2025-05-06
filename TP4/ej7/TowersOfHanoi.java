package tp04;

import java.util.Scanner;

/**
 * Clase que implementa la solución al problema de las Torres de Hanói.
 * El objetivo del problema es mover todos los discos de una torre inicial a una torre final,
 * siguiendo estas reglas:
 * 1. Solo se puede mover un disco a la vez.
 * 2. Un disco más grande no puede colocarse sobre uno más pequeño.
 * 3. Se puede usar una torre auxiliar para mover los discos.
 */
public class TowersOfHanoi {

    /**
     * Método recursivo para resolver el problema de las Torres de Hanói.
     *
     * @param n         Número de discos a mover.
     * @param start     Torre de inicio.
     * @param auxiliary Torre auxiliar.
     * @param end       Torre de destino.
     */
    public void solve(int n, String start, String auxiliary, String end) {
        // Caso base: si solo hay un disco, moverlo directamente a la torre de destino.
        if (n == 1) {
            System.out.println(start + " -> " + end);
        } else {
            // Mover n-1 discos de la torre de inicio a la torre auxiliar, usando la torre de destino.
            solve(n - 1, start, end, auxiliary);
            // Mover el disco restante de la torre de inicio a la torre de destino.
            System.out.println(start + " -> " + end);
            // Mover los n-1 discos de la torre auxiliar a la torre de destino, usando la torre de inicio.
            solve(n - 1, auxiliary, start, end);
        }
    }

    /**
     * Método principal que solicita al usuario el número de discos y resuelve el problema.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Crear una instancia de la clase TowersOfHanoi.
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();

        // Solicitar al usuario el número de discos.
        System.out.print("Enter number of discs: ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();

        // Resolver el problema de las Torres de Hanói con las torres A, B y C.
        towersOfHanoi.solve(discs, "A", "B", "C");
    }
}