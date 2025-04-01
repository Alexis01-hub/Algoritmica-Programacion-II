package Ejercicio10.model;

/**
 * Representa un empleado que trabaja por horas.
 */
public class EmpleadoHora extends Empleado {
    private double valorHora;
    private double horasTrabajadas;

    /**
     * Constructor para inicializar un empleado por horas.
     * @param nombre Nombre del empleado.
     * @param dni DNI del empleado.
     * @param valorHora Valor por hora trabajada.
     * @param horasTrabajadas Horas trabajadas.
     */
    public EmpleadoHora(String nombre, String dni, double valorHora, double horasTrabajadas) {
        super(nombre, dni);
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    /**
     * Obtiene el valor por hora trabajada.
     * @return Valor por hora trabajada.
     */
    public double getValorHora() {
        return valorHora;
    }

    /**
     * Establece el valor por hora trabajada.
     * @param valorHora Nuevo valor por hora trabajada.
     */
    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    /**
     * Obtiene las horas trabajadas.
     * @return Horas trabajadas.
     */
    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    /**
     * Establece las horas trabajadas.
     * @param horasTrabajadas Nuevas horas trabajadas.
     */
    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    /**
     * Devuelve una representación en cadena del empleado por horas.
     * @return Representación en cadena del empleado.
     */
    @Override
    public String toString() {
        return "EmpleadoHora{" +
                "valorHora=" + valorHora +
                ", horasTrabajadas=" + horasTrabajadas +
                ", nombre='" + getNombre() + '\'' +
                ", dni='" + getDni() + '\'' +
                '}';
    }
    
}