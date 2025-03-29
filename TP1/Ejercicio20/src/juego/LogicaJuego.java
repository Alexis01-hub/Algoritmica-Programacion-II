package src.juego;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que contiene la lógica del juego.
 */
public class LogicaJuego {
    private static final int RANGO_MAXIMO = 1000;

    /**
     * Método que implementa la lógica del juego.
     */
    public static void jugar(Scanner scanner) {
        int numeroAleatorio = generarNumeroAleatorio();
        int numeroElegido;
        int intentos = 0;
        boolean adivinado = false;

        System.out.println("Estoy pensando en un número entre 1 y " + RANGO_MAXIMO + ".");
        System.out.println("¿Puedes adivinar cuál es?");

        while (!adivinado) {
            System.out.print("Por favor, ingrese un número: ");

            // Validación de entrada
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar la entrada inválida
                continue;
            }

            numeroElegido = scanner.nextInt();
            intentos++;

            if (numeroElegido == numeroAleatorio) {
                System.out.println("¡Felicidades! Adivinaste el número.");
                System.out.println("Lo lograste en " + intentos + " intentos.");
                adivinado = true;
                break;
            } else if (numeroElegido < numeroAleatorio) {
                System.out.println("El número que buscas es mayor. Inténtalo de nuevo.");
            } else {
                System.out.println("El número que buscas es menor. Inténtalo de nuevo.");
            }
        }
    }

    /**
     * Método que genera un número aleatorio entre 1 y RANGO_MAXIMO.
     */
    public static int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(RANGO_MAXIMO) + 1;
    }
}