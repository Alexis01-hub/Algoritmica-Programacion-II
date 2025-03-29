import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        procesarNumero();
    }

    public static void procesarNumero() {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Ingrese un número:");
            int num = teclado.nextInt();

            if (esPar(num)) {
                System.out.println("El número es par");
            } else {
                System.out.println("El número es impar");
            }
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número entero.");
        }
    }

    public static boolean esPar(int num) {
        return num % 2 == 0;
    }
}
