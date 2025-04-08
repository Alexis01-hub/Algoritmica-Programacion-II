public class PruebaLista {

	public static void main(String[] args) {
		Lista<Empleado> lista = new Lista<Empleado>(5);

		Empleado e1 = new Empleado(100, "Juan");
		Empleado e2 = new Empleado(110, "Ana");
		Empleado e3 = new Empleado(120, "Pedro");
		Empleado e4 = new Empleado(120, "Maria"); // crear una excepción para cuando ingrese el 4 elemento a la lista

		System.out.println("=== Prueba de agregar elementos ===");
		try {
			lista.add(e1);
			lista.add(e2);
			lista.add(e3);
			lista.add(e4); // Esto debería lanzar una excepción
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Excepción capturada al agregar: " + e.getMessage());
		}
		System.out.println("Lista actual:\n" + lista);

		System.out.println("\n=== Prueba de agregar en una posición específica ===");
		try {
			lista.add(1, new Empleado(130, "Luis"));
			System.out.println("Lista después de agregar en posición 1:\n" + lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Excepción capturada al agregar en posición: " + e.getMessage());
		}

		System.out.println("\n=== Prueba de obtener elementos ===");
		try {
			System.out.println("Elemento en índice 0: " + lista.get(0));
			System.out.println("Elemento en índice 1: " + lista.get(1));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Excepción capturada al obtener: " + e.getMessage());
		}

		System.out.println("\n=== Prueba de eliminar por elemento ===");
		Empleado eEliminar = new Empleado(120, "Pedro");

		Empleado eliminado = lista.remove(eEliminar);
		if (eliminado != null) {
			System.out.println("Elemento eliminado: " + eliminado);
		} else {
			System.out.println("Elemento no encontrado para eliminar: " + eEliminar);
		}
		System.out.println("Lista después de eliminar por elemento:\n" + lista);

		System.out.println("\n=== Prueba de eliminar por índice ===");
		try {
			System.out.println("Eliminando elemento en índice 1...");
			lista.remove(1);
			System.out.println("Lista después de eliminar en índice 1:\n" + lista);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Excepción capturada al eliminar: " + e.getMessage());
		}

		System.out.println("\n=== Contenido final de la lista ===");
		System.out.println(lista);
	}
}
