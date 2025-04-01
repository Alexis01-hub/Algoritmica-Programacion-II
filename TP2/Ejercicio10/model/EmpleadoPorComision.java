package Ejercicio10.model;

/**
 * Representa un empleado que trabaja por comisión.
 */
public class EmpleadoPorComision extends Empleado {
    double porcentajeComision;
    double ventasBrutas;

    /**
     * Constructor para inicializar un empleado por comisión.
     * @param nombre Nombre del empleado.
     * @param dni DNI del empleado.
     * @param porcentajeComision Porcentaje de comisión.
     * @param ventasBrutas Ventas brutas realizadas.
     */
    public EmpleadoPorComision(String nombre, String dni, double porcentajeComision, double ventasBrutas) {
        super(nombre, dni);
        this.porcentajeComision = porcentajeComision;
        this.ventasBrutas = ventasBrutas;
    }

    /**
     * Obtiene el porcentaje de comisión.
     * @return Porcentaje de comisión.
     */
    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    /**
     * Establece el porcentaje de comisión.
     * @param porcentajeComision Nuevo porcentaje de comisión.
     */
    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    /**
     * Obtiene las ventas brutas realizadas.
     * @return Ventas brutas realizadas.
     */
    public double getVentasBrutas() {
        return ventasBrutas;
    }

    /**
     * Establece las ventas brutas realizadas.
     * @param ventasBrutas Nuevas ventas brutas realizadas.
     */
    public void setVentasBrutas(double ventasBrutas) {
        this.ventasBrutas = ventasBrutas;
    }

    /**
     * Devuelve una representación en cadena del empleado por comisión.
     * @return Representación en cadena del empleado.
     */
    @Override
    public String toString() {
        return "EmpleadoPorComision{" +
                "porcentajeComision=" + porcentajeComision +
                ", ventasBrutas=" + ventasBrutas +
                ", nombre='" + getNombre() + '\'' +
                ", dni='" + getDni() + '\'' +
                '}';
    }

}
