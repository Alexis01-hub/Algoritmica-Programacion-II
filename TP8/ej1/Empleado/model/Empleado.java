package Empleado.model;

/**
 * Clase base que representa un empleado genérico.
 */
public class Empleado {
    private String nombre;
    private String dni;

    /**
     * Constructor para inicializar un empleado con nombre y DNI.
     * @param nombre Nombre del empleado.
     * @param dni DNI del empleado.
     */
    public Empleado(String dni, String nombre) {
        this.nombre = nombre;
        this.dni = dni;
    }

    /**
     * Obtiene el DNI del empleado.
     * @return DNI del empleado.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del empleado.
     * @param dni Nuevo DNI del empleado.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * @param nombre Nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve una representación en cadena del empleado.
     * @return Representación en cadena del empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
