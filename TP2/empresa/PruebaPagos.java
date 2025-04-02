package empresa;

/*Esta clase es para probar las clases Factura y Empleado, poniéndolos en el arreglo llamado 'pagos'
 * que es de tipo PorPagar.
 */
public class PruebaPagos {

	public static void main(String[] args) {

		// Empiezo a instanciar los objetos de clase Facturas y Empleados
		PorPagar pagos[] = new PorPagar[10]; // Arreglo que almacena objetos que implementan la interfaz PorPagar

		//------ Cargo los cinco empleados y un empleado es el supervisor de los otros ------
		Empleado supervisorJuan = new Empleado(1, "Juan", null, 70, 5000); // Supervisor sin supervisor propio
		pagos[0] = supervisorJuan; // Asignar el supervisor al arreglo
		pagos[1] = new Empleado(2, "Pedro", supervisorJuan, 40, 100); // Empleado con supervisor
		pagos[2] = new Empleado(3, "Sanchez", supervisorJuan, 60, 300); // Empleado con supervisor
		pagos[3] = new Empleado(4, "Jose", null, 0, 0); // Empleado sin supervisor
		pagos[4] = new Empleado(5, "Maria", null, 0, 0); // Empleado sin supervisor
		// ------ Cargo las cinco facturas ------
		// Cada factura se crea con un proveedor, número y fecha, y se le agregan ítems
		pagos[5] = crearFacturaConItems("Proveedor1", 1234, "2023-10-01");
		pagos[6] = crearFacturaConItems("Proveedor2", 1235, "2023-10-02");
		pagos[7] = crearFacturaConItems("Proveedor3", 1236, "2023-10-03");
		pagos[8] = crearFacturaConItems("Proveedor4", 1237, "2023-10-04");
		pagos[9] = crearFacturaConItems("Proveedor5", 1238, "2023-10-05");
		// ------ Mostrar los Pagos ------
		// Iterar sobre el arreglo 'pagos' para mostrar el tipo de objeto y el monto a pagar
		String tipo; // Variable para guardar el tipo de objeto que es el elemento del arreglo pagos[].
		for (int i = 0; i < pagos.length; i++) { 
			if (pagos[i] instanceof Empleado) { // Verifica si el objeto en pagos[i] es de tipo Empleado
				tipo = "Empleado";
				System.out.printf("%s%2d: $%.2f %n", tipo, i+1, pagos[i].obtenerPago());
			} else { // Si no es Empleado, entonces es Factura
				tipo = "Factura";
				System.out.printf("%s %2d: $%.2f %n", tipo, i+1, pagos[i].obtenerPago());
			}
		}
	}

	// Método auxiliar para crear una factura con ítems predefinidos
	private static Factura crearFacturaConItems(String proveedor, int numero, String fecha) {
		Factura factura = new Factura(proveedor, numero, fecha); // Crear factura con datos básicos
		// Agregar ítems a la factura con descripción, cantidad y precio unitario
		factura.agregarItem("papitas slays de messi", 5, 500);
		factura.agregarItem("cocacola", 10, 1000);
		factura.agregarItem("gomitas", 100, 100);
		factura.agregarItem("pepsi", 100, 100);
		factura.agregarItem("chocolate", 100, 100);
		factura.agregarItem("agua", 100, 100);
		factura.agregarItem("jugo", 100, 100);
		factura.agregarItem("galletas", 100, 100);
		factura.agregarItem("yerba", 100, 100);
		factura.agregarItem("chicle", 100, 100);
		return factura; // Retornar la factura creada
	}
}
