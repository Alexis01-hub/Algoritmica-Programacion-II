package ConjuntoEnteros;

import java.util.Scanner;

/**
 * Clase principal para interactuar con conjuntos de enteros.
 * Permite realizar operaciones como unión, intersección, diferencia,
 * eliminación de elementos y comparación de igualdad entre conjuntos.
 */
public class AplicacionConjuntoEnteros {

    /**
     * Método principal que ejecuta la aplicación.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConjuntoEnteros conjunto1 = new ConjuntoEnteros();
        ConjuntoEnteros conjunto2 = new ConjuntoEnteros();

        /**
         * Solicita al usuario ingresar el primer conjunto de enteros.
         * Los valores deben estar en el rango de 0 a 100.
         */
        System.out.println("Ingrese el primer conjunto de enteros (0-100) separados por espacios:");
        String[] entrada1 = scanner.nextLine().split(" ");
        for (String num : entrada1) {
            conjunto1.insertarElemento(Integer.parseInt(num));
        }

        /**
         * Solicita al usuario ingresar el segundo conjunto de enteros.
         * Los valores deben estar en el rango de 0 a 100.
         */
        System.out.println("Ingrese el segundo conjunto de enteros (0-100) separados por espacios:");
        String[] entrada2 = scanner.nextLine().split(" ");
        for (String num : entrada2) {
            conjunto2.insertarElemento(Integer.parseInt(num));
        }

        /**
         * Permite al usuario eliminar elementos de los conjuntos ingresados.
         */
        System.out.println("Desea eliminar algun elemento de los conjuntos? (si/no)");
        String respuesta = scanner.nextLine();
        while (respuesta.equalsIgnoreCase("si")) {
            System.out.println("¿De cuál conjunto desea eliminar un elemento? (Ingrese el número del conjunto, por ejemplo: 1 o 2)");
            int conjuntoSeleccionado = scanner.nextInt();
            System.out.println("Ingrese el elemento a eliminar:");
            int elemento = scanner.nextInt();

            switch (conjuntoSeleccionado) {
            case 1:
                conjunto1.eliminarElemento(elemento);
                break;
            case 2:
                conjunto2.eliminarElemento(elemento);
                break;
            default:
                System.out.println("Conjunto no válido.");
            }

            scanner.nextLine(); // Consumir el salto de línea restante
            System.out.println("¿Desea eliminar otro elemento? (si/no)");
            respuesta = scanner.nextLine();
        }

        /**
         * Solicita al usuario seleccionar una operación entre los conjuntos:
         * 1. Unión
         * 2. Intersección
         * 3. Diferencia
         */
        System.out.println("Seleccione una operación:");
        System.out.println("1. Unión");
        System.out.println("2. Intersección");
        System.out.println("3. Diferencia");
        int opcion = scanner.nextInt();

        ConjuntoEnteros resultado = new ConjuntoEnteros();
        switch (opcion) {
            case 1:
                resultado = conjunto1.union(conjunto2);
                System.out.println("Resultado de la unión: " + resultado.aStringConjunto());
                break;
            case 2:
                resultado = conjunto1.interseccion(conjunto2);
                System.out.println("Resultado de la intersección: " + resultado.aStringConjunto());
                break;
            case 3:
                resultado = conjunto1.diferencia(conjunto2);
                System.out.println("Resultado de la diferencia: " + resultado.aStringConjunto());
                break;
            default:
                System.out.println("Opción no válida.");
        }

        /**
         * Permite al usuario verificar si los dos conjuntos iniciales son iguales.
         */
        System.out.println("¿Desea verificar si los dos conjuntos son iguales? (si/no)");
        scanner.nextLine(); // Consumir el salto de línea restante
        String respuestaIgualdad = scanner.nextLine();
        if (respuestaIgualdad.equalsIgnoreCase("si")) {
            if (conjunto1.esIgualA(conjunto2)) {
                System.out.println("Los conjuntos son iguales.");
            } else {
                System.out.println("Los conjuntos no son iguales.");
            }
        }

        /**
         * Permite al usuario comparar un conjunto inicial con el conjunto resultante
         * de la operación seleccionada.
         */
        System.out.println("¿Desea comparar un conjunto inicial con el conjunto resultante? (si/no)");
        String respuestaComparacion = scanner.nextLine();
        if (respuestaComparacion.equalsIgnoreCase("si")) {
            System.out.println("¿Con cuál conjunto inicial desea comparar? (Ingrese el número del conjunto, por ejemplo: 1 o 2)");
            int conjuntoSeleccionado = scanner.nextInt();

            switch (conjuntoSeleccionado) {
                case 1:
                    if (conjunto1.esIgualA(resultado)) {
                        System.out.println("El conjunto 1 es igual al conjunto resultante.");
                    } else {
                        System.out.println("El conjunto 1 no es igual al conjunto resultante.");
                    }
                    break;
                case 2:
                    if (conjunto2.esIgualA(resultado)) {
                        System.out.println("El conjunto 2 es igual al conjunto resultante.");
                    } else {
                        System.out.println("El conjunto 2 no es igual al conjunto resultante.");
                    }
                    break;
                default:
                    System.out.println("Conjunto no válido.");
            }
        }

        scanner.close();
    }
}
