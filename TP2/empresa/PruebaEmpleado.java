package empresa;

import java.util.ArrayList;
import java.util.List;

// En esta clase se prueba la clase Empleado.
public class PruebaEmpleado {
	public static void main(String[] args) {
		// Crear una lista para almacenar los empleados
		List<Empleado> empleados = new ArrayList<>();

		// Crear un empleado que será el supervisor
		Empleado supervisorJuan = new Empleado(1, "Juan", null, 70, 5000);

		// Crear empleados y asignar el supervisor
		empleados.add(supervisorJuan); // Agregar el supervisor a la lista
		empleados.add(new Empleado(2, "Pedro", supervisorJuan, 40, 100)); // Empleado con supervisor
		empleados.add(new Empleado(3, "Sanchez", supervisorJuan, 60, 300)); // Empleado con supervisor
		empleados.add(new Empleado(4, "Jose", null, 0, 0)); // Empleado sin supervisor
		empleados.add(new Empleado(5, "Maria", null, 0, 0)); // Empleado sin supervisor

		// Mostrar la lista de empleados
		System.out.println("-------------------lista de empleados-------------------");
		
		// Iterar sobre la lista de empleados y mostrar su información
		for (Empleado empleado : empleados) {
			System.out.println(empleado.toString()); // Mostrar información básica del empleado
			System.out.println("Sueldo: $" + empleado.obtenerPago()); // Mostrar el sueldo calculado
			System.out.println("==================================");
		}
	}

}



