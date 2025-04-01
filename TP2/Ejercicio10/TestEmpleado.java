package Ejercicio10;

import Empleado.model.EmpleadoAsalariado;
import Empleado.model.EmpleadoBaseMasComision;
import Empleado.model.EmpleadoHora;
import Empleado.model.EmpleadoPorComision;

/**
 * Clase de prueba para demostrar el uso de las clases de empleados.
 */
public class TestEmpleado {
    /**
     * Método principal para crear y mostrar diferentes tipos de empleados.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Juan", "12345678", 3000);
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Maria", "87654321", 0.1, 50000);
        EmpleadoHora empleadoHora = new EmpleadoHora("Pedro", "11223344", 20, 160);
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision("Ana", "44332211", 0.15, 60000, 2000);
        System.out.println(empleadoAsalariado.toString());
        System.out.println(empleadoPorComision.toString());
        System.out.println(empleadoHora.toString());
        System.out.println(empleadoBaseMasComision.toString());

    }
}
