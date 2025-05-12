public class Empleado {
    private String nombre;
    private int horasTrabajadas;
    private double pagoPorHora;

    public Empleado(String nombre, int horasTrabajadas, double pagoPorHora) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getPagoPorHora() {
        return pagoPorHora;
    }

    public double calcularSueldo() {
        return horasTrabajadas * pagoPorHora;
    }
}