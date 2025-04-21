package ArchivosParcial1.MiResolucion.parcial2020.empresa;

public class Empleado extends Personal {
    private double sueldo;
    
    public Empleado(String nombre, String dni, double sueldo, Departamento departamento) {
        super(nombre, dni, departamento); // Llama al constructor de la clase base (Personal)
        this.sueldo = sueldo;
    }
    @Override
    public double calcularSueldo() {
        return sueldo; // Retorna el sueldo del empleado
    }

}
