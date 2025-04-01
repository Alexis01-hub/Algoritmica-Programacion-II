package Ejercicio10.model;

/**
 * Representa un empleado asalariado con un salario mensual fijo.
 */
public class EmpleadoAsalariado extends Empleado {
    private double salarioMensual;

    /**
     * Constructor para inicializar un empleado asalariado.
     * @param nombre Nombre del empleado.
     * @param dni DNI del empleado.
     * @param salarioMensual Salario mensual del empleado.
     */
    public EmpleadoAsalariado(String nombre, String dni, double salarioMensual) {
        super(nombre, dni);
        this.salarioMensual = salarioMensual;
    }

    /**
     * Obtiene el salario mensual del empleado.
     * @return Salario mensual del empleado.
     */
    public double getSalarioMensual() {
        return salarioMensual;
    }

    /**
     * Establece el salario mensual del empleado.
     * @param salarioMensual Nuevo salario mensual del empleado.
     */
    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    /**
     * Devuelve una representación en cadena del empleado asalariado.
     * @return Representación en cadena del empleado asalariado.
     */
    @Override
    public String toString() {
        return "Empleado Asalariado:\n" +
            "  Nombre: " + getNombre() + "\n" +
            "  DNI: " + getDni() + "\n" +
            "  Salario Mensual: $" + String.format("%.2f", salarioMensual);
    }
}
