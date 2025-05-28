import Empleado.model.Empleado;
import hash.*;

/**
 * Ejemplo de uso de Map para cargar la nómina de empleados en una empresa.
 * Se utiliza como clave el número de DNI del empleado y como valor el nombre.
 * Se prueban los métodos: remove, keySet, values y entrySet.
 * Cambia la implementación del mapa para probar UnsortedTableMap, ChainHashMap o ProbeHashMap.
 *
 * Ejercicio 2.7 - Algoritmica y Programación II
 */
public class Prueba {
    public static void main(String[] args) {
        // Crear los empleados y almacenarlos en un array
        Empleado personas[] = new Empleado[5];
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Empleado("DNI" + (i + 1), "Empleado" + (i + 1));
        }

        // Crear el mapa (puedes cambiar la implementación para probar otras)
        //UnsortedTableMap<Long, String> map = new UnsortedTableMap<Long, String>();
        //ChainHashMap<Long, String> map = new ChainHashMap<Long, String>();
        ProbeHashMap<Long, String> map = new ProbeHashMap<Long, String>();

        // Insertar los empleados en el mapa usando el DNI como clave
        for (int i = 0; i < personas.length; i++) {
            map.put((long) (i + 1), personas[i].getNombre());
        }

        // Mostrar el mapa usando keySet
        System.out.println("Contenido del mapa:");
        for (Long key : map.keySet()) {
            System.out.println("Clave: " + key + ", Valor: " + map.get(key));
        }

        // Mostrar solo los valores (values)
        System.out.println("\nValores del mapa:");
        for (String value : map.values()) {
            System.out.println("Valor: " + value);
        }

        // Mostrar todas las entradas (entrySet)
        System.out.println("\nEntradas del mapa:");
        for (Entry<Long, String> entry : map.entrySet()) {
            System.out.println("Entrada: Clave = " + entry.getKey() + ", Valor = " + entry.getValue());
        }

        // Probar el método remove
        System.out.println("\nEliminando al empleado con clave 3...");
        String eliminado = map.remove(3L);
        if (eliminado != null) {
            System.out.println("Empleado eliminado: " + eliminado);
        } else {
            System.out.println("No se encontró empleado con clave 3.");
        }

        // Mostrar el mapa después de eliminar
        System.out.println("\nMapa después de eliminar:");
        for (Entry<Long, String> entry : map.entrySet()) {
            System.out.println("Entrada: Clave = " + entry.getKey() + ", Valor = " + entry.getValue());
        }
    }
}
