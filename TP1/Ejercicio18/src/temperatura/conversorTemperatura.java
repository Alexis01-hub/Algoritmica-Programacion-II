package temperatura;

/**
 * Clase que contiene métodos para convertir temperaturas entre Fahrenheit y Celsius.
 */
public class conversorTemperatura {
    /**
     * Método que convierte de Fahrenheit a Celsius.
     * 
     * @param fahrenheit Temperatura en grados Fahrenheit.
     * @return Temperatura convertida a grados Celsius.
     */
    public static double fahrToCent(double fahrenheit) {
        return 5.0 / 9.0 * (fahrenheit - 32);
    }

    /**
     * Método que convierte de Celsius a Fahrenheit.
     * 
     * @param centigrados Temperatura en grados Celsius.
     * @return Temperatura convertida a grados Fahrenheit.
     */
    public static double centToFahr(double centigrados) {
        return 9.0 / 5.0 * centigrados + 32;
    }
}