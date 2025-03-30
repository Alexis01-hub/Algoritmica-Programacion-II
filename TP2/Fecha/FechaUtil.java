package Fecha;

import java.time.LocalDate;

/**
 * Clase utilitaria para realizar operaciones con objetos de tipo Fecha.
 */
public class FechaUtil {

    /**
     * Verifica si una fecha es mayor que otra fecha dada.
     * 
     * @param fecha1 Primera fecha.
     * @param fecha2 Segunda fecha.
     * @return true si la primera fecha es mayor, false en caso contrario.
     */
    public static boolean esMayor(Fecha fecha1, Fecha fecha2) {
        if (fecha1.getAnio() > fecha2.getAnio()) {
            return true;
        } else if (fecha1.getAnio() == fecha2.getAnio()) {
            if (fecha1.getMes() > fecha2.getMes()) {
                return true;
            } else if (fecha1.getMes() == fecha2.getMes()) {
                return fecha1.getDia() > fecha2.getDia();
            }
        }
        return false;
    }

    /**
     * Verifica si una fecha es menor que otra fecha dada.
     * 
     * @param fecha1 Primera fecha.
     * @param fecha2 Segunda fecha.
     * @return true si la primera fecha es menor, false en caso contrario.
     */
    public static boolean esMenor(Fecha fecha1, Fecha fecha2) {
        if (fecha1.getAnio() < fecha2.getAnio()) {
            return true;
        } else if (fecha1.getAnio() == fecha2.getAnio()) {
            if (fecha1.getMes() < fecha2.getMes()) {
                return true;
            } else if (fecha1.getMes() == fecha2.getMes()) {
                return fecha1.getDia() < fecha2.getDia();
            }
        }
        return false;
    }

    /**
     * Verifica si dos fechas son iguales.
     * 
     * @param fecha1 Primera fecha.
     * @param fecha2 Segunda fecha.
     * @return true si las fechas son iguales, false en caso contrario.
     */
    public static boolean esIgual(Fecha fecha1, Fecha fecha2) {
        return fecha1.getDia() == fecha2.getDia() &&
               fecha1.getMes() == fecha2.getMes() &&
               fecha1.getAnio() == fecha2.getAnio();
    }

    /**
     * Calcula la diferencia en días entre dos fechas.
     * 
     * @param fecha1 Primera fecha.
     * @param fecha2 Segunda fecha.
     * @return Número de días entre las dos fechas.
     */
    public static int diferencia(Fecha fecha1, Fecha fecha2) {
        LocalDate fechaLocal1 = LocalDate.of(fecha1.getAnio(), fecha1.getMes(), fecha1.getDia());
        LocalDate fechaLocal2 = LocalDate.of(fecha2.getAnio(), fecha2.getMes(), fecha2.getDia());
        return (int) Math.abs(java.time.temporal.ChronoUnit.DAYS.between(fechaLocal1, fechaLocal2));
    }

    /**
     * Calcula una nueva fecha sumando o restando una cantidad de días.
     * 
     * @param fecha Fecha base.
     * @param dias  Cantidad de días a sumar (positivo) o restar (negativo).
     * @return Nueva fecha resultante.
     */
    public static Fecha sumarDias(Fecha fecha, int dias) {
        LocalDate fechaLocal = LocalDate.of(fecha.getAnio(), fecha.getMes(), fecha.getDia());
        LocalDate nuevaFecha = fechaLocal.plusDays(dias);
        return new Fecha(nuevaFecha.getDayOfMonth(), nuevaFecha.getMonthValue(), nuevaFecha.getYear());
    }

    /**
     * Devuelve el día de la semana de una fecha dada.
     * 
     * @param fecha Fecha a evaluar.
     * @return Día de la semana como cadena (por ejemplo, "Lunes").
     */
    public static String diaDeLaSemana(Fecha fecha) {
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        LocalDate fechaLocal = LocalDate.of(fecha.getAnio(), fecha.getMes(), fecha.getDia());
        return diasSemana[fechaLocal.getDayOfWeek().getValue() - 1];
    }
}
