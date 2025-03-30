package Fecha;


/**
 * Clase que representa una fecha con día, mes y año.
 * Proporciona métodos para manipular y validar fechas.
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    /**
     * Constructor de la clase Fecha.
     * 
     * @param dia  Día de la fecha.
     * @param mes  Mes de la fecha.
     * @param anio Año de la fecha.
     * @throws IllegalArgumentException Si la fecha no es válida.
     */
    public Fecha(int dia, int mes, int anio) {
        if (!esFechaValida(dia, mes, anio)) {
            throw new IllegalArgumentException("Fecha no válida: " + dia + "/" + mes + "/" + anio);
        }
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Obtiene el día de la fecha.
     * 
     * @return Día de la fecha.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Establece el día de la fecha.
     * 
     * @param dia Nuevo día de la fecha.
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Obtiene el mes de la fecha.
     * 
     * @return Mes de la fecha.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Establece el mes de la fecha.
     * 
     * @param mes Nuevo mes de la fecha.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Obtiene el año de la fecha.
     * 
     * @return Año de la fecha.
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Establece el año de la fecha.
     * 
     * @param anio Nuevo año de la fecha.
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Avanza la fecha al día siguiente.
     * Ajusta el mes y el año si es necesario.
     */
    public void diaSiguiente() {
        dia++;
        if (!esFechaValida(dia, mes, anio)) {
            dia = 1;
            mes++;
            if (mes > 12) {
                mes = 1;
                anio++;
            }
        }
    }

    /**
     * Retrocede la fecha al día anterior.
     * Ajusta el mes y el año si es necesario.
     */
    public void diaAnterior() {
        dia--;
        if (dia < 1) {
            mes--;
            if (mes < 1) {
                mes = 12;
                anio--;
            }
            // Array con los días máximos por mes (no bisiesto)
            int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
            // Ajuste para febrero en año bisiesto
            if (mes == 2 && esBisiesto(anio)) {
                dia = 29;
            } else {
                dia = diasPorMes[mes - 1];
            }
        }
    }

    /**
     * Devuelve una representación en formato "dd/MM/yyyy" de la fecha.
     * 
     * @return Cadena que representa la fecha.
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }

    /**
     * Verifica si una fecha es válida.
     * 
     * @param dia  Día de la fecha.
     * @param mes  Mes de la fecha.
     * @param anio Año de la fecha.
     * @return true si la fecha es válida, false en caso contrario.
     */
    private boolean esFechaValida(int dia, int mes, int anio) {
        if (anio < 1) {
            return false; // El año debe ser positivo
        }
        if (mes < 1 || mes > 12) {
            return false; // El mes debe estar entre 1 y 12
        }
        // Array con los días máximos por mes (no bisiesto)
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Ajuste para febrero en año bisiesto
        if (mes == 2 && esBisiesto(anio)) {
            return dia >= 1 && dia <= 29;
        }

        // Validación del día para los demás meses
        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    /**
     * Determina si un año es bisiesto.
     * 
     * @param anio Año a verificar.
     * @return true si el año es bisiesto, false en caso contrario.
     */
    private boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
        
    }

    public boolean esMayor(Fecha otra) {
        return FechaUtil.esMayor(this, otra);
    }

    public boolean esMenor(Fecha otra) {
        return FechaUtil.esMenor(this, otra);
    }

    public boolean esIgual(Fecha otra) {
        return FechaUtil.esIgual(this, otra);
    }

    public int diferencia(Fecha otra) {
        return FechaUtil.diferencia(this, otra);
    }

    public Fecha sumarDias(int dias) {
        return FechaUtil.sumarDias(this, dias);
    }

    public String diaDeLaSemana() {
        return FechaUtil.diaDeLaSemana(this);
    }
}
