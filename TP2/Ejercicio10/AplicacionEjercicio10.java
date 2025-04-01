package Ejercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ejercicio10.model.Empleado;
import Ejercicio10.model.EmpleadoAsalariado;
import Ejercicio10.model.EmpleadoBaseMasComision;

/**
 * Aplicación para gestionar una lista de empleados y calcular sus salarios.
 * Permite ingresar empleados de tipo asalariado o base más comisión, y
 * aplica un incremento del 10% al salario total de los empleados base más comisión.
 */
public class AplicacionEjercicio10 {
    /** Número máximo de empleados que se pueden ingresar. */
    public static final int MAX_EMPLEADOS = 3;

    /**
     * Método principal que ejecuta la aplicación.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();
        int cont = 0;

        /**
         * Bucle para ingresar los datos de los empleados.
         * Permite ingresar empleados de tipo asalariado o base más comisión.
         * Maneja excepciones para entradas inválidas.
         */
        while (cont < MAX_EMPLEADOS) {
            try {
                System.out.println("-------------------- " + (cont + 1));
                System.out.println("Ingrese el nombre del empleado " + (cont + 1) + ": ");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese el DNI del empleado " + (cont + 1) + ": ");
                String dni = scanner.nextLine();
                System.out.println("Ingrese el salario mensual del empleado " + (cont + 1) + ": ");
                double salario = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
                System.out.println("Ingrese el tipo de empleado (1: Asalariado, 2: Base + Comision): ");
                int tipoEmpleado = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (tipoEmpleado == 1) {
                    empleados.add(new EmpleadoAsalariado(nombre, dni, salario));
                } else if (tipoEmpleado == 2) {
                    System.out.println("Ingrese el porcentaje de comisión: ");
                    double porcentajeComision = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese las ventas brutas: ");
                    double ventasBrutas = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea
                    empleados.add(new EmpleadoBaseMasComision(nombre, dni, porcentajeComision, ventasBrutas, salario));
                } else {
                    System.out.println("Tipo de empleado inválido. Intente nuevamente.");
                    continue;
                }
                cont++;
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Por favor, intente nuevamente.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        /**
         * Imprime el listado de empleados y sus salarios.
         * Para los empleados base más comisión, calcula y muestra el salario total
         * y el salario incrementado en un 10%.
         */
        System.out.println("\nListado de empleados y sus salarios:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoBaseMasComision) {
                EmpleadoBaseMasComision emp = (EmpleadoBaseMasComision) empleado;
                double salarioBase = emp.getSalario();
                double comision = emp.getVentasBrutas() * emp.getPorcentajeComision();
                double salarioTotal = salarioBase + comision;
                double salarioIncrementado = salarioTotal * 1.10; // Incrementar salario total en un 10%
                System.out.println("Empleado Base Más Comisión:");
                System.out.println("  Nombre: " + emp.getNombre());
                System.out.println("  DNI: " + emp.getDni());
                System.out.println("  Salario Base: " + salarioBase);
                System.out.println("  Porcentaje Comisión: " + emp.getPorcentajeComision());
                System.out.println("  Ventas Brutas: " + emp.getVentasBrutas());
                System.out.println("  Salario Total: " + salarioTotal + " (Salario incrementado: " + salarioIncrementado + ")");
            } else {
                System.out.println(empleado);
            }
        }

        scanner.close();
    }
}
