import java.util.Scanner;
import java.util.Stack;

/**
 * Clase que gestiona una nómina de empleados utilizando una pila.
 * Permite cargar empleados y calcular sus sueldos.
 */
public class NominaEmpleados {
    private Stack<Empleado> pilaEmpleados;

    /**
     * Constructor de la clase NominaEmpleados.
     * Inicializa la pila de empleados.
     */
    public NominaEmpleados() {
        pilaEmpleados = new Stack<>();
    }

    /**
     * Método para cargar empleados en la pila.
     * Solicita al usuario ingresar los datos de los empleados (nombre, horas trabajadas y pago por hora).
     * Los datos se almacenan en la pila como objetos de tipo {@link Empleado}.
     */
    public void cargarEmpleados() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese la cantidad de empleados: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            for (int i = 0; i < n; i++) {
                System.out.print("Ingrese el nombre del empleado: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingrese las horas trabajadas: ");
                int horasTrabajadas = scanner.nextInt();

                System.out.print("Ingrese el pago por hora: ");
                double pagoPorHora = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea

                pilaEmpleados.push(new Empleado(nombre, horasTrabajadas, pagoPorHora));
            }
        } finally {
            scanner.close(); // Cerrar el Scanner para liberar recursos
        }
    }

    /**
     * Método para mostrar los sueldos de los empleados.
     * Calcula y muestra el sueldo de cada empleado almacenado en la pila.
     * Los empleados se procesan en orden inverso al que fueron ingresados (LIFO).
     */
    public void mostrarSueldos() {
        System.out.println("\nSueldo de los empleados:");
        while (!pilaEmpleados.isEmpty()) {
            Empleado empleado = pilaEmpleados.pop();
            System.out.println("Empleado: " + empleado.getNombre() +
                               ", Sueldo: $" + empleado.calcularSueldo());
        }
    }
}
