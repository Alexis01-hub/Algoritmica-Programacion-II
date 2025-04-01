package Empleado.model;

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
     * Devuelve una representación en cadena del empleado con salario base más comisión.
     * @return Representación en cadena del empleado.
     */
    @Override
    public String toString() {
        return "EmpleadoBaseMasComision{" +
                "salarioBase=" + salarioBase +
                ", porcentajeComision=" + getPorcentajeComision() +
                ", ventasBrutas=" + getVentasBrutas() +
                ", nombre='" + getNombre() + '\'' +
                ", dni='" + getDni() + '\'' +
                '}';
    }
    
}
