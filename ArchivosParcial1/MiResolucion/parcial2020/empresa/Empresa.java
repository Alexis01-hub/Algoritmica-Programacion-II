package ArchivosParcial1.MiResolucion.parcial2020.empresa;


public class Empresa {
    private String nombre;
    private Personal personal[]; // Lista de empleados y contratados
    private static final int MAX_PERSONAL = 100; // Capacidad máxima de la lista de personal
    private int indice;

    public Empresa(String nombre) {
        this.nombre = nombre;
        personal = new Personal[MAX_PERSONAL];
        indice= 0; // Inicializa la lista de personal
    }

    public Personal agregarEmpleado(String nombre, String dni, Departamento departamento, double sueldo){
        if (indice == MAX_PERSONAL) {
            throw new IndexOutOfBoundsException("No se pueden agregar más empleados"); // Lanza excepción si se supera la capacidad
        }
        Personal p = new Empleado(nombre, dni, sueldo, departamento);
        personal[indice] = p; // Agrega un empleado a la lista
        indice++; // Incrementa el índice para el siguiente empleado
        return p; // Retorna el empleado creado 
    }
    public Personal agregarContratado(String nombre, String dni, Departamento departamento, double valorhora, double cantHoras){
        if (indice == MAX_PERSONAL) {
            throw new IndexOutOfBoundsException("No se pueden agregar más empleados"); // Lanza excepción si se supera la capacidad
        }
        Personal p = new Contratado(nombre, dni, valorhora, cantHoras, departamento);
        personal[indice] = p; // Agrega un contratado a la lista
        indice++; // Incrementa el índice para el siguiente contratado
        return p; // Retorna el contratado creado
    }

    public double calcularSueldos(){
        double total = 0;
        for(int i = 0; i < indice; i++){
            total += personal[i].calcularSueldo(); // Suma los sueldos de todos los empleados y contratados
        }
        return total; // Retorna el total de sueldos
    }

    public double calcularSueldo(Departamento departamento){
        double total = 0;
        for(int i=0; i < indice; i++){
            if (personal[i].getDepartamento().equals(departamento)) {
                total += personal[i].calcularSueldo(); // Suma los sueldos de los empleados y contratados del departamento especificado
            }
        }
        return total; // Retorna el total de sueldos del departamento
    }

    public String getNombre() {
        return nombre;
    }

}
