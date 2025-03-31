package ConjuntoEnteros;

public class TestConjuntoEnteros {
    public static void main(String[] args) {
        // Crear dos instancias de ConjuntoEnteros
        ConjuntoEnteros conjunto1 = new ConjuntoEnteros();
        ConjuntoEnteros conjunto2 = new ConjuntoEnteros();

        // Mostrar los conjuntos iniciales
        System.out.println("--------------- Test de ConjuntoEnteros ---------");
        System.out.println("Conjunto 1: " + conjunto1.aStringConjunto()); // Conjunto vacío
        System.out.println("Conjunto 2: " + conjunto2.aStringConjunto()); // Conjunto vacío
        System.out.println("--------------------------------------------------");

        // Insertar elementos en los conjuntos
        System.out.println("Insertando elementos en el conjunto 1 y 2...");
        //inserto en conjunto1
        conjunto1.insertarElemento(1); // Agregar elemento 1 al conjunto1
        conjunto1.insertarElemento(2); // Agregar elemento 2 al conjunto1
        conjunto1.insertarElemento(4); // Agregar elemento 4 al conjunto1
        //inserto en conjunto2
        conjunto2.insertarElemento(2); // Agregar elemento 2 al conjunto2
        conjunto2.insertarElemento(3); // Agregar elemento 3 al conjunto2
        conjunto2.insertarElemento(5); // Agregar elemento 5 al conjunto2
        System.out.println("Conjunto 1: " + conjunto1.aStringConjunto());
        System.out.println("Conjunto 2: " + conjunto2.aStringConjunto());
        System.out.println("------------------------------------------------");

        // Eliminar elementos de los conjuntos
        System.out.println("Eliminando elementos del conjunto 1 y 2...");
        conjunto1.eliminarElemento(4); // Eliminar elemento 4 del conjunto1
        System.out.println("Conjunto 1: " + conjunto1.aStringConjunto());
        conjunto2.eliminarElemento(3); // Eliminar elemento 3 del conjunto2
        System.out.println("Conjunto 2: " + conjunto2.aStringConjunto());
        System.out.println("------------------------------------------------");

        // Comparar si los conjuntos son iguales
        System.out.println("Comparando conjuntos...");
        if (conjunto1.esIgualA(conjunto2)) {
            System.out.println("Los conjuntos son iguales."); // Mensaje si son iguales
        } else {
            System.out.println("Los conjuntos son diferentes."); // Mensaje si son diferentes
        }
        System.out.println("------------------------------------------------");

        // Realizar la unión de los conjuntos
        System.out.println("Unión de conjuntos...");
        ConjuntoEnteros unionConjunto = conjunto1.union(conjunto2); // Unión de conjunto1 y conjunto2
        System.out.println("Conjunto 1: " + conjunto1.aStringConjunto());
        System.out.println("Conjunto 2: " + conjunto2.aStringConjunto());
        System.out.println("Unión: " + unionConjunto.aStringConjunto());
        System.out.println("------------------------------------------------");

        // Realizar la intersección de los conjuntos
        System.out.println("Intersección de conjuntos...");
        ConjuntoEnteros interseccionConjunto = conjunto1.interseccion(conjunto2); // Intersección de conjunto1 y conjunto2
        System.out.println("Conjunto 1: " + conjunto1.aStringConjunto());
        System.out.println("Conjunto 2: " + conjunto2.aStringConjunto());
        System.out.println("Intersección: " + interseccionConjunto.aStringConjunto());
        System.out.println("------------------------------------------------");

        // Realizar la diferencia de los conjuntos
        System.out.println("Diferencia de conjuntos...");
        ConjuntoEnteros diferenciaConjunto = conjunto1.diferencia(conjunto2); // Diferencia de conjunto1 y conjunto2
        System.out.println("Conjunto 1: " + conjunto1.aStringConjunto());
        System.out.println("Conjunto 2: " + conjunto2.aStringConjunto());
        System.out.println("Diferencia: " + diferenciaConjunto.aStringConjunto());
        System.out.println("------------------------------------------------");

        // Insertar elemento fuera de rango en el conjunto 1
        System.out.println("Insertando elemento fuera de rango en el conjunto 1...");
        conjunto1.insertarElemento(101); // Elemento fuera de rango
        System.out.println("Conjunto 1: " + conjunto1.aStringConjunto());
        System.out.println("------------------------------------------------");

        // Eliminar elemento fuera de rango en el conjunto 2
        System.out.println("Eliminando elemento fuera de rango en el conjunto 2...");
        conjunto2.eliminarElemento(-1); // Elemento fuera de rango
        System.out.println("Conjunto 2: " + conjunto2.aStringConjunto());
        System.out.println("------------------------------------------------");

        System.out.println("Fin de las pruebas.");
    }
}