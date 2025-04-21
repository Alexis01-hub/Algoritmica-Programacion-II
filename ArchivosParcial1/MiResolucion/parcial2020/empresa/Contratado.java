package ArchivosParcial1.MiResolucion.parcial2020.empresa;

public class Contratado extends Personal {
    private double valorhora;
    private double cantHoras;

    public Contratado(String nombre, String dni, double valorhora, double cantHoras, Departamento departamento) {
        super(nombre, dni, departamento); // Llama al constructor de la clase base (Personal)
        this.valorhora = valorhora;
        this.cantHoras = cantHoras;
    }

    @Override
    public double calcularSueldo() {
        return valorhora * cantHoras; // Retorna el sueldo del contratado
    }
}
