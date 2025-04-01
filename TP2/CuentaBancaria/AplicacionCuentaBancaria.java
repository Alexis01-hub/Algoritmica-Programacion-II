package CuentaBancaria;

import CuentaBancaria.logica.*;
import java.util.Scanner;

/**
 * Clase principal que representa la aplicación bancaria.
 * Permite al usuario interactuar con diferentes tipos de cuentas bancarias.
 */
public class AplicacionCuentaBancaria {

    /**
     * Método principal que ejecuta la aplicación bancaria.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la Aplicación Bancaria.");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su CUIT: ");
        String cuit = scanner.nextLine();
        System.out.print("Ingrese su dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese su correo electrónico: ");
        String email = scanner.nextLine();

        // Crear un cliente con los datos ingresados por el usuario
        Cliente cliente = new Cliente(nombre, cuit, direccion, email);
        CuentaBancaria cuenta = null;

        while (true) {
            System.out.println("\n--- Menú de la Aplicación Bancaria ---");
            System.out.println("1. Crear Caja de Ahorro");
            System.out.println("2. Crear Cuenta Corriente");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Mostrar Información de la Cuenta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el saldo inicial: ");
                    double saldoCaja = scanner.nextDouble();
                    cuenta = new CajaAhorro("CA123", cliente.getNombre(), saldoCaja);
                    System.out.println("Caja de Ahorro creada exitosamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el saldo inicial: ");
                    double saldoCorriente = scanner.nextDouble();
                    System.out.print("Ingrese el límite fijo: ");
                    double limiteFijo = scanner.nextDouble();
                    cuenta = new CuentaCorriente("CC123", cliente.getNombre(), saldoCorriente, limiteFijo);
                    System.out.println("Cuenta Corriente creada exitosamente.");
                    break;

                case 3:
                    if (cuenta == null) {
                        System.out.println("Primero debe crear una cuenta.");
                    } else {
                        System.out.print("Ingrese el monto a depositar: ");
                        double montoDeposito = scanner.nextDouble();
                        cuenta.depositar(montoDeposito);
                    }
                    break;

                case 4:
                    if (cuenta == null) {
                        System.out.println("Primero debe crear una cuenta.");
                    } else {
                        System.out.print("Ingrese el monto a retirar: ");
                        double montoRetiro = scanner.nextDouble();
                        cuenta.retirar(montoRetiro);
                    }
                    break;

                case 5:
                    if (cuenta == null) {
                        System.out.println("Primero debe crear una cuenta.");
                    } else {
                        System.out.println("\n--- Información de la Cuenta ---");
                        System.out.println(cuenta);
                        System.out.println("Cliente: " + cliente);
                    }
                    break;

                case 6:
                    System.out.println("Gracias por usar la aplicación bancaria.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
