package temperatura;

import java.util.Scanner;

/**
 * Clase principal que permite al usuario elegir entre convertir de Fahrenheit a Celsius o de Celsius a Fahrenheit.
 */
public class Temperatura {
    public static void main(String[] args) {
        double fahrenheit;
        double centigrados;
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Seleccione la conversión que desea realizar:");
        System.out.println("1. Fahrenheit a Celsius");
        System.out.println("2. Celsius a Fahrenheit");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Introduzca la temperatura en Fahrenheit: ");
                fahrenheit = scanner.nextDouble();
                System.out.println(fahrenheit + " grados Fahrenheit son " + 
                    String.format("%.2f", conversorTemperatura.fahrToCent(fahrenheit)) + " grados Celsius");
                break;
            case 2:
                System.out.println("Introduzca la temperatura en Celsius: ");
                centigrados = scanner.nextDouble();
                System.out.println(centigrados + " grados Celsius son " + 
                    String.format("%.2f", conversorTemperatura.centToFahr(centigrados)) + " grados Fahrenheit");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        scanner.close();
    }
}
