package src.juego;

import java.util.Scanner;

/**
 * Clase que implementa un juego para adivinar un número aleatorio.
 */
public class Juego {
    /**
     * Método principal que inicia el juego.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jugarDeNuevo = true;

        while (jugarDeNuevo) {
            LogicaJuego.jugar(scanner); // Llamada al método que contiene la lógica del juego

            // Preguntar al jugador si quiere volver a jugar
            System.out.print("¿Quieres jugar de nuevo? (s/n): ");
            String respuesta = scanner.next().trim().toLowerCase();

            if (!respuesta.equals("s")) {
                jugarDeNuevo = false;
                System.out.println("¡Gracias por jugar! Hasta la próxima.");
            }
        }

        scanner.close();
    }
}