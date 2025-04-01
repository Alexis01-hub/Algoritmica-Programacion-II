package Ejercicio10.model;

/**
 * Representa un empleado con salario base más comisión.
 */
public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    private double salarioBase;

    /**
     * Constructor para inicializar un empleado con salario base más comisión.
     * @param nombre Nombre del empleado.
     * @param dni DNI del empleado.
     * @param porcentajeComision Porcentaje de comisión.
     * @param ventasBrutas Ventas brutas realizadas.
     * @param salarioBase Salario base del empleado.
     */
    public EmpleadoBaseMasComision(String nombre, String dni, double porcentajeComision, double ventasBrutas, double salarioBase) {
        super(nombre, dni, porcentajeComision, ventasBrutas);
        this.salarioBase = salarioBase;
    }

    /**
     * Obtiene el salario base del empleado.
     * @return Salario base del empleado.
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * Establece el salario base del empleado.
     * @param salarioBase Nuevo salario base del empleado.
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * Obtiene el salario total del empleado.
     * @return Salario total del empleado.
     */
    public double getSalario() {
        return salarioBase + (getPorcentajeComision() * getVentasBrutas());
    }

    /**
     * Establece el salario total del empleado.
     * @param nuevoSalario Nuevo salario total del empleado.
     */
    public void setSalario(double nuevoSalario) {
        this.salarioBase = nuevoSalario - (getPorcentajeComision() * getVentasBrutas());
    }

    /**
     * Devuelve una representación en cadena del empleado con salario base más comisión.
     * @return Representación en cadena del empleado.
     */
    @Override
    public String toString() {
        return String.format("Empleado Base Más Comisión: " + 
            "\n  Nombre: %s" + 
            "\n  DNI: %s" + 
            "\n  Salario Base: %.2f" + 
            "\n  Porcentaje Comisión: %.2f" + 
            "\n  Ventas Brutas: %.2f" + 
            "\n  Salario Total: %.2f", 
            getNombre(), getDni(), salarioBase, getPorcentajeComision(), getVentasBrutas(), getSalario());
    }
    
}
