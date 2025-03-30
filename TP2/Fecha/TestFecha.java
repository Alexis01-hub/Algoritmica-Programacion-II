package Fecha;

/**
 * Clase de prueba para la clase Fecha.
 * Permite verificar el correcto funcionamiento de las operaciones de manipulación de fechas.
 */
public class TestFecha {
    /**
     * Método principal para ejecutar las pruebas de la clase Fecha.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Fecha fecha1 = new Fecha(29, 3, 2025);
        Fecha fecha2 = new Fecha(31, 12, 2023);

        System.out.println("Fecha 1: " + fecha1);
        System.out.println("Fecha 2: " + fecha2);

        // Test de comparación
        System.out.println("Fecha 1 es mayor que Fecha 2: " + fecha1.esMayor(fecha2));
        System.out.println("Fecha 1 es menor que Fecha 2: " + fecha1.esMenor(fecha2));
        System.out.println("Fecha 1 es igual a Fecha 2: " + fecha1.esIgual(fecha2));

        // Test de diferencia de días
        System.out.println("Diferencia en días entre Fecha 1 y Fecha 2: " + fecha1.diferencia(fecha2));

        // Test de sumar días
        Fecha nuevaFecha = fecha2.sumarDias(10);
        System.out.println("Fecha 2 después de sumar 10 días: " + nuevaFecha);

        // Test de restar días
        nuevaFecha = fecha2.sumarDias(-15);
        System.out.println("Fecha 2 después de restar 15 días: " + nuevaFecha);

        // Test de día de la semana
        System.out.println("Día de la semana de Fecha 1: " + fecha1.diaDeLaSemana());
        System.out.println("Día de la semana de Fecha 2: " + fecha2.diaDeLaSemana());
    }
}
