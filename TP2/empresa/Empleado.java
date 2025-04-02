package empresa;

/**
 * Representa un empleado de una empresa que implementa la interfaz PorPagar.
 * Contiene información sobre el legajo, nombre, horas trabajadas, valor por hora
 * y un supervisor opcional.
 */
public class Empleado implements PorPagar {

	// Atributos
	/** Número de legajo del empleado. */
	private int legajo;

	/** Nombre del empleado. */
	private String nombre;

	/** Cantidad de horas trabajadas por el empleado. */
	private int horasTrabajadas;

	/** Valor por hora trabajada del empleado. */
	private double valorHora;

	/** Supervisor directo del empleado. Puede ser null si no tiene supervisor. */
	private Empleado supervisor;

	/**
	 * Constructor para inicializar un empleado.
	 *
	 * @param legajo Número de legajo del empleado.
	 * @param nombre Nombre del empleado.
	 * @param supervisor Supervisor directo del empleado. Puede ser null.
	 * @param horas_Trabajadas Cantidad de horas trabajadas por el empleado.
	 * @param valorHora Valor por hora trabajada del empleado.
	 */
	public Empleado(int legajo, String nombre, Empleado supervisor, int horas_Trabajadas, double valorHora) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.supervisor = supervisor;
		this.horasTrabajadas = horas_Trabajadas;
		this.valorHora = valorHora;
	}

	/**
	 * Calcula el sueldo del empleado basado en las horas trabajadas y el valor por hora.
	 *
	 * @return El sueldo calculado o 0.0 si los valores son inválidos.
	 */
	public double obtenerPago() {
		if (horasTrabajadas > 0 && valorHora > 0) { 
			return horasTrabajadas * valorHora; //si las horas con mayores a 0 y el valor por hora tambien. Entonces calcula el pago.
		}
		return 0.0;
	}

	/**
	 * Devuelve una representación en forma de cadena del empleado.
	 *
	 * @return Una cadena con los detalles del empleado, incluyendo el supervisor si existe.
	 */
	@Override
	public String toString() {
		if (supervisor == null)
			return "Legajo: "+legajo+"\n"+"Nombre: "+nombre+"\n"+"Supervisor: No tiene supervisor"+"\n"+"Horas trabajadas: "+horasTrabajadas+"\n"+"Valor por hora: $"+valorHora+"\n";

		return "Legajo: "+legajo+"\n"+"Nombre: "+nombre+"\n"+"Horas trabajadas: "+horasTrabajadas+"\n"+"Valor por hora: $"+valorHora+"\n";
	}

}
