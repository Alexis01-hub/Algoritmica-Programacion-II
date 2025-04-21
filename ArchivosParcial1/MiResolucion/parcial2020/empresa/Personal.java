package ArchivosParcial1.MiResolucion.parcial2020.empresa;

public abstract class Personal {
    private String nombre;
    private String dni;
    private Departamento departamento; // Se agregó el atributo departamento
    // Constructor de la clase Personal

    public Personal(String nombre, String dni, Departamento departamento) {
        this.departamento = departamento; // Inicializa el departamento
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public abstract double calcularSueldo(); // Método abstracto para calcular sueldo

    @Override
    public String toString() {
        return "Personal [nombre=" + nombre + ", dni=" + dni + ", departamento=" + departamento + "]";
    }

    public String getNombre() {
        return nombre;
    }
    public String getDni() {
        return dni;
    }
    public Departamento getDepartamento() {
        return departamento; // Método para obtener el departamento
    }

}
